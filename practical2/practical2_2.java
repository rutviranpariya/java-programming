class CinemaShow {

    private String title;
    private int seatsAvailable;
    private final int capacity;
    private static int totalBooked = 0;

    CinemaShow(String title, int capacity) {
        this.title = title;
        this.capacity = capacity;
        seatsAvailable = capacity;
    }

    CinemaShow(String title) {
        this(title, 100);
    }

    boolean book(int n) {
        if (n <= seatsAvailable) {
            seatsAvailable -= n;
            totalBooked += n;
            return true;
        }
        return false;
    }

    void cancel(int n) {
        seatsAvailable += n;

        if (seatsAvailable > capacity)
            seatsAvailable = capacity;
    }

    int getSeatsAvailable() {
        return seatsAvailable;
    }

    static int getTotalBooked() {
        return totalBooked;
    }
}

public class practical2_2 {

    public static void main(String[] args) {

        CinemaShow show = new CinemaShow("Avengers", 50);

        System.out.println("Book 20: " + show.book(20));
        System.out.println("Seats Available: " + show.getSeatsAvailable());

        System.out.println("Book 15: " + show.book(15));
        System.out.println("Seats Available: " + show.getSeatsAvailable());

        System.out.println("Book 20: " + show.book(20));
        System.out.println("Seats Available: " + show.getSeatsAvailable());

        show.cancel(10);
        System.out.println("Cancel 10");
        System.out.println("Seats Available: " + show.getSeatsAvailable());

        System.out.println("Book 15: " + show.book(15));
        System.out.println("Seats Available: " + show.getSeatsAvailable());

        show.cancel(100);
        System.out.println("Cancel 100");
        System.out.println("Seats Available: " + show.getSeatsAvailable());

        System.out.println("Total Booked: " + CinemaShow.getTotalBooked());
    }
}
