package lesson4;

import java.util.*;

public class Occurrence {

    public int countOccurrence(List<String> ranks, String checkRow) {
        int count = 0;
        for (String rank: ranks) {
            if(rank.equals(checkRow)) count++;
        }
        return count;
    }

    public List<Integer> toList(Integer[] arbitraryArray) {
        return Arrays.asList(arbitraryArray);
    }

    public List<Integer> findUnique(List<Integer> repeatedIntValues) {
        return new HashSet<>(repeatedIntValues).stream().toList();
    }

    public void calcOccurrence(List<String> repeatedStringValues) {
        for(Map.Entry<String, Integer> countDifferentObjects: countUniqueConcurrence(repeatedStringValues).entrySet()) {
            System.out.println(countDifferentObjects.getKey() + ": " + countDifferentObjects.getValue());
        }
    }

    public List<String> findOccurrence(List<String> repeatedStringValues) {
        List<String> records = new LinkedList<>();
        for(Map.Entry<String, Integer> countDifferentAnimal: countUniqueConcurrence(repeatedStringValues).entrySet()) {
            records.add("{name: \"" + countDifferentAnimal.getKey() +"\", occurrence: \"" +
                    countDifferentAnimal.getValue() + "\"}");
        }
        return records;
    }

    private Map<String, Integer> countUniqueConcurrence(List<String> repeatedStringValues) {
        Map<String, Integer> nameAndConcurrence = new HashMap<>();
        for(String stringValue: repeatedStringValues) {
            if (nameAndConcurrence.containsKey(stringValue)) {
                nameAndConcurrence.put(stringValue, nameAndConcurrence.get(stringValue)+1);
            } else {
                nameAndConcurrence.put(stringValue, 1);
            }
        }
        return nameAndConcurrence;
    }



}
