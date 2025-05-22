import java.io.PrintWriter;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class PasswordServer extends SingleThreadTCPServer {

    @Override
    public void handleMessage(String message, PrintWriter out) {
        String[] args = message.trim().split(" ");

        if (args.length != 3) {
            out.println("ERROR: Debe enviar exactamente tres argumentos separados por espacios.");
            return;
        }

        String letters = args[0];
        String digits = args[1];
        String specials = args[2];

        if (letters.isEmpty() || digits.isEmpty() || specials.isEmpty()) {
            out.println("ERROR: Ninguna de las cadenas puede estar vacía.");
            return;
        }

        String password = generatePassword(letters, digits, specials);
        out.println("Generated password: " + password);
    }

    private String generatePassword(String letters, String digits, String specials) {
        Random random = new Random();
        List<Character> passwordChars = new ArrayList<>();

        // 1. Añadir un dígito obligatorio
        passwordChars.add(digits.charAt(random.nextInt(digits.length())));

        // 2. Añadir un carácter especial obligatorio
        passwordChars.add(specials.charAt(random.nextInt(specials.length())));

        // 3. Rellenar con letras (8 - 2 = 6 letras restantes)
        for (int i = 0; i < 6; i++) {
            passwordChars.add(letters.charAt(random.nextInt(letters.length())));
        }

        // 4. Mezclar los caracteres
        Collections.shuffle(passwordChars);

        // 5. Construir la contraseña
        StringBuilder password = new StringBuilder();
        for (char ch : passwordChars) {
            password.append(ch);
        }

        return password.toString();
    }

    public static void main(String[] args) {
        new PasswordServer().startLoop(args);
    }
}