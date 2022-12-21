package mySets;

class MySetElement<T> {

    MySetElement<T> next;
    T value;

    public MySetElement(MySetElement<T> next, T value) {
        this.next = next;
        this.value = value;
    }

}
