/*
	Author: Matthew Allen
	Website: https://github.com/Daz44
	Created by Daz at 10:02:26 pm on 22 Oct 2014

	THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
	IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
	FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
	AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
	LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
	OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
	THE SOFTWARE.

 */
package test.mallen.flightui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.mallen.flightui.ui.modules.RoundedIndicator;
import com.mallen.flightui.ui.modules.Theme;

public class Test extends JPanel {
	private static final long serialVersionUID = 1L;

	RoundedIndicator gi = new RoundedIndicator(20, 20, 100, 100, 0, 360, 30,
			false);

	public Test() {
		Theme.setTheme("embraer");
		JFrame jf = new JFrame();
		jf.setSize(800, 800);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		jf.add(this);
		jf.setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		int i = 10;
		gi.update(i);
		gi.setSize(800, 800);
		gi.draw(g, this);

		g.setColor(Color.BLACK);

		try {
			Thread.sleep(20);
		} catch (Exception e) {
			e.printStackTrace();
		}

		repaint();
	}

	public static void main(String[] args) {
		new Test();
	}
}
