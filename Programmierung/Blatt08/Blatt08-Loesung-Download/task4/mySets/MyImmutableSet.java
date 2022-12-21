package mySets;

import java.util.*;

class MyImmutableSet<T> extends MyAbstractSet<T> implements MyMinimalSet<T> {

    public MyImmutableSet(MySetElement<T> head) {
        super(head);
    }

    @Override
    public void addAllTo(Collection<T> col)
            throws UnmodifiableCollectionException {
        try {
            for (T t: this) {
                col.add(t);
            }
        } catch (UnsupportedOperationException e) {
            throw new UnmodifiableCollectionException();
        }
    }
}
