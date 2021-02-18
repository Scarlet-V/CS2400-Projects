package BagProject;

public class Node 
{
 private T data;
 private Node next;

 private Node(T dataPortion)
 {
	this (dataPortion, null);
 }

private Node(T dataPortion, Node nextNode)
{
	data = dataPortion;
	next = nextNode;
} // end constructor

private T getData()
[
	return data;
]

private void setData(T newData)
{
	data=newData;
}

private Node getNextNode()
{
	return next;
}

private void setNextNode(Node nextNode)
{
	next= nextNode;
}

}
