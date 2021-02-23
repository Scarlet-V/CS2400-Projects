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
	public BagInterface<T> union(BagInterface<T> anotherBag) 
	{
		BagInterface < T > result = new LinkedBag < >();
		T[] others = anotherBag.toArray();
		for (T elem : others) 
		{
		result.add(elem);
		}
		T[] mine = this.toArray();
		for (T elem : mine) 
		{
		result.add(elem);
		}
		return result;
	}

	@Override
	public BagInterface<T> intersection(BagInterface<T> anotherBag) 
	{
		BagInterface < T > result = new LinkedBag < >();
      	BagInterface < T > finalResult = new LinkedBag < >();
		T[] mine = this.toArray();
		T[] others = anotherBag.toArray();
		for (T elem : others) 
		{
		result.add(elem);
		}

		for (T elem1 : mine) 
		{
			if(result.contains(elem1))
		{
				finalResult.add(elem1);
		}
		}
		return finalResult;
	}

	@Override
	public BagInterface<T> difference(BagInterface<T> anotherBag) 
	{
		BagInterface < T > result = new LinkedBag < >();
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
	}	
}
