package lesson7;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Parser {

    private File book;
    private List<String> words;
    private static final String bookAbsentMessage = "Book \"%s\" doesn't exist";

    public Parser(File book) throws IOException {
        this.book = book;
        this.words = getAllWordsFromBook();
    }

    private List<String> getAllWordsFromBook() throws IOException {
        try(BufferedReader text = new BufferedReader(new FileReader(book))) {
            return text.lines()
                    .map(line -> line.split(" "))
                    .flatMap(Arrays::stream)
                    .map(word -> word.trim().toLowerCase().replaceAll("[^a-zA-ZА-Яа-я\\-_]",""))
                    .filter(word -> !word.equals("-"))
                    .filter(word -> !word.equals("_"))
                    .filter(word -> !word.equals(""))
                    .toList();
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException(String.format(bookAbsentMessage, book.getName()));
        }
    }

    public List<String> get10MostPopularWordsWithCountOfCharsMoreThan2() {
        return words.stream()
                .filter(word -> word.length() > 2)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public long getCountOfUniqueWords() {
        return new HashSet<>(words).size();
    }

    public void saveDataToFile() throws FileNotFoundException {
        try {
            writeDataToCarrier(new PrintWriter(getStatisticsPath()));
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException(String.format(bookAbsentMessage, book.getName()));
        }
    }

    public void saveDataToConsole() {
        writeDataToCarrier(new PrintWriter(System.out, false, StandardCharsets.UTF_8));
    }

    private void writeDataToCarrier(PrintWriter wordsWriter) {
        try(wordsWriter) {
            for (String word: get10MostPopularWordsWithCountOfCharsMoreThan2()) {
                wordsWriter.write(word + " - " + word.length() + " chars\n");
            }
            wordsWriter.write("Count of unique words: " + getCountOfUniqueWords());
            wordsWriter.flush();
        }
    }

    private String getStatisticsPath() {
        String[] tokens = book.getName().split("\\.");
        String newFileName = tokens[tokens.length-2] + "_statistics." + tokens[tokens.length-1];
        return book.getParent() + "\\" + newFileName;
    }

}
