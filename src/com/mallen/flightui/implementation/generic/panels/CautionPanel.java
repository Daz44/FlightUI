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

package com.mallen.flightui.implementation.generic.panels;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import com.mallen.flightui.ui.modules.Theme;
import com.mallen.flightui.ui.modules.WarningIndicator;
import com.mallen.flightui.wrapper.flui.FLUIWarning;

public class CautionPanel extends JPanel {
	WarningIndicator wInd = new WarningIndicator(10, 10, 50, 50, "MW", false,
			Theme.gFalse);
	WarningIndicator cInd = new WarningIndicator(80, 10, 50, 50, "MC", false,
			Theme.gNeutral);

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setDoubleBuffered(true);

		Graphics2D g2d = (Graphics2D) g;

		g.setColor(Theme.gBackground);
		g.fillRect(0, 0, getWidth(), getHeight());

		wInd.update(FLUIWarning.MasterWarning());
		wInd.draw(g);

		cInd.update(FLUIWarning.MasterCaution());
		cInd.draw(g);
		repaint();
	}
}
