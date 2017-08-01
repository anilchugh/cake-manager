package com.waracle.cakemgr.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.waracle.cakemgr.model.Cake;

@RepositoryRestResource(collectionResourceRel = "cakes", path = "cakes")
public interface CakeRepository extends CrudRepository<Cake, Long> {

}
