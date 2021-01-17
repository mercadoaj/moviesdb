package com.mercado.rest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes=RestApplicationTests.class)
class RestApplicationTests {

	@Test
	void contextLoads() {
	}

/*
	@Test
	public void shouldReturnASingleRow() throws Exception {
		Long movieId = 1L;
		LocalDate releaseDate = LocalDate.of(2020,8,22);

		Movie movie = new Movie("Tenet", 
			"Armed with only one word, Tenet, and fighting for the survival of the entire world, a Protagonist journeys through a twilight world of international espionage on a mission that will unfold in something beyond real time.",
			"https://m.media-amazon.com/images/M/MV5BOGJmZjcxNTAtYjViZS00YzJmLTlkMzgtZmVkYTQ5YjUwMjIyXkEyXkFqcGdeQXVyNjMwMzc3MjE@._V1_FMjpg_UY863_.jpg",
			262838L, releaseDate);
		movie.setId(movieId);
		Optional<Movie> opt = Optional.of(movie);

		when(movieService.findById(movieId)).thenReturn(opt);


		this.mockMvc.perform(get("/movies/1"))
          	.andExpect(status().isOk())
			.andExpect(content().contentType("application/json"))
           	.andExpect(jsonPath("$.id").value(movie.getId()))
           	.andExpect(jsonPath("$.title").value(movie.getTitle()))
           	.andExpect(jsonPath("$.releaseDate").value(movie.getReleaseDate()))
           	.andExpect(jsonPath("$.voteAverage").value(movie.getVoteAverage()));
           	.andDo(print());
	}
*/
}
