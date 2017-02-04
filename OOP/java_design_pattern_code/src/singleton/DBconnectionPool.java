package singleton;
import java.util.*;
/*
 * 负责数据库连接，是一个单例
 */
public class DBconnectionPool {
	private List<String> connecionList = null;
	
	//将构造方法私有化，因为是单例嘛
	private DBconnectionPool(){
		connecionList = new ArrayList<String>();
	};
	
	//用内部类的办法来完成单例对象的初始化，
	//这样即可以实现延迟加载
	//又可以保证线程安全
	private static class HolderClass{
		private final static DBconnectionPool instance = new DBconnectionPool();
	}
	
	public static DBconnectionPool getInstance(){
		return HolderClass.instance;
	}

	public void addConnection(String con) {
		// TODO Auto-generated method stub
		connecionList.add(con);
		System.out.println("添加连接:"+con);
	}
	public void query(String sql) {
		//随机选择一个连接
		Random rd = new Random();
		int i = rd.nextInt(connecionList.size());
		String con = connecionList.get(i);
		System.out.println("使用链接-"+con+"-查询了语句："+sql);
	}
}
