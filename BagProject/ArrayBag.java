public class ArrayBag<T> impliments BagInterface<T>
{
    private final T[] bag;
    private static final int DEFAULT_CAPACITY = 25;
    private int numberOfEntries;

    public ArrayBag()
    {

    }
    public ArrayBag(int capacity)
    {
        numberOfEntries =0;
        @SuppressWarnings("unchecked")
        T[] tempBag=(T[]new Object[capacity]);
        bag = tempBag;
    }
    public boolean add(T newEntry)
    {
        boolean result = true;
        if (isFull())
        {
            result = false;
        }
        else
        {
            bag[numberOfEntries] = newEntry
            numberOfEntries++;
        }
        return result;
    }
    public T[] toArray()
    {
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries];
        for (int index =0; index < numberOfEntries; index++)
        {
            result[index] = bag[index];
        }
        return result;
    }
}