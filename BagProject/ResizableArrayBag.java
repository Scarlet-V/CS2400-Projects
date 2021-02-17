package BagProject;
import java.util.ArrayList;

public class ResizableArrayBag<T> implements BagInterface<T> {
private final T[] bag;
private static final int numberOfEntries;
    public ResizableArrayBag(){

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


    public int getCurrentSize() {
        // TODO Auto-generated method stub
        return 0;
    }


    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }


    public boolean add(Object newEntry) {
        boolean result = true;
        if (isArrayFull()) {
               result = false;
        }
        else{  // Assertion: result is true here
         bag[numberOfEntries] = newEntry;
        numberOfEntries++;
        } // end if
        
        return result;
  
    }


    public Object remove() {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean remove(Object anEntry) {
        // TODO Auto-generated method stub
        return false;
    }


    public void clear() {
        // TODO Auto-generated method stub

    }


    public int getFrequencyOf(Object anEntry) {
        // TODO Auto-generated method stub
        return 0;
    }


    public boolean contains(Object anEntry) {
        // TODO Auto-generated method stub
        return false;
    }


    public Object[] toArray() {
        // TODO Auto-generated method stub
        return null;
    }



}
