package lesson9;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Client {

    public static void main(String[] args) throws IOException {

        Charset encoding = Charset.forName("KOI8-U");
        Pattern datePattern = Pattern.compile("^\\d{4}-\\d{2}-\\d{2} \\d{1,2}:\\d{2}:\\d{2}");

        try (Socket localhost = new Socket("localhost", 8081);
             Scanner in = new Scanner(localhost.getInputStream(), encoding);
             PrintWriter out = new PrintWriter(
                     new OutputStreamWriter(localhost.getOutputStream(), encoding),true)) {

            Scanner console = new Scanner(System.in);

            while (true) {
                try {
                    String response = in.nextLine();
                    System.out.println("Сервер: " + response);

                    if (datePattern.matcher(response).find()) break;
                } catch (NoSuchElementException ex) {
                    break;
                }

                System.out.print("Ви: ");
                String request = console.nextLine();
                out.println(request);
            }
        }

    }
}
