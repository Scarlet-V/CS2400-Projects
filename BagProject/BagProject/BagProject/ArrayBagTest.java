package BagProject.BagProject;
import java.util.Arrays;
public class ArrayBagTest 
{

	public static void main(String[] args) 
	{
		BagInterface<String> b1 = new ResizableArrayBag<String>();
		BagInterface<String> b2 = new ResizableArrayBag<String>();
		b1.add("h");
		b1.add("e");
		b1.add("l");
		b1.add("l");
		b1.add("o");
		b2.add("h");
		b2.add("o");
		b2.add("w");
		b2.add("y");
		b2.add("o");
		b2.add("u");

		System.out.println("bag1: "+Arrays.toString(b1.toArray()));
		System.out.println("bag2: "+Arrays.toString(b2.toArray()));

		System.out.println("bag1 union bag2: "+ Arrays.toString(b1.union(b2).toArray()));
		System.out.println("bag1 intersection bag2: "+ Arrays.toString(b1.intersection(b2).toArray()));
		System.out.println("bag1 difference bag2: "+ Arrays.toString(b1.difference(b2).toArray()));
	}

}
