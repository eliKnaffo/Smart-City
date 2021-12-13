/** naor sasi - 302727052
 *  eli - 207206723
 */

package Traffic_Control;

public class Road{
	private Junction start; //Starting junction
	private Junction end;	//End junction
	
	public Road(Junction start, Junction end) {
		this.start = start; 
		int i=0;
		boolean equals= false;
		if (start.equals(end)) {
			equals = true;
		}
		while ((start.equals(end) || (start.destination(end)) && i<Junction.all_Junction.size()-1)){
			end = Junction.all_Junction.get((int)(Math.random()*Junction.all_Junction.size()));
			i++;
		}
		if (start.equals(end) || start.destination(end)) {
			end = new Junction();
		}
		this.end = end;
		if (equals) {
			System.out.println("Road can not connect a junction to itself, the end junction has been replaced with " + this.end.toString());
		}
		start.setExitingRoads(Road.this);
		end.setEnteringRoads(Road.this);
		creating();
	}

	public Junction getStart() {
		return start;
	}
	public Junction getEnd() {
		return end;
	}
	public double getLength () {
		return start.calcDistance(end);
	}
	@Override
	public String toString() {
		return  "Road from " + start.toString() + " to " + end.toString();
	}
	public void creating () {
		System.out.println("Creating " + toString() + ", length " + ((float)(Math.round(getLength()*100)))/100);
	}

}
