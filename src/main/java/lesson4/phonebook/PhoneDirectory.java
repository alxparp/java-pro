package lesson4.phonebook;

import java.util.LinkedList;
import java.util.List;

public class PhoneDirectory {

    private List<Record> records;

    public PhoneDirectory() {
        records = new LinkedList<>();
    }

    public void add(String name, String phone) {
        records.add(new Record(name, phone));
    }

    public Record find(String name) {
        for(Record record: records) {
            if (name.equals(record.getName())) {
                return record;
            }
        }
        return null;
    }

    public List<Record> findAll(String name) {
        List<Record> sameNameEntry = new LinkedList<>();
        for(Record record: records) {
            if (name.equals(record.getName())) {
                sameNameEntry.add(record);
            }
        }
        return sameNameEntry.size() > 0 ? sameNameEntry : null;
    }

}
