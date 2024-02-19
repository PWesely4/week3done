import java.security.SecureRandom;
import java.util.Scanner;
public class week3{
    int userRow = 0;
    int userCol = 0;

    public void run() {
        createGameGrid();
    }
    public void testRandomNums(){
        SecureRandom Rand = new SecureRandom();
        int num = Rand.nextInt();
        System.out.println(num);
        num = Rand.nextInt();
        System.out.println(num);
    }

    public void createGameGrid () {
        Scanner scnr = new Scanner(System.in);
        int[][] grid = new int[10][10];
        SecureRandom Rand = new SecureRandom();
        int wallChance = 10;

        for(int y = 0; y < grid.length; y++ ) {
            for(int x = 0; x < grid[y].length; x++) {
                int temp = Rand.nextInt(100);
                if (temp < wallChance) {
                    grid[y][x] = 1;
                }
                else {
                    grid[y][x] = 0;
                }
                System.out.print(grid[y][x] + "  ");
            }
            System.out.println();
        }
        while(grid[userRow][userCol] != 1 && userCol != 9 && userRow != 9) {
            System.out.println("1. if you would like to move right");
            System.out.println("2. if you would like to move down");
            int userInput = scnr.nextInt();
            if (userInput == 1) {
                userCol++;
                System.out.println("User position is: " + (userCol + 1) + ", " + (userRow + 1));
            } else if (userInput == 2) {
                userRow++;
                System.out.println("User position is: " + (userCol + 1) + ", " + (userRow + 1));
            } else {
                System.out.println("Invalid Input");
            }
        }
        if(grid[userRow][userCol] == 1) {
            System.out.println("You failed!");
        }
        else {
            System.out.println("You Win!");
        }

        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                if (y == userRow && x == userCol) {
                    System.out.print("X  ");
                } else {
                    System.out.print(grid[y][x] + "  ");
                }
            }
            System.out.println();
        }
    }
}