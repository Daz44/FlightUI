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

import com.flightsim.fsuipc.FSUIPC;

public class FLUI_READER {

	/**
	 * char : 1 byte short : 2 bytes int : 4 bytes long : 4 bytes float : 4
	 * bytes double : 8 bytes
	 */

	/**
	 * getInt() used to lookup memory locations and return the Integer value.
	 * 
	 * @param param
	 *            - Memory location for FSUIPC (or use FSUIPC_MEMORY.get();
	 * @return
	 */
	static FSUIPC fs = new FSUIPC();

	public static int getInt(Object param) {
		int i = fs.getInt((int) param);
		return i;
	}

	/**
	 * getDouble() used to lookup memory locations and return the Double value.
	 * 
	 * @param param
	 *            - Memory location for FSUIPC (or use FSUIPC_MEMORY.get();
	 * @return
	 */
	public static double getDouble(Object param) {
		double i = fs.getDouble((int) param);
		return i;
	}

	/**
	 * getShort() used to lookup memory locations and return the Short value.
	 * 
	 * @param param
	 *            - Memory location for FSUIPC (or use FSUIPC_MEMORY.get();
	 * @return
	 */
	public static short getShort(Object param) {
		short s = fs.getShort((int) param);
		return s;
	}

	/**
	 * getByte() used to lookup memory locations and return the Byte value.
	 * 
	 * @param param
	 *            - Memory location for FSUIPC (or use FSUIPC_MEMORY.get();
	 * @return
	 */
	public static byte getByte(Object param) {
		byte b = fs.getByte((int) param);
		return b;
	}
}
