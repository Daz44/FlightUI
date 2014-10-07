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
#####BUILD FROM 7TH OCTOBER 2014
######MAJOR FLIGHT DISPLAY
![FlightUI Screenshot as of 7/10/2014](https://raw.githubusercontent.com/Daz44/FlightUI/master/other/Screenshot.PNG)
#####OTHER INSTRUMENTS
![FlightUI Screenshot as of 7/10/2014](https://raw.githubusercontent.com/Daz44/FlightUI/master/other/Screenshot2.PNG)


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

MIT

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
