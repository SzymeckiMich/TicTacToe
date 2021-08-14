import java.util.Scanner;

public class PlayerBuilder {
    Scanner scanner = new Scanner(System.in);

    public Player buildFirstPlayer() {
        String name;
        Symbol PlayerSymbol;
        System.out.println("Enter player name:");
        name = scanner.nextLine();
        System.out.println("Choose your symbol: 0 - CROSS, 1 - CIRCLE");
        int symbol = scanner.nextInt();
        scanner.nextLine();

        switch (symbol){
            case 0:
                PlayerSymbol = Symbol.X;
                break;
            default:
                PlayerSymbol = Symbol.O;
        }
        return new Player(name, PlayerSymbol);
    }

    public Player buildSecondPlayer(Player firstPlayer) {
        String name;
        Symbol PlayerSymbol;
        System.out.println("Enter player name:");
        name = scanner.nextLine();

        if (firstPlayer.getSymbol().equals(Symbol.O)) {
            PlayerSymbol = Symbol.X;
        } else {
            PlayerSymbol = Symbol.O;
        }
        return new Player(name, PlayerSymbol);
    }
}
