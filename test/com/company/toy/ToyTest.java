package com.company.toy;

import com.company.util.Direction;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ToyTest {

   Toy toy = new Toy();

   @Before
   public void setup(){
       toy.setX(0);
       toy.setY(0);
       toy.setDirection(Direction.NORTH.name());

   }

    @Test
    public void move() {
        List<String> cmd=new ArrayList<String>();
        cmd.add("mov1e");
        assertEquals(true,toy.move(cmd));

    }

    @Test
    public void moveTest1() {
        List<String> cmd=new ArrayList<String>();
        cmd.add("Move");
        assertEquals(true,toy.move(cmd));
        assertEquals(1,toy.getY());
        assertEquals(0,toy.getX());

    }

    @Test
    public void moveReport() {
        List<String> cmd=new ArrayList<String>();
        cmd.add("Report");
        assertEquals(false,toy.move(cmd));
        assertEquals(0,toy.getY());
        assertEquals(0,toy.getX());

    }
    @Test
    public void changeDirectionLeft() {
        List<String> cmd=new ArrayList<String>();
        cmd.add("left");
        assertEquals(true,toy.move(cmd));
        assertEquals(0,toy.getY());
        assertEquals(0,toy.getX());
        assertEquals("WEST",toy.getDirection());
        cmd=new ArrayList<String>();
        cmd.add("left");
        assertEquals(true,toy.move(cmd));
        assertEquals("SOUTH",toy.getDirection());
        cmd=new ArrayList<String>();
        cmd.add("left");
        assertEquals(true,toy.move(cmd));
        assertEquals("EAST",toy.getDirection());
        cmd=new ArrayList<String>();
        cmd.add("left");
        assertEquals(true,toy.move(cmd));
        assertEquals("NORTH",toy.getDirection());

    }

    @Test
    public void changeDirectionRigth() {
        List<String> cmd=new ArrayList<String>();
        cmd.add("right");
        assertEquals(true,toy.move(cmd));
        assertEquals(0,toy.getY());
        assertEquals(0,toy.getX());
        assertEquals("EAST",toy.getDirection());
        cmd=new ArrayList<String>();
        cmd.add("right");
        assertEquals(true,toy.move(cmd));
        assertEquals("SOUTH",toy.getDirection());
        cmd=new ArrayList<String>();
        cmd.add("right");
        assertEquals(true,toy.move(cmd));
        assertEquals("WEST",toy.getDirection());
        cmd=new ArrayList<String>();
        cmd.add("right");
        assertEquals(true,toy.move(cmd));
        assertEquals("NORTH",toy.getDirection());

    }
}