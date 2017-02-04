package decorator;

public class ReverseEncrypt extends EncryptDecorator {

	public ReverseEncrypt(Encrypt encrypt) {
		super(encrypt);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String encrypt(String s) {
		return "�������("+super.encrypt(s)+")";
	}

}
