
public class RoverController {

	private Rover rover;

	public RoverController(Rover rover) {
		this.rover = rover;
	}

	public String excute(String mission) {
		String[] args = mission.split(",");
		init(args);
		for (int i = 5; i < args.length; i++) {
			moveAndTurn(args[i]);
		}
		return rover.getPosition();
	}

	/**
	 * 初始化面积、降落点、方向
	 * 
	 * @param mission
	 */
	public void init(String[] args) {
		Integer width = Integer.valueOf(args[0]);
		Integer height = Integer.valueOf(args[1]);
		Integer x = Integer.valueOf(args[2]);
		Integer y = Integer.valueOf(args[3]);
		rover.load(new Area(width, height), x, y, args[4]);
	}

	public void moveAndTurn(String arg) {
		if ("M".equals(arg)) {
			rover.move();
		} else {
			rover.turn(arg);
		}
	}
}
