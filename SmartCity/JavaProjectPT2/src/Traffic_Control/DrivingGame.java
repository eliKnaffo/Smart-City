/** naor sasi - 302727052
 *  eli - 207206723
 */

package Traffic_Control;

import java.util.ArrayList;

public class DrivingGame {
	private Map map;
	private ArrayList<Vehicle> carinmap = new ArrayList<Vehicle>(); // Array of vehicles map
	private Timer timer = new Timer();

	public DrivingGame(int numberjunction, int numbercar) {
		map = new Map(numberjunction);
		creatingCar(numbercar);

	}

	public void creatingCar(int numbercar) {
		for (int i = 0; i < numbercar; i++) {
			carinmap.add(new Vehicle(this.map));
		}
	}

	public void play(int turns) {
		timer.run();
		for (int i = 1; i <= turns; i++) {
			System.out.println();
			System.out.println("Turn" + i);
			playSingleTurn();
		}
	}

	public void playSingleTurn() {
		for (int i = 0; i < carinmap.size(); i++) {
			carinmap.get(i).move();
		}
		int count;
		for (int i = 0; i < map.getInbound().size(); i++) {
			count = map.getInbound().get(i);
			// System.out.println(count);
			// System.out.println(rehovot.getJunctions().get(count).toString());
			map.getJunctions().get(count).getTrafficlights().check();
			// rehovot.getJunctions().get(i).getTrafficlights().toString();
		}
	}

	public Map getMap() {
		return map;
	}

	public ArrayList<Vehicle> getCarinmap() {
		return carinmap;
	}

}
