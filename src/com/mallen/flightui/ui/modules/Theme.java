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

package com.mallen.flightui.ui.modules;

import java.awt.Color;
import java.awt.Graphics;

public class Theme {
	
	//Virtual Horizon
	public static Color vhSky; 
	public static Color vhGround;
	/////////////////
	
	//Global
	public static Color gForeground;
	public static Color gMidground; 
	public static Color gBackground;
	public static Color gAero;
	public static Color gTrue;
	public static Color gNeutral;
	public static Color gFalse;
	//////////////////
	
	
	public static void setTheme(Color vertSky, Color vertGround, Color globFore, Color globAero,Color globMid, Color globBack, Color globTrue, Color globNeutral, Color globFalse){
		gAero = globAero;
		vhSky = vertSky;
		vhGround = vertGround;
		gForeground = globFore;
		gMidground = globMid;
		gBackground = globBack;
		
		gTrue = globTrue;
		gNeutral = globNeutral;
		gFalse = globFalse;
	}
	
	public static void setAero(boolean aero, Graphics g){
		if(aero){
			g.setColor(Theme.gAero);
		} else {
			g.setColor(Theme.gBackground);
		}
		
	}
}
