/** naor sasi - 302727052
 *  eli - 207206723
 */

package Traffic_Control;

public class Point {
	private double x; //X-axis in a two-dimensional axis system
	private double y; //y-axis in a two-dimensional axis system
	private final double X_MAX = 800; //Maximum value for the X axis
	private final double Y_MAX = 600; //Maximum value for the y axis
	private final double AXIS_MIN = 0; //Minimum value for hinges
	
	//A default builder creates a random dot
	public Point () {
		randonPoint();
		creating();
	}
	public Point (double x, double y) {
		setX(x);
		setY(y);
		creating();
	}
	//A method that checks if an axis is in range
	private boolean checkAxis(double z ,double z_max) {
		if (z>=AXIS_MIN && z<=z_max) {
			return true;
		}
		return false;
	}
	public void randonPoint () {
		setX (randomAxis(X_MAX));
		setY (randomAxis(Y_MAX));	
	}
	//Random axis calculation
	private double randomAxis(double z_max){
		return (double)(Math.random()*z_max+1);	
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		if (checkAxis(x , X_MAX)) {
			this.x = x;
		}
		else {
			System.out.print(x + " is illegal value for x and has been replaced with ");
			this.x = randomAxis(X_MAX);
			System.out.println(this.x);
		}
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		if (checkAxis(y , Y_MAX)) {
			this.y = y;
		}
		else {
			System.out.print(y + " is illegal value for y and has been replaced with ");
			this.y = randomAxis(Y_MAX);
			System.out.println(this.y);
		}
	}
	//Method Calculating distance between 2 points
	public double calcDistance (Point other) {
		return Math.sqrt(Math.pow(this.x-other.getX(), 2)+Math.pow(this.y-other.getY(), 2));
	}
	@Override
	public String toString() {
		return "Point (" + ((float)(Math.round(x*100)))/100 +", " +((float)(Math.round(y*100)))/100 + ")";
	}
	public void creating () {
		System.out.println("Creating " + toString());
	}
	public double getX_MAX() {
		return X_MAX;
	}
	public double getY_MAX() {
		return Y_MAX;
	}
	public double getAXIS_MIN() {
		return AXIS_MIN;
	}
	

}
