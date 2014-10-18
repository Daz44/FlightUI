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
import com.mallen.flightui.core.exceptions.FLUIException;
import com.mallen.flightui.core.exceptions.FlightSimConnectionException;
import com.mallen.flightui.core.exceptions.InvalidDLLConfigurationException;
import com.mallen.flightui.core.exceptions.InvalidJVMConfigurationException;
import com.mallen.flightui.implementation.prodigy.panels.ProdigyPrimaryPanel;
import com.mallen.flightui.ui.modules.Theme;

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
			t.configFrame(false, true, true);
		//	new Console();
			}
	}
	
	public static void main(String s[]) 
	{
		try {		
			FLUIProdigy m = new FLUIProdigy();
				if(s.length > 0){
					Theme.setTheme(s[0].toLowerCase());
				} else {
					Theme.setTheme("embraer");
				}
			m.init();
		}catch(Exception e){
			System.out.println("FATAL EXCEPTION - Please ensure that FSUI_PC.DLL is in the correct direcoty!");
			System.exit(1);
		}
	}
	
	/**
	 * Initializes FlightUI panel (VirtualHorizon, Radio Panel, etc...)
	 * 
	 * @param isUndecorated If the frames should be decorated or not (JFrame.setUndecorated())
	 * @param isResizable If the frames should be resizable or not (JFrame.setResiazble())
	 * @throws Exception	
	 */
	public void configFrame(boolean isUndecorated, boolean isResizable, boolean visible){
		try {		

			 JFrame Frame_ProdigyPrimary = new JFrame();
			
			Frame_ProdigyPrimary.setTitle("FlightUI - VirtualHorizon (Airliner)");
			Frame_ProdigyPrimary.setResizable(isResizable);
			Frame_ProdigyPrimary.setSize(1920, 1080);
			Frame_ProdigyPrimary.setLocation(0, 0);
			Frame_ProdigyPrimary.setIconImage(ImageIO.read(new File("resources/FLUI.png")));
			Frame_ProdigyPrimary.setMinimumSize(new Dimension(500, 500));
			Frame_ProdigyPrimary.add(new ProdigyPrimaryPanel());
			Frame_ProdigyPrimary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Frame_ProdigyPrimary.setAlwaysOnTop(true);
			Frame_ProdigyPrimary.setVisible(visible);
			
		} catch(Exception e){ e.printStackTrace();}
	}
}
