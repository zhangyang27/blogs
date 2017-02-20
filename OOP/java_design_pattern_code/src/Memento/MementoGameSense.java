package Memento;
/**
 * 备忘录类
 * 在这里保存了原生器的所有属性
 */
public class MementoGameSense {
	
	
	public MementoGameSense(String actor, String place, String goods, String gold) {
		super();
		this.actor = actor;
		this.place = place;
		this.goods = goods;
		this.gold = gold;
	}
	private String place;
	private String goods;
	private String gold;
	private String actor;
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
}
