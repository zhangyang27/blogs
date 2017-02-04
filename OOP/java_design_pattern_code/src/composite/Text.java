package composite;

public class Text implements Widget {
	private String name;
	public Text(String name){
		this.name = name;
	}
	@Override
	public void onclick() {
		// TODO Auto-generated method stub
		System.out.println(this.name+"text±»µã»÷ÁË");
	}

}
