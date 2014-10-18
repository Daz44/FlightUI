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

package com.mallen.flightui.implementation.generic;
import java.awt.Dimension;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import com.flightsim.fsuipc.fsuipc_wrapper;
import com.mallen.flightui.core.exceptions.FLUIException;
import com.mallen.flightui.core.exceptions.FlightSimConnectionException;
import com.mallen.flightui.core.exceptions.InvalidDLLConfigurationException;
import com.mallen.flightui.core.exceptions.InvalidJVMConfigurationException;
import com.mallen.flightui.implementation.generic.panels.ArtificialHorizonPanel;
import com.mallen.flightui.implementation.generic.panels.AutopilotPanel;
import com.mallen.flightui.implementation.generic.panels.CautionPanel;
import com.mallen.flightui.implementation.generic.panels.EnginePanelGuage;
import com.mallen.flightui.implementation.generic.panels.LightPanel;
import com.mallen.flightui.implementation.generic.panels.LightPanel2;
import com.mallen.flightui.implementation.generic.panels.RadioPanel;
import com.mallen.flightui.ui.modules.Theme;

public class FLUIGeneric
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
			FLUIGeneric t = new FLUIGeneric();
			t.configFrame(true, true, true);
		//	new Console();
			}
	}
	
	public static void main(String s[]) 
	{
		try {		
			FLUIGeneric m = new FLUIGeneric();
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

			 JFrame Frame_VirtualHorizon = new JFrame();
			 JFrame Frame_Autopilot = new JFrame();
			 JFrame Frame_LightPanel1 = new JFrame();
			 JFrame Frame_LightPanel2 = new JFrame();
			 JFrame Frame_RadioPanel = new JFrame();
			 JFrame Frame_ENGDisp_Gauge = new JFrame();
			 JFrame Frame_CautionPanel = new JFrame();
			
			Frame_VirtualHorizon.setTitle("FlightUI - VirtualHorizon (Airliner)");
			Frame_VirtualHorizon.setResizable(isResizable);
			Frame_VirtualHorizon.setSize(1000, 1000);
			Frame_VirtualHorizon.setLocation(-1080, 100);
			Frame_VirtualHorizon.setIconImage(ImageIO.read(new File("resources/FLUI.png")));
			Frame_VirtualHorizon.setMinimumSize(new Dimension(500, 500));
			Frame_VirtualHorizon.add(new ArtificialHorizonPanel());
			Frame_VirtualHorizon.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Frame_VirtualHorizon.setAlwaysOnTop(true);
			Frame_VirtualHorizon.setType(javax.swing.JFrame.Type.UTILITY);		
			
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
			
			Frame_Autopilot.setVisible(visible);
			Frame_LightPanel1.setVisible(visible);
			Frame_LightPanel2.setVisible(visible);
			Frame_RadioPanel.setVisible(visible);
			Frame_ENGDisp_Gauge.setVisible(visible);
			Frame_VirtualHorizon.setVisible(visible);
			Frame_CautionPanel.setVisible(visible);
			
		} catch(Exception e){ e.printStackTrace();}
	}
}
