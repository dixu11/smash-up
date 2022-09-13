package pl.dixu.client;

import pl.dixu.server.Point;

public class Bound {

    private Point point;
    private int width;
    private int height;

    public Bound(Point point, int width, int height) {
        this.point = point;
        this.width = width;
        this.height = height;
    }


    public boolean isInBound(Point other) {
        return other.x >= point.x && other.x <= point.x + width && other.y >= point.y && other.y <= point.y + height;
    }
}
