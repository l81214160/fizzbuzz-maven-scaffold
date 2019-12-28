
public class Rover {

	private static final String Right = "R";
	public static final String Left = "L";
	public static final String West = "W";
	public static final String East = "E";
	public static final String North = "N";
	public static final String Sourth = "S";
	private Area area;
	private int m;
	private int n;
	private String direction;

	public void load(Area area, int i, int j, String direction) {
		this.area = area;
		this.m = i;
		this.direction = direction;
		this.n = j;
		
		if (i > area.getI()) {
			throw new IllegalArgumentException("x= " + i + "is out of area width" + area.getI());
		}

		if (j > area.getJ()) {
			throw new IllegalArgumentException("y = " + j + " is out of area width " + area.getJ());
		}

	}

	/**
	 * 返回当前的位置
	 * 
	 * @return
	 */
	public String getPosition() {
		return String.format("%d", m) + String.format("%d", n) + direction;
	}

	/**
	 * 移动
	 */
	public void move() {
		if (North.equals(direction)) {
			n = n + 1;
		} else if (Sourth.equals(direction)) {
			n = n - 1;
		} else if (East.equals(direction)) {
			m = m + 1;
		} else if (West.equals(direction)) {
			m = m - 1;
		}
	}

	/**
	 * 转向
	 */
	public void turn(String mission) {
		if (Left.equals(mission)) {
			if (North.equals(direction)) {
				direction = West;
			} else if (Sourth.equals(direction)) {
				direction = East;
			} else if (East.equals(direction)) {
				direction = North;
			} else if (West.equals(direction)) {
				direction = Sourth;
			}
		} else if (Right.equals(mission)) {
			if (North.equals(direction)) {
				direction = East;
			} else if (Sourth.equals(direction)) {
				direction = West;
			} else if (East.equals(direction)) {
				direction = Sourth;
			} else if (West.equals(direction)) {
				direction = North;
			}
		}
	}
	
	public static void main(String[] args) {
		Rover rover = new Rover();
		RoverController roverController = new RoverController(rover);
		String mission = "10,10,5,5,E,M,L,M,R,R,M,R,M,M,R,M,M,M,M,L,R";
		String postion = roverController.excute(mission);
		System.out.println(postion);
	}
}
