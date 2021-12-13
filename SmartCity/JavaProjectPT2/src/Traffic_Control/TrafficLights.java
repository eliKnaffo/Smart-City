/** naor sasi - 302727052
 *  eli - 207206723
 */

package Traffic_Control;

//import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class TrafficLights {
	private int delay; //While the light stays green delay
	private int timepassed; // Time elapsed since the beginning of the
	protected ArrayList<Road> Roads = new ArrayList<Road>(); // the set of actions
	private Road green; // What a green road
//	private LocalDateTime myObj; //Start time the road turned green

	public TrafficLights(ArrayList<Road> EnteringRoads) {
		this.Roads = EnteringRoads;
		playGreen();
	}

	public void playGreen() {
		delay = randomDelay();
		timepassed = 0;
		green = selectRoads(this.Roads);
		//myObj = LocalDateTime.now();
		System.out.println(toString());
	}
	public int randomDelay () {
		return (int)((Math.random()*3)+2);
	}
	
	public abstract Road selectRoads(ArrayList<Road> EnteringRoads);	
	public void check() {
	//	if (myObj.plusSeconds(delay).isBefore(LocalDateTime.now())) {
			timepassed ++;
			if (timepassed >= delay) {
				timepassed = 0;
				this.green = selectRoads(this.Roads);
				System.out.println(toString());
			}
	//		myObj = LocalDateTime.now();
	//	}
		
	}

	public Road getGreen() {
		return green;
	}

	@Override
	public String toString() {
		return "TrafficLights " + this.Roads.get(0).getEnd().toString() + ", delay= " + this.delay + ": green light on " + green.toString();
	}
	
	
	
}
