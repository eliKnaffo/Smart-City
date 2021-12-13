/** naor sasi - 302727052
 *  eli - 207206723
 */

package Traffic_Control;

//import java.time.LocalDateTime;
import java.util.ArrayList;

public class Vehicle extends Thread {
	private Map map;
	static int namevehicles = 0;
	private int namevehicle;
	private float speed; // Vehicle speed
	private ArrayList<Road> route; // Route
	private int countroad;
//	private LocalDateTime car_start_drive; // Time the vehicle started road
	private int traveled; // Distance the vehicle has traveled
//	private double[] time_road; //Travel time to each road in Minute
	private double traveledroute;

	public Vehicle(Map map) {
		route = new ArrayList<Road>();
		this.map = map;
		drive();
	}

	public void drive() {
		countroad = 0;
		traveled = 0;
		this.speed = randomSpeed();
		route = map.randomRoute();
		if (route.size() > 0) {
			traveledroute = route.get(0).getLength();
			countroad++;
		}
		namevehicle = ++namevehicles;
		creating();
//		car_start_drive = LocalDateTime.now();
//		Time_Calculation();

	}

	private float randomSpeed() {
		return (float) ((Math.random() * 90) + 30);
	}

	// Track time calculation
	/**
	 * private void Time_Calculation () { time_road = new double[route.size()]; for
	 * (int i=0 ; i< route.size(); i++) { time_road[i] =
	 * ((route.get(i).getLength())/(this.speed))*60; } }
	 */
	public void move() {
		/**
		 * LocalDateTime time = LocalDateTime.now(); while
		 * ((car_start_drive.plusMinutes(count_road).isBefore(time)) && (count_road<
		 * route.size()-1)) { car_start_drive.plusMinutes(count_road); count_road++; }
		 */

		try {
			Thread.sleep(1000);
			if (countroad < route.size() - 1) {
				traveled += speed;
				while ((traveled > traveledroute) && (countroad < route.size() - 1)) {
					traveledroute += route.get(countroad).getLength();
					countroad++;
				}
				System.out.println(toString() + " is moving on the " + route.get(countroad).toString());
			} else {
				System.out.println(toString() + " arrived to it's destion: " + route.get(countroad).getEnd());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean isArrived() {
		if (countroad < route.size() - 1) {
			traveled += speed;
			while ((traveled > traveledroute) && (countroad < route.size() - 1)) {
				traveledroute += route.get(countroad).getLength();
				countroad++;
			}
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void run() {
		while (isArrived() == false) {
			move();
		}
	}

	@Override
	public String toString() {
		return "Vehicle " + namevehicle;
	}

	public void creating() {
		System.out.println("Creating " + toString() + ", speed: " + Math.round(speed) + ", path: "
				+ map.retrieveRoute(this.route));
	}

}
