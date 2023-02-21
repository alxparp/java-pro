package lesson7;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        BookParser bookParser;
        String fileTitle = Utils.readFileTitle("Enter book name: ");

        try {
            bookParser = new BookParser(Utils.getFile(fileTitle));
            bookParser.saveToFile();
            bookParser.saveToConsole();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

}
