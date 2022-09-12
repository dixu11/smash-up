package pl.dixu.server.card;

public class Card {
    private String name;
    private CardType type;
    private int index = 1;

    public Card(String name, CardType type) {
        this.name = name;
        this.type = type;
    }

    public CardType getType() {
        return type;
    }

    public int getIndex() {
        return index;
    }
}
