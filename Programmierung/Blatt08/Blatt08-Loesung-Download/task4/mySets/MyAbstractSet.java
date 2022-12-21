package mySets;

import java.util.*;

abstract class MyAbstractSet<T> implements Iterable<T> {

    MySetElement<T> head;

    @Override
    public String toString() {
        String res = "{";
        MySetElement<T> current = head;
        while (current != null) {
            res += current.value;
            if (current.next != null) res += ", ";
            current = current.next;
        }
        return res + "}";
    }

    public MyAbstractSet(MySetElement<T> head) {
        this.head = head;
    }

    public int size() {
        int res = 0;
        for (T t: this) {
            res++;
        }
        return res;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean contains(Object o) {
        for (T t: this) {
            if (t.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new MySetIterator<>(head);
    }

    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    public boolean containsAll(Collection<?> c) {
        for (Object o: c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof MyAbstractSet<?>) {
            return this.containsAll((Collection<?>) other) && this.size() == ((MyAbstractSet<?>) other).size();
        }
        return false;
    }

}
