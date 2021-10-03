# toyrobot
# Application Toy Robot

- toy's position is captured in x and y coordinators and correct current face as direction.
- move command will move robot accordingly in x or y based on current direction
- direction change via left/right will change robot's face by 90 degree
   (e.g. from North to West on left and North to East on right)
- Report command will list current x and y location and current face of robot.
- all invalid commands are ignored
- all valid command are captured for reporting if required

Application is packaged as maven projected
# constrain
1. initial position has to be between 0 and 5 for both x and y coordinator


# how to run
1. install maven, java 8
2. run maven clean install
3. java -jar target\toy-app-1.1.1.jar
