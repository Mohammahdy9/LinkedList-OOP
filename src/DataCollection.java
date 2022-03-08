
public interface DataCollection<E> {
	public void insert(E oneThing);
	public int size();
	public String toString();
	public E find(String key);
	public int countOccurrences(boolean lookFor);
	public boolean contains(E oneThing);
	public int total();
	public double average();
	public int countRange(int low, int high);
	}

