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

package com.mallen.flightui.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Converter {

	// TODO: Sort this class out (Refactor)

	public static int feetToMeters(int i) {
		return (int) (i / 3.28);
	}

	public static int feetToMeters(String s) {
		int i = Integer.parseInt(s);
		return (int) (i / 3.28);
	}

	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	public static boolean intToBool(int i) {
		if (i == 0)
			return false;
		if (i != 0)
			return true;

		return false;
	}

	// ONLY TO BE USED FOR LIGHT PANEL --
	public static int boolToInt(boolean b) {
		if (b)
			return 1;
		if (!b)
			return 3;

		return 2;
	}
}
