package com.github.svyaz.javalearning.singlylinkedlist;

public class SinglyLinkedList<T> {
    /**
     * Head item of the list.
     */
    private ListItem<T> head;

    /**
     * Counter for getting list size.
     */
    private int count;

    /**
     * Creates SinglyLinkedList with 1-st item head.
     */
    public SinglyLinkedList(ListItem<T> head) {
        if (head != null) {
            this.head = head;
            count = 1;
            ListItem<T> tmpListItem = head;
            while (tmpListItem.getNext() != null) {
                tmpListItem = tmpListItem.getNext();
                ++count;
            }
        }
    }

    /**
     * Creates SinglyLinkedList with 1 item specified as data.
     */
    public SinglyLinkedList(T head) {
        if (head != null) {
            this.head = new ListItem<>(head, null);
            count = 1;
        }
    }

    /**
     * Returns size of the list.
     */
    public int size() {
        return count;
    }

    /**
     * Returns head-data of the list.
     */
    public T getHeadData() {
        return head.getData();
    }



    // TODO Implement equals
    // TODO Implement hashCode
    // TODO Implement toString
}
