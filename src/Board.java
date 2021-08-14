import java.util.Random;
import java.util.Scanner;

public class Board {
    Scanner scanner = new Scanner(System.in);


    private Field[] fields;
    private Player FirstPlayer;
    Random generator = new Random();

    public Player getFirstPlayer() {
        return FirstPlayer;
    }

    public Board(Player player1, Player player2) {
        Field[] fields = new Field[9];
        for (int i = 0; i < 9; i++) {
            fields[i] = new Field(i, Symbol.E);
        }
        if (generator.nextBoolean()) {
            this.FirstPlayer = player1;
        } else {
            this.FirstPlayer = player2;
        }
        this.fields = fields;
    }

    public void DrawBoard() {
        for (int i = 0; i < 9; i++) {
            if (i == 1 || i == 4 || i == 7) {
                System.out.print("|");
                drawSymbol(fields[i]);
                System.out.print("|");
            } else {
                drawSymbol(fields[i]);
                if (i == 2 || i == 5) {
                    System.out.println("");
                    System.out.println("-----------");
                }
            }
        }
    }

    private void drawSymbol(Field field) {
        if (field.getSymbol() == Symbol.E) {
            System.out.print("   ");
        } else {
            System.out.print(" " + field.getSymbol() + " ");
        }
    }

    public void FillField(Player player) {
        fields[EnterAndCheckField(player)].setSymbol(player.getSymbol());
    }

    private int EnterAndCheckField(Player player) {
        int field;
        while (true) {
            System.out.println("");
            System.out.print(player.getName() + " enter field index to fill: ");
            System.out.println("");
            field = scanner.nextInt();
            if (fields[field].getSymbol().equals(Symbol.E)) {
                break;
            }
        }
        return field;
    }


    public boolean checkFields() {
        int[][] combs = new int[8][3];
        combs[0] = new int[]{0, 1, 2};
        combs[1] = new int[]{3, 4, 5};
        combs[2] = new int[]{6, 7, 8};
        combs[3] = new int[]{0, 3, 6};
        combs[4] = new int[]{1, 4, 7};
        combs[5] = new int[]{2, 5, 8};
        combs[6] = new int[]{0, 4, 8};
        combs[7] = new int[]{2, 4, 6};

        for (int i = 0; i < 8; i++) {
            if ((fields[combs[i][0]].getSymbol().equals(fields[combs[i][1]].getSymbol())) &&
                    (fields[combs[i][0]].getSymbol().equals(fields[combs[i][2]].getSymbol()) &&
                            (fields[combs[i][0]].getSymbol().equals(Symbol.O) || fields[combs[i][0]].getSymbol().equals(Symbol.X)))) {
                return true;
            }
        }
        return false;
    }
}