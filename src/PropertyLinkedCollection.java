import java.util.Iterator;
/**
 * PropertyLinkedCollection class keeps track of information associated with a PropertyLinkedCollection
 * @author Mohamed Mahdy
 * 3/3/2021
 *
 *Invariant of this PropertyCollection class
 *
 * 1- The number of items contained in the PropertyLinkedCollection is stored in an instance variable called manyItems
 * 2- The PropertyLinkedCollection entries are stored in a PropertyNode variable called head
 * 3- The PropertyLinkedCollection begins at index 1 going though manyItems.
 * 4- When using the insert method, the Properties are sorted in descending order
 * 5- When using the add method, the Properties are inserted at the head and are unordered
 *
 */
public class PropertyLinkedCollection implements DataCollection<Property>{
	private PropertyNode head;
	private int manyItems;
	
	public PropertyLinkedCollection() {
		this.head = null;
		this.manyItems = 0;
	}
	
	public void add(Property p) {
		head = new PropertyNode(p,head);
		manyItems++;
	}
	
	public void insert(Property p) {
		if (head == null) {
			head = new PropertyNode(p,head);
			manyItems++;
		}
		else if (p.compareTo(head.getData())>0) {
			head = new PropertyNode(p,head);
			manyItems++;
		}
		else {
			PropertyNode previousNode = findPrevious(p);
			previousNode.setLink(new PropertyNode(p, previousNode.getLink()));
			manyItems++;
		}
	}
    
	@Override
	public int size() {
		return manyItems;
	}
	
	public PropertyNode findPrevious(Property p)	{

		PropertyNode cur = head;
		
		while (cur.getLink() != null && cur.getLink().getData().compareTo(p)>0)	{
			cur = cur.getLink();
		}
		return cur;
	}
	
	@Override
	public Property find(String key) {
		PropertyNode cur = head;
		while (cur!=null) {
			if(cur.getData().getName().compareTo(key)==0) {
				return cur.getData(); 
			}
		cur = cur.getLink();
		}
		return null;
	}

	@Override
	public int countOccurrences(boolean lookFor) {
		PropertyNode cur = head;
		int amount = 0;
		while (cur != null)	{
			if(cur.getData().isAvailability()==lookFor) {
				amount++;
			}
			cur = cur.getLink();
		}
		return amount;
	}

	@Override
	public boolean contains(Property p) {
		PropertyNode cur = head;
		while (cur != null)	{
			if(cur.getData().equals(p)) {
				return true;
			}
			cur = cur.getLink();
		}
		return false;
	}

	@Override
	public int total() {
		PropertyNode cur = head;
		int sum = 0;
		while (cur != null)	{
			sum+=cur.getData().getValue();
			cur = cur.getLink();
		}
		return sum;
	}

	@Override
	public double average() {
		double avg = ((float)total())/manyItems;
		return avg;
	}

	@Override
	public int countRange(int low, int high) {
		int count = 0;
		PropertyNode cur=head;
		
		if(high<low) {
			int temp = high;
			high = low;
			low = temp;
		}
		while (cur != null)	{
			if(cur.getData().getValue()<=high && cur.getData().getValue()>=low) {
				count++;
			}
			cur = cur.getLink();
		}
		return count;
	}
	
	public void delete(Property p) {
		if (head == null) {
			System.out.println("List is empty! ");
		}
		if (p.compareTo(head.getData())==0) {
			head = head.getLink();
			manyItems--;
		}
		PropertyNode previousNode = findPrevious(p);
		if ((previousNode.getLink()==null)||previousNode.getLink().getData().compareTo(p)!=0) {
			System.out.println("Property not found! ");
		}
		else {
			previousNode.setLink(previousNode.getLink().getLink());
			manyItems--;
		}
	}
	
	public int positionOf(Property p) {
		PropertyNode cur = head;
		int position = 0;
		
		if (head == null) {
			return position;	
		}
		while (cur != null)	{
			position++;
			if(cur.getData().compareTo(p)==0) {
				return position;
			}
			cur = cur.getLink();
		}
		return 0;
	}
	
	public Property grab(int position) {
		PropertyNode cur = head;
		int count = 0;
		
		if (position<=0 || position> manyItems) { 
			return null;
		}
		if (head == null) { 
			return null;	
		}
		while (cur != null)	{
			count++;
			if(count==position) { 
				return cur.getData() ;
			}
			cur = cur.getLink();
		}
		return null;
	}
	
	public String toString()	{
		
	String output ="\nName:\t\t"+" Value:\t\t\t"+" Availability:\n";
	output+="-------------------------------------------------------------\n";

		PropertyNode cur = head;
		while (cur != null)	{
			output += cur.getData().toString() +"\n";
			cur = cur.getLink();
		}
		return output;
	}
	
	public Iterator<Property> iterator(){
		return new PropertyLinkedCollectionIterator();
	}	

/** PropertyCollectionIterator
 * 
 * This is an embedded class that implements the constructor, hasNext() and next()
 * methods for an iterator for the PropertyCollection class
 * 
 */
public class PropertyLinkedCollectionIterator implements Iterator<Property>{
	PropertyNode cur = head;
	
	@Override
	public boolean hasNext() {
		if(cur==null)
			return false;
		else		
			return true;
	}
	
	@Override
	public Property next() {
		Property output = cur.getData();
		cur=cur.getLink();
		return output;
		}
	}
}



	