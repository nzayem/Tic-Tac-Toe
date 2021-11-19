import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int x, y;
        int counterEmpty = 9;
        String player = "Player X";
        boolean boardActive = true;

        Scanner scanner = new Scanner(System.in);

        String[][] boardMatrix = new String[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardMatrix[i][j] = "_";
            }
        }

        printBoard(boardMatrix);

        while (true) {

            try {

                System.out.print("Enter the coordinates: ");

                x = scanner.nextInt();
                y = scanner.nextInt();

                if (x > 3 || y > 3) {

                    System.out.println("Coordinates should be from 1 to 3!");

                    boardActive = false;


                } else if (!boardMatrix[x - 1][y - 1].equals("_")) {

                    System.out.println("This cell is occupied! Choose another one!");

                    boardActive = false;


                } else if ("Player X".equals(player)) {

                    assingXorO(boardMatrix, x, y, "X");

                    counterEmpty--;

                    player = "Player O";

                    boardActive = true;

                } else if ("Player O".equals(player)) {

                    assingXorO(boardMatrix, x, y, "O");

                    counterEmpty--;

                    player = "Player X";
                    boardActive = true;

                }

                if (boardActive) {

                    printBoard(boardMatrix);

                }


                if (winCase(boardMatrix, "X")) {

                    System.out.println("X wins");
                    break;

                } else if (winCase(boardMatrix, "O")) {

                    System.out.println("O wins");
                    break;

                } else if (counterEmpty == 0) {

                    System.out.println("Draw");
                    break;

                }


            } catch (Exception e) {

                System.out.println("You should enter numbers!");

                scanner.nextLine();

            }
        }

        scanner.close();

    }

    public static void printBoard(String[][] array) {

        System.out.println("---------");

        System.out.println("| " + array[0][0] + " " + array[0][1] + " " + array[0][2] + " |");
        System.out.println("| " + array[1][0] + " " + array[1][1] + " " + array[1][2] + " |");
        System.out.println("| " + array[2][0] + " " + array[2][1] + " " + array[2][2] + " |");

        System.out.println("---------");
    }

    public static boolean winCase(String[][] array, String a) {

        return(array[0][0].equals(a) && array[0][1].equals(a) && array[0][2].equals(a)
                || (array[1][0].equals(a) && array[1][1].equals(a) && array[1][2].equals(a))
                || (array[2][0].equals(a) && array[2][1].equals(a) && array[2][2].equals(a))
                || (array[0][0].equals(a) && array[1][0].equals(a) && array[2][0].equals(a))
                || (array[0][1].equals(a) && array[1][1].equals(a) && array[2][1].equals(a))
                || (array[0][2].equals(a) && array[1][2].equals(a) && array[2][2].equals(a))
                || (array[0][0].equals(a) && array[1][1].equals(a) && array[2][2].equals(a))
                || (array[0][2].equals(a) && array[1][1].equals(a) && array[2][0].equals(a)));
    }


    public static void assingXorO(String[][] board, int x, int y, String xoro) {

        board[x -1][y - 1] = xoro;

    }

}
