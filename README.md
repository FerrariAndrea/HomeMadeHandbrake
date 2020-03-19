# HomeMadeHandbrake
A hand brake for PC games, homemade

# Init Raspberry
You need have raspberry in the same lan of your pc.
You need an hardware button which simulate the hand brake,
for example you can use a real hand brake as this: 

![alt text](https://github.com/FerrariAndrea/HomeMadeHandbrake/blob/master/video/hb.jpg)

I used a normal gipo (GIPO 0) controlled by 'RaspSide_C_part\gipoController.c'.
You need set your gipo pin and then run on your raspberry:
>g++  gipoController.c -l wiringPi -o  gipoController

Now you can run "distJar/RaspSide.jar" on your raspberry (this is the server side)
> java -jar RaspSide.jar

# Init PC

You can run "distJar/PCSide.jar" on your pc (client slide, so you need run first RaspSide.jar)
> java -jar PcSide.jar

# Result

I have tested it with AssettoCorsa simulator with the "SPACE" keyboard key configured as hand brake on the simulator:
https://github.com/FerrariAndrea/HomeMadeHandbrake/blob/master/video/result.mp4

# known problems

My raspberry has an Matrix led 8x8, if you don't have it then RaspSide.jar will be crash, you need comment the Matrix code on the sources
