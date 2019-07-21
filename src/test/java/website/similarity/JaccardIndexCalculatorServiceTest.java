package website.similarity;

import static org.junit.Assert.assertArrayEquals;

import java.time.LocalDateTime;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import website.similarity.service.JaccardIndexCalculatorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JaccardIndexCalculatorServiceTest {

	private static final Logger LOGGER = Logger.getLogger(JaccardIndexCalculatorServiceTest.class.getName());
	
	@Autowired
	JaccardIndexCalculatorService jaccardIndexCalculatorService;
	
	@Test
	public void jaccardIndexTest() {
		LOGGER.info("Inside JaccardIndexCalculatorServiceTest : " + LocalDateTime.now() + jaccardIndexCalculatorService);
		double[] actualDoubles = {jaccardIndexCalculatorService.calculateJaccardIndex("", ""),
								jaccardIndexCalculatorService.calculateJaccardIndex("one two three", "one two three"),
								jaccardIndexCalculatorService.calculateJaccardIndex("this is an apple", "this is a book")};
		double[] expectedDoubles = {1, 1, 0.333};
		double delta = 0.001;
		assertArrayEquals("Website similarity is not as expected",expectedDoubles,actualDoubles, delta);
	}
}
