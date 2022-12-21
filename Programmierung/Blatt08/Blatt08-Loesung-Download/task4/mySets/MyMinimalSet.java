package mySets;

import java.util.*;

public interface MyMinimalSet<T> extends Iterable<T> {

    public boolean contains(Object o);
    public void addAllTo(Collection<T> col) throws UnmodifiableCollectionException;

}
