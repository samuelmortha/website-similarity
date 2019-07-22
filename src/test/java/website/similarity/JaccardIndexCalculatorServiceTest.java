package website.similarity;

import static org.junit.Assert.assertArrayEquals;

import java.io.IOException;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
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
		
		LOGGER.info("Inside JaccardIndexCalculatorServiceTest. ");
		
		double[] actualDoubles = {jaccardIndexCalculatorService.calculateJaccardIndex("", ""),
								jaccardIndexCalculatorService.calculateJaccardIndex("one two three", "one two three"),
								jaccardIndexCalculatorService.calculateJaccardIndex("this is an apple", "this is a book")};
		
		double[] expectedDoubles = {1, 1, 0.333};
		
		double delta = 0.001;
		
		assertArrayEquals("Website similarity is not as expected",expectedDoubles,actualDoubles, delta);
		
		LOGGER.info("Test finished with actualDoubles : " + actualDoubles[2] + " and expectedDoubles : " + expectedDoubles[2]);
	}
	
	@Test
	public void compareTwoURLs() {
		
		LOGGER.info("Performing website-similarity test for two URLs files.");
		
		try {
		
			Document document1 = Jsoup.connect("https://en.wikipedia.org/wiki/Cisco_Systems").get();
			Document document2 = Jsoup.connect("https://en.wikipedia.org/wiki/Certis_Group").get();
			double[] actual = {jaccardIndexCalculatorService.calculateJaccardIndex(document1.body().text(), document2.body().text())};
			double[] expected = {0.1584};
			double delta = 0.001;
			
			assertArrayEquals("Website similarity is not as expected",expected,actual, delta);
			
			LOGGER.info("URL test finished with actual : " + actual[0] + " and expected : " + expected[0]);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
