package World;


import jdk.jshell.spi.ExecutionControl;

import java.io.InputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ExecutionControl.NotImplementedException {

        InputStream input = System.in;
        Scanner readInput = new Scanner(input);

        System.out.println("Please enter your field width: ");
        String worldWidth = readInput.nextLine();

        System.out.println("Please enter your field height: ");
        String worldHeight = readInput.nextLine();

        System.out.println("Would you like to a random world(R) or set it up yourself(Y): ");
        String setUpChoice = readInput.nextLine();

        World oldWorld;

        if(setUpChoice.equals("Y")) {
            throw new ExecutionControl.NotImplementedException("Not yet implemented");
        } else {
            oldWorld = new World(Integer.parseInt(worldHeight),Integer.parseInt(worldWidth));
        }

        World newWorld = null;

        while(!(oldWorld.equals(newWorld))) {
            if(newWorld != null) {
                oldWorld = newWorld;
            }
            newWorld = oldWorld.evolve();
            System.out.print(newWorld + "\n\n");
        }

    }
}

