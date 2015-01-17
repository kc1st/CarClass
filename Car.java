/**
 * Name: KC
 * Date: 01/16/2015
 * Assignment #3.4.6
 * Changes: 1. add property: carNum
 *          2. more color choices
 * Cannot do: cannot check whether the position has been occupied.
 */

import java.io.*;
import java.util.*;

public class Car {

    private int x, y;
    private String color;
    private String carNum;
    private boolean ignition;
    private static ArrayList<String> carNumList;

    public Car() {

        carNumList = new ArrayList<String>();
        assignNum();
        assignColor();
        assignPosition();
        ignition = false;

    }
    public void assignNum() {

        carNum = "" + (char) ((int) (Math.random() * 25) + 'A');

        for (int i = 0; i <= 3; i++)

            carNum += (int) (Math.random() * 9);

        if (carNumList.isEmpty())
            carNumList.add(carNum);
        else if (!carNumList.contains(carNum))
            carNumList.add(carNum);
        else
            assignNum();
    }
    public String getNum () {

        return carNum;
    }
    public void assignColor() {

        Scanner fileReader = null;
        try {
            fileReader = new Scanner(new File("/Users/kc/GitHub/CarParking/CarColor.txt"));
        } catch (FileNotFoundException e) {}

        ArrayList<String> carColorList = new ArrayList<String>();
        int colorNum = 0;
        do {
            carColorList.add(fileReader.nextLine());
            colorNum++;
        } while (fileReader.hasNext());

        color = carColorList.get((int) (Math.random() * colorNum));
    }
    public String getColor() {

        return color;
    }
    public void assignPosition() {

        x = (int)(Math.random() * 20 + 1);
        y = (int)(Math.random() * 20 + 1);
    }
    public int move(int position, int change) {

        if (!ignition) {
            System.out.println("Error: the ignition is off. Please turn the ignition on.\n");
            return position;
        }
        else if (position + change < 0 || position + change > 20) {
            System.out.println("Error: you move the car beyond the vertical boundary.\n");
            return position;
        }
        else
            return position + change;
    }
    public void moveX(int change) {


        x = move(x,change);
    }
    public void moveY(int change) {
    
        y = move(y,change);
    }
    public int getX() {

        return x;
    }
    public int getY() {

        return y;
    }
    public void changeIgnition() {

        ignition = !ignition;
    }
    public boolean getIgnition() {

        return ignition;
    }
    @Override
    public String toString() {

        String carStats = "Car Stats:\nNumber: " + getNum()
                + "\nColor: " + getColor()
                + "\nIgnition: " + (ignition ? "On" : "Off")
                + "\nLocation: " + x + ", " + y + "\n";

        String[][] grid = new String[20][20];

        for (int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                grid[i][j]  = (i == y - 1 && j == x - 1 ? String.valueOf(getColor().charAt(0)) : "-");
                grid[i][j] += (j == grid.length - 1 ? "\n" : " ");
                carStats += grid[i][j];
            }
        }
        return carStats;
    }
}
