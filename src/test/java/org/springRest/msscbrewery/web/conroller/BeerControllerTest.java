package org.springRest.msscbrewery.web.conroller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springRest.msscbrewery.web.model.BeerDto;
import org.springRest.msscbrewery.web.model.BeerStyleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(BeerController.class)
class BeerControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper mapper;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetBeerById() throws Exception {
		mockMvc.perform(get("/api/v1/beer/"+UUID.randomUUID().toString())
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	void testSaveNewBeerBeerDto()  throws Exception {
		BeerDto beer=BeerDto.builder()
				.Id(UUID.randomUUID())
				.beerName("Stock pile")
				.beerStyle(BeerStyleEnum.ALE)
				.build();
		String json=mapper.writeValueAsString(beer);
		mockMvc.perform(post("/api/v1/beer/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json)).andExpect(status().isCreated());
	}

	@Test
	void testSaveNewBeerUUIDBeerDto() throws Exception{
		BeerDto beer=BeerDto.builder()
				.Id(UUID.randomUUID())
				.beerName("Stock pile")
				.beerStyle(BeerStyleEnum.ALE)
				.build();
		String json=mapper.writeValueAsString(beer);
		mockMvc.perform(put("/api/v1/beer/"+UUID.randomUUID().toString())
				.contentType(MediaType.APPLICATION_JSON)
				.content(json)).andExpect(status().isNoContent());
	}

}
