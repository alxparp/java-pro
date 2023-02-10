package lesson7;

import java.io.File;
import java.util.Scanner;

public class Utils {

    private final static String PATH_TO_HOMEWORK = "src\\main\\java\\lesson7\\";

    public static String readFileTitle(String message) {
        System.out.print(message);
        Scanner readingData = new Scanner(System.in);
        return readingData.nextLine();
    }

    public static File getFile(String fileName) {
        String bookTitleWithFullPath = PATH_TO_HOMEWORK + fileName;
        return new File(bookTitleWithFullPath);
    }

}
