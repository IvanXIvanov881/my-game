import java.util.Random;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //TODO
        //FILED - huge size matrix
        //objects on the field
        //loots for Player and Enemy

        //Player - object
        //Player - weapons
        //Player damage

        //Enemy - objects
        //enemy movement - random
        //Enemy - damage

        //System
        //movement - keys
        //Game difficult - Easy, Medium, High

        //in next release Levels

        //TODO LOCATION OF PLAYER AND ENEMIES>
        int playerRow = 19;
        int playerCol = 14;
        int z0Row = 0;
        int z0Col = 0;
        int z1Row = 0;
        int z1Col = 0;
        int z2Row = 0;
        int z2Col = 0;

        //TODO FIELD>
        String[][] gameField = new String[20][30];
        for (int rows = 0; rows < gameField.length; rows++) {
            for (int cols = 0; cols < gameField[rows].length; cols++) {
                gameField[rows][cols] = ".";
            }
        }
        gameField[19][14] = "P";
        gameField[0][15] = "X";
        Random rndEnemy = new Random();

        //TODO RANDOM OBJECT ON FIELD >
        for (int i = 0; i < 50; i++) {
            int rowObj = rndEnemy.nextInt(0, 20);
            int colObj = rndEnemy.nextInt(0, 30);
            if (gameField[rowObj][colObj].equals("Z") || gameField[rowObj][colObj].equals("P") || gameField[rowObj][colObj].equals("X")) {
                i--;
            } else {
                gameField[rowObj][colObj] = "@";
            }
        }

        //TODO START POSITIONS >
        for (int i = 0; i < 3; i++) {
            int enemyRow = rndEnemy.nextInt(0, 10);
            int enemyCol = rndEnemy.nextInt(0, 15);
            gameField[enemyRow][enemyCol] = "Z" + i;
            for (int row = 0; row < gameField.length; row++) {
                for (int col = 0; col < gameField[row].length; col++) {
                    if (gameField[row][col].equals("Z0")) {
                        z0Row = row;
                        z0Col = col;
                    }
                    if (gameField[row][col].equals("Z1")) {
                        z1Row = row;
                        z1Col = col;
                    }
                    if (gameField[row][col].equals("Z2")) {
                        z2Row = row;
                        z2Col = col;
                    }
                }
            }
        }
        //todo PRINT VIEW >
        System.out.println(fieldVisualisation(gameField));
        //TODO PLAY >
        while (!gameField[0][15].equals("P")) {
            String playerMove = scanner.nextLine();

            if (playerMove.equals("up") || playerMove.equals("w") || playerMove.equals("W")) {
                if (gameField[playerRow - 1][playerCol].equals(".")) {
                    gameField[playerRow - 1][playerCol] = "P";
                    gameField[playerRow][playerCol] = ".";
                    playerRow--;
                }
            }
            if (playerMove.equals("down") || playerMove.equals("s") || playerMove.equals("S")) {
                if (gameField[playerRow + 1][playerCol].equals(".")) {
                    gameField[playerRow + 1][playerCol] = "P";
                    gameField[playerRow][playerCol] = ".";
                    playerRow++;
                }
            }
            if (playerMove.equals("left") || playerMove.equals("a") || playerMove.equals("A")) {
                if (gameField[playerRow][playerCol - 1].equals(".")) {
                    gameField[playerRow][playerCol - 1] = "P";
                    gameField[playerRow][playerCol] = ".";
                    playerCol--;
                }
            }
            if (playerMove.equals("right") || playerMove.equals("d") || playerMove.equals("D")) {
                if (gameField[playerRow][playerCol + 1].equals(".")) {
                    gameField[playerRow][playerCol + 1] = "P";
                    gameField[playerRow][playerCol] = ".";
                    playerCol++;
                }
            }

            //TODO Enemy Movement>
            if (playerRow + 1 == z0Row && playerCol == z0Col ||
                    playerCol + 1 == z0Row && playerRow == z0Row ||
                    playerRow - 1 == z0Row && playerCol == z0Col ||
                    playerCol - 1 == z0Col && playerRow == z0Row ||
                    playerRow + 1 == z0Row && playerCol + 1 == z0Col ||
                    playerRow - 1 == z0Row && playerCol - 1 == z0Col ||
                    playerRow - 1 == z0Row && playerCol + 1 == z0Col ||
                    playerRow + 1 == z0Row && playerCol - 1 == z0Col) {
                gameField[playerRow][playerCol] = "ZZ";
                System.out.println(fieldVisualisation(gameField));
                System.out.println("Game Over!");
                System.out.println("You Lose!");
                return;
            }
            if (playerRow > z0Row && playerCol > z0Col) {
                if (gameField[z0Row + 1][z0Col + 1] == ".") {
                    gameField[z0Row + 1][z0Col + 1] = "Z0";
                    gameField[z0Row][z0Col] = ".";
                    z0Row = z0Row + 1;
                    z0Col = z0Col + 1;
                }
            }


            //todo PRINT VIEW >
            System.out.println(fieldVisualisation(gameField));
        }
    }

    public static StringBuilder fieldVisualisation(String[][] gameField) {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < gameField.length; row++) {
            for (int col = 0; col < gameField[row].length; col++) {
                sb.append(gameField[row][col]);
            }
            sb.append(System.lineSeparator());
        }
        return sb;
    }
}
//@import url("https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css");