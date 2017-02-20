package Memento;


/**
 * 设计模式的艺术软件开发人员内功修炼之道_刘伟 P322
 * 有一款RPG网游，为了给玩家提供更多方便，在游戏过程中会设置一个恢复点
 * 用于保存当前的游戏场景，后续游戏过程中玩家角色『不幸牺牲』
 * 可以返回到先前保存的场景，从所设的恢复点开始游戏。
 * @author zhangyang27
 *
 */
public class Client {
	public static void main(String[] args) {
		Caretaker ct = new Caretaker();
		
		GameSense gs = new GameSense("战士雄霸天下", "沸腾古庙", "凌霜剑", "123");
		gs.display();
		ct.save(gs.generateMemento());
		
		gs.setPlace("绝焚之地");
		gs.setGold("550");
		gs.display();
		ct.save(gs.generateMemento());
		
		gs.setGoods("屠龙刀");
		gs.setGold("670");
		gs.display();
		System.out.println("角色死亡...恢复...");
		gs.restoreFromMemento(ct.getMementoGameSense());
		gs.display();
		
	}

}
