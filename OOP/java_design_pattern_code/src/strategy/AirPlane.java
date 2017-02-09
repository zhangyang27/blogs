package strategy;

public class AirPlane extends Aircraft {

	public AirPlane() {
		this.flying = new SubSonicFlying();
		this.takeoff = new LongDistanceTakeOff();
	}

}
