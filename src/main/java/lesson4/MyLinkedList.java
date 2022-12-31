package lesson4;

class MyLinkedList<T> {

    private Entry<T> head;
    private Entry<T> tail;
    private int length;

    public MyLinkedList() {}

    public void addAtHead(T val) {
        if (head == null) {
            head = new Entry<>(val, null, null);
            tail = head;
        }
        else {
            Entry<T> newHead = new Entry<>(val, head, null);
            head.prev = newHead;
            head = newHead;
        }
        ++length;
    }

    public void addAtTail(T val) {
        if (tail == null) {
            tail = new Entry<>(val, null, null);
            head = tail;
        } else {
            Entry<T> newTail = new Entry<>(val, null, tail);
            tail.next = newTail;
            tail = newTail;
        }
        ++length;
    }

    public void addAtIndex(int index, T val) {
        if (index == length) {
            addAtTail(val);
        } else if (index < length) {
            Entry<T> current = head;
            if (current == null || index == 0) {
                addAtHead(val);
                return;
            }
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            Entry<T> newNode = new Entry<>(val, current, current.prev);
            current.prev.next = newNode;
            current.prev = newNode;
            ++length;
        }
    }

    public T get(int index) {
        Entry<T> current = getEntryByIndex(index);
        return current != null ? current.val : null;
    }

    public void deleteAtIndex(int index) {
        Entry<T> current = getEntryByIndex(index);
        if (current == null) return;
        if (length == 1) {
            head = null;
            tail = null;
        } else if (current == head) {
            head = current.next;
            current.next.prev = current.prev;
        } else if (current == tail) {
            tail = current.prev;
            current.prev.next = current.next;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        --length;
    }

    private Entry<T> getEntryByIndex(int index) {
        if (index >= length) return null;
        Entry<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public int getLength() {
        return length;
    }

    private class Entry<T> {
        private T val;
        private Entry next;
        private Entry prev;

        Entry(T val, Entry next, Entry prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

}