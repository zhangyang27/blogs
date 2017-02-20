package State;

import simpleFactory.Shape;
import simpleFactory.shapeFactory;


/**
 * 设计模式的艺术软件开发人员内功修炼之道_刘伟 P366
 * 开发纸牌游戏
 * 游戏中角色有四种角色：入门级（Primary）/熟练级（Secondary）/高手级（Professional）/骨灰级（Final）
 * 角色与积分对应，游戏胜利则增加积分，失败则扣减。
 * 入门级的基本功能：Play()
 * 熟练级：doubleScore()
 * 高手级：changeCards()
 * 骨灰级：peekCards
 * 
 * @author zhangyang27
 *
 */
public class Client {
	public static void main(String[] args) {
		Actor actor = new Actor("zhangsan");
		actor.play();
		actor.win();
		actor.play();
		actor.win();
		actor.play();
		actor.win();
		actor.play();
		actor.win();
		actor.play();
		actor.win();
		actor.play();
		actor.win();
		actor.doubleScore();
		actor.peekCard();
		actor.changeCard();
	}

}
