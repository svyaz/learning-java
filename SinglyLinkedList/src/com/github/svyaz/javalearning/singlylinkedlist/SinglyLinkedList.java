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
     * Creates empty list.
     */
    public SinglyLinkedList() {
    }

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

    /**
     * Adds new element to the beginning of the list.
     */
    public void addToHead(T data) {
        head = new ListItem<>(data, head);
        ++count;
    }

    /**
     * Adds new element to the end of the list.
     */
    public void addToTail(T data) {
        if (count == 0) {
            head = new ListItem<>(data);
        } else {
            ListItem<T> current = head, prev = null;
            for (int i = 0; i <= count; i++) {
                if (i == count) {
                    prev.setNext(new ListItem<>(data));
                    break;
                }
                prev = current;
                current = current.getNext();
            }
        }
        ++count;
    }

    /**
     * Adds new element to the specified index of the list.
     */
    public void add(int index, T data) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException(EXCEPTION_MESSAGE_INDEX_OUT_OF_BOUNDS);
        }

        ListItem<T> current = head, prev = null;
        for (int i = 0; i <= count; i++) {
            if (i == index) {
                if (i == 0) {
                    head = new ListItem<>(data, head);
                } else if (i == count) {
                    prev.setNext(new ListItem<>(data));
                } else {
                    prev.setNext(new ListItem<>(data, current));
                }
                ++count;
                break;
            }
            prev = current;
            current = current.getNext();
        }
    }

    /**
     * Removes head element of the list.
     * Returns data of removed element or null if the list is empty.
     */
    public T removeHead() {
        if (count == 0) {
            return null;
        }
        T returnData = head.getData();
        head = head.getNext();
        --count;
        return returnData;
    }

    /**
     * Removes element of the list with specified index.
     * Returns removed element data.
     */
    public T remove(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException(EXCEPTION_MESSAGE_INDEX_OUT_OF_BOUNDS);
        }

        ListItem<T> current = head, prev = null;
        T returnData = null;
        for (int i = 0; i < count; i++) {
            if (i == index) {
                returnData = current.getData();
                if (i == 0) {
                    head = head.getNext();
                } else if (i == count - 1) {
                    prev.setNext(null);
                } else {
                    prev.setNext(current.getNext());
                }
                --count;
                break;
            }
            prev = current;
            current = current.getNext();
        }
        return returnData;
    }


    /*
    TODO удаление элемента из конца списка, выдает значение элемента
    TODO удаление узла по значению, пусть выдает true, если элемент был удален
    TODO разворот списка за линейное время
    TODO копирование списка

    TODO Implement equals
    TODO Implement hashCode
    TODO Implement toString

    TODO Сделать ListItem с уровнем доступа на пакет.
    TODO Сделать тесты на ListItem если получится по уровню доступа.
    */
}
