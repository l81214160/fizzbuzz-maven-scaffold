
import static org.fest.assertions.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.psbc.cdfzx.FizzBuzz;
@RunWith(Parameterized.class)
public class FizzBuzzTest {

	private int number;
	private String result;
	public FizzBuzzTest(int number, String result) {
		super();
		this.number = number;
		this.result = result;
	}
	
	@Parameters
    public static Collection prepareData(){  
     return Arrays.asList(new Object[][] {
            { 3, "Fizz" },
            { 5, "Buzz" },
            { 15, "FizzBuzz" },
            { 88, "88" }
         });
    }  
	
	@Test
	public void test() {
		assertThat(FizzBuzz.of(number)).isEqualTo(result);
	}
	
}
