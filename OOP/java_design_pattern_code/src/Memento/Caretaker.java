package Memento;

public class Caretaker {
	MementoGameSense mgs; // 设计的比较简单，只能保存上一个状态。
	public void save(MementoGameSense mgs){
		this.mgs = mgs;
	}
	public MementoGameSense getMementoGameSense(){
		return this.mgs;
	}

}
