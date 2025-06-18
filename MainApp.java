import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== QUICKCHAT REGISTRATION ===");

        System.out.print("Enter username (max 5 characters with _): ");
        String username = scanner.nextLine();

        System.out.print("Enter password (at least 8 characters with uppercase, number, and symbol): ");
        String password = scanner.nextLine();

        System.out.print("Enter phone number (+27...): ");
        String phone = scanner.nextLine();

        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        User user = new User(username, password, phone, firstName, lastName);
        Login login = new Login(user);

        String registrationStatus = login.register();
        System.out.println(registrationStatus);

        if (!registrationStatus.equals("REGISTRATION SUCCESSFUL")) {
            System.out.println("Registration failed. Please try again.");
            return;
        }

        System.out.println("\n=== LOGIN ===");
        System.out.print("Enter username: ");
        String inputUsername = scanner.nextLine();

        System.out.print("Enter password: ");
        String inputPassword = scanner.nextLine();

        if (login.authenticate(inputUsername, inputPassword)) {
            System.out.println(login.getLoginMessage(inputUsername, inputPassword));

            System.out.print("Enter recipient number (+27 format): ");
            String recipient = scanner.nextLine();

            if (!Message.checkRecipientCell(recipient)) {
                System.out.println("Invalid recipient number.");
                return;
            }

            System.out.print("Enter your message: ");
            String content = scanner.nextLine();

            Message msg = new Message(recipient, content);

            if (!msg.checkMessageLength()) {
                System.out.println("Message is too long. Must be under 250 characters.");
                return;
            }

            System.out.println("\nMessage successfully created!");
            System.out.println("Message ID: " + msg.getMessageID());
            System.out.println("Message Hash: " + msg.getMessageHash());
            System.out.println("Recipient: " + msg.getRecipient());
            System.out.println("Message: " + msg.getContent());

        } else {
            System.out.println("Login failed.");
        }
    }
}
