package Memento;

public class Caretaker {
	MementoGameSense mgs; // ��ƵıȽϼ򵥣�ֻ�ܱ�����һ��״̬��
	public void save(MementoGameSense mgs){
		this.mgs = mgs;
	}
	public MementoGameSense getMementoGameSense(){
		return this.mgs;
	}

}
