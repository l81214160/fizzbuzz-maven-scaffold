import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MarsTest {

	@Test
	public void areaTest() {
		Area area = new Area(10, 10);
		Rover rover = new Rover();
		rover.load(area, 5, 5, "E");
		String postion = rover.getPosition();
		assertThat(postion).isEqualTo("55E");
	}

	@Test
	public void moveTest() {
		Area area = new Area(10, 10);
		Rover rover = new Rover();
		rover.load(area, 5, 5, "E");
		rover.move();
		String postion = rover.getPosition();
		assertThat(postion).isEqualTo("65E");
	}

	@Test
	public void turnTest() {
		Area area = new Area(10, 10);
		Rover rover = new Rover();
		rover.load(area, 5, 5, "E");
		rover.turn("L");
		String postion = rover.getPosition();
		assertThat(postion).isEqualTo("55N");
	}
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Test
	public void overTest() {
		Area area = new Area(10, 10);
		Rover rover = new Rover();
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("y = 20 is out of area width 10");
		rover.load(area, 5, 20, "E");
	}
	
	@Test
	public void test() {
		Rover rover = new Rover();
		RoverController roverController = new RoverController(rover);
		String mission = "10,10,5,5,E,M,L,M,R";
		String postion = roverController.excute(mission);
		assertThat(postion).isEqualTo("66E");
	}
}
