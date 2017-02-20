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
			this.setChanged(); //必须先设置为true，才能调用通知所有观察者
			//System.out.println(this.hasChanged()); 
			notifyObservers(price); //调用后changed变为false
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
