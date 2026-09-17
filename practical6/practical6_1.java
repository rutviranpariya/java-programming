interface Switchable {
    void on();
    void off();

    default void toggle() {
        on();
    }
}

class Fan implements Switchable {
    public void on() {
        System.out.println("Fan is ON");
    }

    public void off() {
        System.out.println("Fan is OFF");
    }
}

class Light implements Switchable {
    public void on() {
        System.out.println("Light is ON");
    }

    public void off() {
        System.out.println("Light is OFF");
    }
}

interface SwitchPermission {
    boolean maySwitchOn(Switchable device, int hour);
}

public class practical6_1 {
    public static void main(String[] args) {

        Switchable[] devices = {
            new Fan(),
            new Light()
        };

        System.out.println("Toggling devices:");

        for (Switchable device : devices) {
            device.toggle();
        }

        int hour = 10;

        SwitchPermission anonymous = new SwitchPermission() {
            public boolean maySwitchOn(Switchable device, int hour) {
                return hour >= 6 && hour <= 22;
            }
        };

        SwitchPermission lambda = (device, h) -> h >= 8 && h <= 20;

        System.out.println("\nAnonymous Class:");

        for (Switchable device : devices) {
            System.out.println(
                anonymous.maySwitchOn(device, hour)
            );
        }

        System.out.println("\nLambda:");

        for (Switchable device : devices) {
            System.out.println(
                lambda.maySwitchOn(device, hour)
            );
        }
    }
}