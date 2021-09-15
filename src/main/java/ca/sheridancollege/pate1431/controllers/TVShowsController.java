package ca.sheridancollege.pate1431.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.pate1431.beans.TVShows;
import ca.sheridancollege.pate1431.repositories.TVShowsRepository;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/tvshows")
public class TVShowsController {

	private TVShowsRepository tvshowsRepository;

	@GetMapping
	public List<TVShows> getTVShowsCollection() {
		return tvshowsRepository.findAll();
	}

	@GetMapping(value = "/{id}")
	public TVShows getIndividualTVShow(@PathVariable Long id) {
		return tvshowsRepository.findById(id).get();
	}

	@PostMapping(consumes = "application/json")
	public TVShows postTVShows(@RequestBody TVShows tvshows) {
		return tvshowsRepository.save(tvshows);
	}

}
