package prototype;

public class Customer1 implements Cloneable{
	
	public Customer1(String name, Address address, int age) {
		super();
		this.name = name;
		this.address = address;
		this.age = age;
	}
	private String name;
	private Address address;
	private int age;
	
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Customer1 clone(){
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (Customer1)obj;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	
}
