package lesson5;

public class FileData implements Comparable<FileData> {

    private String name;
    private byte size;
    private String path;

    public FileData(String name, byte size, String path) {
        this.name = name;
        this.size = size;
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FileData fileData = (FileData) o;

        if (size != fileData.size) return false;
        if (!name.equals(fileData.name)) return false;
        return path.equals(fileData.path);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (int) size;
        result = 31 * result + path.hashCode();
        return result;
    }

    @Override
    public int compareTo(FileData o) {
        return getSize()-o.getSize();
    }

    @Override
    public String toString() {
        return "FileData{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", path='" + path + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getSize() {
        return size;
    }

    public void setSize(byte size) {
        this.size = size;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
