/** naor sasi - 302727052
 *  eli - 207206723
 */

package Traffic_Control;

import java.util.ArrayList;

public class Junction extends Point{
	private ArrayList<Road> enteringroads = new ArrayList<Road>(); //Array of incoming roads
	private ArrayList<Road> exitingroads = new ArrayList<Road>();	// A set of outgoing roads
	private TrafficLights trafficlights;//A traffic light at an intersection
	//static int Count_Junction=0;
	static ArrayList<Junction> all_Junction = new ArrayList<Junction>();
	private int name;

	public Junction() {
		super();
	}
	public Junction(int x, int y) {
		super(x, y);
	}
	//Method if the nodes are identical having the same point
	public boolean equals(Junction end) {
		if ((end.getX()==super.getX())&&(end.getY()==super.getY())) {
			return true;
		}
		return false;
	}
	//Does the destination junction exist on the outbound roads
	public boolean destination(Junction end) {
		for (int i=0; i<this.exitingroads.size(); i++) {
			if ((end.getX()==this.exitingroads.get(i).getEnd().getX())&&(end.getY()==this.exitingroads.get(i).getEnd().getY())) {
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Road> getEnteringRoads() {
		return enteringroads;
	}

	public void setEnteringRoads(Road EnteringRoads) {
		this.enteringroads.add(EnteringRoads);

	}

	public ArrayList<Road> getExitingRoads() {
		return exitingroads;
	}

	public void setExitingRoads(Road ExitingRoads) {
		this.exitingroads.add(ExitingRoads);
	}
	//Random selection for traffic light type
	public void randomTrafficLights() {
		if (0==(int)(Math.random()*2)) {
			trafficlights = new RandomTrafficLights(this.enteringroads);
		}
		else {
			trafficlights = new ConsecutiveTrafficlights(this.enteringroads);
		}	
	}
	//A random choice for an exit road
	public Road randomExitingRoads () {
		return this.exitingroads.get((int)(Math.random()*this.exitingroads.size()));
	}
	@Override
	public String toString() {
		return "Junction " + this.name;
	}
	public void creating () {
		all_Junction.add(Junction.this);
		this.name = all_Junction.size();
		System.out.println("Creating " + toString() + " at " + super.toString());
	}
	public TrafficLights getTrafficlights() {
		return trafficlights;
	}
	public int getName() {
		return name;
	}
	

}
