package chain;

public class Request {
	String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public Request(String name, int day) {
		super();
		this.name = name;
		this.day = day;
	}
	int day;
}
