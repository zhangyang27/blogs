package decorator;

public class ModEncrypt extends EncryptDecorator {

	public ModEncrypt(Encrypt encrypt) {
		super(encrypt);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String encrypt(String s) {
		return "ȡģ����("+super.encrypt(s)+")";
	}

}
