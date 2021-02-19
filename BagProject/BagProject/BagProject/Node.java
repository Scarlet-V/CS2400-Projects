package BagProject;

public class Node <T>
{
 private T data;
 private Node next;

 private Node(T dataPortion)
 {
	this (dataPortion, null);
 }

private Node(T dataPortion, Node <T> nextNode)
{
	data = dataPortion;
	next = nextNode;
} // end constructor

private T getData()
{
	return data;
}

private void setData(T newData)
{
	data=newData;
}

private Node <T> getNextNode()
{
	return next;
}

private void setNextNode(Node<T> nextNode)
{
	next= nextNode;
}

}
