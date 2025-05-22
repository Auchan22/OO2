import java.io.PrintWriter;
import java.lang.Integer;

public class RepeatServer extends SingleThreadTCPServer {

    @Override
    public void handleMessage(String message, PrintWriter out) {
        String[] args = message.trim().split(" ");

        if (args.length < 2) {
            out.println("ERROR: Debe enviar exactamente 2 argumentos separados por espacios.");
            return;
        }

        String delimitador = " ";
        if (args.length == 3) {
            delimitador = args[2];
        }

        String word = args[0];
        int repeat_times = Integer.parseInt(args[1]);


        if (word.isEmpty()) {
            out.println("ERROR: La cadena no puede estar vacía.");
            return;
        }

        if (repeat_times == 0) {
            out.println("ERROR: La cadena no puede estar vacía y debe ser mayor a 0.");
            return;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < repeat_times; i++) {
            result.append(word);
            result.append( delimitador);
        }
        out.println("Resultado: " + result);
    }

    public static void main(String[] args) {
        new RepeatServer().startLoop(args);
    }
}