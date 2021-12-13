/** naor sasi - 302727052
 *  eli - 207206723
 */

package Traffic_Control;

import java.util.ArrayList;

public class ConsecutiveTrafficlights extends TrafficLights implements Runnable {

	private int lastIdx;
	private ArrayList<Road> EnteringRoads = new ArrayList<Road>();
	private int counter = 0;
	DrivingGame drvg;

	public ConsecutiveTrafficlights(ArrayList<Road> EnteringRoads) {
		super(EnteringRoads);
		this.lastIdx = 0;
	}

	public Road selectRoads(ArrayList<Road> EnteringRoads) {
		if (EnteringRoads.size() - 1 > this.lastIdx) {
			this.lastIdx++;
		} else
			this.lastIdx = 0;
		return EnteringRoads.get(lastIdx);
	}

	public String toString() {
		return "Sequential " + super.toString();
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
