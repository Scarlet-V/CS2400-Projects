package BagProject.BagProject;
/**A class of bags whose entries are stored in a resizable array
 * @author Miranda Silva, Samuel Chih
 */

import java.util.Arrays;
import java.util.ArrayList;

public class ResizableArrayBag<T> implements BagInterface<T> {
    private Node firstNode;
    private T[] bag;
    private static final int MAX_CAPACITY = 1000;
    private boolean integrityOK;
    private int numberOfEntries=0;

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
    public ResizableArrayBag(){
        firstNode = null;
        integrityOK=false;
            @SuppressWarnings("unchecked")
            T[] tempBag = (T[])new Object[MAX_CAPACITY]; 
            bag = tempBag;
            integrityOK = true;
        
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
        if (integrityOK){
        boolean result = true;
        if (isArrayFull()){
        doubleCapacity();
        }
        else{ 
        bag[numberOfEntries] = newEntry;
        numberOfEntries++;
        } 
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

    public T[] toArray() {
      T[] copy = (T[])new Object[numberOfEntries];
        for (int i = 0; i < this.numberOfEntries; i++) {
            if(bag[i]!=null){
                copy[i] = bag[i];
            } else{
                i++;
            }
        }
        return copy;
    }

/*     public T[] toArray()
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
    } */

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
        BagInterface < T > result = new ResizableArrayBag<>();
        T[] mine = this.toArray();
        for (T elem : mine) 
        {
            result.add(elem);
        }
        T[] others = anotherBag.toArray();
        for (T elem : others) 
        {
            result.add(elem);
        }
        return result;
    }
    
    @Override
    public BagInterface<T> intersection(BagInterface<T> anotherBag) 
    {
        BagInterface < T > result = new ResizableArrayBag<>();
        BagInterface < T > finalResult = new ResizableArrayBag<>();
        T[] mine = this.toArray();
        for (T elem : mine) 
        {
            result.add(elem);
        }
        T[] others = anotherBag.toArray();
        for (T elem : others) 
        {
            if(result.contains(elem))
        {
                finalResult.add(elem);
        }
        }
        return finalResult;
    }
    
    public BagInterface<T> difference(BagInterface<T> anotherBag) {
        BagInterface <T> result = new ResizableArrayBag<>();
        T[] mine = this.toArray();
        T[] others = anotherBag.toArray();
        a:
        for (int i=0; i<mine.length;i++) {
            boolean temp =true;
            for (int k=0; k<others.length;k++){
                if(mine[i]==others[k]){
                    temp=false;
                }
                
                for (int j=mine.length-1; j>=0;j--){ 
                 if((k==others.length-1) &&temp==true&&mine[i]!=mine[j]){
                    result.add(mine[i]);
                    break a;
                 }
                }
            }
        }
        return result;
        /*         a:
        for (T i : mine) {
            b:
            for (T k : others) {
                if(i!=k){
                    System.out.println("I: "+i+", K out: "+k);
                    System.out.println("mine: "+mine+", other out: "+others);
                    result.add(i);
                    break a;
                }
                else{
                    break ;
                }  
                
             }
        } */
/*         for (T elem : mine) {
            result.add(elem);
        } */
    }

    /* @Override
    public BagInterface<T> difference(BagInterface<T> anotherBag) 
    {
        BagInterface < T > result = new ResizableArrayBag<>();
        T[] mine = this.toArray();
        for (T elem : mine) 
        {
        result.add(elem);
        }
        T[] others = anotherBag.toArray();
        for (T elem : others) 
        {
        if(result.contains(elem))
        {
        result.remove(elem);
        }
        }
        return result;
        }  */
       
}
