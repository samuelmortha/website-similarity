package website.similarity.controller;

import java.io.IOException;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import website.similarity.error.ResourceNotFoundException;
import website.similarity.service.JaccardIndexCalculatorService;

@RestController
@RequestMapping("/website-similarity")
public class WebsiteSimilarityRestController {

	private static final Logger log = Logger.getLogger(WebsiteSimilarityRestController.class.getName());
	
	@Autowired
	JaccardIndexCalculatorService jaccardIndexCalculatorService;
	
	@GetMapping
	public Double getWebsiteSimilarityAsJaccardIndex(@RequestParam String url1, @RequestParam String url2) {
		
		log.info("Received request to calculate website-similarity between the urls " + url1 + " and " + url2);
		
		Document document1;
		Document document2;
		try {
			document1 = Jsoup.connect(url1).get();
			document2 = Jsoup.connect(url2).get();
			System.out.println(document1.text());
			System.out.println(document2.text());
			return jaccardIndexCalculatorService.calculateJaccardIndex(document1.text(), document2.text());
		} catch (IOException e) {
			log.severe(e.getMessage());
			throw new ResourceNotFoundException(e.getMessage());
		}
	}
}
