public class Field {

    private int index;
    private Symbol symbol;

    public Field(int index, Symbol symbol) {
        this.index = index;
        this.symbol = symbol;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

}
