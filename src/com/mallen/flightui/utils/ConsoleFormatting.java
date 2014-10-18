/*
	Author: Matthew Allen
	Website: https://github.com/Daz44
	Created by Daz at 6:31:43 pm on 18 Oct 2014

	THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
	IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
	FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
	AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
	LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
	OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
	THE SOFTWARE.

*/
package com.mallen.flightui.utils;

import java.io.PrintStream;
import java.util.Scanner;

import com.mallen.flightui.core.exceptions.FLUIException;

public class ConsoleFormatting {
	
	public static int consoleWidth = 80; //Console width in chars
	
	public static void lineBreak(PrintStream ps){
		String s = "";
		for(int i = 0; i < consoleWidth; i++)  s += "-";
		ps.println(s);
	}
	
	public static void drawHeader(PrintStream ps, String header){
		if(header.length() > consoleWidth){
			try {
				throw new FLUIException("Header longer than consoleWidth", "Reduce the number of character in the header to < " + consoleWidth);
			} catch (FLUIException e) {
				e.printStackTrace();
			}
		} else { 
			int drawPosition = (consoleWidth-header.length())/2;
			String s = "";
			
			for(int i = 0; i  <= consoleWidth; i ++){
				if(i == 0 || i == consoleWidth){
					s += "|";
				} else if(i < drawPosition || i > drawPosition + header.length()){
					s += " "; 
				} else if (i >= drawPosition && i <= drawPosition+header.length()){
						s += header;
						i += header.length();
				}
			}
			
			ps.println(s);
		
		} 
	}
	
	public static int getInputInt(PrintStream ps, String question){
		int i = 0;
			Scanner scanner =  new Scanner(System.in);
			ps.print(question + ": ");
			i = scanner.nextInt();
		return i;
	}
	
	public static String getInputString(PrintStream ps, String question){
		String s = "";
			Scanner scanner =  new Scanner(System.in);
			ps.print(question + ": ");
			s = scanner.nextLine();
		return s;
	}
}
