package com.github.svyaz.javalearning.singlylinkedlist;

public class SinglyLinkedList<T> {
    private static final String EXCEPTION_MESSAGE_INDEX_OUT_OF_BOUNDS = "Specified index is out of list bounds.";

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

    /**
     * Returns data of the element with specified index of the list.
     */
    public T getData(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException(EXCEPTION_MESSAGE_INDEX_OUT_OF_BOUNDS);
        }
        ListItem<T> tmpListItem = head;
        int i = 0;
        while (i < count) {
            if (i == index) {
                break;
            }
            tmpListItem = tmpListItem.getNext();
            ++i;
        }
        return tmpListItem.getData();
    }

    /**
     * Sets data of the element with specified index of the list.
     * Returns old value from the element data.
     */
    public T setData(int index, T data) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException(EXCEPTION_MESSAGE_INDEX_OUT_OF_BOUNDS);
        }
        ListItem<T> tmpListItem = head;
        int i = 0;
        while (i < count) {
            if (i == index) {
                break;
            }
            tmpListItem = tmpListItem.getNext();
            ++i;
        }
        T currentData = tmpListItem.getData();
        tmpListItem.setData(data);
        return currentData;
    }

    /*
    TODO удаление элемента по индексу, пусть выдает значение элемента
    TODO вставка элемента в начало
    TODO вставка элемента по индексу
    TODO удаление узла по значению, пусть выдает true, если элемент был удален
    TODO удаление первого элемента, пусть выдает значение элемента
    TODO разворот списка за линейное время
    TODO копирование списка
    */
    // TODO Implement equals
    // TODO Implement hashCode
    // TODO Implement toString
}
