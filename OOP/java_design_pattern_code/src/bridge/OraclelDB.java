package bridge;

public class OraclelDB implements DBSource {

	@Override
	public String getData() {
		return "从Oracle获得了数据";
	}

}
