package website.similarity;

import static org.junit.Assert.assertArrayEquals;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

	private static final Logger LOGGER = Logger.getLogger(HttpRequestTest.class.getName());
	
	@LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void httpRequestTest() throws Exception {
    	
    	LOGGER.info("Calculating website-similarity index between websites.");
    	
        double sameURLSimilarityIndex = this.restTemplate
        									.getForObject("http://localhost:" + port 
        											+ "/website-similarity?"
        											+ "url1=https://en.wikipedia.org/wiki/Cisco_Systems&"
        											+ "url2=https://en.wikipedia.org/wiki/Cisco_Systems", 
        											Double.class);
        
        double differentURLSimilarityIndex = this.restTemplate
        									.getForObject("http://localhost:" + port 
        											+ "/website-similarity?"
        											+ "url1=https://en.wikipedia.org/wiki/Cisco_Systems&"
        											+ "url2=https://en.wikipedia.org/wiki/Certis_Group", 
        											Double.class);
        
        double[] actualDoubles = {sameURLSimilarityIndex, differentURLSimilarityIndex};

        double[] expectedDoubles = {1, 0.158};

        double delta = 0.001;

        assertArrayEquals("Website similarity is not as expected",expectedDoubles,actualDoubles, delta);
        
        LOGGER.info("Done Calculating website-similarity index between two websites.");
    }
}

