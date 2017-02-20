package Memento;
/**
 * 相当于原发器类
 * 这个类里有一些状态需要被保存
 */
public class GameSense {
	
	private String actor;
	public GameSense(String actor, String place, String goods, String gold) {
		super();
		this.actor = actor;
		this.place = place;
		this.goods = goods;
		this.gold = gold;
	}
	private String place;
	private String goods;//物品更该是一个集合，不过有例子算了
	private String gold;
	
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getGoods() {
		return goods;
	}
	public void setGoods(String goods) {
		this.goods = goods;
	}
	public String getGold() {
		return gold;
	}
	public void setGold(String gold) {
		this.gold = gold;
	}
	
	public MementoGameSense generateMemento(){
		return new MementoGameSense(actor, place, goods, gold);
	}
	
	public void restoreFromMemento(MementoGameSense mgs){
		this.actor = mgs.getActor();
		this.place = mgs.getPlace();
		this.goods = mgs.getGoods();
		this.gold = mgs.getGold();
	}
	public void display(){
		System.out.println("目前角色"+actor+"在"+place+"，并且持有金币："+gold+"，持有物品："+goods);
	}
	

}
