package com.waracle.cakemgr.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.waracle.cakemgr.model.Cake;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CakeRepositoryTest {
	@Autowired
	private CakeRepository repository;

	@Test
	public void testCakeCount() {
		Cake cake = new Cake();
		cake.setTitle("Marble Cake");
		cake.setDescription(
				"A cake with marble like appearance achieved by very lightly blending light and dark batter");
		cake.setImage("http://img.taste.com.au/L1NLVIPb/taste/2016/11/coffee-walnut-cake-88106-1.jpeg");
		repository.save(cake);
		assertThat(repository.count() == 3);
	}

}
