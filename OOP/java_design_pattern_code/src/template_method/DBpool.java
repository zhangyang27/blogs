package template_method;

public class DBpool extends DB {

	@Override
	public void getConnect() {
		// TODO Auto-generated method stub
		System.out.println("使用数据库连接池获得数据库链接");
	}

}
