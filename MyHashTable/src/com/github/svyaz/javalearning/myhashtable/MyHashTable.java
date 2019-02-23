package com.github.svyaz.javalearning.myhashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Collection permits null as elements and permits duplicate objects.
 */
public class MyHashTable<T> implements Collection<T> {
    /**
     * Exceptions messages
     */
    private static final String EXCEPTION_MESSAGE_ILLEGAL_CAPACITY = "Specified capacity must be greater than 0.";
    private static final String EXCEPTION_MESSAGE_NULL_ARGUMENT = "Specified argument is null.";
    private static final String EXCEPTION_MESSAGE_NO_NEXT_ELEMENT = "No next element in table.";
    private static final String EXCEPTION_MESSAGE_CONCURRENT_MODIFICATION = "Concurrent modification of table found.";

    /**
     * Default capacity for arrayItems.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Internal array for storing lists.
     */
    private ArrayList[] arrayItems;

    /**
     * count of elements in the table
     */
    private int count;

    /**
     * Modifications counter for checking by iterator.
     */
    private int modCount = 0;

    /**
     * Creates instance with DEFAULT_CAPACITY size of internal array
     */
    public MyHashTable() {
        arrayItems = new ArrayList[DEFAULT_CAPACITY];
    }

    /**
     * Creates instance with specified size of internal array
     */
    public MyHashTable(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_ILLEGAL_CAPACITY);
        }
        arrayItems = new ArrayList[capacity];
    }

    /**
     * Returns the number of elements in this collection.
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * Returns true if this collection contains no elements.
     */
    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Returns true if this collection contains at least one of the specified element
     * such that Objects.equals(object, element).
     */
    @Override
    public boolean contains(Object object) {
        if (count == 0) {
            return false;
        }
        int index = Math.abs(Objects.hashCode(object) % arrayItems.length);
        if (arrayItems[index] == null) {
            return false;
        }
        for (int i = 0; i < arrayItems[index].size(); i++) {
            if (Objects.equals(object, arrayItems[index].get(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns an iterator over the elements in this collection.
     */
    @Override
    public Iterator<T> iterator() {
        return new MyHashTableIterator();
    }

    /**
     * Nested class for implementation iterator.
     */
    private class MyHashTableIterator implements Iterator<T> {
        /**
         * Position of current table element.
         */
        private int currentPosition = -1;

        /**
         * Start value of property modCount of the table.
         */
        private int startModCount = modCount;

        /**
         * Returns true if the iteration has more elements.
         */
        @Override
        public boolean hasNext() {
            return currentPosition + 1 < count;
        }

        /**
         * Returns the next element in the iteration.
         */
        @Override
        @SuppressWarnings("unchecked")
        public T next() {
            if (currentPosition + 1 >= count) {
                throw new NoSuchElementException(EXCEPTION_MESSAGE_NO_NEXT_ELEMENT);
            }
            if (modCount != startModCount) {
                throw new ConcurrentModificationException(EXCEPTION_MESSAGE_CONCURRENT_MODIFICATION);
            }

            int position = -1;
            for (ArrayList arrayItem : arrayItems) {
                if (arrayItem != null) {
                    for (Object item : arrayItem) {
                        ++position;
                        if (position == currentPosition + 1) {
                            ++currentPosition;
                            return (T) item;
                        }
                    }
                }
            }
            return null;
        }
    }

    /**
     * Returns an array containing all of the elements in this collection.
     */
    @Override
    public Object[] toArray() {
        if (count == 0) {
            return new Object[0];
        }

        Object[] result = new Object[count];
        int index = 0;
        for (ArrayList list : arrayItems) {
            if (list != null) {
                for (Object item : list) {
                    result[index] = item;
                    ++index;
                }
            }
        }
        return result;
    }

    /**
     * Returns an array containing all of the elements in this collection;
     * the runtime type of the returned array is that of the specified array.
     * If the collection fits in the specified array, it is returned therein.
     * Otherwise, a new array is allocated with the runtime type of the
     * specified array and the size of this collection.
     *
     * <p>If this collection fits in the specified array with room to spare
     * (i.e., the array has more elements than this collection), the element
     * in the array immediately following the end of the collection is set to
     * {@code null}.  (This is useful in determining the length of this
     * collection <i>only</i> if the caller knows that this collection does
     * not contain any {@code null} elements.)
     *
     * <p>If this collection makes any guarantees as to what order its elements
     * are returned by its iterator, this method must return the elements in
     * the same order.
     *
     * <p>Like the {@link #toArray()} method, this method acts as bridge between
     * array-based and collection-based APIs.  Further, this method allows
     * precise control over the runtime type of the output array, and may,
     * under certain circumstances, be used to save allocation costs.
     *
     * <p>Suppose {@code x} is a collection known to contain only strings.
     * The following code can be used to dump the collection into a newly
     * allocated array of {@code String}:
     *
     * <pre>
     *     String[] y = x.toArray(new String[0]);</pre>
     * <p>
     * Note that {@code toArray(new Object[0])} is identical in function to
     * {@code toArray()}.
     *
     * @param array the array into which the elements of this collection are to be
     *              stored, if it is big enough; otherwise, a new array of the same
     *              runtime type is allocated for this purpose.
     * @return an array containing all of the elements in this collection
     * @throws ArrayStoreException  if the runtime type of the specified array
     *                              is not a supertype of the runtime type of every element in
     *                              this collection
     * @throws NullPointerException if the specified array is null
     */
    @Override
    //@SuppressWarnings("all")
    public <T1> T1[] toArray(T1[] array) {
        if (array == null) {
            throw new NullPointerException(EXCEPTION_MESSAGE_NULL_ARGUMENT);
        }
        if (array.length < count) {

            /*T1[] result = new Object[count];

            int index = 0;
            for (ArrayList list : arrayItems) {
                if (list != null) {
                    for (Object item : list) {
                        result[index] = (T1) item;
                        ++index;
                    }
                }
            }

            return result;*/


            ArrayList<T1> result = new ArrayList<>(count);
            for (ArrayList list : arrayItems) {
                if (list != null) {
                    for (Object item : list) {
                        result.add((T1) item);
                    }
                }
            }


            return (T1[]) result.toArray();
        }


        System.arraycopy(toArray(), 0, array, 0, count);

        //TODO: Вопрос: Если моя таблица допускает в значениях null-ы, то нужно ли тут выставлять в null
        //TODO: элемент array[count] как написано в условии реализации метода?

        return array;
    }

    /**
     * Adds an element to the table.
     * Permits null and duplicates.
     * Returns true if this collection changed as a result of the call.
     */
    @Override
    @SuppressWarnings("unchecked")
    public boolean add(T object) {
        int index = Math.abs(Objects.hashCode(object) % arrayItems.length);
        ++modCount;
        if (arrayItems[index] == null) {
            ArrayList<T> list = new ArrayList<>();
            list.add(object);
            arrayItems[index] = list;
        } else {
            arrayItems[index].add(object);
        }
        ++count;
        return true;
    }

    /**
     * Removes all element in the collection such that Objects.equals(object, element).
     * Returns true if any element was removed as a result of this call.
     */
    @Override
    @SuppressWarnings("all")
    public boolean remove(Object object) {
        int index = Math.abs(Objects.hashCode(object) % arrayItems.length);
        if (arrayItems[index] == null) {
            return false;
        }
        int listCountBefore = arrayItems[index].size();
        if (arrayItems[index].removeAll(Arrays.asList(object))) {
            ++modCount;
            count -= listCountBefore - arrayItems[index].size();
            if (arrayItems[index].size() == 0) {
                arrayItems[index] = null;
            }
            return true;
        }
        return false;
    }

    /**
     * Returns true if this collection contains all of the elements
     * in the specified collection.
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
     * Adds all of the elements in the specified collection to this collection.
     */
    @Override
    public boolean addAll(Collection<? extends T> collection) {
        if (collection == null) {
            throw new NullPointerException(EXCEPTION_MESSAGE_NULL_ARGUMENT);
        }
        if (collection.size() == 0) {
            return false;
        }
        for (T element : collection) {
            add(element);
        }
        return true;
    }

    /**
     * Removes all of this table's elements that are also contained in the
     * specified collection.
     * Returns true if this table changed as a result of the call.
     */
    @Override
    public boolean removeAll(Collection<?> collection) {
        if (collection == null) {
            throw new NullPointerException(EXCEPTION_MESSAGE_NULL_ARGUMENT);
        }
        if (count == 0) {
            return false;
        }
        boolean hasChanged = false;
        for (Object element : collection) {
            hasChanged = remove(element);
        }
        return hasChanged;
    }

    /**
     * Retains only the elements in this collection that are contained in the
     * specified collection.
     * Returns true if this collection changed as a result of the call.
     */
    @Override
    @SuppressWarnings("unchecked")
    public boolean retainAll(Collection<?> collection) {
        if (collection == null) {
            throw new NullPointerException(EXCEPTION_MESSAGE_NULL_ARGUMENT);
        }
        if (count == 0) {
            return false;
        }
        boolean hasChanged = false;
        for (int i = 0; i < arrayItems.length; i++) {
            if (arrayItems[i] != null) {
                int listCountBefore = arrayItems[i].size();
                if (arrayItems[i].retainAll(collection)) {
                    ++modCount;
                    hasChanged = true;
                    count -= listCountBefore - arrayItems[i].size();
                    if (arrayItems[i].size() == 0) {
                        arrayItems[i] = null;
                    }
                }
            }
        }
        return hasChanged;
    }

    /**
     * Removes all of the elements from this collection.
     */
    @Override
    public void clear() {
        ++modCount;
        for (int i = 0; i < arrayItems.length; i++) {
            arrayItems[i] = null;
        }
        count = 0;
    }

    /**
     * Returns true if the specified object is equal to the table.
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        MyHashTable<?> myHashTable = (MyHashTable<?>) object;
        if (count != myHashTable.count) {
            return false;
        }
        for (int i = 0; i < arrayItems.length; i++) {
            if (!Objects.equals(myHashTable.arrayItems[i], arrayItems[i])) {
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
        int result = 31 + Objects.hashCode(count);
        for (ArrayList arrayItem : arrayItems) {
            result = 31 * result + (arrayItem == null ? 0 : arrayItem.hashCode());
        }
        return result;
    }

    /**
     * Returns string representation of the table.
     */
    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder();
        resultString.append('[');
        boolean isFirst = true;
        for (ArrayList list : arrayItems) {
            if (list != null) {
                if (isFirst) {
                    isFirst = false;
                } else {
                    resultString.append(", ");
                }
                resultString.append(list.toString());
            }
        }
        return resultString.append(']').toString();
    }
}
