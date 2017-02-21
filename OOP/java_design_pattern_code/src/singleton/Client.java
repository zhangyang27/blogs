package singleton;
/**
 * 设计模式的艺术软件开发人员内功修炼之道_刘伟 P276
 * 创建一个数据库连接池，它应该是一个单例
 * 他能够拥有指定个数的连接对象，并且在查询时随机从池子中挑选连接对象发起连接。
 */
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBconnectionPool db1,db2,db3;
		db1 = DBconnectionPool.getInstance();
		db2 = DBconnectionPool.getInstance();
		db3 = DBconnectionPool.getInstance();
		
		
		//添加连接对象
		db1.addConnection("con1");
		db2.addConnection("con2");
		db3.addConnection("con3");
		
		//调用连接对象
		db1.query("select * from user");
		db2.query("select * from info");
		db3.query("show processlist");
		db1.query("select id from user where name = '1'");
		
		if(db1 == db2 && db2 == db3){
			System.out.println("只有一个数据库连接池，单例模式成功");
		}
	}

}
