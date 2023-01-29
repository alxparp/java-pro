package lesson5;

import java.util.*;

public class FileNavigator {

    private final Map<String, Set<FileData>> listFiles;

    public FileNavigator() {
        listFiles = new HashMap<>();
    }

    public void add(String path, FileData file) {
        if (!path.equals(file.getPath())) {
            System.out.println("Paths " + path + " and " + file.getPath() + " don't correspond");
            return;
        }
        listFiles.computeIfAbsent(path, s -> new TreeSet<>()).add(file);
    }

    public List<FileData> find(String path) {
        return listFiles.get(path).stream().toList();
    }

    public List<FileData> filterBySize(int size) {
        return sortBySize().stream()
                .takeWhile(x -> x.getSize() <= size)
                .toList();
    }

    public void remove(String path) {
        listFiles.remove(path);
    }

    public List<FileData> sortBySize() {
        return listFiles.values().stream()
                .flatMap(Collection::stream)
                .sorted()
                .toList();
    }
}
