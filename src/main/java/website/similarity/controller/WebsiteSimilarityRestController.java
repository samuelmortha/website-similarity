package website.similarity.controller;

import java.io.IOException;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import website.similarity.error.ResourceNotFoundException;
import website.similarity.service.JaccardIndexCalculatorService;

@RestController
@RequestMapping("/")
public class WebsiteSimilarityRestController {

	private static final Logger LOGGER = Logger.getLogger(WebsiteSimilarityRestController.class.getName());
	
	@Autowired
	JaccardIndexCalculatorService jaccardIndexCalculatorService;
	
	@GetMapping
	@RequestMapping("website-similarity")
	@ResponseBody
	public Double getWebsiteSimilarityAsJaccardIndex(@RequestParam(required = true) String url1, @RequestParam(required = true) String url2) {
		
		LOGGER.info("Received request to calculate website-similarity between the urls " + url1 + " and " + url2);
		
		Document document1;
		Document document2;
		try {
			document1 = Jsoup.connect(url1).get();
			document2 = Jsoup.connect(url2).get();
			return jaccardIndexCalculatorService.calculateJaccardIndex(document1.body().text(), document2.body().text());
		} catch (IOException e) {
			LOGGER.severe(e.getMessage());
			throw new ResourceNotFoundException(e.getMessage());
		}
	}
}
