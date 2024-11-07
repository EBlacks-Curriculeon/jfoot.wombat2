package com.github.curriculeon.jfoot;

import com.github.git_leon.RandomUtils;

import static com.github.curriculeon.jfoot.Direction.*;

/**
 * Wombat. A Wombat moves forward until it hits the edge of the world, at
 * which point it turns left. If a wombat finds a leaf, it eats it.
 *
 * @author Michael Kölling
 * @version 2.0
 */
public class Wombat extends Herbivore {
    public Wombat() {
        setImage("wombat.png");
    }

    public void act() {
        if (this.foundLeaf()) {
            this.eatLeaf();
        } else if (this.canMove()) {
            this.move();
        } else {
            this.turnLeft();
        }
        if (atRightEdge()) {
            this.turnLeft();
            if (this.foundLeaf()) {
                this.eatLeaf();

            } else if (this.canMove()) {
                this.move();
            }
            if (this.canMove())
                this.turnLeft();
        } else if  (this.foundLeaf()){
            this.eatLeaf();
        }

        if (atLeftEdge()) {
            this.turnRight();
            if (this.foundLeaf()) {
                this.eatLeaf();

            } else if (this.canMove())
            this.move();{
            }
            if (this.canMove())
                this.turnRight();
        } else if (this.foundLeaf()) {
            this.eatLeaf();
        }


    }



    public void turnLeft() {
        if (this.getDirection() == EAST) {
            this.setDirection(NORTH);
        } else if (this.getDirection() == WEST) {
            this.setDirection(SOUTH);
        } else if (this.getDirection() == NORTH) {
            this.setDirection(WEST);
        } else {
            this.setDirection(EAST);
        }

    }
    public void turnRight() {
        if (this.getDirection() == WEST) {
            this.setDirection(SOUTH);
        } else if (this.getDirection() == EAST) {
            this.setDirection(SOUTH);
        } else if (this.getDirection() == SOUTH) {
            this.setDirection(WEST);
        } else {
            this.setDirection(WEST);
        }

    }
    //Wombat needs to know if and when it's at the right edge
    public boolean atRightEdge(){
        if (getDirection().equals(EAST) && !canMove()) {
            return true;
        } else {
            return false;
        }
    }
    // Wombat need to know if and when its at left edge
    public boolean atLeftEdge(){
        if (getDirection().equals(WEST) && !canMove()) {
            return true;
        } else {
            return false;
        }
    }

}



