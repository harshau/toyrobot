package com.company.util;

import com.company.toy.Toy;

import java.util.*;

/**
 * Read user instruction via console
 */
public class ReadCommand {

    /**
     * read customer inputs via System input
     * @return
     */
    public List<String> readCommands(){

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String [] steps = input.trim().split(",");
        return Arrays.asList(steps);
    }


    /**
     * validate initial command and set toy robot's initial position on table     *
     * @param cmds
     * @param toy
     * @return
     */
    public static boolean validateInitialCommand(List<String> cmds , Toy toy){
        boolean valid=false;
        List<String> validDirections=new ArrayList<String>();
        validDirections.add(Direction.SOUTH.name());
        validDirections.add(Direction.NORTH.name());
        validDirections.add(Direction.EAST.name());
        validDirections.add(Direction.WEST.name());

        String regex = "\\d+";
        int x,y;

        if(cmds.size()==3){

            if(cmds.get(0).trim().toLowerCase().startsWith("place")){
                String[] cmdss =cmds.get(0).trim().split(" ");

                if(cmdss.length!=2) return valid;
                if (!cmdss[1].trim().matches(regex)){ return  valid;}
                x= Optional.of(Integer.valueOf(cmdss[1].trim())).orElse(999999);

                if (!cmds.get(1).trim().matches(regex)){ return  valid;}
                y=Optional.of(Integer.valueOf(cmds.get(1).trim())).orElse(999999);

                String direction = Optional.of(cmds.get(2)).orElse("NotDefined").trim();
                if(validDirections.contains(direction.toUpperCase()) && y<=5 && x<=5){
                    toy.setDirection(direction.toUpperCase());
                    toy.setX(x);
                    toy.setY(y);
                    valid=true;
                }
            }
        }

        return valid;
    }



}
