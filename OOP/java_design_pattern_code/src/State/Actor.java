package State;
/**
 * 环境类
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
		System.out.println("新角色创建成功，当前为初级");
	}

	
	public void play(){
		System.out.println("玩了一局!!!");
	}
	
	public void win(){
		this.score++;
		System.out.println("赢啦，当前得分："+this.score);
		stateChanged();
	}
	
	public void fail(){
		this.score--;
		System.out.println("输啦，当前得分："+this.score);
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
			System.out.println("级别改变：当前为初级");
		}else if(this.score>=3 && this.score<5){
			this.setState(new Secondary());
			System.out.println("级别改变：当前为熟练");
		}else if(this.score >=5 && this.score<7){
			this.setState(new Professional());
			System.out.println("级别改变：当前为专家");
		}else if(this.score >=7 ){
			this.setState(new Final());
			System.out.println("级别改变：当前为骨灰");
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
