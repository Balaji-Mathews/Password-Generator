import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {

    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()-_=+[]{}|;:,.<>?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the desired length of the password: ");
        int length = scanner.nextInt();

        if (length < 1) {
            System.out.println("Password length should be at least 1.");
            return;
        }

        System.out.println("Choose character types to include:");
        System.out.println("1. Uppercase letters");
        System.out.println("2. Lowercase letters");
        System.out.println("3. Numbers");
        System.out.println("4. Symbols");
        System.out.print("Enter your choice(s) separated by spaces: ");
        scanner.nextLine(); // Consume the newline character
        String choices = scanner.nextLine();

        if (choices.isEmpty()) {
            System.out.println("You must select at least one character type.");
            return;
        }

        StringBuilder charPool = new StringBuilder();
        if (choices.contains("1")) {
            charPool.append(UPPERCASE_LETTERS);
        }
        if (choices.contains("2")) {
            charPool.append(LOWERCASE_LETTERS);
        }
        if (choices.contains("3")) {
            charPool.append(NUMBERS);
        }
        if (choices.contains("4")) {
            charPool.append(SYMBOLS);
        }

        String generatedPassword = generatePassword(length, charPool.toString());
        System.out.println("Generated Password: " + generatedPassword);
    }

    private static String generatePassword(int length, String charPool) {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(charPool.length());
            char randomChar = charPool.charAt(randomIndex);
            password.append(randomChar);
        }

        return password.toString();
    }
}
