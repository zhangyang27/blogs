package proxy;
/**
 * ӵ����ʵ���������Ϣ
 * @author zhangyang27
 *
 */
public class BusniessData implements Data{
	public String getData(String name,int orderID){
		return orderID+"����Ϣ��";
	}
}
