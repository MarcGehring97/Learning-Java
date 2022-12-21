public class List {

  public static final List EMPTY = new List(null, 0);

  private final List next;
  private final int value;

  public List(List n, int v) {
    this.next = n;
    this.value = v;
  }

  public List getNext() {
    return this.next;
  }

  public int getValue() {
    return this.value;
  }

  /**
   * @return true iff this list is empty
   */
  public boolean isEmpty() {
      return this == EMPTY;
  }

  /**
   * @return a String representation of this list
   */
  public String toString() {
    if (this.isEmpty()) {
      return "";
    } else if (this.next.isEmpty()) {
      return String.valueOf(this.value);
    } else {
      return this.value + ", " + this.next.toString();
    }
  }

  /**
   * @return the length of the list
  */
  public int length() {
    if (this.isEmpty()) {
      return 0;
    } else {
      return 1 + this.next.length();
    }
  }

  /**
   * Computes a list containing the first <code>length</code> elements
   * of the current list. If this list does not contain enough
   * elements, the whole list is returned instead.
   * @param length the length of the sublist to compute
   * @return the computed sublist
   */
  public List getSublist(int length) {
    if (length <= 0 || this.isEmpty()) {
      return EMPTY;
    } else {
      List newNext = this.getNext().getSublist(length - 1);
      return new List(newNext, this.value);
    }
  }

}
