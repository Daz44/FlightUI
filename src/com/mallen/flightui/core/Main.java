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

package com.mallen.flightui.core;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import com.flightsim.fsuipc.FSUIPC;
import com.flightsim.fsuipc.fsuipc_wrapper;
import com.mallen.flightui.core.exceptions.FLUIException;
import com.mallen.flightui.core.exceptions.FlightSimConnectionException;
import com.mallen.flightui.core.exceptions.InvalidDLLConfigurationException;
import com.mallen.flightui.core.exceptions.InvalidJVMConfigurationException;
import com.mallen.flightui.panels.ArtificialHorizonPanel;
import com.mallen.flightui.panels.AutopilotPanel;
import com.mallen.flightui.panels.CautionPanel;
import com.mallen.flightui.panels.EnginePanelGuage;
import com.mallen.flightui.panels.LightPanel;
import com.mallen.flightui.panels.LightPanel2;
import com.mallen.flightui.panels.RadioPanel;
import com.mallen.flightui.ui.modules.Theme;
import com.mallen.flightui.wrapper.FLUI_GLOBAL;
import com.mallen.flightui.wrapper.FLUI_READER;
import com.mallen.flightui.wrapper.FLUI_DATA;

public class Main
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
			Main t = new Main();
			t.configFrame(true, true);
			t.setFrameVisibility(true);
			new Console();
			}
	}
	
	public static void main(String s[]) 
	{
		try {
			Main m = new Main();
			m.init();
		}catch(Exception e){
			System.out.println("FATAL EXCEPTION - Please ensure that FSUI_PC.DLL is in the correct direcoty!");
			System.exit(1);
		}
	}
	
	FSUIPC fs = new FSUIPC();
	FLUI_DATA ad = new FLUI_DATA();
	FLUI_READER adr = new FLUI_READER();
	
	JFrame Frame_VirtualHorizon = new JFrame();
	JFrame Frame_Autopilot = new JFrame();
	JFrame Frame_LightPanel1 = new JFrame();
	JFrame Frame_LightPanel2 = new JFrame();
	JFrame Frame_RadioPanel = new JFrame();
	JFrame Frame_ENGDisp_Gauge = new JFrame();
	JFrame Frame_CautionPanel = new JFrame();
	
	/**
	 * Initializes FlightUI panel (VirtualHorizon, Radio Panel, etc...)
	 * 
	 * @param isUndecorated If the frames should be decorated or not (JFrame.setUndecorated())
	 * @param isResizable If the frames should be resizable or not (JFrame.setResiazble())
	 * @throws Exception	
	 */
	public void configFrame(boolean isUndecorated, boolean isResizable){
		try {		
			
			Frame_VirtualHorizon.setTitle("FlightUI - VirtualHorizon (Airliner)");
			Frame_VirtualHorizon.setResizable(isResizable);
			Frame_VirtualHorizon.setSize(1000, 1000);
			Frame_VirtualHorizon.setLocation(-1080, 100);
			Frame_VirtualHorizon.setLocationRelativeTo(null);
			Frame_VirtualHorizon.setIconImage(ImageIO.read(new File("resources/FLUI.png")));
			Frame_VirtualHorizon.setMinimumSize(new Dimension(500, 500));
			Frame_VirtualHorizon.add(new ArtificialHorizonPanel());
			Frame_VirtualHorizon.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Frame_VirtualHorizon.setUndecorated(isUndecorated);
			Frame_VirtualHorizon.setAlwaysOnTop(true);
			Frame_VirtualHorizon.setType(javax.swing.JFrame.Type.UTILITY);		
			Frame_VirtualHorizon.setVisible(true);
			
			
			Frame_Autopilot.setTitle("FlightUI - AUTOPILOT (Airliner)");
			Frame_Autopilot.setResizable(isResizable);
			Frame_Autopilot.setSize(1000, 70);
			Frame_Autopilot.setLocation(-1080, 30);
			Frame_Autopilot.setIconImage(ImageIO.read(new File("resources/FLUI.png")));
			Frame_Autopilot.add(new AutopilotPanel());
			Frame_Autopilot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Frame_Autopilot.setUndecorated(isUndecorated);
			Frame_Autopilot.setType(javax.swing.JFrame.Type.UTILITY);
			
			Frame_LightPanel1.setTitle("FlightUI - LIGHTING (Airliner)");
			Frame_LightPanel1.setResizable(isResizable);
			Frame_LightPanel1.setLocation(-1080 ,30-70);
			Frame_LightPanel1.setSize(1000, 70);
			Frame_LightPanel1.setIconImage(ImageIO.read(new File("resources/FLUI.png")));
			Frame_LightPanel1.add(new LightPanel());
			Frame_LightPanel1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Frame_LightPanel1.setUndecorated(isUndecorated);
			Frame_LightPanel1.setType(javax.swing.JFrame.Type.UTILITY);
			
			Frame_LightPanel2.setTitle("FlightUI - LIGHTING (Airliner)");
			Frame_LightPanel2.setResizable(isResizable);
			Frame_LightPanel2.setLocation(-1080, -30-70);
			Frame_LightPanel2.setSize(1000, 70);
			Frame_LightPanel2.setIconImage(ImageIO.read(new File("resources/FLUI.png")));
			Frame_LightPanel2.add(new LightPanel2());
			Frame_LightPanel2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Frame_LightPanel2.setUndecorated(isUndecorated);
			Frame_LightPanel2.setType(javax.swing.JFrame.Type.UTILITY);
			
			
			Frame_RadioPanel.setTitle("FlightUI - RADIO (Airliner)");
			Frame_RadioPanel.setResizable(isResizable);
			Frame_RadioPanel.setLocation(-1080, -30-70-70);
			Frame_RadioPanel.setSize(1000, 70);
			Frame_RadioPanel.setIconImage(ImageIO.read(new File("resources/FLUI.png")));
			Frame_RadioPanel.add(new RadioPanel());
			Frame_RadioPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Frame_RadioPanel.setUndecorated(isUndecorated);
			Frame_RadioPanel.setType(javax.swing.JFrame.Type.UTILITY);
			
			
			Frame_ENGDisp_Gauge.setTitle("FlightUI - ENGINE (Airliner)");
			Frame_ENGDisp_Gauge.setResizable(isResizable);
			Frame_ENGDisp_Gauge.setLocation(-1080, -30-70-70-160);
			Frame_ENGDisp_Gauge.setSize(1000, 160);
			Frame_ENGDisp_Gauge.setIconImage(ImageIO.read(new File("resources/FLUI.png")));
			Frame_ENGDisp_Gauge.add(new EnginePanelGuage());
			Frame_ENGDisp_Gauge.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Frame_ENGDisp_Gauge.setUndecorated(isUndecorated);
			Frame_ENGDisp_Gauge.setType(javax.swing.JFrame.Type.UTILITY);

			Frame_CautionPanel.setTitle("FlightUI - CAUTION/WARNING PANEL (Airliner)");
			Frame_CautionPanel.setResizable(isResizable);
			Frame_CautionPanel.setLocation(-1080, -30-70-70-160-100);
			Frame_CautionPanel.setSize(150, 100);
			Frame_CautionPanel.setIconImage(ImageIO.read(new File("resources/FLUI.png")));
			Frame_CautionPanel.add(new CautionPanel());
			Frame_CautionPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Frame_CautionPanel.setUndecorated(isUndecorated);
			Frame_CautionPanel.setType(javax.swing.JFrame.Type.UTILITY);
		} catch(Exception e){ e.printStackTrace();}
	}
	
	/**
	 * Sets Global Theme of FlightUI.
	 * Visit https://github.com/Daz44/FlightUI for overview of Themes!
	 * Throws FLUIException in the event of an invalid theme!
	 * @param theme String denoting the theme to be used. eg. Boeing, Embraer, Airliner (Generic) 
	 * @exception FLUIException
	 */
	public void setTheme(String theme){
		if(theme.toLowerCase().trim().equals("airliner")){
			// AIRLINER THEME 
			Theme.setTheme(new Color(0, 102, 253), new Color(126, 92, 52), new Color(250, 250, 250), new Color(20, 20, 20, 80), new Color(205, 205, 205), new Color(55, 55, 55), new Color(50, 190, 90), new Color(220, 200, 0),new Color(190, 50, 50));
		} else if(theme.toLowerCase().trim().equals("military")){
			//MILJET THEME
			Theme.setTheme(new Color(10, 10, 10), new Color(55, 55, 55), new Color(0, 210, 20), new Color(0, 210, 20, 80),new Color(0, 120, 10), new Color(0, 0, 0), new Color(50, 190, 90), new Color(220, 200, 0),new Color(50, 100, 50));	
		} else if(theme.toLowerCase().trim().equals("embraer")){
			//EMBRAER THEME
			Theme.setTheme(new Color(70, 130, 200), new Color(130, 50, 0), new Color(255, 255, 255),  new Color(5, 5, 5, 50), new Color(0, 0, 0), new Color(5, 5, 5, 100), new Color(130, 200, 90), new Color(5, 190, 205),new Color(200, 0, 0));
		} else if(theme.toLowerCase().trim().equals("airbus")){
			//AIRBUS THEME
			Theme.setTheme(new Color(20, 70, 170), new Color(60, 20, 20), new Color(255, 255, 255),  new Color(30, 30, 30), new Color(0, 0, 0), new Color(5, 5, 5), new Color(10, 150, 30), new Color(10, 200, 200),new Color(200, 0, 0));
		} else if(theme.toLowerCase().trim().equals("boeing")){
			//BOEING THEME
			Theme.setTheme(new Color(10, 140, 200) /*SKY*/, new Color(150, 70, 20)/*GROUND*/, new Color(245, 245, 245)/*FORE*/,  new Color(100, 90, 90)/*AERO*/, new Color(5, 5, 5)/*MID*/, new Color(10, 15, 22) /*BACK*/, new Color(10, 150, 30) /*TRUE*/, new Color(10, 200, 200) /*NEUTRAL*/, new Color(200, 0, 0)/*FALSE*/);		
		} else {
			try {
				throw new FLUIException("Invalid Theme: " + theme, "'" + theme + "' is not a valid theme - please see the Readme for supported themes");
			} catch (FLUIException e) {
				e.printStackTrace();
			}
		}
		//(vertSky, vertGround, globFore, globMid, globBack, globTrue, globNeutral, globFalse)
	}
	
	/**
	 * Sets visiblity of all JFrames created within initFrame()
	 * @param visible Parameter passed to JFrame.setVisible(visible)
	 */
	public void setFrameVisibility(boolean visible){
		setTheme("embraer");
		try {
			Frame_Autopilot.setVisible(visible);
			Frame_LightPanel1.setVisible(visible);
			Frame_LightPanel2.setVisible(visible);
			//Frame_RadioPanel.setVisible(visible);
			Frame_ENGDisp_Gauge.setVisible(visible);
			Frame_CautionPanel.setVisible(visible);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
