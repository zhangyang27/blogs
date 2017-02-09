package strategy;

public class Fighter extends Aircraft {

	public Fighter() {
		this.flying = new SuperSonicFlying();
		this.takeoff = new LongDistanceTakeOff();
	}

}
