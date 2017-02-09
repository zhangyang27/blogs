package strategy;

public class Harrier extends Aircraft {

	public Harrier() {
		this.flying = new SuperSonicFlying();
		this.takeoff = new VerticalTakeOff();
	}

}
