# ForzaDashboard
Forza Motorsport 7 data-out receiver

What it's intended for:
I'm usually driving manual (sometimes with clutch) and frequent car changes make it difficult to get those upshifts right. I can either focus on the track or on the rpm-display.
The shift-indicators some cars provide also don't help much due to them working differently for each car (growing, flashing, blinking...aaargh!)

What it does:
This simple dashboard shows a singular shift-indicator all the time, no matter which car I'm driving in and how many rpm the engine can do.

the shift indicator is customizable by car to limit the range for low-revving cars and increase it for high-revving cars so as not to miss your perfect shift.

the shift indicator is based on measured max. rpm. Not the (data-out) max rpm which is the display-limit. The measured rpm are stored per car and by default, the shift indicator maximum is set to 99% of those max measured rpm - that way you don't hit the limiter.

It also shows other information such as current rpm, speed (kph/mph), calculated acceleration and deceleration, and many of the other data-out values.

You can name your car (If anyone of you can produce a list of car ordinals (data-out) with corresponding names, I'll gladly import them)

If you figure out a way to loopback the data-out stream, you can also use the "always on top" feature, using the dashboard as an overlay, positioning it over your ingame dashboard (in windowed mode) - alternatively simply use the ForzaRelay also here on GitHub.

Listening Port configurable in .properties file - standard port is 1337.

Maximizing, Resizing, dragging without the windows bar on top cluttering the info-display.

(some) car data stored in .properties file - for each car that you've actually driven using the dashboard. so after a while, It could be complete.

Update:
recently added laptime display (still a little buggy) to show each laptime as well as delta to the lap before and fuel consumption

How to use this:
- You need any Java Runtime Environment (JRE) for example from here: https://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html
- After installing JRE, go to "releases" https://github.com/Weitwalter/ForzaDashboard/releases. 
- You need to download the ForzaConfig.properties and ForzaCarSettings.properties files as well as the ForzaDashboard.jar file.
- Put the downloaded files into one folder (which one does not matter)
- Run the ForzaDasboard .jar executable (remember: the ListeningPort is set in the ForzaConfig.properties (Default: 1337)
- You don't need the source code if you don't want to develop.
