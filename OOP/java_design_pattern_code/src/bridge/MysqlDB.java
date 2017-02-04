package bridge;

public class MysqlDB implements DBSource {

	@Override
	public String getData() {
		return "从Mysql获得了数据";
	}

}
