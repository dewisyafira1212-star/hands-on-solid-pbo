package latihan1;

// 1. Interface spesifik (ISP)
interface Notifier {
    void send(String message);
}

// 2. Implementasi terpisah untuk tiap kanal (OCP)
class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Mengirim Email: " + message);
    }
}

class SMSNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Mengirim SMS: " + message);
    }
}

class WhatsAppNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Mengirim WhatsApp: " + message);
    }
}

// 3. Service bergantung pada abstraksi (DIP)
class NotificationService {
    private Notifier notifier;

    public NotificationService(Notifier notifier) {
        this.notifier = notifier;
    }

    public void notifyUser(String message) {
        notifier.send(message);
    }
}

public class Main {
    public static void main(String[] args) {
        NotificationService emailService = new NotificationService(new EmailNotifier());
        emailService.notifyUser("Halo, ini email test!");

        NotificationService smsService = new NotificationService(new SMSNotifier());
        smsService.notifyUser("Ini SMS test!");

        NotificationService waService = new NotificationService(new WhatsAppNotifier());
        waService.notifyUser("Ini pesan WhatsApp test!");
    }
}