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

package com.mallen.flightui.wrapper;

public class FLUI_DATA {
	
	/*
	 * TODO: Remove 
	 */
	
	public static double getRadarAltitude(){
		return FLUI_GLOBAL.radAlt;
	}
	
	public static int getAltitude(){
		return FLUI_GLOBAL.qnhAlt;
	}
	
	public static int getHeading(){
		return FLUI_GLOBAL.hdg;
	}
	public static int getTAS(){
		return FLUI_GLOBAL.trueSpeed;
	}
	public static int getIAS(){
		return FLUI_GLOBAL.indicatorSpeed;
	}
}
