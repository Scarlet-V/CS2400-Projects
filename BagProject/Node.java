package BagProject;

public class Node {
 private T data;
 private Node next;

 private Node(T dataPortion){
	this (dataPortion, null);
 }

private Node(T dataPortion, Node nextNode){
	data = dataPortion;
	next = nextNode;
} // end constructor

}
