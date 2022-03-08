import java.text.DecimalFormat;

public class Property implements Comparable<Property> {
	
	DecimalFormat df =  new DecimalFormat("$###,###,##0.00");
	private String name;
	private int value;
	private boolean availability;
	
	public Property(String name, int value, boolean availability) {
		this.setName(name);
		this.setValue(value);
		this.setAvailability(availability);	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean isAvailability() { //is or get?
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	
	public String toString() {
		return name+"\t "+df.format(value)+"\t\t "+availability;
	}
	
	@Override
	public boolean equals(Object o){
		if (o instanceof Property)	{	
			Property p1 = (Property) o;	
			if (this.name.equalsIgnoreCase(p1.name))
				return true;
		}
		return false;
	}

	@Override
	public int compareTo(Property p) {
		return name.compareToIgnoreCase(p.getName());
	}
}
