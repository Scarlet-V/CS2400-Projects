import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Test;

public class LinkedBagTest {
	BagInterface<String> b1 = new LinkedBag<String>();
	BagInterface<String> b2 = new LinkedBag<String>();
	{
	b1.add("Hello");//a
	b1.add("how are");//c
	b1.add("you?");//c

	b2.add("how are");//b
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
}
