package prototype;

import java.io.*;


public class CustomerDeepCopy implements Serializable{
	
	public CustomerDeepCopy(String name, Address address, int age) {
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

	public CustomerDeepCopy deepclone() throws IOException,ClassNotFoundException{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();  
        ObjectOutputStream oos = null;
		oos = new ObjectOutputStream(baos);
		oos.writeObject(this);
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());  
        ObjectInputStream ois = null;
        ois = new ObjectInputStream(bais);
		return (CustomerDeepCopy)ois.readObject();
		
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
