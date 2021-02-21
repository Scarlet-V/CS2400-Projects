package BagProject.BagProject;
/**A class of bags whose entries are stored in a resizable array
 * @author Miranda Silva, Samuel Chih
 */

import java.util.Arrays;

public class ResizableArrayBag<T> implements BagInterface<T> 
{
    private Node firstNode;
    private T[] bag;
    private static final int MAX_CAPACITY = 100;
    private boolean integrityOK;
    private int numberOfEntries = 100;

    public ResizableArrayBag(int desiredCapacity)
    {
        firstNode = null;
        integrityOK=false;
        if(desiredCapacity<=MAX_CAPACITY)
        {
            
            @SuppressWarnings("unchecked")
            T[] tempBag = (T[])new Object[desiredCapacity]; 
            bag = tempBag;
            integrityOK = true;
        }
        else
            throw new IllegalStateException("Attempt to create a bag whose"+"capacity exceeds allowed maximum.");
    } 
    
    public ResizableArrayBag() 
    {
        this(MAX_CAPACITY);
    }

    private void checkCapacity(int capacity)
    {
        if(capacity>MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a bag whose"+"capacity exceeds allowed"+"maximum of"+MAX_CAPACITY);
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

    public String union()
    {
        return null;
    

    }

    public void intersection() 
    {
      /**  for (int i=0;i<numberOfEntries;i++)
        {
            result.add(bag[i]);
        }
        for (Object ob : other.toArray())
        {
            result.add((T)ob);
        }
        return result;*/
    }


    public void difference() 
    {
        

    }


    public int getCurrentSize() 
    {
        return numberOfEntries;
    }

    public boolean isArrayFull()
    {
        return numberOfEntries==bag.length;
    }


    public boolean isEmpty() 
    {
        return numberOfEntries == 0;
    }

    public boolean add(T newEntry) 
    {
        if (integrityOK)
        {
        boolean result = true;
        if (isArrayFull())
        {
        doubleCapacity();
        }
        else
        { // Assertion: result is true here
        bag[numberOfEntries] = newEntry;
        numberOfEntries++;
        } // end if
        return result;
        }

        else
            throw new SecurityException("ArrayBag object is corrupt.");
    }

    public T remove()
    {
        T result = removeEntry(numberOfEntries - 1);
        return result;
    }

    private T removeEntry(int givenIndex) 
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
        int frequency = 0;

		int counter=0;
		Node currentNode=firstNode;
		while ((counter<numberOfEntries)&&(currentNode !=null))
		{
			if(anEntry.equals(currentNode !=null))
			{
				frequency++;
			}
			counter++;
			currentNode = currentNode.next;
		}
		return frequency;
    }


    public boolean contains(T anEntry) 
    {
        boolean found = false;
		Node currentNode=firstNode;

		while (!found && (currentNode !=null))
		{
			if (anEntry.equals(currentNode.data))
				found = true;
				else
					currentNode =currentNode.next;
		}
		return found;
    }


    public T[] toArray()
    {
        @SuppressWarnings("unchecked")
		T[] result=(T[])new Object[numberOfEntries];

		int index=0;
		Node currentNode=firstNode;
		while((index<numberOfEntries)&&(currentNode !=null))
		{
			result[index] =currentNode.data;
			index++;
			currentNode=currentNode.next;
		}
		return result;
    }

    private class Node {
		private T data;
		private Node next;

		private Node(T dataPortion) {
			this(dataPortion, null);
		}

		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		}
	}

    @Override
    public BagInterface<T> union(BagInterface<T> anotherBag) 
    {
   
        ResizableArrayBag<T> result = new ResizableArrayBag<T>();
        for (int i = 0; i < numberOfEntries; i++) 
        {
              result.add(bag[i]);
        }
        for (Object ob : anotherBag.toArray()) 
        {
             result.add((T) ob);
        }
        return result;
    }

    @Override
    public BagInterface<T> intersection(BagInterface<T> anotherBag) 
    {
        ResizableArrayBag<T> result = new ResizableArrayBag<T>();
        for (int i = 0; i < numberOfEntries; i++) 
        {
            T item = bag[i];
            if (!result.contains(item) && anotherBag.contains(item)) 
            {
                  int common_count = Math.min(getFrequencyOf(item),anotherBag.getFrequencyOf(item));
                  for (int j = 0; j < common_count; j++) 
                  {
                        result.add(item);
                  }
            }
        }
            return null;
    }

    @Override
    public BagInterface<T> difference(BagInterface<T> anotherBag) 
    {
        {
            ResizableArrayBag<T> result = new ResizableArrayBag<T>();
            for (int i = 0; i < numberOfEntries; i++) 
            {
                  T item = bag[i];
                  if (!result.contains(item)) 
                  {
                        int difference = getFrequencyOf(item) - anotherBag.getFrequencyOf(item);
                        for (int j = 0; j < difference; j++) 
                        {
                              result.add(item);
                        }
                  }
            }
            return result;
        }
    }
}