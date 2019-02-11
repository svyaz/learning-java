package com.github.svyaz.javalearning.myarraylist;

import java.util.*;

public class MyArrayList<E> implements List<E> {
    /**
     * Exceptions messages
     */
    private static final String EXCEPTION_MESSAGE_INDEX_OUT_OF_BOUNDS = "Specified index is out of list bounds.";
    private static final String EXCEPTION_MESSAGE_INDEXES_INCOMPATIBLE = "fromIndex cannot be greater than toIndex.";
    private static final String EXCEPTION_MESSAGE_ILLEGAL_CAPACITY = "Specified capacity must be greater than 0.";
    private static final String EXCEPTION_MESSAGE_NO_NEXT_ELEMENT = "No next element in list.";
    private static final String EXCEPTION_MESSAGE_CONCURRENT_MODIFICATION = "Concurrent modification of list found.";

    /**
     * Default capacity for items.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Private array for storing list elements.
     */
    private E[] items;

    /**
     * Private field for storing array length.
     */
    private int size;

    /**
     * Modifications counter for checking by iterator.
     */
    private int modCount = 0;

    /**
     * Creates instance with DEFAULT_CAPACITY.
     */
    @SuppressWarnings("unchecked")
    public MyArrayList() {
        items = (E[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * Creates instance with specified capacity.
     */
    @SuppressWarnings("unchecked")
    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_ILLEGAL_CAPACITY);
        }
        items = (E[]) new Object[capacity];
    }

    /**
     * Creates instance with specified elements of input array.
     */
    @SuppressWarnings("unchecked")
    public MyArrayList(E[] items) {
        int capacity = DEFAULT_CAPACITY + (items.length <= DEFAULT_CAPACITY ? 0 : items.length);
        this.items = Arrays.copyOf(items, capacity);
        this.size = items.length;
    }

