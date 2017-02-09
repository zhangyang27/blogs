package template_method;

public abstract class DB {

	public String templateMethod(String sql,String type){
		this.getConnect();
		this.OpenDB();
		String ret = this.Excute(sql, type);
		this.CloseConnect();
		return ret;
	}
	private void CloseConnect() {
		// TODO Auto-generated method stub
		System.out.println("关闭数据库");
		
	}
	private void OpenDB() {
		// TODO Auto-generated method stub
		System.out.println("打开数据库");
	}
	public  abstract void getConnect();
	
	private String Excute(String sql,String type){
		if(type == "QUERY"){
			return sql+"的查询结果";
		}else if(type == "UPDATE"){
			return sql+"的更新结果";
		}else{
			return "type error";
		}
		
	}
	
}
