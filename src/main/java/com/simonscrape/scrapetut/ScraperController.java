package com.simonscrape.scrapetut;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScraperController {
	
	@Autowired
	private WebScraperService webScraperService;
	
	@GetMapping("/scrape")
	public String scrape(@RequestParam String url) {
		return webScraperService.scrape(url);
	}

}
