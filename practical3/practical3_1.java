import java.util.Objects;

class Point {

    private int x;
    private int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Point))
            return false;

        Point p = (Point) obj;

        return x == p.x && y == p.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

public class practical3_1 {

    public static void main(String[] args) {

        Point[] points = {
            new Point(2, 3),
            new Point(4, 5),
            new Point(2, 3),
            new Point(6, 7),
            new Point(4, 5),
            new Point(8, 9)
        };

        int distinct = 0;

        for (int i = 0; i < points.length; i++) {

            boolean found = false;

            for (int j = 0; j < i; j++) {
                if (points[i].equals(points[j])) {
                    found = true;
                    break;
                }
            }

            if (!found)
                distinct++;
        }

        System.out.println("Distinct: " + distinct);
    }
}