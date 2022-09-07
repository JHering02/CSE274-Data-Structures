
public class Driver {
	
	public static void main(String[] args) {
		
		// As we test our methods, make sure the method works as expected...
		// ...with an empty list
		// ...with a non-empty list
		// **** YOU CAN MAKE ANY CHANGES YOU WANT TO THE CODE IN THIS METHOD ****
		// It is your tester.  Test thoroughly.
		// As we test our methods, make sure the method works as expected...
		// ...with an empty list
		// ...with a non-empty list
		
		LinkedList list = new LinkedList();
		System.out.println("?" + list.toString());
		
		list.insertFirst(17);
		list.insertFirst(20);		
		System.out.println("20 17? " + list.toString());
		
		list.insertLast(50);
		list.insertLast(51);
		System.out.println("20 17 50 51? " + list.toString());
		

	}
	
}
