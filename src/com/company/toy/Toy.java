package com.company.toy;

import com.company.util.Direction;

import java.util.ArrayList;
import java.util.List;


/**
 * Toy Robot class current location of robot is defined by x and y
 * and current face in direction
 * all commands executed are captured in commands
 */
public class Toy {

    private int x = 0;
    private int y = 0;
    private String direction = "";

    private List<String> commands = new ArrayList<String>();


    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public String getDirection() {
        return direction;
    }

    public void setY(int y) {
        this.y = y;
    }


    public void setDirection(String direction) {
        this.direction = direction;
    }

    /**
     * get command as parameter and move robot accordingly
     * any move which is not valid or will move robot off the table is ignored
     * @param command
     * @return
     */
    public boolean move(List<String> command  ){
        if(command.size()!=1){
            return true; //invalid command
        }
        String c = command.get(0).trim();
        if(c.equalsIgnoreCase("MOVE")){// move
            if(direction.equalsIgnoreCase(Direction.NORTH.toString()) && y<5){
                y=y+1;
                commands.add(c);
            }
            if(direction.equalsIgnoreCase(Direction.SOUTH.toString()) && y>0){
                y=y-1;
                commands.add(c);
            }
            if(direction.equalsIgnoreCase(Direction.EAST.toString()) && x<5){
              x=  x+1;
              commands.add(c);
            }
            if(direction.equalsIgnoreCase(Direction.WEST.toString()) && x>0){
                x=   x-1;
                commands.add(c);
            }

        }else if (c.equalsIgnoreCase("Left") ) {// turn Left direction
            changeDirection(c);
            commands.add(c);
        }else if (c.equalsIgnoreCase("right")) {// turn right direction
            changeDirection(c);
            commands.add(c);
        }else if (c.equalsIgnoreCase("report")) {// report
            printLocation();
            return false;
        }
        return true;
    }

    /**
     * changeDirection takes command and update direction accordingly
     * @param cmd
     */
    private void changeDirection(String cmd){
        if(direction.equalsIgnoreCase(Direction.NORTH.toString()) && cmd.equalsIgnoreCase("Left")){
            direction=Direction.WEST.toString(); return ;
        }
        if(direction.equalsIgnoreCase(Direction.WEST.toString()) && cmd.equalsIgnoreCase("Left")){
            direction=Direction.SOUTH.toString(); return ;
        }
        if(direction.equalsIgnoreCase(Direction.SOUTH.toString()) && cmd.equalsIgnoreCase("Left")){
            direction=Direction.EAST.toString(); return ;
        }
        if(direction.equalsIgnoreCase(Direction.EAST.toString()) && cmd.equalsIgnoreCase("Left")){
            direction=Direction.NORTH.toString(); return ;
        }
        if(direction.equalsIgnoreCase(Direction.EAST.toString()) && cmd.equalsIgnoreCase("Right")){
            direction=Direction.SOUTH.toString(); return ;
        }
        if(direction.equalsIgnoreCase(Direction.SOUTH.toString()) && cmd.equalsIgnoreCase("Right")){
            direction=Direction.WEST.toString(); return ;
        }
        if(direction.equalsIgnoreCase(Direction.WEST.toString()) && cmd.equalsIgnoreCase("Right")){
            direction=Direction.NORTH.toString(); return ;
        }
        if(direction.equalsIgnoreCase(Direction.NORTH.toString()) && cmd.equalsIgnoreCase("Right")){
            direction=Direction.EAST.toString(); return ;
        }

    }

    /**
     * print current location of direction or robot
     */
    private void printLocation(){
        System.out.println("Output: " + x+", "+y+", "+direction);

    }

    @Override
    public String toString() {
        return "Toy{" +
                "x=" + x +
                ", y=" + y +
                ", direction=" + direction +
                '}';
    }
}
