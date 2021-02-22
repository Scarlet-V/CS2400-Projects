import java.util.Arrays;
public class ArrayBagTest 
{
	public static void main(String[] args) 
	{
		BagInterface<String> b1 = new ResizableArrayBag<String>();
		BagInterface<String> b2 = new ResizableArrayBag<String>();

		b1.add("Hello");//a
		b1.add("Hello");//a
		b1.add("Hello");//a
		b1.add("how are");//b
		b1.add("you?");//c
		b1.add("ハワユ");//e

		b2.add("how are");//b
		b2.add("how are");//b
		b2.add("/");//d
		b2.add("/");
		b2.add("/");
		b2.add("ハワユ");//e
		//difference should only "Hello" "you?" "ハワユ"

		System.out.println("bag1: "+Arrays.toString(b1.toArray()));
		System.out.println("bag2: "+Arrays.toString(b2.toArray()));

		System.out.println("bag1 union bag2: "+ Arrays.toString(b1.union(b2).toArray()));
		System.out.println("bag1 intersection bag2: "+ Arrays.toString(b1.intersection(b2).toArray()));
		System.out.println("bag1 difference bag2: "+ Arrays.toString(b2.difference(b1).toArray()));
	}

}
