package proxy;
/**
 * 拥有真实的商务的信息
 * @author zhangyang27
 *
 */
public class BusniessData implements Data{
	public String getData(String name,int orderID){
		return orderID+"的信息。";
	}
}
