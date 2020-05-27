package com.company;

public abstract class Piece {

    int positionX, positionY;
    boolean captured;

    public Piece(int positionX, int positionY) {
       this.positionX = positionX;
       this.positionY = positionY;
    }

    public abstract void move();

    public int[] getLocation() {
        return new int[]{positionX, positionY};
    }

    @Override
    public String toString() {
        return "Piece{" +
                "positionX=" + positionX +
                ", positionY=" + positionY +
                ", captured=" + captured +
                '}';
    }
}
