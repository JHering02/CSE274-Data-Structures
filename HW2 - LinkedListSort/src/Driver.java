import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Driver class to check the Generic Linked List properly using Adress.java
 * 
 * @author James Hering (CSE 274, 22 September 2022)
 *
 */
public class Driver {
	public static void main(String[] args) throws FileNotFoundException {
		try {
			Scanner reader = new Scanner(new File("./addresses.txt"));
			GenericLinkedList<Address> addr = new GenericLinkedList<Address>();
			while (reader.hasNextLine()) {
				String lName = reader.nextLine();
				String fName = reader.nextLine();
				String strAddress = reader.nextLine();
				int zip = Integer.parseInt(reader.nextLine());
				String phoneNum = reader.nextLine();
				addr.insert(new Address(fName, lName, zip, strAddress, phoneNum));
			}
			System.out.println("The Unsorted List");
			for (int i = 0; i < addr.getSize(); i++) {
				System.out.println(addr.getAt(i).toString() + "\n");
			}
			addr.sort();
			System.out.println("The Sorted List");
			for (int i = 0; i < addr.getSize(); i++) {
				System.out.println(addr.getAt(i).toString() + "\n");
			}
		} catch (Exception e) {
			throw new FileNotFoundException();
		}
	}
}
