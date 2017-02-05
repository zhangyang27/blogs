package flyweight;

public class Picture implements Element {
	String content;
	
	public Picture(String content) {
		super();
		this.content = content;
	}

	@Override
	public String getContent() {
		// TODO Auto-generated method stub
		return content;
	}

}
