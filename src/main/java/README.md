# Northcoders Mars Rover project.
## A project to test our current understanding of Java.

This programme simulates a mars rover landing on a plateau.
The rover will move around the plateau following simple commands
given as a series of input strings.

Simple string commands are  sent to the rover to simulate the difficulty 
of controlling a vehicle from earth.

input example

5 5

The first command sets up the size of the plateau

1 3 E

The second command are the landing coordinates and facing direction
(1,3) facing East

LRMMLRM

instructions to move.


L - rotate 90 degrees Left, 

M - move forward, 

R - rotate 90 degrees right.

This first implementation is a minimum viable product. It will require refactoring to make a fully working programme. Tests have been added for TDD.

UserInput class is the entry point to command line interface. As per spec no prompts are given to the user. They will need to know the input sequence.
UserInput class calls the InputParser class passing in each string as an argument.
The first string is the Plateau Size to be created. The InputParser.parsePlateauSize method takes the string, in this example 5 5 and returns a PlateauSize object. 
The creation of the plateau should be moved to its own separate class to handle different plateau creation scenarios. 


UserInput class takes the second string and passes it to the InputParser.parsePosition class as an argument, this returns a Position object.
This method should be updated to only perform the string validation and pass the Position creation to a separate class. This could for example implement 3D Positions.

UserInput class then creates a Rover object passing in the PlateauSize and the Position objects to the Rover constructor.

UserInput class then takes the third string and passes that to the InputParser.parseInstruction method as a string. This method checks
if the instructions are valid and returns an Instruction[].

UserInput class then passes the Instruction[] to the Rover object for it to move.

enums for compass directions N E S W and move instruction L R M, limit the input to the classes to valid values.

Rover class holds the current rover position and the plateau it has landed on.
It also implements the move, checking to see the rover does not move out of bounds 
and aborts all further processing if an out-of-bounds instruction is given. These methods should be moved to their own classes.

As it stands multiple rovers can land on a plateau and multiple plateaus can be created. This simulates different colonies each with
their own fleet of rovers.

Moving forward better UserInput should run a loop for rover movement until an exit command is given. 
Clearer instructions should be given for what and when to input as strings.

Rover movement can be shown on a 2D map. A MissionControl class can handle the different plateaus and rovers.
Tracking of rovers can be added and rover collision avoidance can be implemented.
similarly an object collision detection and avoidance can be added to MissionControl.
rovers cannot detect objects so a rover camera class can be added for their own Object collision detection and avoidance.
A ProximityDetector interface. This can be MissionControl for a blind rover or an onboard camera.
A Vehicle interface will allow for vehicles other than rovers
A Plateau interface allows for different landing areas.



