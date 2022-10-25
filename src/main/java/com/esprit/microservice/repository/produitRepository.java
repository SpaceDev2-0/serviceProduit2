package com.esprit.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esprit.microservice.entity.produit;

public interface produitRepository extends JpaRepository<produit,Integer> {

}
