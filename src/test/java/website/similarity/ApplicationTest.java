package website.similarity;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import website.similarity.controller.WebsiteSimilarityRestController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {
	
	private static final Logger LOGGER = Logger.getLogger(ApplicationTest.class.getName());

	@Autowired
	WebsiteSimilarityRestController websiteSimilarityRestController;
	
	@Test
	public void contextLoads() throws Exception {
		LOGGER.info("Inside Application Test : " + LocalDateTime.now());
		assertThat(websiteSimilarityRestController).isNotNull();
	}
}
