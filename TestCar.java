/**
 * Name: KC
 * Date: 01/15/2015
 * Assignment # 3,4,6
 * Summary: 1. Car object storing status
 *          2. Park multiple cars
 */

import java.util.*;
import java.io.*;

public class TestCar {

    public static void main(String[] args) {

        Car[] cars = new Car[10];

        for (int i = 0; i < cars.length; i++)
            cars[i] = new Car(); // call Car constructor to assign car qualities

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Which car would you like to use next (1-10)? ");
            int carIndex = input.nextInt() - 1;

            if (carIndex > 9 || carIndex < 0) {
                System.out.println("Error: invalid choice.\n");
                continue;
            }
            else {
                System.out.println(cars[carIndex].toString());

                System.out.println(
                        "What would you like to do next " +
                                "(1 - change ignition; 2 - change position of car; 3 - quit this program)?");
                int actionChoice = input.nextInt();

                if (actionChoice == 1)
                    cars[carIndex].changeIgnition();

                else if (actionChoice == 2) {
                    System.out.println(
                            "What direction would you like to move the car (1 - horizontal; 2 - vertical)?");
                    int directionChoice = input.nextInt();

                    if (directionChoice == 1) {
                        System.out.println("How far (negative value to move left)? ");
                        int changeInX = input.nextInt();


                        cars[carIndex].moveX(changeInX);
                    }
                    else if (directionChoice == 2) {
                        System.out.println("How far (negative value to move up)? ");
                        int changeInY = input.nextInt();

                        cars[carIndex].moveY(changeInY);
                    }
                    else
                        System.out.println("Error: invalid choice\n");
                }
                else if (actionChoice == 3) 
                    break;

                else 
                    System.out.println("Error: invalid choice\n");
            }
            System.out.println(cars[carIndex].toString());
        }
        System.exit(0);
    }
}



















