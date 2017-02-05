package flyweight;

public class Vedio implements Element {
	String content;
	
	public Vedio(String content) {
		super();
		this.content = content;
	}

	@Override
	public String getContent() {
		// TODO Auto-generated method stub
		return content;
	}

}
