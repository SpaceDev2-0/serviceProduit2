package com.esprit.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.microservice.entity.produit;
import com.esprit.microservice.repository.produitRepository;



@Service
public class produitService {
	@Autowired
	private produitRepository productRepository;
	//@Scheduled(fixedRate = 60000)
	public List<produit> retrieveAllProduit() {
		List<produit> produits=(List<produit>) productRepository.findAll();
		return produits;
	}
	public produit addProduct(produit product){
		return productRepository.save(product);
	}
	
	public produit getProductByid (int id) {
		// TODO Auto-generated method stub
		produit product = productRepository.findById(id).isPresent() ? productRepository.findById(id).get() : null;
		return product;
	}
	
	public produit updateProduct(int id, produit newProduct){
		if(productRepository.findById(id).isPresent()){
			produit existingProductt =productRepository.findById(id).get();
			existingProductt.setProductName(newProduct.getProductName());
			existingProductt.setPrice(newProduct.getPrice());
			existingProductt.setDescription(newProduct.getDescription());
			existingProductt.setCategory(newProduct.getCategory());
			existingProductt.setAvailability(newProduct.getAvailability());
			existingProductt.setImageUrl(newProduct.getImageUrl());
			return productRepository.save(existingProductt);
			
		}else{
			return null;
		}

	}
	public String deleteProduct(int id){
		if(productRepository.findById(id).isPresent()){
			productRepository.deleteById(id);
			return  "product  supprimé";
		}else
			return "product non supprimé";
	}
	
}
