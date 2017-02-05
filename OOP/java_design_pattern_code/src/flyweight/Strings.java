package flyweight;

public class Strings implements Element {
	String content;
	
	public Strings(String content) {
		super();
		this.content = content;
	}

	@Override
	public String getContent() {
		// TODO Auto-generated method stub
		return content;
	}

}
