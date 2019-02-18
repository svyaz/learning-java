package com.github.svyaz.javalearning.singlylinkedlist;

public class SinglyLinkedList<T> {
    private static final String EXCEPTION_MESSAGE_INDEX_OUT_OF_BOUNDS = "Specified index is out of list bounds.";
    private static final String EXCEPTION_MESSAGE_EMPTY_LIST = "List is empty.";

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
     * Creates SinglyLinkedList with 1 item specified as head data.
     */
    public SinglyLinkedList(T head) {
        if (head != null) {
            this.head = new ListItem<>(head);
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
        if (count == 0) {
            throw new IndexOutOfBoundsException(EXCEPTION_MESSAGE_EMPTY_LIST);
        }
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
            throw new IndexOutOfBoundsException(EXCEPTION_MESSAGE_EMPTY_LIST);
        }
        T returnData = head.getData();
        head = head.getNext();
        --count;
        return returnData;
    }

    /**
     * Removes last element of the list.
     * Returns data of removed element or null if the list is empty.
     */
    public T removeTail() {
        if (count == 0) {
            throw new IndexOutOfBoundsException(EXCEPTION_MESSAGE_EMPTY_LIST);
        }

        ListItem<T> current = head, prev = null;
        T returnData = null;
        for (int i = 0; i < count; i++) {
            if (i == count - 1) {
                returnData = current.getData();
                if (i == 0) {
                    head = null;
                } else {
                    prev.setNext(null);
                }
                --count;
                break;
            }
            prev = current;
            current = current.getNext();
        }
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

    /**
     * Removes specified element from the list if it presents.
     * Returns true if list is changed.
     */
    public boolean remove(T element) {
        for (ListItem<T> current = head, prev = null;
             current != null;
             prev = current, current = current.getNext()) {

            if (current.getData().equals(element)) {
                if (prev == null) {
                    head = head.getNext();
                } else {
                    prev.setNext(current.getNext());
                }
                --count;
                return true;
            }
        }
        return false;
    }

    /**
     * Turns the list from end to start.
     */
    public void turn() {
        if (count > 0) {
            ListItem<T> current = head, prev = null;
            while (true) {
                if (head.getNext() != null) {
                    head = head.getNext();
                    current.setNext(prev);
                    prev = current;
                    current = head;
                } else {
                    current.setNext(prev);
                    break;
                }
            }
        }
    }

    /**
     * Returns a copy of the list.
     */
    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> newList = new SinglyLinkedList<>();
        if (count > 0) {
            newList.count = count;
            ListItem<T> tmpItemLink, tmpPrev = null;
            for (ListItem<T> current = head; current != null; current = current.getNext()) {
                tmpItemLink = new ListItem<>(current.getData());
                if (tmpPrev != null) {
                    tmpPrev.setNext(tmpItemLink);
                } else {
                    newList.head = tmpItemLink;
                }
                tmpPrev = tmpItemLink;
            }
        }
        return newList;
    }

    /**
     * Returns string representation of the list.
     */
    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder();
        resultString.append('[');
        for (ListItem<T> item = head; item != null; item = item.getNext()) {
            resultString.append(item.getData());
            if (item.getNext() != null) {
                resultString.append(", ");
            }
        }
        return resultString.append(']').toString();
    }

    /**
     * Returns true if the specified object is equal to the list.
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        SinglyLinkedList<?> that = (SinglyLinkedList<?>) object;
        if (count != that.count) {
            return false;
        }
        if (count > 0) {
            ListItem<T> currentThis = this.head;
            ListItem<?> currentThat = that.head;
            while (currentThis != null) {
                if (!currentThis.getData().equals(currentThat.getData())) {
                    return false;
                }
                currentThis = currentThis.getNext();
                currentThat = currentThat.getNext();
            }
        }
        return true;
    }

    /**
     * Calculates hash code of the list.
     */
    @Override
    public int hashCode() {
        int result = count;
        for (ListItem<T> item = head; item != null; item = item.getNext()) {
            result = 31 * result + item.hashCode();
        }
        return result;
    }
}
