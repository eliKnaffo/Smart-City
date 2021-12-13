/** naor sasi - 302727052
 *  eli - 207206723
 */

package Traffic_Control;

//import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;


public class Map {
	ArrayList<Integer> inbound = new ArrayList<Integer>(); //Junctions where there are traffic lights
	private int numberjunction; //Number of nodes in the map
	private ArrayList<Junction> junctions = new ArrayList<Junction>(); // Nodes on the map
	private ArrayList<Road> rods = new ArrayList<Road>();
	private ArrayList<Road>  calcShortest = new ArrayList<Road>(); //The shortest way
	private double distance; //Distance in units Distance of the shortest way
	
	public Map(int numberjunction) {
		this.numberjunction = numberjunction;
		creatingJunctionsRoads();
		inboundRoads();
	}
	public Map(ArrayList<Junction> junctions,ArrayList<Road> roads) {
		for (int i=0; i<junctions.size();i++) {
			setJunctions(junctions.get(i));
		}
		for (int i=0; i<roads.size();i++) {
			setRods(roads.get(i));
		}
		inboundRoads();
	}
	
	private void creatingJunctionsRoads() {
		for (int i=0 ; i<this.numberjunction ; i++) {
			junctions();
		}
		randomRoadsAdd();
	}
	
	public void  junctions() {
		junctions.add(new Junction());
	}
	public void  randomRoadsAdd() {
		//Randomly creates at least 1 and another half of the total amount of roads
	/**	for (int i=0; i<(int)((Math.random()*this.junctions.size())+1); i++) {
			this.rods.add(new Road(Randon_Junction(), Randon_Junction()));
		}
		*/
		for (int i=0; i<this.junctions.size();i++) {
			for (int j=0; j<this.junctions.size(); j++) {
				if ((i!=j) && (1==(int)(Math.random()*2))){
					this.rods.add(new Road(this.junctions.get(i), this.junctions.get(j)));
				}
			}
		}
	}	

	public ArrayList<Road> getRods() {
		return rods;
	}


	public void setRods(Road rods) {
		this.rods.add(rods);
	}

	public ArrayList<Junction> getJunctions() {
		return junctions;
	}
	

	public void setJunctions(Junction junction) {
		this.junctions.add(junction);
		inboundRoads();
		
	}

	public int getNumberJunction() {
		return numberjunction;
	}
	
	//Add a random traffic light by probability
	private void inboundRoads() {
		Random random = new Random();
		for (int i=0; i< this.junctions.size(); i++) {
			if (((this.junctions.get(i).getEnteringRoads().size())>0) && this.junctions.get(i).getTrafficlights() == null) {
				if ((random.nextBoolean())&&(random.nextBoolean())) {
					this.junctions.get(i).randomTrafficLights();
					inbound.add(i);
				}
			}
		}
	}
	//A method that builds a random trajectory
	public ArrayList<Road> randomRoute() {
		Junction randonjunction ;
		ArrayList<Road> route = new ArrayList<Road>();
		int count = 0;
		randonjunction = randonJunction();
		while ((randonjunction.getExitingRoads().size()>0) && (count<4)) {
			route.add(randonjunction.randomExitingRoads());
			randonjunction = route.get(route.size()-1).getEnd();
			count++;
		}
		return route;
	}
	//Retrieve route
	public String retrieveRoute (ArrayList<Road> route) {
		return route.toString();
	}
	//Random junction selection
	public Junction randonJunction () {
		return this.junctions.get((int)(Math.random()*this.junctions.size()));
	}
	// A method that returns the shortest route between 2 junction
	public String calcShortestPath (Junction start, Junction end) {
		calcShortest = new ArrayList<Road>(); //The shortest way
		distance = 0; //Distance in units Distance of the shortest way
		if (!start.equals(end)) {
			sortTest(start, end, calcShortest, distance);
		}
		return retrieveRoute(this.calcShortest);
	}
	private void sortTest(Junction start, Junction end, ArrayList<Road>  calcShortest, double distance) {	
		if (!start.equals(end)) {
			boolean equals;
			ArrayList<Road>  perhapscalcShortest;
			double perhapsdistance; // Perhaps distance in units distance of the shortest way
			for (int i=0; i<start.getExitingRoads().size(); i++) {
				perhapscalcShortest = new ArrayList<Road>(); //A way that is perhaps extremely short
				equals = false;
				perhapsdistance = distance;
				for (int j=0; j< calcShortest.size(); j++) {
					perhapscalcShortest.add(calcShortest.get(j));
					if (perhapscalcShortest.get(j).getStart().equals(start.getExitingRoads().get(i).getEnd())) {
						equals = true;
					}
				}
				//System.out.println(equals);
				if (!equals) {
					//System.out.println(start.getExitingRoads().get(i).toString());
					perhapsdistance +=start.getExitingRoads().get(i).getLength();
					if (perhapsdistance < this.distance || this.distance == 0) {
						perhapscalcShortest.add(start.getExitingRoads().get(i));
						sortTest(start.getExitingRoads().get(i).getEnd(), end, perhapscalcShortest, perhapsdistance);
					}
					
				}
			}
		}
		else {
			if (distance < this.distance || this.distance==0) {
				this.calcShortest = calcShortest;
				this.distance = distance;
			}
		}


	}
	public ArrayList<Integer> getInbound() {
		return inbound;
	}
	
}
