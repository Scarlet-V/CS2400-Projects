/**
    An interface that displays the operations of a bag containing items
    @author Miranda Silva, Samuel Chih
*/
public interface BagInterface <T> {
    public String union();
    {

    }

    public void interaction();
    {

    }

    public void difference();
    {

    }
    /**Gets the current number of entries in the bag
     * @return The integer number of entries currently in the bag
     */
    public int getCurrentSize();
    {

    }
    /**Checks whether the bag is empty
     * @return True if the bag is empty or False if the bag is not
     */
    public boolean isEmpty();
    {

    }
    /**Adds a new entry to this bag
     * @param newEntry The object which will be added as a new entry
     * @return True if the addition is successful, or false if it is not
     */
    public boolean add(T newEntry);
    {

    }
    /**Removes one unspecified entry from this bag if possible
     * @return Either the removed entry if the removal was successful or null if it was not successful
     */
    public T remove();
    {

    }
    /**Removes one occurrence of a given entry from this bag if possible
     * @param anEntry The entry to be removed
     * @return True if the removal was successful or false if it is not successful
     */
    public boolean remove(T anEntry);
    {

    }
    /**Removes all entries from this bag
     */
    public void clear();
    {

    }
    /**Counts the number of times a given entry appears in this bag 
     * @param anEntry The entry to be counted
     * @return The number of times anEntry appears in the bag
     */
    public int getFrequencyOf(T anEntry);
    {

    }
    /**Tests whether this bag contains a given entry.
     * @param anEntry The entry to find
     * @return True if the bag contains anEntry or false if it does not
     */
    public boolean contains(T anEntry);
    {

    }
    /**Retrieves all entries that are in this bag
     * @return A newly allocated array of all the entries in the bag. Note: If the bag is empty, the returned array is empty 
     */
    public T[] toArray();
    {

    }
}

