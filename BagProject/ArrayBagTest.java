import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Test;

public class ArrayBagTest 
{	
	BagInterface<String> b1 = new ResizableArrayBag<String>();
	BagInterface<String> b2 = new ResizableArrayBag<String>();
	{
		b1.add("Hello");//a
		b1.add("how are");//c
		b1.add("you?");//c
	
		b2.add("how are");
		b2.add("how are");//b
		b2.add("/");//d
		b2.add("ハワユ");//e
	}

	@Test
	public void testUnion(){
		System.out.println("[Hello, how are, you?, how are, how are, /, ハワユ]");
		assertEquals("[Hello, how are, you?, how are, how are, /, ハワユ]",Arrays.toString(b1.union(b2).toArray()));
	}

	@Test
	public void testDifference(){
		System.out.println("testDifference: [Hello, you?]");
		assertEquals("[Hello, you?]",Arrays.toString(b1.difference(b2).toArray()));
		System.out.println("[how are, /, ハワユ]");
		assertEquals("[how are, /, ハワユ]",Arrays.toString(b2.difference(b1).toArray()));
	}
	@Test
	public void testIntersection(){
		System.out.println("[how are]");
		assertEquals("[how are]",Arrays.toString(b1.intersection(b2).toArray()));
		System.out.println("[how are, how are]");
		assertEquals("[how are, how are]", Arrays.toString(b2.intersection(b1).toArray()));
	}
  	public static void main(String[] args) 
	{
		BagInterface<String> b1 = new ResizableArrayBag<String>();
		BagInterface<String> b2 = new ResizableArrayBag<String>();
		b1.add("Hello");//a
		b1.add("how are");//c
		b1.add("you?");//c
	
		b2.add("how are");
		b2.add("how are");//b
		b2.add("/");//d
		b2.add("ハワユ");//e

		System.out.println("bag1: "+Arrays.toString(b1.toArray()));
		System.out.println("bag2: "+Arrays.toString(b2.toArray()));

		System.out.println("bag1 union bag2: "+ Arrays.toString(b1.union(b2).toArray())); //[Hello, how are, you?, how are, how are, /, ハワユ]
		System.out.println("bag1 intersection bag2: "+ Arrays.toString(b1.intersection(b2).toArray())); //[Hello]
		System.out.println("bag2 intersection bag1: "+ Arrays.toString(b2.intersection(b1).toArray()));
		System.out.println("bag1 difference bag2: "+ Arrays.toString(b1.difference(b2).toArray())); // [how are]
		System.out.println("bag2 difference bag1: "+ Arrays.toString(b2.difference(b1).toArray())); // [how are, /, "ハワユ"]
	}  
 
}
