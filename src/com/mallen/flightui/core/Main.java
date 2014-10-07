package com.mallen.flightui.core;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import com.flightsim.fsuipc.FSUIPC;
import com.flightsim.fsuipc.fsuipc_wrapper;
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
	
	public static void main(String s[]) 
	{
		System.out.println("Running tests + " + System.getProperty("java.library.path"));
		int ret = fsuipc_wrapper.Open(fsuipc_wrapper.SIM_ANY);
		
		
		System.out.println("ret =" + ret);
		if(ret == 0 )
			{
				System.out.println("Flight sim not found");
			}
		else
			{
				
				Main t = new Main();
				t.drawFrame();
			}
	}
	
	FSUIPC fs = new FSUIPC();
	FLUI_DATA ad = new FLUI_DATA();
	FLUI_READER adr = new FLUI_READER();
	
	public void drawFrame(){
		
		Theme.setTheme(new Color(50, 100, 250), new Color(80, 50, 50), new Color(250, 250, 250), new Color(205, 205, 205), new Color(55, 55, 55), new Color(50, 190, 90), new Color(220, 200, 0),new Color(190, 50, 50));
		Theme.vhGround = new Color(126, 92, 52);
		Theme.vhSky = new Color(0, 102, 253);
		
		//Theme.setTheme(new Color(0, 120, 200), new Color(200, 85, 0), new Color(0, 0, 0), new Color(205, 205, 205), new Color(255, 255, 255), new Color(50, 160, 0), new Color(15, 150, 150),new Color(190, 0, 0));
		//(vertSky, vertGround, globFore, globMid, globBack, globTrue, globNeutral, globFalse)
		
		
		try {
			boolean isUndecorated =false;
			boolean isResizable = true;
			
			JFrame VH = new JFrame();
			VH.setTitle("FlightUI - VirtualHorizon (Airliner)");
			VH.setResizable(isResizable);
			VH.setSize(1000, 1000);
			VH.setLocation(-1080, 100);
			VH.setIconImage(ImageIO.read(new File("FLUI.png")));
			VH.setMinimumSize(new Dimension(500, 500));
			VH.add(new ArtificialHorizonPanel());
			VH.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			VH.setUndecorated(isUndecorated);
			//VH.setType(javax.swing.JFrame.Type.UTILITY);
			
			VH.setVisible(true);
			
			/*
			JFrame AP = new JFrame();
			AP.setTitle("FlightUI - AUTOPILOT (Airliner)");
			AP.setResizable(isResizable);
			AP.setSize(1000, 70);
			AP.setLocation(-1080, 30);
			AP.setIconImage(ImageIO.read(new File("FLUI.png")));
			AP.add(new AutopilotPanel());
			AP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			AP.setUndecorated(isUndecorated);
			AP.setType(javax.swing.JFrame.Type.UTILITY);
			
			JFrame LightPanel = new JFrame();
			LightPanel.setTitle("FlightUI - LIGHTING (Airliner)");
			LightPanel.setResizable(isResizable);
			LightPanel.setLocation(-1080 ,30-70);
			LightPanel.setSize(1000, 70);
			LightPanel.setIconImage(ImageIO.read(new File("FLUI.png")));
			LightPanel.add(new LightPanel());
			LightPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			LightPanel.setUndecorated(isUndecorated);
			LightPanel.setType(javax.swing.JFrame.Type.UTILITY);
			
			JFrame LightPanel2 = new JFrame();
			LightPanel2.setTitle("FlightUI - LIGHTING (Airliner)");
			LightPanel2.setResizable(isResizable);
			LightPanel2.setLocation(-1080, -30-70);
			LightPanel2.setSize(1000, 70);
			LightPanel2.setIconImage(ImageIO.read(new File("FLUI.png")));
			LightPanel2.add(new LightPanel2());
			LightPanel2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			LightPanel2.setUndecorated(isUndecorated);
			LightPanel2.setType(javax.swing.JFrame.Type.UTILITY);
			
			
			JFrame RadioPanel = new JFrame();
			RadioPanel.setTitle("FlightUI - RADIO (Airliner)");
			RadioPanel.setResizable(isResizable);
			RadioPanel.setLocation(-1080, -30-70-70);
			RadioPanel.setSize(1000, 70);
			RadioPanel.setIconImage(ImageIO.read(new File("FLUI.png")));
			RadioPanel.add(new RadioPanel());
			RadioPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			RadioPanel.setUndecorated(isUndecorated);
			RadioPanel.setType(javax.swing.JFrame.Type.UTILITY);
			
			
			JFrame ENGDisp_Guage = new JFrame();
			ENGDisp_Guage.setTitle("FlightUI - ENGINE (Airliner)");
			ENGDisp_Guage.setResizable(isResizable);
			ENGDisp_Guage.setLocation(-1080, -30-70-70-160);
			ENGDisp_Guage.setSize(1000, 160);
			ENGDisp_Guage.setIconImage(ImageIO.read(new File("FLUI.png")));
			ENGDisp_Guage.add(new EnginePanelGuage());
			ENGDisp_Guage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ENGDisp_Guage.setUndecorated(isUndecorated);
			ENGDisp_Guage.setType(javax.swing.JFrame.Type.UTILITY);

			
			JFrame CautionPanel = new JFrame();
			CautionPanel.setTitle("FlightUI - CAUTION/WARNING PANEL (Airliner)");
			CautionPanel.setResizable(false);
			CautionPanel.setLocation(-1080, -30-70-70-160-100);
			CautionPanel.setSize(150, 100);
			CautionPanel.setIconImage(ImageIO.read(new File("FLUI.png")));
			CautionPanel.add(new CautionPanel());
			CautionPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			CautionPanel.setUndecorated(isUndecorated);
			CautionPanel.setType(javax.swing.JFrame.Type.UTILITY);
			
			AP.setVisible(true);
			LightPanel.setVisible(true);
			LightPanel2.setVisible(true);
			RadioPanel.setVisible(true);
			ENGDisp_Guage.setVisible(true);
			CautionPanel.setVisible(true);
			*/
			
			new ConsoleMode();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
