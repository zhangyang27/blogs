package adapter;

public class EncryptAdapter implements Encrypt{
	thirdPartyEncrypted tpe = new thirdPartyEncrypted();
	public String encrypt(String a) {
		return tpe.specialEncrypt(a);
	}

}
