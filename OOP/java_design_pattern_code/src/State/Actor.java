package State;
/**
 * ������
 * @author zhangyang27
 *
 */
public class Actor {
	private ActorState state;
	private int score;
	private String name;
	public Actor(String name) {
		this.setName(name);
		this.score = 0;
		this.setState(new Primmary());
		System.out.println("�½�ɫ�����ɹ�����ǰΪ����");
	}

	
	public void play(){
		System.out.println("����һ��!!!");
	}
	
	public void win(){
		this.score++;
		System.out.println("Ӯ������ǰ�÷֣�"+this.score);
		stateChanged();
	}
	
	public void fail(){
		this.score--;
		System.out.println("��������ǰ�÷֣�"+this.score);
		stateChanged();
	}
	
	public void doubleScore(){
		state.doubleScore();
	}
	
	public void changeCard(){
		state.changeCard();
	}
	
	public void peekCard(){
		state.peekCard();
	}
	
	public void stateChanged(){
		if(this.score<3){
			this.setState(new Primmary());
			System.out.println("����ı䣺��ǰΪ����");
		}else if(this.score>=3 && this.score<5){
			this.setState(new Secondary());
			System.out.println("����ı䣺��ǰΪ����");
		}else if(this.score >=5 && this.score<7){
			this.setState(new Professional());
			System.out.println("����ı䣺��ǰΪר��");
		}else if(this.score >=7 ){
			this.setState(new Final());
			System.out.println("����ı䣺��ǰΪ�ǻ�");
		}
			
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public ActorState getState() {
		return state;
	}



	public void setState(ActorState state) {
		this.state = state;
	}
}
