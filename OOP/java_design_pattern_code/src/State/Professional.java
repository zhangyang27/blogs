package State;

public class Professional extends ActorState{

	@Override
	public void changeCard() {
		// TODO Auto-generated method stub
		System.out.println("使用特技 换牌");
	}

	@Override
	public void peekCard() {
		// TODO Auto-generated method stub
		System.out.println("无法使用该特技");
	}

	@Override
	public void doubleScore() {
		// TODO Auto-generated method stub
		System.out.println("使用特技 双倍积分");
	}

}
