import java.util.Random;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //TODO
        //FILED - huge size matrix@
        //objects on the field@
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

        //TODO FIELD >
        String[][] gameField = new String[20][30];
        for (int rows = 0; rows < gameField.length; rows++) {
            for (int cols = 0; cols < gameField[rows].length; cols++) {
                gameField[rows][cols] = ".";
            }
        }
        //TODO FIELD <

        gameField[19][14] = "P";
        gameField[0][15] = "X";
        Random rndEnemy = new Random();

        //TODO OBJECT ON FIELD >
        for (int i = 0; i < 70; i++) {
            int rowObj = rndEnemy.nextInt(0, 20);
            int colObj = rndEnemy.nextInt(0, 30);
            if (gameField[rowObj][colObj].equals("Z") || gameField[rowObj][colObj].equals("P") || gameField[rowObj][colObj].equals("X")) {
                i--;
            } else {
                gameField[rowObj][colObj] = "@";
            }
        }
        //TODO OBJECT ON FIELD <

        //todo ENEMY START POSITIONS >
        for (int i = 0; i < 3; i++) {
            int enemyRow = rndEnemy.nextInt(0, 10);
            int enemyCol = rndEnemy.nextInt(0, 15);
            gameField[enemyRow][enemyCol] = "Z";
        }
        //todo ENEMY START POSITIONS <

        //TODO PLAY >
        while (gameField[0][15].equals("P")) {

            String playerMove = scanner.nextLine();

            if (playerMove.equals("W") || playerMove.equals("w")) {

            }
            if (playerMove.equals("S") || playerMove.equals("s")){

            }
            if (playerMove.equals("a") || playerMove.equals("A")){

            }
            if (playerMove.equals("d") || playerMove.equals("D")){

            }
        }
        //TODO PLAY<

        //todo PRINT VIEW >
        System.out.println(fieldVisualisation(gameField));
        //todo PRINT VIEW <
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
