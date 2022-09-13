package pl.dixu.server.card;

public enum DeckType {
    LOCATION(true), PLAYER(false);
    private boolean tap;

    DeckType(boolean tap) {
        this.tap = tap;
    }

    public boolean isTap() {
        return tap;
    }
}
