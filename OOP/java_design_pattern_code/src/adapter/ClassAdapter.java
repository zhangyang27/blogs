package adapter;

public class ClassAdapter extends thirdPartyEncrypted implements Encrypt{

	@Override
	public String encrypt(String a) {
		// TODO Auto-generated method stub
		return specialEncrypt(a);
	}
	
}
