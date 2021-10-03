package com.company.util;

import com.company.toy.Toy;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ReadCommandTest {

    Toy toy;



    @Before
    public void setup(){
        toy= Mockito.mock(Toy.class);
    }

    @Test
    public void validateInitialCommand() {
        List<String> cmd= new ArrayList<>();
        cmd.add("place 3");
        cmd.add("3");
        cmd.add("north");
        assertEquals(true, ReadCommand.validateInitialCommand(cmd,toy));

    }

    @Test
    public void inValidInitialCommand() {
        List<String> cmd= new ArrayList<>();
        cmd.add("place 33");
        cmd.add("3");
        cmd.add("north");
        assertEquals(false, ReadCommand.validateInitialCommand(cmd,toy));

    }
    @Test
    public void inValidInitialCommand2() {
        List<String> cmd= new ArrayList<>();
        cmd.add("place 6");
        cmd.add("3");
        cmd.add("north");
        assertEquals(false, ReadCommand.validateInitialCommand(cmd,toy));

    }
    @Test
    public void inValidInitialCommand3() {
        List<String> cmd= new ArrayList<>();
        cmd.add("place 0");
        cmd.add("6");
        cmd.add("north");
        assertEquals(false, ReadCommand.validateInitialCommand(cmd,toy));

    }
    @Test
    public void ValidInitialCommand4() {
        List<String> cmd= new ArrayList<>();
        cmd.add("place 5");
        cmd.add("5");
        cmd.add("north");
        assertEquals(true, ReadCommand.validateInitialCommand(cmd,toy));

    }

    @Test
    public void inValidInitialCommand4() {
        List<String> cmd= new ArrayList<>();
        cmd.add("place 5");
        cmd.add("5");
        cmd.add("north1");
        assertEquals(false, ReadCommand.validateInitialCommand(cmd,toy));

    }
}