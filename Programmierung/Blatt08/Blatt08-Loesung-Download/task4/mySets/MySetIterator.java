package mySets;

import java.util.*;

// no need to implement remove,
// as the default implementation already throws an UnsupportedOperationException
class MySetIterator<T> implements Iterator<T> {

    private MySetElement<T> current;

    public MySetIterator(MySetElement<T> current) {
        this.current = current;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next() {
        if (current == null) {
            throw new NoSuchElementException();
        }
        T res = current.value;
        current = current.next;
        return res;
    }


}
