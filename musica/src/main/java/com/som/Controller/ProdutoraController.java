package com.som.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.som.Model.Produtora;
import com.som.Repository.ProdutoraRepository;

@RestController
@RequestMapping("/produtora")
public class ProdutoraController {

	@Autowired
	private ProdutoraRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Produtora>> getAll() {
		return ResponseEntity.ok(repository.findAll());
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getbid(@PathVariable int id) {		
		Optional<Produtora> produtoraExist = repository.findById(id);
		
		if (produtoraExist.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();			
		return ResponseEntity.ok(produtoraExist.get());
	}
	
	@PostMapping
	public ResponseEntity<Produtora> post(@RequestBody Produtora produtora){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produtora));
	}
	
	@PutMapping
	public ResponseEntity<Produtora> put(@PathVariable Produtora ProdutoraAtualizado){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(ProdutoraAtualizado));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id){
		repository.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}	
}
