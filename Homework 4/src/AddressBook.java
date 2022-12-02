import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {


	private static void buildMap(Map<String, Address> map) throws FileNotFoundException {
		try {
			Scanner reader = new Scanner(new File("addresses.txt"));
			while (reader.hasNextLine()) {
				String lName = reader.nextLine();
				String fName = reader.nextLine();
				String house = reader.nextLine();
				int zip = Integer.parseInt(reader.nextLine());
				String phone = reader.nextLine();
				String key = fName.toLowerCase() + lName.toLowerCase();
				if(!(map.containsKey(key))) {
					map.put(key, new Address(fName, lName, zip, house, phone));
				}
			}
			reader.close();
			System.out.println("AdressBook has been created successfully.");
		} catch (Exception e) {
			System.out.println("Program will fail to build a map. \"adresses.txt\" was not provided in the directory.");
		}
	}
	
	private static void searchMap(String str1, Map<String, Address> map) {
		if(map.containsKey(str1)) {
			System.out.println(map.get(str1).toString());
		} else {
			System.out.println("Entry not found.");
		}
	}
	public static void main(String[] args) {
		Map<String, Address> map = new HashMap<String, Address>();
		Scanner reader = new Scanner(System.in);
		String response = "";
		try {
			buildMap(map);
			do {			
				System.out.println("To search for a person, enter the first name, followed by a space & last name");
				System.out.print("Who would you like to search for (or enter -1 to exit program)? ");
				response = reader.next();
				if(!response.equals("-1")) {	
					String response2 = reader.next();
					response = response.toLowerCase() + response2.toLowerCase();
					searchMap(response, map);
				}
			} while(!(response.equals("-1")));
			System.out.println("Good bye.");
			reader.close();
		} catch (FileNotFoundException e) {

		}
	}

}
