interface Notifier {
    void send(String message);
}

interface Urgent {
}

class UrgentNotifier implements Notifier, Urgent {

    private String type;

    UrgentNotifier(String type) {
        this.type = type;
    }

    public void send(String message) {
        System.out.println(type + ": " + message);
    }
}

public class practical6_2
 {
    public static void main(String[] args) {

        Notifier email = message ->
            System.out.println("Email: " + message);

        Notifier sms = message ->
            System.out.println("SMS: " + message);

        Notifier urgentEmail =
            new UrgentNotifier("Urgent Email");

        Notifier[] senders = {
            email,
            sms,
            urgentEmail
        };

        String message = "Meeting at 5 PM";

        for (Notifier sender : senders) {

            sender.send(message);

            if (sender instanceof Urgent) {
                sender.send(message);
            }
        }
    }
}