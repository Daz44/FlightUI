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

package test.mallen.flighui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.mallen.flightui.ui.modules.NumberIndicatorHorizontal;
import com.mallen.flightui.ui.modules.NumberIndicatorVerticalTape;
import com.mallen.flightui.ui.modules.Theme;

public class Test extends JPanel{
	NumberIndicatorVerticalTape nit = new NumberIndicatorVerticalTape(10, 10, 100, 500, 100);

	public static void main(String[] args){
	//	Theme.setTheme(new Color(50, 100, 250), new Color(80, 50, 50), new Color(250, 250, 250), new Color(205, 205, 205), new Color(55, 55, 55), new Color(50, 190, 90), new Color(220, 200, 0),new Color(190, 50, 50));
		Theme.vhGround = new Color(126, 92, 52);
		Theme.vhSky = new Color(0, 102, 253);
		
		Test m = new Test();
		m.initFrame();
	}
	
	public void initFrame(){
		JFrame jf = new JFrame();
		jf.setSize(500, 1000);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(this);
		jf.setVisible(true);
	}
	
	
	int i = 4100;
	
	public void paint(Graphics g){
	super.paint(g);
	setDoubleBuffered(true);
	
		i++;
		nit.update(i);
		nit.draw(g, this);

		g.setColor(Color.RED);
		g.fillRect(10, 10-2+500, 100, 4);
		g.drawString("ALT: " + i, 15, 500);
		try {
			Thread.sleep(10);
		} catch(Exception e){
			e.printStackTrace();
		}
	
	repaint();
	}
}
