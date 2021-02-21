package BagProject.BagProject;

public class LinkedBag<T> implements BagInterface<T> 
{
	private Node firstNode;
	private int numberOfEntries;


	public LinkedBag() 
	{
		firstNode = null;
		numberOfEntries = 0;
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

	public boolean add(T newEntry) {
		Node newNode = new Node(newEntry);
		newNode.next = firstNode;
		firstNode = newNode;
		numberOfEntries++;
		return true;
	}

	public T remove() {
		T result = null;
		if (firstNode != null) {
			result = firstNode.data;
			firstNode = firstNode.next; // Remove first node from chain
			numberOfEntries--;
		} // end if

		return result;
	} // end remove

	private Node getReferenceTo(T anEntry) 
	{
		boolean found = false;
		Node currentNode = firstNode;

		while (!found && (currentNode != null)) 
		{
			if (anEntry.equals(currentNode.data))
				found = true;
			else
				currentNode = currentNode.next;
		} // end while
		return currentNode;
	} // end getReferenceTo

	public boolean remove(T anEntry) 
	{
		boolean result = false;
		Node nodeN = getReferenceTo(anEntry);

		if  (nodeN !=null)
		{
			// Replace located entry with entry in first node
			nodeN.data=firstNode.data;
			// Remove first node
			firstNode = firstNode.next;
			numberOfEntries--;

			result=true;
		} // end if

		return result;
	} // end remove

	public boolean isEmpty()
	{
		return numberOfEntries==0;
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

	@Override
	public String union() 
	{
		
		return null;
	}

	@Override
	public void intersection() 
	{
		

	}

	@Override
	public void difference() 
	{
		

	}

	@Override
	public BagInterface<T> union(BagInterface<T> anotherBag) 
	{
		return null;
	}

	@Override
	public BagInterface<T> intersection(BagInterface<T> anotherBag) 
	{
		return null;
	}

	@Override
	public BagInterface<T> difference(BagInterface<T> anotherBag) 
	{
		return null;
	}
}
