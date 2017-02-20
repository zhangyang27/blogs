package State;

public class Final extends ActorState{

	@Override
	public void changeCard() {
		// TODO Auto-generated method stub
		System.out.println("使用特技 换牌");
	}

	@Override
	public void peekCard() {
		// TODO Auto-generated method stub
		System.out.println("使用特技 偷看牌");
	}

	@Override
	public void doubleScore() {
		// TODO Auto-generated method stub
		System.out.println("使用特技 双倍积分");
	}

}
