package com.simonscrape.scrapetut;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class WebScraperService {

    public String scrape(String url) {
    
    	List<TeamStats> teamStatsList = new ArrayList<>();
    	
    	
    	
    	try {
    		
    		// Start with fetching the HTML code of the webpage
    		
    		Document document = Jsoup.connect(url).get();
    		
    		// We want to scrape from the Data table, which is a score list from the European pro league of legends league
    		
    		Element table = document.select("table.wikitable2.standings").first(); // Target the correct table
    		//Let's add a error hadnler and see if we can allocated the table or not.
    		if(table == null) {
    			return "Table not found.";
    		}
    		Elements rows = table.select("tr");
    		
    		// Now we want to loop thru the rows in the data table.
    		// Let's skip the headers since we have our model class that pretty much is a preset header.
    		
    		for(int i = 0; i < rows.size(); i++) {
    			Element row = rows.get(i);
    			Elements cells = row.select("td");
    			
    			
    			// Check if the row contains the expected number of cells
    			if (cells.size() >= 5) {
    				try {
    	    			// Extract data for each column
    	    			int place = Integer.parseInt(cells.get(0).text().trim());
    	    			String team = cells.get(1).text().trim();
    	    			String games= cells.get(2).text().trim();
    	    			String winrate = cells.get(3).text().trim();
    	    			String streak = cells.get(4).text().trim();
    	    			
    	    			
    	    			// Create a TeamStats object and add to the list
    	    			TeamStats teamStats = new TeamStats(place, team, games, winrate, streak);
    	    			teamStatsList.add(teamStats);
    				}catch(NumberFormatException e) {
    					// Skip rows where the place column is not a number
    					
    					continue;
    				}
    			}
    		
    		}
    	
    	// Convert the list to JSON, which mapper to use. = fasterxml.jackson.databind.ObjectMapper
    	
    	ObjectMapper objectMapper = new ObjectMapper();
    	return objectMapper.writeValueAsString(teamStatsList);
    	
    		
    	} catch(Exception e) {
    		return "Error" + e.getMessage();
    	}
    	
    }

}




/*
 *         StringBuilder result = new StringBuilder();
        try {
            // Fetch the HTML code of the webpage
            Document document = Jsoup.connect(url).get();

            // Get the title of the page
            String title = document.title();
            result.append("Title: ").append(title).append("\n");

            // Extract all the links on the page
            result.append("Links:\n");
            Elements links = document.select("a[href]");
            for (Element link : links) {
                result.append("Link: ").append(link.attr("href")).append(" Text: ").append(link.text()).append("\n");
            }

            // Extract table rows (if any) from the page
            result.append("Table Rows:\n");
            Elements rows = document.select("tr");
            for (Element row : rows) {
                // Extract individual cells (td) from each row
                Elements cells = row.select("td");
                for (Element cell : cells) {
                    result.append(cell.text()).append("\t");
                }
                result.append("\n");
            }

        } catch (Exception e) {
            result.append("Error: ").append(e.getMessage());
        }
        return result.toString();
    }*/
 