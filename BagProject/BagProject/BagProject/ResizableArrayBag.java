package BagProject;
/**A class of bags whose entries are stored in a resizable array
 * @author Miranda Silva, Samuel Chih
 */
import java.util.ArrayList;
import java.util.Arrays;

public class ResizableArrayBag<T> implements BagInterface<T> {

    private T[] bag;
    private static final int MAX_CAPACITY = 100;
    private int  numberOfEntries = 100;
    /**Creates an empty bag
     * @param capacity the integer capacity desired
     */
    public ResizableArrayBag(int desiredCapacity)
    {
        if(desiredCapacity<=MAX_CAPACITY)
        {
            // the cast is safe because the new array contains null entries
            @SuppressWarnings("unchecked")
            T[] tempBag=(T[]new Object[capacity]); //unchecked cast
            bag = tempBag;
            boolean integrityOK = true;
        }
        else
            throw new IllegalStateException("Attempt to create a bag whose"+"capacity exceeds allowed maximum.");
    } /**end of constructor */
    
    private void checkCapacity(int capacity)
    {
        if(capacity>MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a bag whose"+"capacity exceeds allowed"+"maximum of"+MAX_CAPACITY)
    }

    private void doubleCapacity()
    {
        int newLength=2*bag.length;
        checkCapacity(newLength);
        bag=Arrays.copyOf(bag, newLength);
    }

    private void checkIntegrity()
    {
        if (!integrityOK)
            throw new SecurityException("ResizableArray object is corrupt.");
    }

    public String union() {
        return null;
        // TODO Auto-generated method stub

    }

    public void interaction() {
        // TODO Auto-generated method stub

    }


    public void difference() {
        // TODO Auto-generated method stub

    }


    public int getCurrentSize() 
    {
        return numberOfEntries;
    }


    public boolean isEmpty() 
    {
        return numberOfEntries == 0;
    }

    /**Adds a new entry to this bag
     * @param newEntry The object to be added as a new entry
     */
    public boolean add(T newEntry) 
    {
        checkIntegrity();
        boolean result = true;
        while (!isArrayFull()) 
        {
               Capacity ++;
        }

         // Assertion: result is true here
        bag[numberOfEntries] = newEntry;
        numberOfEntries++;
        return true;
    }

    public T remove()
    {
        checkIntegrity();
        T result=removeEntry(numberOfEntries-1);
        return result;
    }

    private T remove(int givenIndex) 
    {
        T result=null;

        if(!isEmpty()&&(givenIndex>=0))
        {
            result=bag[givenIndex];
            bag[givenIndex]=bag[numberOfEntries-1];
            bag[numberOfEntries-1]=null;
            numberOfEntries--;
        }
        return result;
    }

    public boolean remove(T anEntry) 
    {
        checkIntegrity();
        int index = getIndexOf(anEntry);
        T result = removeEntry(index);
        return anEntry.equals(result);
    }

    private int getIndexOf(T anEntry)
    {
        int where =-1;
        boolean found = false;
        int index = 0;

        while (!found &&(index<numberOfEntries))
        {
            if (anEntry.equals(bag[index]))
            {
                found=true;
                where=index;
            }
            index++;
        }
        return where;
    }

    public void clear() 
    {
        while(!isEmpty())
            remove();

    }


    public int getFrequencyOf(T anEntry) 
    {
        checkIntegrity();
        int counter =0;

        for (int index =0; index < numberOfEntries; index++)
        {
            if(anEntry.equals(bag[index]))
            {
                counter++;
            }
        }
        return counter;
    }


    public boolean contains(T anEntry) 
    {
        checkIntegrity();
        return getIndexOf(anEntry)>-1;
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


    public void intersection() {
        // TODO Auto-generated method stub

    }



}