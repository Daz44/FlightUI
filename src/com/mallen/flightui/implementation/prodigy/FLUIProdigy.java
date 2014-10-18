/*
	Author: Matthew Allen
	Website: https://github.com/Daz44
	Created by Daz at 10:27:29 PM on 13/10/2014

	THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
	IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
	FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
	AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
	LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
	OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
	THE SOFTWARE.

*/

package com.mallen.flightui.implementation.prodigy;
import java.awt.Dimension;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import com.flightsim.fsuipc.fsuipc_wrapper;
import com.mallen.flightui.core.Console;
import com.mallen.flightui.core.exceptions.FLUIException;
import com.mallen.flightui.core.exceptions.FlightSimConnectionException;
import com.mallen.flightui.core.exceptions.InvalidDLLConfigurationException;
import com.mallen.flightui.core.exceptions.InvalidJVMConfigurationException;
import com.mallen.flightui.implementation.prodigy.panels.ProdigyPrimaryPanel;
import com.mallen.flightui.ui.modules.Theme;
import com.mallen.flightui.utils.ConsoleFormatting;

public class FLUIProdigy
{
	
	public void init() throws Exception{
		System.out.println("Running tests + " + System.getProperty("java.library.path"));
		
		int FSUIPC_CONNECTION = 0;
		try {
			FSUIPC_CONNECTION = fsuipc_wrapper.Open(fsuipc_wrapper.SIM_ANY);
		} catch(Error e){
			if(e.getMessage().equals("Can't load IA 32-bit .dll on a AMD 64-bit platform")){
					throw new InvalidJVMConfigurationException(e.getMessage(), "Please start FlightUI with a 32BIT JVM!");
			} else {
				if(e.getCause().toString().contains("dll in java.library.path")){
					throw new InvalidDLLConfigurationException(e.getCause().toString(), "Please make sure fsuipc.dll is placed within your working directory or %home%");
				} else {
					throw new FLUIException(e.getCause().toString(), e.getMessage());
				}
			}  
		}
		
		System.out.println("ret =" + FSUIPC_CONNECTION);
		if(FSUIPC_CONNECTION == 0 ){
			throw new FlightSimConnectionException("Flight Sim Not Found", "Make sure your flight simulator is launched and try again!");
		}
		else
		{
			FLUIProdigy t = new FLUIProdigy();
			t.configFrame();
		//	new Console();
			}
	}
	

	int xVal = 0;
	int yVal =  0;
	int widthVal =  0;
	int heightVal =  0;
	
	public static void main(String s[]) 
	{
		FLUIProdigy m = new FLUIProdigy();
		try {		
				if(s.length > 0){
					Theme.setTheme(s[0].toLowerCase());
				} else {
					Theme.setTheme("embraer");
				}
			m.init();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void configFrame(){
		ConsoleFormatting.lineBreak(System.out);
		ConsoleFormatting.drawHeader(System.out, "FLIGHTUI CONFIGURATION PRODIGY");
		ConsoleFormatting.lineBreak(System.out);
		
		xVal = ConsoleFormatting.getInputInt(System.out, "X value for PFD");
		yVal =  ConsoleFormatting.getInputInt(System.out, "Y value for PFD");
		widthVal =  ConsoleFormatting.getInputInt(System.out, "Width value for PFD");
		heightVal =  ConsoleFormatting.getInputInt(System.out, "Height value for PFD");
		
		ConsoleFormatting.lineBreak(System.out);
		ConsoleFormatting.drawHeader(System.out, "XVAL: " + xVal);
		ConsoleFormatting.drawHeader(System.out, "YVAL: " + yVal);
		ConsoleFormatting.drawHeader(System.out, "WVAL: " + widthVal);
		ConsoleFormatting.drawHeader(System.out, "HVAL: " + heightVal);
		ConsoleFormatting.lineBreak(System.out);
		
		drawFrame(false, true, true);
	}
	
	/**
	 * Initializes FlightUI panel (VirtualHorizon, Radio Panel, etc...)
	 * 
	 * @param isUndecorated If the frames should be decorated or not (JFrame.setUndecorated())
	 * @param isResizable If the frames should be resizable or not (JFrame.setResiazble())
	 * @throws Exception	
	 */
	public void drawFrame(boolean isUndecorated, boolean isResizable, boolean visible){
		try {		

			 JFrame Frame_ProdigyPrimary = new JFrame();
			
			Frame_ProdigyPrimary.setTitle("FlightUI - VirtualHorizon (Airliner)");
			Frame_ProdigyPrimary.setResizable(isResizable);
			Frame_ProdigyPrimary.setSize(widthVal, heightVal);
			Frame_ProdigyPrimary.setLocation(xVal, yVal);
			Frame_ProdigyPrimary.setIconImage(ImageIO.read(new File("resources/FLUI.png")));
			Frame_ProdigyPrimary.add(new ProdigyPrimaryPanel());
			Frame_ProdigyPrimary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Frame_ProdigyPrimary.setAlwaysOnTop(true);
			Frame_ProdigyPrimary.setVisible(visible);
			
		} catch(Exception e){ e.printStackTrace();}
	}
}
