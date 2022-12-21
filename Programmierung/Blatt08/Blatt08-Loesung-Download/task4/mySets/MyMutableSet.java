package mySets;

import java.util.*;

public class MyMutableSet<T> extends MyAbstractSet<T> implements Set<T> {

    public MyMutableSet() {
        super(null);
    }

    public MyMutableSet(T e) {
        super(null);
        head = new MySetElement<>(head, e);
    }

    @Override
    public boolean add(T e) {
        if (!contains(e)) {
            head = new MySetElement<>(head, e);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean remove(Object o) {
        if (head == null) {
            return false;
        }
        if (head.value.equals(o)) {
            head = head.next;
            return true;
        }
        MySetElement<T> previous = head;
        MySetElement<T> current = head.next;
        while (current != null) {
            if (current.value.equals(o)) {
                previous.next = current.next;
                return true;
            } else {
                previous = previous.next;
                current = current.next;
            }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean changed = false;
        for (T t: c) {
            changed = changed | add(t);
        }
        return changed;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean changed = false;
        for (Object o: c) {
            changed = changed | remove(o);
        }
        return changed;
    }

    @Override
    public void clear() {
        head = null;
    }

    public MyMinimalSet<T> freezeAndClear() {
        MyMinimalSet<T> res = new MyImmutableSet<>(head);
        clear();
        return res;
    }

    public MyMutableSet<MyMutableSet<T>> powerset() {
        MyMutableSet<T> emptyset = new MyMutableSet<T>();
        MyMutableSet<MyMutableSet<T>> res = new MyMutableSet<MyMutableSet<T>>(emptyset);

        /*
        * Wir fuegen die Elemente der Potenzmenge aufsteigend nach Kardinalitaet zu res hinzu.
        */
        for(int i = 0; i < this.size(); i++) {
            for(MyMutableSet<T> subset : res) {
                if(subset.size() == i) {
                    for(T element : this) {
                        MyMutableSet<T> fresh_subset = new MyMutableSet<T>(element);
                        fresh_subset.addAll(subset);
                        res.add(fresh_subset);
                    }
                }
            }
        }

        return res;
    }

    public MyMutableSet<MyPair<T,T>> pairs() {
        MyMutableSet<MyPair<T,T>> res = new MyMutableSet<MyPair<T,T>>();

        for(T e1 : this) {
            for(T e2 : this) {
                res.add(new MyPair<T,T>(e1, e2));
            }
        }

        return res;
    }

    public MyMutableSet<MyPair<Integer,T>> enumerate() {
        MyMutableSet<MyPair<Integer,T>> res = new MyMutableSet<MyPair<Integer,T>>();
        int i = 0;
        for(T e : this) {
            res.add(new MyPair<Integer,T>(i,e));
            i++;
        }
        return res;
    }

    public MyMutableSet<MyPair<MyMutableSet<T>,Integer>> numberOfSubsets() {
        MyMutableSet<MyPair<MyMutableSet<T>,Integer>> res = new MyMutableSet<MyPair<MyMutableSet<T>,Integer>>();

        for(MyMutableSet<T> subset : powerset()) {
            res.add(new MyPair<MyMutableSet<T>,Integer>(subset, (int) Math.pow(2, subset.size()) - 1));
        }

        return res;
    }

    public static void main(String[] args) {
        MyMutableSet<Integer> set = new MyMutableSet<Integer>();
        set.add(17);
        set.add(23);

        System.out.println(set);
        System.out.println(set.powerset());
        System.out.println(set.pairs());
        System.out.println(set.enumerate());
        System.out.println(set.numberOfSubsets());
    }
}
