package ExpresionesRegulares;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejemplo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String texto = "Hola mundo!! estoy en Colombia!!";
        String regex;
        while (true) {
            regex = scanner.nextLine();

            if (regex.equals("exit"))
                break;
            Pattern patron = Pattern.compile(regex); // Expresion regular
            Matcher m = patron.matcher(texto);

            boolean coincidencia = m.find();
            System.out.println("¿Hay alguna coincidencia? " + coincidencia);
        }
    }
}