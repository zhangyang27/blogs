package template_method;

import simpleFactory.Shape;
import simpleFactory.shapeFactory;


/**
 * 设计模式的艺术软件开发人员内功修炼之道_刘伟 P379
 * 用模板方法模式开发一个数据库操作模块，用户只需要将SQL传入模板方法即可
 * 自动完成连接数据库、打开数据库、操作数据库（查询或者更新）、关闭数据库等操作，设计时要求：
 * 1. 系统需支持多种数据库方式，例如 JDBC——ODBC桥接，厂商驱动或者数据库连接池等。
 * 2. 每次调用模板方法时，需要从查询或更新两个方法中选择，可以在模板方法中加入一个参数决定；
 * @author zhangyang27
 *
 */
public class Client {
	public static void main(String[] args) {
		String sql = "select * from user;";
		DB db = new DBpool();
		String ret = db.templateMethod(sql, "QUERY");
		System.out.println(ret);
		db = new JDBC_ODBC();
		ret = db.templateMethod(sql, "QUERY");
		System.out.println(ret);
	}

}
