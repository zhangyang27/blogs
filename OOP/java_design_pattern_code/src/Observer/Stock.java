package Observer;

import java.util.Observable;

public class Stock extends Observable {
	public Stock(String name) {
		super();
		this.name = name;
	}

	public Stock(String name, float price) {
		super();
		this.name = name;
		this.price = price;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		if(Math.abs((this.price - price) /this.price) > 0.1){
			this.setChanged(); //����������Ϊtrue�����ܵ���֪ͨ���й۲���
			//System.out.println(this.hasChanged()); 
			notifyObservers(price); //���ú�changed��Ϊfalse
			//System.out.println(this.hasChanged());
		}
		this.price = price;
	}

	private String name;
	private float price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
