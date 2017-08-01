package com.waracle.cakemgr;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.waracle.cakemgr.model.Cake;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CakeManagerApplicationTests {
	public static final String URL = "http://localhost";

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void whenLoadingCakesThenCorrectStatusCode() throws Exception {
		mockMvc.perform(get("/cakes")).andExpect(status().isOk());
	}

	@Test
	public void whenAddingCakeThenCorrectStatusCode() throws Exception {
		Cake cake = getCake();

		mockMvc.perform(post("/cakes", cake).contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(cake))).andExpect(status().is2xxSuccessful());
	}

	@Test
	public void whenAddingCakesWithoutTitle() throws Exception {
		Cake cake = getCake();
		cake.setTitle(null);

		mockMvc.perform(post("/cakes", cake).contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(cake))).andExpect(status().is4xxClientError());
	}

	private Cake getCake() {
		Cake cake = new Cake();
		cake.setTitle("Marble Cake");
		cake.setDescription(
				"A cake with marble like appearance achieved by very lightly blending light and dark batter");
		cake.setImage(null);
		return cake;
	}

}
