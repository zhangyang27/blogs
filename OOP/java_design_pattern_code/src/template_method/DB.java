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
		System.out.println("�ر����ݿ�");
		
	}
	private void OpenDB() {
		// TODO Auto-generated method stub
		System.out.println("�����ݿ�");
	}
	public  abstract void getConnect();
	
	private String Excute(String sql,String type){
		if(type == "QUERY"){
			return sql+"�Ĳ�ѯ���";
		}else if(type == "UPDATE"){
			return sql+"�ĸ��½��";
		}else{
			return "type error";
		}
		
	}
	
}
