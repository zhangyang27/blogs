package State;
/**
 * 根据题意，换牌、偷看、双倍积分都是高级的角色才会有的技能
 * 为什么这里会设置成抽象方法呢？
 * 我觉得这个得从业务的角度来考虑
 * 当一个玩家是初级时，在界面也会显示这几个特技的图标，只是初级角色点了之后会显示『级别不够，等级多高才能使用』
 * 所以各个等级不是没有这些特技，只是不同等级对特技的反应不同而已。
 * 
 * 当然也可以根据业务的要求更换。
 * 
 * 另外，也可以不断用继承的方式来完成，比如高手级继承熟练级，就可以获得双倍积分的特技。
 * 这样感觉代码会少很多，但是总感觉有点乱和怪。状态是从另一个状态类，而非抽象状态类继承而来。
 * 至少不符合UML图吧，实际使用不好说了。
 */
abstract public class ActorState {


	abstract public void changeCard();

	abstract public void peekCard();
	
	abstract public void doubleScore();
	
}
