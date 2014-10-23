FlightUI 
=========
Open Source Glass Cockpit

  - Wrapper - Memory wrapper for the FSUIPC Library
  - Interface - UI Elements developed in Java
  - Glass Cockpit - Implementation of Wrapper & Interface

FlightUI is a Glass Cockpit implementation written using Java - with a default implementation for [Microsoft's Flight Simulator X] via the [FSUIPC SDK]. This glass cockpit is designed as a generic implementation providing usability for all types of Aircraft.


Resources
-----------

FlightUI makes use of technolegies *including* the following:
* [Java] - Programming Language
* [FSUIPC SDK] - SDK allowing access to aircraft data in [Microsoft's Flight Simulator X]
* [Microsoft's Flight Simulator X] - PC Flight Simulator


---
Screenshots
---
#####BUILD FROM 23RD OCTOBER 2014
######PRODIGY FLIGHT PANEL
![FlightUI Screenshot as of 23/10/2014](https://raw.githubusercontent.com/Daz44/FlightUI/master/other/ScreenshotProdigyPanel-23-10-14.PNG)
#####BUILD FROM 21ST OCTOBER 2014
######PRODIGY FLIGHT PANEL
![FlightUI Screenshot as of 21/10/2014](https://raw.githubusercontent.com/Daz44/FlightUI/master/other/ScreenshotProdigyPanel.PNG)
#####BUILD FROM 7TH OCTOBER 2014 - GENERIC
######MAJOR FLIGHT DISPLAY
![FlightUI Screenshot as of 7/10/2014](https://raw.githubusercontent.com/Daz44/FlightUI/master/other/Screenshot.PNG)
#####OTHER INSTRUMENTS
![FlightUI Screenshot as of 7/10/2014](https://raw.githubusercontent.com/Daz44/FlightUI/master/other/Screenshot2.PNG)
#####THEMES
![FlightUI Themes](https://raw.githubusercontent.com/Daz44/FlightUI/master/other/images/Themes_01.png)
![FlightUI Themes for Airbus and Beoing](https://raw.githubusercontent.com/Daz44/FlightUI/master/other/images/Themes_02.png)
```
		// AIRLINER THEME 
		//Theme.setTheme(new Color(0, 102, 253), new Color(126, 92, 52), new Color(250, 250, 250), new Color(20, 20, 20, 80), new Color(205, 205, 205), new Color(55, 55, 55), new Color(50, 190, 90), new Color(220, 200, 0),new Color(190, 50, 50));
		
		//MILJET THEME
		//Theme.setTheme(new Color(10, 10, 10), new Color(55, 55, 55), new Color(0, 210, 20), new Color(0, 210, 20, 80),new Color(0, 120, 10), new Color(0, 0, 0), new Color(50, 190, 90), new Color(220, 200, 0),new Color(50, 100, 50));
		
		//EMBRAER THEME
		//Theme.setTheme(new Color(70, 130, 200), new Color(130, 50, 0), new Color(255, 255, 255),  new Color(5, 5, 5, 100), new Color(0, 0, 0), new Color(5, 5, 5), new Color(130, 200, 90), new Color(5, 190, 205),new Color(200, 0, 0));
		
		//AIRBUS THEME
		//Theme.setTheme(new Color(20, 70, 170), new Color(60, 20, 20), new Color(255, 255, 255),  new Color(30, 30, 30), new Color(0, 0, 0), new Color(5, 5, 5), new Color(10, 150, 30), new Color(10, 200, 200),new Color(200, 0, 0));
		
		//BOEING THEME
		//Theme.setTheme(new Color(10, 140, 200) /*SKY*/, new Color(150, 70, 20)/*GROUND*/, new Color(245, 245, 245)/*FORE*/,  new Color(100, 90, 90)/*AERO*/, new Color(5, 5, 5)/*MID*/, new Color(10, 15, 22) /*BACK*/, new Color(10, 150, 30) /*TRUE*/, new Color(10, 200, 200) /*NEUTRAL*/, new Color(200, 0, 0)/*FALSE*/);		
		//(vertSky, vertGround, globFore, globMid, globBack, globTrue, globNeutral, globFalse)
		
```
---
Configuration
-------------

##### Running FlightUI
```
CD "C:\Directory_With_JAR_and_DLL"
java -jar - FlightUI.jar //(Must be x86 JVM)

```
####Building FlightUI
```
To build FlightUI simply build as you would with any other applications
> FSUIPC_RECOMP.jar is required (May be replaced with FSUIPC.jar from the FSUIPC SDK
> JRE 7+ is required for building
```

####Common Errors
```
Error:  Can't load IA 32-BIT .dll on a AMD 64-bit platform
Cause:  Attempting to run on a 64-bit VM
Fix:    Run on a 32-bit VM
```
```
Error: Exception in thread "main" java.lang.UnsatisfiedLinkError: C:\Users\Daz\AppData\Roaming\PATH\fsuipc_java.dll:
        at java.lang.ClassLoader$NativeLibrary.load(Native Method)
        at java.lang.ClassLoader.loadLibrary1(Unknown Source)
        at java.lang.ClassLoader.loadLibrary0(Unknown Source)
        at java.lang.ClassLoader.loadLibrary(Unknown Source)
        at java.lang.Runtime.loadLibrary0(Unknown Source)
        at java.lang.System.loadLibrary(Unknown Source)
        at com.flightsim.fsuipc.fsuipc_wrapper.<clinit>(Unknown Source)
        at com.mallen.flightui.core.Main.main(Main.java:29)
Cause: fsuipc_java.dll in the current directory of the CMD instance. eg. If CMD.exe shows C:\users\dev\documents then the DLL must        be in the directory.
Fix: Navigate to a directory containing the .DLL within Command Prompt or Place fsuipc_java.dll in the selected directory.
```
```
PLEASE REPORT ALL OTHER ERRORS TO THE DEVELOPER A
```



License
----
	MIT OPEN SOURCE LICENCE
	
	THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
	IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
	FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
	AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
	LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
	OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
	THE SOFTWARE.

-------------------
&copy; [Matthew Allen] 2014

[Matthew Allen]:http://www.github.com/daz44
[FSUIPC SDK]:http://www.schiratti.com/dowson.html
[Microsoft's Flight Simulator X]:https://en.wikipedia.org/wiki/Microsoft_Flight_Simulator_X
[Java]:http://www.java.com
[marked]:https://github.com/chjj/marked
[Ace Editor]:http://ace.ajax.org
[node.js]:http://nodejs.org
[Twitter Bootstrap]:http://twitter.github.com/bootstrap/
[keymaster.js]:https://github.com/madrobby/keymaster
[jQuery]:http://jquery.com
[@tjholowaychuk]:http://twitter.com/tjholowaychuk
[express]:http://expressjs.com
