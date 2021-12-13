package Traffic_Control;

public class Timer implements Runnable {

	private int counter = 0;
	DrivingGame drvg;

	@Override
	public void run() {
		int timeStarts = (int) System.currentTimeMillis();

		try {
			while (counter < 5) {
				Thread.sleep(1000);
				int timeNew = (int) System.currentTimeMillis() - timeStarts;
				System.out.println(timeNew);
				for (int i = 0; i < this.drvg.getCarinmap().size(); i++) {
					if (this.drvg.getCarinmap().get(i).isArrived() == true) {
						counter++;
					}
				}

			}
			System.err.println("All cars have finished!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
