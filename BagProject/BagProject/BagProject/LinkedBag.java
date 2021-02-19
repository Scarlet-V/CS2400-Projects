package BagProject;

public class LinkedBag<T> implements BagInterface<T> 
{
	private Node firstNode;
	private int numberOfEntries;

	public LinkedBag()
	{
		firstNode=null;
		numberOfEntries=0;
	}

	private class Node
	{

	}
	/**
	 * testing 
	 */
	public boolean add(T newEntry)
	{
		Node newNode = new Node (newEntry);
		newNode.next=firstNode;

		firstNode = newNode;
		numberOfEntries++;

		return true;
	}

	public T remove()
	{
		T result = null;
		if (firstNode !=null)
		{
			result=firstNode.getData();
			firstNode=firstNode.getNextNode(); //Remove first node from chain
			numberOfEntries--;
		} //end if

		return result;
	} //end remove

	private Node getReferenceTo(T anEntry)
	{
		boolean found = false;
		Node current = firstNode;

		while(!found && (currentNode !=null))
		{
			if (anEntry.equals(currentNode.getData()))
				found=true;
			else
				currentNode = currentNode.getNextNode();
		} //end while
		return currentNode;
	} //end getReferenceTo

	public boolean remove(T anEntry)
	{
		boolean result = false;
		Node nodeN = getReferenceTo(anEntry);

		if  (nodeN = getReferenceTo(anEntry))
		{
			// Replace located entry with entry in first node
			nodeN.setData(firstNode.getData());
			// Remove first node
			firstNode = firstNode.getNextNode();

			numberOfEntries--;

			result=true;
		} // end if

		return result;
	} // end remove

	public boolean isEmpty()
	{
		return numberOfEntries===0;

	}

	public int getCurrentSize()
	{
		return numberOfEntries;
	}

	public void clear()
	{
		while (!isEmpty())
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
			currentNode = currentNode.getNextNode();
		}
		return frequency;
	}

	public boolean contains(T anEntry)
	{
		boolean found = false;
		Node currentNode=firstNode;

		while (!found && (currentNode !=null))
		{
			if (anEntry.equals(currentNode.getData()))
				found = true;
				else
					currentNode =currentNode.getNextNode();
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
			result[index] =currentNode.getData();
			index++;
			currentNode=currentNode.getNextNode();
		}
		return result;
	}
}