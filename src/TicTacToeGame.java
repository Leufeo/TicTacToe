public class TicTacToeGame {
    public void play()
    {
        Player player1 = new Player();
        Player player2 = new Player();
        GameBoard gameBoard = new GameBoard();
        short nextPlayer = gameBoard.determineBeginner(player1.name, player2.name);

        while (gameBoard.finished()==null)
        {
            gameBoard.display();
            nextPlayer = gameBoard.enterMove(nextPlayer, player1, player2);
        }


        gameBoard.display();
        System.out.printf(gameBoard.findWinnerName(gameBoard.finished(), player1, player2) + " won.");
    }
}