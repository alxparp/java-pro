package lesson7;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BookParser {

    private File book;
    private List<String> words;
    private static final String bookAbsentMessage = "Book \"%s\" doesn't exist";
    private static final String bookPattern = "[^a-zA-Z]";

    public BookParser(File book) throws IOException {
        this.book = book;
        this.words = words();
    }

    private List<String> words() throws IOException {
        try(BufferedReader text = new BufferedReader(new FileReader(book))) {
            return text.lines()
                    .flatMap(line -> Arrays.stream(line.split(" ")))
                    .map(this::processWord)
                    .filter(word -> !word.equals(""))
                    .toList();
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException(String.format(bookAbsentMessage, book.getName()));
        }
    }

    private String processWord(String word) {
        return word.trim()
                .toLowerCase()
                .replaceAll(bookPattern, "");
    }

    public List<String> topWords() {
        return words.stream()
                .filter(word -> word.length() > 2)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public long uniqueWords() {
        return new HashSet<>(words).size();
    }

    public void saveToFile() throws FileNotFoundException {
        try {
            writeToCarrier(new PrintWriter(statPath()));
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException(String.format(bookAbsentMessage, book.getName()));
        }
    }

    public void saveToConsole() {
        writeToCarrier(new PrintWriter(System.out, false, StandardCharsets.UTF_8));
    }

    private void writeToCarrier(PrintWriter wordsWriter) {
        try(wordsWriter) {
            for (String word: topWords()) {
                wordsWriter.write(word + " - " + word.length() + " chars\n");
            }
            wordsWriter.write("Count of unique words: " + uniqueWords());
            wordsWriter.flush();
        }
    }

    private String statPath() {
        String[] tokens = book.getName().split("\\.");
        String newFileName = tokens[tokens.length-2] + "_statistics." + tokens[tokens.length-1];
        return book.getParent() + "\\" + newFileName;
    }

}
