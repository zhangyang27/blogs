package decorator;

public abstract class EncryptDecorator implements Encrypt {
	protected Encrypt EncrytedStringToBeDecorated;
	
	//�ù�����������
	public EncryptDecorator(Encrypt encrypt) {
		this.EncrytedStringToBeDecorated = encrypt;
	}
	
	@Override
	public String encrypt(String s) {
		// TODO Auto-generated method stub
		return this.EncrytedStringToBeDecorated.encrypt(s);
	}

}
