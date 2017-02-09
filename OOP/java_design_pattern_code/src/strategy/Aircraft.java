package strategy;

public abstract class Aircraft {
	Flying flying;
	TakeOff takeoff;
	public void fly(){
		takeoff.takeOff();
		flying.flying();
	}
	
	
}
