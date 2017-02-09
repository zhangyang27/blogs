package strategy;

public class Helicopter extends Aircraft {

	public Helicopter() {
		this.flying = new SubSonicFlying();
		this.takeoff = new VerticalTakeOff();
	}

}
