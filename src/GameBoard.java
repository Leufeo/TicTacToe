import java.util.Scanner;

public class GameBoard {
    private Character state[][] = new Character[3][3];

    public Character finished() {
        Character winner = rowsWin();
        if (winner != null) {
            return winner;
        }
        winner = columnWin();
        if (winner != null) {
            return winner;
        }
        winner = diagonalWin();
        if (winner != null) {
            return winner;
        }
        winner = boardFilled();
        if (winner != null) {
            return winner;
        }
        return null;
    }
    public short determineBeginner(String name1, String name2)
    {
        short nextPlayer = 2;
        if (Math.random() < 0.5)
        {
            System.out.printf(name1 + " begins." + '\n');
            nextPlayer = 1;
        }
        if (nextPlayer == 2)
        {
            System.out.printf(name2 + " begins." + '\n');
        }
        return nextPlayer;
    }
    public void display()
    {
        for (int i=0; i<3; i++)
        {
            for (int j=0; j<2; j++)
            {
                System.out.printf(nullToSpace(state[i][j]) + " | ");
            }
            System.out.printf("" + nullToSpace(state[i][2]) + '\n');
        }
    }
    public String findWinnerName(char winnerSymbol, Player player1, Player player2)
    {
        String winner="Nobody";
        if (winnerSymbol == player1.symbol)
        {
            winner = player1.name;
        }
        if (winnerSymbol == player2.symbol)
        {
            winner = player2.name;
        }
        return winner;
    }

    public short enterMove(short nextPlayer, Player player1, Player player2)
    {
        if (nextPlayer == 1)
        {
            requestInputMove(player1);
            nextPlayer = 2;
        }
        else
        {
            requestInputMove(player2);
            nextPlayer = 1;
        }
        return nextPlayer;
    }

    private void requestInputMove(Player player)
    {
        System.out.printf(player.name + ", enter your move: ");
        Scanner sc = new Scanner(System.in);
        int rowAndColoumn = Integer.parseInt(sc.nextLine());
        state[rowAndColoumn/10-1][rowAndColoumn%10-1] = player.symbol;
    }

    private Character rowsWin() {
        for (int i = 0; i < 3; i++) {
            if (state[i][0] == state[i][1] && state[i][0] == state[i][2]) {
                return state[i][0];
            }
        }
        return null;
    }

    private Character columnWin() {
        for (int i = 0; i < 3; i++) {
            if (state[0][i] == state[1][i] && state[0][i] == state[2][i]) {
                return state[0][i];
            }
        }
        return null;
    }

    private Character diagonalWin() {
        if (state[0][0] == state[1][1] && state[0][0] == state[2][2]) {
            return state[1][1];
        }
        if (state[1][1] == state[0][2] && state[1][1] == state[2][0]) {
            return state[1][1];
        }
        return null;
    }

    private Character boardFilled() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (state[i][j] == null) {
                    return null;
                }
            }
        }
        return ' ';
    }

    private char nullToSpace (Character a)
    {
        char b;
        if (a == null)
        {
            b = ' ';
        }
        else
        {
            b = a;
        }
        return b;
    }
}