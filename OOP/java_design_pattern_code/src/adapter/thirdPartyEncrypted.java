package adapter;

public class thirdPartyEncrypted {

	public String specialEncrypt(String s){
		System.out.println("��-"+s+"-����");
		return s.hashCode()+"";
	}
}
