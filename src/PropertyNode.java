
public class PropertyNode {
	
	private Property data;
	private PropertyNode link;
	
	public PropertyNode(Property data, PropertyNode link) {
		this.data=data;
		this.link=link;
	}
	public Property getData()	{ 
		return data; 	
	}
	
	public void setData(Property element)	{
		this.data = element;
	}

	public PropertyNode getLink(){	
		return link;
	}
	public void setLink(PropertyNode link)	{ 
		this.link = link;
	}
}
