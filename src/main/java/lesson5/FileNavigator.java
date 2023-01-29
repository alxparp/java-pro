package lesson5;

import java.util.*;

public class FileNavigator {

    private final Map<String, Set<FileData>> listFiles;

    public FileNavigator() {
        listFiles = new HashMap<>();
    }

    public void add(String path, FileData file) {
        if (path == null || file == null ) {
            return;
        }
        if (!path.equals(file.getPath())) {
            System.out.println("Paths " + path + " and " + file.getPath() + " don't correspond");
            return;
        }
        if (!listFiles.containsKey(path)) {
            Set<FileData> files = new TreeSet<>();
            files.add(file);
            listFiles.put(path, files);
        } else {
            Set<FileData> files = listFiles.get(path);
            files.add(file);
        }
    }

    public List<FileData> find(String path) {
        if (path != null)
            return listFiles.get(path).stream().toList();
        return new ArrayList<>();
    }

    public List<FileData> filterBySize(int size) {
        List<FileData> returnedList = new ArrayList<>();
        if (size <= 0) return returnedList;
        for (FileData fileData: sortBySize()) {
            if (fileData.getSize() <= size) {
                returnedList.add(fileData);
            } else {
                return returnedList;
            }
        }
        return returnedList;
    }

    public void remove(String path) {
        listFiles.remove(path);
    }

    public List<FileData> sortBySize() {
        Set<FileData> allFilesData = new TreeSet<>();
        for (Set<FileData> listFileData: listFiles.values()) {
            allFilesData.addAll(listFileData);
        }
        return allFilesData.stream().toList();
    }
}
