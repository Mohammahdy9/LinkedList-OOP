import java.util.Iterator;

public class PropertyDriver {

	public static void main(String[] args) {
		
		//assert false;
				
		Property pr1  = new Property("Anotala N",900,false);
		Property pr2  = new Property("Bemidji Ave",1000,true);
		Property pr3 = new Property("Casablanca",1100,true);
		Property pr4 = new Property("Franklin N",5900,true);
		Property pr5 = new Property("Dayton NW",4000,false);
		Property pr6 = new Property("East Rd ",3400,true);

		PropertyLinkedCollection pc1 = new PropertyLinkedCollection();//Unordered List
		
		pc1.add(pr1);
		pc1.add(pr2);
		pc1.add(pr3);
		pc1.add(pr4);
		pc1.add(pr5);
		System.out.println("Unordered List: \n");
		System.out.println(pc1);
	
		PropertyLinkedCollection pc2 = new PropertyLinkedCollection();//Ordered List
		
		pc2.insert(pr1);
		pc2.insert(pr2);
		pc2.insert(pr3);
		pc2.insert(pr4);
		pc2.insert(pr5);
		System.out.println("\nOrdered List: \n");
		System.out.println(pc2);
		
		System.out.println("Testing Methods On Ordered List: \n");
		System.out.println("Size of Ordered List: "+pc2.size());//Should return 5
		System.out.println("Find Anotala N : "+pc2.find("Anotala N"));//Should return pr1
		System.out.println("Find East Rd: "+pc2.find("East Rd"));//Should return null
		System.out.println("Count the occurences of True: "+pc2.countOccurrences(true));//Should return 3
		System.out.println("Does the list have Bemidji Ave?: "+pc2.contains(pr2));//Should return true
		System.out.println("Does the list have East Rd?: "+pc2.contains(pr6));//Should return false
		System.out.println("Total value of the Property Collection: $"+pc2.total());//Should return 12900
		System.out.println("Average value of the Property Collection: $"+pc2.average());//Should return 2580.0
		System.out.println("How many Properties between the values of 1000 and 4000?: "+pc2.countRange(1000, 4000));//Should return 3
		System.out.println("Position of Casablanca: "+pc2.positionOf(pr3));//Should return 3
		System.out.println("Grab Property in position 3: "+pc2.grab(3));//Should return pr3
		
		System.out.println("\nPrinting with an iterator:\n");
		Iterator<Property> itr = pc2.iterator();
		while (itr.hasNext())	{
			System.out.println(itr.next());	// display next item in the list
		}
		
		System.out.println("\nDeleting Casablanca... ");
		pc2.delete(pr3);
		System.out.println("\nRevised Ordered List: "+pc2);
		System.out.print("Trying to delete Casablanca again...: ");
		pc2.delete(pr3);
		

		//Testing using asserts
		
		assert pc2.size() == 4;//true
		assert pc2.contains(pr2);//true
		
	}

}
