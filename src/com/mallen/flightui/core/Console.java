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

import java.util.Date;
import java.util.Scanner;

import com.mallen.flightui.wrapper.FLUI_READER;
import com.mallen.flightui.wrapper.flui.FLUIAircraft;

public class Console {
	public Console(){
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("                          FLIGHTUI AIRCRAFT CONSOLE");
		System.out.println("------------------------------------------------------------------------------");
		
		System.out.println("Init @ " + new Date()); 
		this.waitForInput();
	}
	
	
	private Scanner input = new Scanner(System.in);
	public void waitForInput(){
		System.out.print("[INPUT] > ");
		this.parseInput(input.nextLine());
	}
	
	public void parseInput(String s){
		
		if(s.split(" ")[0].toLowerCase().equals("getint")){
			FLUI_READER fr = new FLUI_READER();
			System.out.println("[ " + s.split(" ")[1] + "} " + fr.getInt(Integer.valueOf(s.split(" ")[1].toLowerCase())));
		}
		
		if(s.split(" ")[0].toLowerCase().equals("aircraftdata")){
			if(s.split(" ")[1].toLowerCase().equals("heading")){
				System.out.println("[ " + s.split(" ")[1] + "} " + FLUIAircraft.Heading());
			} else if(s.split(" ")[1].toLowerCase().equals("magheading")){
				System.out.println("[ " + s.split(" ")[1] + "} " + FLUIAircraft.MagneticHeading());
			} else if(s.split(" ")[1].toLowerCase().equals("altitude")){
				System.out.println("[ " + s.split(" ")[1] + "} " + FLUIAircraft.AltFeet());
			} else if(s.split(" ")[1].toLowerCase().equals("altitudem")){
				System.out.println("[ " + s.split(" ")[1] + "} " + FLUIAircraft.AltMeter());
			}
		}
			
		this.waitForInput();
	}
	
	public static void main(String[] args){
		new Console();
	}
}
