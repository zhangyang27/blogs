package State;

public class Professional extends ActorState{

	@Override
	public void changeCard() {
		// TODO Auto-generated method stub
		System.out.println("ʹ���ؼ� ����");
	}

	@Override
	public void peekCard() {
		// TODO Auto-generated method stub
		System.out.println("�޷�ʹ�ø��ؼ�");
	}

	@Override
	public void doubleScore() {
		// TODO Auto-generated method stub
		System.out.println("ʹ���ؼ� ˫������");
	}

}
