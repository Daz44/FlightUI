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

package com.mallen.flightui.wrapper.flui;

import com.mallen.flightui.wrapper.FLUI_GLOBAL;

public class FLUIWarning {
	
	//FLUI MasterCaution
	public static boolean MasterCaution(){
		if(!FLUI_GLOBAL.gear	 && FLUI_GLOBAL.qnhAlt < 1000){
			return true;
		} else {
			return false;
		}
	}
	
	//FLUI MasterWarning
	public static boolean MasterWarning(){
		if(FLUI_GLOBAL.AIRCRAFT_STALLED || FLUI_GLOBAL.AIRCRAFT_OVERSPEED){
			return true;
		} else {
			return false;
		}
	}

}

