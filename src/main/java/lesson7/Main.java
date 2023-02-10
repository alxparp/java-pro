package lesson7;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Parser parser;
        String fileTitle = Utils.readFileTitle("Enter book name: ");

        try {
            parser = new Parser(Utils.getFile(fileTitle));
            parser.saveDataToFile();
            parser.saveDataToConsole();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

}
