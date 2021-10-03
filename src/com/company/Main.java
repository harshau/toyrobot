package com.company;

import com.company.toy.Toy;
import com.company.util.ReadCommand;

import java.util.List;


import static com.company.util.ReadCommand.validateInitialCommand;

/**
 * starts application and read input
 */
public class Main {

    public static void main(String[] args) {
        ReadCommand command = new ReadCommand();
        Toy toy=new Toy();

        System.out.print("Please Start with current position and direction (e.g. Place 0,0,North ):");
        List<String> cmd = command.readCommands();


        //discard all command until initial place and direction is shared
        while( !validateInitialCommand(cmd,toy)){
            System.out.println("Initial position is not valid please try again(e.g. Place 0,0,North ):");
            cmd = command.readCommands();
        }
        cmd = command.readCommands();


        boolean nextRead =toy.move( cmd);
        while (nextRead) {
            cmd=command.readCommands();
            nextRead=toy.move( cmd);

        }


    }






}
