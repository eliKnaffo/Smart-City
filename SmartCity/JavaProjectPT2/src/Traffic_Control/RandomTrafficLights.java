/** naor sasi - 302727052
 *  eli - 207206723
 */

package Traffic_Control;

import java.util.ArrayList;

public class RandomTrafficLights extends TrafficLights implements Runnable {

	private ArrayList<Road> EnteringRoads = new ArrayList<Road>();
	private DrivingGame drvg;
	private int counter = 0;

	public RandomTrafficLights(ArrayList<Road> EnteringRoads) {
		super(EnteringRoads);
	}

	public Road selectRoads(ArrayList<Road> EnteringRoads) {
		int randomIdx = (int) (Math.random() * EnteringRoads.size());
		return EnteringRoads.get(randomIdx);
	}

	public String toString() {
		return "Random " + super.toString();
	}

	@Override
	public void run() {

		selectRoads(this.EnteringRoads);
		try {
			while (counter < 5) {
				for (int i = 0; i < this.drvg.getCarinmap().size(); i++) {
					if (this.drvg.getCarinmap().get(i).isArrived() == true) {
						counter++;
					} else {
						System.err.println("All cars have finished!");
					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
