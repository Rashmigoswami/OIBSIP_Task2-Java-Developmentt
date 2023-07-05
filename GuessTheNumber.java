import java.util.Scanner;
import java.util.Random;
class Games {
    private int Userguess, chance, point;
    private final int realNumber;
    Games() {
        Random rn = new Random();
        realNumber = rn.nextInt(100);
    }
    public void setPts(int point) {
        this.point = point;
    }
    public void setChans(int chance) {
        this.chance = chance;
    }
    public int getChances() {
        return chance;
    }
    public void setGuessedNumber(int guessNo) {
        this.Userguess = guessNo;
    }
    public boolean guessno() {
        if (chance == 9) {
            chance++;
            return false;
        } else if (realNumber == Userguess) {
            System.out.println("You Guessed it Right ! CONGRATULATIONS:)");
            System.out.println("Your Score is: " + (10 - point) * 10);
            System.out.println("The answer is " + realNumber);
            return true;
        } else if (realNumber < Userguess) {
            System.out.println("You guessed more than the number");
            chance++;
            point++;
            System.out.println((10 - chance) + " NO. OF chances left");
            return false;
        } else {
            System.out.println("You guessed less  than the number");
            chance++;
            point++;
            System.out.println((10 - chance) + " no. of chances left");
            return false;
        }
    }
}
public class GuessTheNumber {
    public static void main(String[] args) {
        Games game = new Games();
        Scanner sc = new Scanner(System.in);
        int choice = 1;
        System.out.println("              Guess the Number Game         ");
        boolean exitVar = false;
        while (choice != 0) {
            System.out.println("1. Let's begin the Game");
            System.out.println("2. Exit");
            System.out.println("Enter your choice:");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    boolean won = false;
                    game.setChans(0);
                    game.setPts(0);
                    while (!exitVar && !won) {
                        System.out.println("Enter any number of your choice:");
                        game.setGuessedNumber(sc.nextInt());
                        exitVar = game.guessno();
                        if (game.getChances() == 10) {
                            System.out.println("You have lost!");
                            break;
                        }
                        if (exitVar) {
                            won = true;
                        }
                    }
                    exitVar = false;
                    System.out.println();
                }
                case 2 -> {
                    System.out.println("Exiting the game.");
                    choice = 0;
                }
                default -> System.out.println("Incorrect input! Enter the number again.");
            }
        }
    }
}