    /**
     * Returns the number of elements in this list.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns true if this list contains no elements.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns true if this list contains at least one element such as specified object.
     */
    @Override
    public boolean contains(Object object) {
        return indexOf(object) >= 0;
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     */
    @Override
    public Iterator<E> iterator() {
        return new MyArrayListIterator();
    }

    /**
     * Nested class for implementation iterator.
     */
    private class MyArrayListIterator implements Iterator<E> {
        /**
         * Index of current list element.
         */
        private int currentIndex = -1;

        /**
         * Start value of property modCount of the list.
         */
        private int startModCount = modCount;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return currentIndex + 1 < size;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            if (currentIndex + 1 >= size) {
                throw new NoSuchElementException(EXCEPTION_MESSAGE_NO_NEXT_ELEMENT);
            }
            if (modCount != startModCount) {
                throw new ConcurrentModificationException(EXCEPTION_MESSAGE_CONCURRENT_MODIFICATION);
            }
            ++currentIndex;
            return items[currentIndex];
        }
    }

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence (from first to last element).
     */
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(items, size);
    }

    /**
     * Returns an array containing all of the elements in this list in
     * proper sequence (from first to last element); the runtime type of
     * the returned array is that of the specified array.  If the list fits
     * in the specified array, it is returned therein.  Otherwise, a new
     * array is allocated with the runtime type of the specified array and
     * the size of this list.
     *
     * <p>If the list fits in the specified array with room to spare
     * * (i.e., the array has more elements than the list), the element in
     * * the array immediately following the end of the collection is set to
     * * {@code null}.  (This is useful in determining the length of the
     * * list <i>only</i> if the caller knows that the list does not contain
     * * any null elements.)
     *
     * @param array the array into which the elements of this list are to
     *              be stored, if it is big enough; otherwise, a new array of the
     *              same runtime type is allocated for this purpose.
     * @return an array containing the elements of this list
     * @throws ArrayStoreException  if the runtime type of the specified array
     *                              is not a supertype of the runtime type of every element in
     *                              this list
     * @throws NullPointerException if the specified array is null
     */
    @Override
    @SuppressWarnings("all")
    public <T> T[] toArray(T[] array) {
        if (array.length < size) {
            return (T[]) Arrays.copyOf(items, size, array.getClass());
        }
        System.arraycopy(items, 0, array, 0, size);
        if (array.length > size) {
            array[size] = null;
        }
        return array;
    }

    /**
     * Removes the first occurrence of the specified element from the list.
     */
    @Override
    public boolean remove(Object object) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(items[i], object)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Returns true if this list contains all of the elements of the
     * specified collection.
     */
    @Override
    public boolean containsAll(Collection<?> collection) {
        for (Object object : collection) {
            if (!contains(object)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Appends all of the elements in the specified collection to the end of the list.
     * Returns true if this list changed as a result of the call.
     */
    @Override
    @SuppressWarnings("unchecked")
    public boolean addAll(Collection<? extends E> collection) {
        if (collection.size() == 0) {
            return false;
        }
        ++modCount;
        E[] collectionArray = (E[]) collection.toArray();
        ensureCapacity(size + collectionArray.length);
        System.arraycopy(collectionArray, 0, items, size, collectionArray.length);
        size += collectionArray.length;
        return true;
    }

    /**
     * Inserts all of the elements in the specified collection into this
     * list at the specified position (optional operation).  Shifts the
     * element currently at that position (if any) and any subsequent
     * elements to the right (increases their indices).
     * Returns true if this list changed as a result of the call.
     */
    @Override
    @SuppressWarnings("unchecked")
    public boolean addAll(int index, Collection<? extends E> collection) {
        if (collection.size() == 0) {
            return false;
        }
        ++modCount;
        E[] collectionArray = (E[]) collection.toArray();
        int additionsLength = collectionArray.length;
        ensureCapacity(size + additionsLength);
        System.arraycopy(items, index, items, index + additionsLength, size - index);
        System.arraycopy(collectionArray, 0, items, index, additionsLength);
        size += additionsLength;
        return true;
    }

    /**
     * Removes from this list all of its elements that are contained in the
     * specified collection.
     * Returns true if this list changed as a result of the call.
     * Uses private method removeItems().
     */
    @Override
    public boolean removeAll(Collection<?> collection) {
        return removeItems(collection, true);
    }

    /**
     * Retains only the elements in this list that are contained in the
     * specified collection.
     * Returns true if this list changed as a result of the call.
     * Uses private method removeItems().
     */
    @Override
    public boolean retainAll(Collection<?> collection) {
        return removeItems(collection, false);
    }

    /**
     * Removes all of the elements from this list.
     */
    @Override
    public void clear() {
        ++modCount;
        size = 0;
    }

    /**
     * Returns the element at the specified position in this list.
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(EXCEPTION_MESSAGE_INDEX_OUT_OF_BOUNDS);
        }
        return items[index];
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element (optional operation).
     * Returns the element previously at the specified position
     */
    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(EXCEPTION_MESSAGE_INDEX_OUT_OF_BOUNDS);
        }
        E currentElement = items[index];
        items[index] = element;
        return currentElement;
    }

    /**
     * Appends the specified element to the end of list.
     */
    @Override
    public boolean add(E element) {
        if (items.length <= size) {
            increaseCapacity();
        }
        ++modCount;
        items[size] = element;
        ++size;
        return true;
    }

    /**
     * Inserts the specified element at the specified position in the list.
     */
    @Override
    public void add(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(EXCEPTION_MESSAGE_INDEX_OUT_OF_BOUNDS);
        }
        if (items.length <= size) {
            increaseCapacity();
        }
        ++modCount;
        System.arraycopy(items, index, items, index + 1, size - index);
        items[index] = element;
        ++size;
    }

    /**
     * Removes the element at the specified position in the list.
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(EXCEPTION_MESSAGE_INDEX_OUT_OF_BOUNDS);
        }
        ++modCount;
        E removedElement = items[index];
        if (index < size - 1) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
        }
        --size;
        return removedElement;
    }

    /**
     * Returns the index of the first occurrence of the specified element.
     * Returns -1 if the specified element is not found.
     */
    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(items[i], object)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     */
    @Override
    public int lastIndexOf(Object object) {
        if (object == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (items[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (object.equals(items[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Returns a list iterator over the elements in this list (in proper
     * sequence).
     *
     * @return a list iterator over the elements in this list (in proper
     * sequence)
     */
    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    /**
     * Returns a list iterator over the elements in this list (in proper
     * sequence), starting at the specified position in the list.
     * The specified index indicates the first element that would be
     * returned by an initial call to {@link ListIterator#next next}.
     * An initial call to {@link ListIterator#previous previous} would
     * return the element with the specified index minus one.
     *
     * @param index index of the first element to be returned from the
     *              list iterator (by a call to {@link ListIterator#next next})
     * @return a list iterator over the elements in this list (in proper
     * sequence), starting at the specified position in the list
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                   ({@code index < 0 || index > size()})
     */
    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    /**
     * Returns a view of the portion of this list between the specified
     * {@code fromIndex}, inclusive, and {@code toIndex}, exclusive.  (If
     * {@code fromIndex} and {@code toIndex} are equal, the returned list is
     * empty.)  The returned list is backed by this list, so non-structural
     * changes in the returned list are reflected in this list, and vice-versa.
     * The returned list supports all of the optional list operations supported
     * by this list.<p>
     * <p>
     * This method eliminates the need for explicit range operations (of
     * the sort that commonly exist for arrays).  Any operation that expects
     * a list can be used as a range operation by passing a subList view
     * instead of a whole list.  For example, the following idiom
     * removes a range of elements from a list:
     * <pre>{@code
     *      list.subList(from, to).clear();
     * }</pre>
     * Similar idioms may be constructed for {@code indexOf} and
     * {@code lastIndexOf}, and all of the algorithms in the
     * {@code Collections} class can be applied to a subList.<p>
     * <p>
     * The semantics of the list returned by this method become undefined if
     * the backing list (i.e., this list) is <i>structurally modified</i> in
     * any way other than via the returned list.  (Structural modifications are
     * those that change the size of this list, or otherwise perturb it in such
     * a fashion that iterations in progress may yield incorrect results.)
     *
     * @param fromIndex low endpoint (inclusive) of the subList
     * @param toIndex   high endpoint (exclusive) of the subList
     * @return a view of the specified range within this list
     * @throws IndexOutOfBoundsException for an illegal endpoint index value
     *                                   ({@code fromIndex < 0 || toIndex > size ||
     *                                   fromIndex > toIndex})
     */
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size) {
            throw new IndexOutOfBoundsException(EXCEPTION_MESSAGE_INDEX_OUT_OF_BOUNDS);
        }
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_INDEXES_INCOMPATIBLE);
        }

        return null;
    }

    /**
     * Reduces items[] capacity to current list size.
     */
    public void trimToSize() {
        ++modCount;
        if (items.length > size) {
            items = Arrays.copyOf(items, size);
        }
    }

    /**
     * Increases capacity of items
     */
    private void increaseCapacity() {
        items = Arrays.copyOf(items, items.length * 2);
    }

    /**
     * Check if the current capacity is not less than specified number
     * and increases it if necessary.
     */
    private void ensureCapacity(int capacity) {
        if (items.length < capacity) {
            ++modCount;
            items = Arrays.copyOf(items, capacity);
        }
    }

    /**
     * Internal method for removing items from the list with condition 'isPresent'.
     * Used by removeAll and retainAll.
     * Returns true if any items is removed.
     */
    private boolean removeItems(Collection<?> collection, boolean isPresent) {
        boolean modified = false;
        int i = 0;
        while (i < size) {
            if (collection.contains(items[i]) == isPresent) {
                remove(i);
                modified = true;
                continue;
            }
            ++i;
        }
        return modified;
    }

    /**
     * Returns true if the specified object is equal to the list.
     * Not included current value of modCount property.
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        MyArrayList<?> myArrayList = (MyArrayList<?>) object;
        if (size != myArrayList.size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!Objects.equals(myArrayList.items[i], items[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns a hash code based on the contents of the specified array.
     */
    @Override
    public int hashCode() {
        int result = 1;
        for (int i = 0; i < size; i++) {
            result = 31 * result + (items[i] == null ? 0 : items[i].hashCode());
        }
        return result;
    }

    /**
     * Returns string representation of the list.
     */
    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder();
        resultString.append('[');
        for (int i = 0; i < size; i++) {
            resultString.append(String.valueOf(items[i]));
            if (i < size - 1) {
                resultString.append(", ");
            }
        }
        return resultString.append(']').toString();
    }

    // TODO Implement ListIterator<E> listIterator() ?
    // TODO Implement ListIterator<E> listIterator(int index) ?
    // TODO Implement List<E> subList(int fromIndex, int toIndex) ?

    // TODO Замечания:
    /*
    4. addAll - надо обойтись без преобразования коллекции в массив
    5. add по индексу должен разрешать вставку в конец коллекции
    6. addAll по индексу - нет проверки индекса
    7. indexOf, lastIndexOf - Objects.equals
    8. trimToSize, ensureCapacity не должны менять modCount, логически список не изменился
    9. ensureCapacity надо сделать public
    11. toString - можно не вызывать valueOf, билдер вызывает его сам
     */
}
