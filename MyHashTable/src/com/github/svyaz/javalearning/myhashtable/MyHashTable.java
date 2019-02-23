package com.github.svyaz.javalearning.myhashtable;

import java.util.*;

/**
 * Collection permits null as elements and permits duplicate objects.
 */
public class MyHashTable<T> implements Collection<T> {
    /**
     * Exceptions messages
     */
    private static final String EXCEPTION_MESSAGE_ILLEGAL_CAPACITY = "Specified capacity must be greater than 0.";
    private static final String EXCEPTION_MESSAGE_NULL_ARGUMENT = "Specified argument is null.";

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

    //TODO implement this

    /**
     * Returns an iterator over the elements in this collection.  There are no
     * guarantees concerning the order in which the elements are returned
     * (unless this collection is an instance of some class that provides a
     * guarantee).
     *
     * @return an {@code Iterator} over the elements in this collection
     */
    @Override
    public Iterator<T> iterator() {
        return null;
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
    public boolean remove(Object object) {
        int index = Math.abs(Objects.hashCode(object) % arrayItems.length);
        if (arrayItems[index] == null) {
            return false;
        }

        boolean hasChanged = false;
        for (int i = 0; i < arrayItems[index].size(); i++) {
            if (Objects.equals(object, arrayItems[index].get(i))) {
                arrayItems[index].remove(i);
                --count;
                hasChanged = true;
                if (arrayItems[index].size() == 0) {
                    arrayItems[index] = null;
                    break;
                }
            }
        }
        return hasChanged;
    }

    //TODO implement this

    /**
     * Returns {@code true} if this collection contains all of the elements
     * in the specified collection.
     *
     * @param c collection to be checked for containment in this collection
     * @return {@code true} if this collection contains all of the elements
     * in the specified collection
     * @throws ClassCastException   if the types of one or more elements
     *                              in the specified collection are incompatible with this
     *                              collection
     *                              (<a href="#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified collection contains one
     *                              or more null elements and this collection does not permit null
     *                              elements
     *                              (<a href="#optional-restrictions">optional</a>),
     *                              or if the specified collection is null.
     * @see #contains(Object)
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    //TODO implement this

    /**
     * Adds all of the elements in the specified collection to this collection
     * (optional operation).  The behavior of this operation is undefined if
     * the specified collection is modified while the operation is in progress.
     * (This implies that the behavior of this call is undefined if the
     * specified collection is this collection, and this collection is
     * nonempty.)
     *
     * @param c collection containing elements to be added to this collection
     * @return {@code true} if this collection changed as a result of the call
     * @throws UnsupportedOperationException if the {@code addAll} operation
     *                                       is not supported by this collection
     * @throws ClassCastException            if the class of an element of the specified
     *                                       collection prevents it from being added to this collection
     * @throws NullPointerException          if the specified collection contains a
     *                                       null element and this collection does not permit null elements,
     *                                       or if the specified collection is null
     * @throws IllegalArgumentException      if some property of an element of the
     *                                       specified collection prevents it from being added to this
     *                                       collection
     * @throws IllegalStateException         if not all the elements can be added at
     *                                       this time due to insertion restrictions
     * @see #add(Object)
     */
    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    //TODO implement this

    /**
     * Removes all of this collection's elements that are also contained in the
     * specified collection (optional operation).  After this call returns,
     * this collection will contain no elements in common with the specified
     * collection.
     *
     * @param c collection containing elements to be removed from this collection
     * @return {@code true} if this collection changed as a result of the
     * call
     * @throws UnsupportedOperationException if the {@code removeAll} method
     *                                       is not supported by this collection
     * @throws ClassCastException            if the types of one or more elements
     *                                       in this collection are incompatible with the specified
     *                                       collection
     *                                       (<a href="#optional-restrictions">optional</a>)
     * @throws NullPointerException          if this collection contains one or more
     *                                       null elements and the specified collection does not support
     *                                       null elements
     *                                       (<a href="#optional-restrictions">optional</a>),
     *                                       or if the specified collection is null
     * @see #remove(Object)
     * @see #contains(Object)
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    //TODO implement this

    /**
     * Retains only the elements in this collection that are contained in the
     * specified collection (optional operation).  In other words, removes from
     * this collection all of its elements that are not contained in the
     * specified collection.
     *
     * @param c collection containing elements to be retained in this collection
     * @return {@code true} if this collection changed as a result of the call
     * @throws UnsupportedOperationException if the {@code retainAll} operation
     *                                       is not supported by this collection
     * @throws ClassCastException            if the types of one or more elements
     *                                       in this collection are incompatible with the specified
     *                                       collection
     *                                       (<a href="#optional-restrictions">optional</a>)
     * @throws NullPointerException          if this collection contains one or more
     *                                       null elements and the specified collection does not permit null
     *                                       elements
     *                                       (<a href="#optional-restrictions">optional</a>),
     *                                       or if the specified collection is null
     * @see #remove(Object)
     * @see #contains(Object)
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    /**
     * Removes all of the elements from this collection.
     */
    @Override
    public void clear() {
        for (int i = 0; i < arrayItems.length; i++) {
            arrayItems[i] = null;
        }
        count = 0;
    }

    //TODO функция перестройки таблицы при увеличении емкости
    //TODO equals
    //TODO hashCode

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
