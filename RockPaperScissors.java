package MiniGames;

import java.util.*;

public class RockPaperScissors {
    static int compScore = 0;
    static int playerScore = 0;
    static String tieGame = "The game is a tie! #dnf";
    static String youLose = "you lose :(";
    static String youWin = "you win :)";
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            String playerMove = null;
            String computerMove = null;
            for (int i = 0; i < 100; i++) {
                String[] rps = {"r", "p", "s"};
                computerMove = rps[new Random().nextInt(rps.length)];
                while (true) {
                    System.out.println("Please enter your next move(r, p or s)");
                    playerMove = scanner.nextLine();
                    if (playerMove.equals("r") || playerMove.equals("p") || playerMove.equals("s")) {
                        break;
                    }
                    System.out.println(playerMove + " is not valid");
                }
                System.out.println("Computer played with: " + computerMove);
                countPlayerScore(computerMove, playerMove);
                countComputerScore(computerMove, playerMove);
                if (compScore == 3) {
                    break;
                }else {
                    if (playerScore == 3) {
                    break;
                    }
                }
            }

            System.out.println("----------------------------------------------");
            System.out.println("Final computer score: " + compScore);
            System.out.println("Final player score: " + playerScore);
            System.out.println("----------------------------------------------");

            System.out.println("do you wanna play again?(y/n)");
            String playAgain = scanner.nextLine();
            if (playAgain.equals("y")) {
                System.out.println("continue game");
                compScore = 0;
                playerScore = 0;
            } else if (playAgain.equals("n")) {
                System.out.println("end game");
                break;
            }
        }
        scanner.close();
    }

    private static void countPlayerScore(String computeMove, String playerMove) {
        if (computeMove.equals(playerMove)) {
            System.out.println(tieGame);
        } else if (playerMove.equals("r")) {
            if (computeMove.equals("p")) {
                System.out.println(" ");
            } else if (computeMove.equals("s")) {
                System.out.println(youWin);
                playerScore++;
                System.out.println("player score is: " + playerScore);
            }
        } else if (playerMove.equals("p")) {
            if (computeMove.equals("r")) {
                System.out.println(youWin);
                playerScore++;
                System.out.println("player score is: " + playerScore++);
            } else if (computeMove.equals("s")) {
                System.out.println(" ");
            }
        } else if (playerMove.equals("s")) {
            if (computeMove.equals("p")) {
                System.out.println(youWin);
                playerScore++;
                System.out.println("player score is: " + playerScore);
            } else if (computeMove.equals("r")) {
                System.out.println(" ");
            }
        }

    }

    private static void countComputerScore(String computerMove, String playerMove) {
        switch (playerMove) {
            case "r":
                if (computerMove.equals("p")) {
                    System.out.println(youLose);
                    compScore++;
                    System.out.println("computer score is: " + compScore);
                }
                break;
            case "p":
                if (computerMove.equals("r")) {
                    System.out.println(" ");
                } else if (computerMove.equals("s")) {
                    System.out.println(youLose);
                    compScore++;
                    System.out.println("computer score is: " + compScore);
                }
                break;
            case "s":
                if (computerMove.equals("p")) {
                    System.out.println(" ");
                } else if (computerMove.equals("r")) {
                    System.out.println(youLose);
                    compScore++;
                    System.out.println("computer score is: " + compScore);
                }
                break;
            default:
        }
    }
}