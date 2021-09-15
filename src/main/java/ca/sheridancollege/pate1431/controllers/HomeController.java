package ca.sheridancollege.pate1431.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import ca.sheridancollege.pate1431.beans.TVShows;

@Controller
public class HomeController {

	@GetMapping("/viewTvshows")
	public String viewTvshows(Model model, RestTemplate restTemplate) {
		ResponseEntity<TVShows[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/tvshows",
				TVShows[].class);

		model.addAttribute("tvshowsList", responseEntity.getBody());
		return "viewTvshows";
	}

	@PostMapping("/insertTvshows")
	public String insertTvshows(Model model, @ModelAttribute TVShows tvshows, RestTemplate restTemplate) {
		restTemplate.postForLocation("http://localhost:8080/tvshows", tvshows);
		ResponseEntity<TVShows[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/tvshows",
				TVShows[].class);

		model.addAttribute("tvshowsList", responseEntity.getBody());
		return "insertTvshows";
	}

	@GetMapping(value = "/getTvshows/{id}", produces = "application/json")
	@ResponseBody
	public TVShows getTvshows(@PathVariable Long id, RestTemplate restTemplate) {
		ResponseEntity<TVShows> responseEntity = restTemplate.getForEntity("http://localhost:8080/tvshows/" + id,
				TVShows.class);

		return responseEntity.getBody();
	}

}
