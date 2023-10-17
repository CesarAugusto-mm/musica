package com.som.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.som.Model.Estilo;
import com.som.Repository.EstiloRepository;

@RestController
@RequestMapping("/estilo")
public class EstiloController {
	
	@Autowired
	private EstiloRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Estilo>>get() {
		return ResponseEntity.ok(repository.findAll());
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Estilo> getById(@PathVariable int id) {
		Optional<Estilo> EstiloExist = repository.findById(id);
		
		if (EstiloExist.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.ok(EstiloExist.get());
	}
	
	@PostMapping
	public ResponseEntity<Estilo> post(@RequestBody Estilo estilo) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save (estilo));
	}
	
	@PutMapping
	public ResponseEntity<Estilo> put(@RequestBody Estilo estilo) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save (estilo));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		repository.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
 