public class MainGame {
    public static void main(String[] args) {
        boolean WinFlag = true;
        int filledFields = 0;

        PlayerBuilder builder = new PlayerBuilder();

        Player player1 = builder.buildFirstPlayer();
        Player player2 = builder.buildSecondPlayer(player1);
        Board board = new Board(player1, player2);
        Player CurrentPlayer = board.getFirstPlayer();


        while (true) {
            board.DrawBoard();
            board.FillField(CurrentPlayer);
            filledFields++;
            if (board.checkFields()) break;
            if (filledFields == 9) {
                WinFlag = false;
                break;
            }
            CurrentPlayer = CurrentPlayer.equals(player1) ? player2 : player1;
        }

        FinalMessage(CurrentPlayer, board, WinFlag);
    }


    public static void FinalMessage(Player currentPlayer, Board board, boolean WinFlag) {
        board.DrawBoard();
        System.out.println("");
        System.out.println("");

        if (WinFlag) {
            System.out.println(currentPlayer.getName() + " wins!");
        } else {
            System.out.println("Nobody wins :(");
        }
    }
}

