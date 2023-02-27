package lesson9;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;

public class Server {

    public static void main(String[] args) {

        Charset encoding = Charset.forName("KOI8-U");
        Set<Character> ruLetters = Set.of('Ё', 'ё', 'Ъ', 'ъ', 'Ы', 'ы', 'Э', 'э');
        String greeting = "Привіт!";
        String bye = " Пока!";
        String question = "Що таке паляниця?";
        String answer = "Різновид українського хліба.";

        try (ServerSocket server = new ServerSocket(8081)) {
            try (Socket incoming = server.accept()) {
                InputStream inputStream = incoming.getInputStream();
                OutputStream outputStream = incoming.getOutputStream();

                try (Scanner in = new Scanner(inputStream, encoding);
                     PrintWriter out = new PrintWriter(
                             new OutputStreamWriter(outputStream, encoding),
                             true)) {

                    out.println(greeting);
                    String response = in.nextLine();

                    boolean isRuPhrase = response.chars()
                            .mapToObj(c -> (char) c)
                            .anyMatch(ruLetters::contains);

                    if (isRuPhrase) {
                        out.println(question);
                        response = in.nextLine();
                        if (!response.equals(answer)) return;
                    }

                    out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + bye);
                }

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}