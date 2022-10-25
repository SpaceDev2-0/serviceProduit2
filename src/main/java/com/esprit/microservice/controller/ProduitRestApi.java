package com.esprit.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.microservice.entity.produit;
import com.esprit.microservice.service.produitService;



@CrossOrigin("*")
@RestController
@RequestMapping("/produits")
public class ProduitRestApi {
	@Autowired
	private produitService productService;
    	//affichage 
		//http://localhost:8090/SpringMVC/servlet/retrieveProduits
		@GetMapping("/retrieveProduits")
		public List<produit> getProduct(){
			return productService.retrieveAllProduit();
			
		}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<produit> createProduct(@RequestBody produit product){
		return new ResponseEntity<>(productService.addProduct(product), HttpStatus.OK);
		
	}
	//affichage
	//http://localhost:8083/SpringMVC/retriveAllArticleByname/1

    @GetMapping(value="/getProductById/{id}")
    public produit getPanierById(@PathVariable(value="id") int id){
        return productService.getProductByid(id);
    }

	
	@PutMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<produit> updateProduct(@PathVariable(value="id") int id,
			@RequestBody produit product){
		return new ResponseEntity<>(productService.updateProduct(id,product),HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteProduct(@PathVariable(value="id") int  id){
		return new ResponseEntity<>(productService.deleteProduct(id),HttpStatus.OK);
		
	}
	

}
