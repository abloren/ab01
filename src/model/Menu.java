package model;

// model of meno to define menu info
public class Menu{
	protected int id;
	protected String category;
	protected String name;
	protected int price;
	

	public Menu() {
		
	}
	
	public Menu(String name) {
		super();
		this.name = name;
	}

	public Menu(int id, String category, String name, int price) {
		this.category = category;
		this.name = name;
		this.price = price;
		this.id = id;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public boolean equals(Object obj) {
		Menu m = (Menu)obj;
		if(name.equalsIgnoreCase(m.getName()))
			return true;
		return false;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}
}
