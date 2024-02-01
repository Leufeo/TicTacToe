import java.util.Scanner;

public class Player {
    String name;
    char symbol;

    public Player()
    {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Who is the next player? ");
        this.name = sc.nextLine();

        System.out.printf("Which symbol has the player? ");
        this.symbol = sc.nextLine().charAt(0);
    }
}