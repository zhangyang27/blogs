package composite;

public class Button implements Widget {
	private String name;
	public Button(String name){
		this.name = name;
	}
	@Override
	public void onclick() {
		// TODO Auto-generated method stub
		System.out.println(this.name+"±»µã»÷ÁË");
	}

}
