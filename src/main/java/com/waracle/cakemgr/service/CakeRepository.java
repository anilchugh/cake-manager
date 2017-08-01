package com.waracle.cakemgr.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.waracle.cakemgr.model.Cake;

@RepositoryRestResource(collectionResourceRel = "cakes", path = "cakes")
public interface CakeRepository extends JpaRepository<Cake, Long> {

}
