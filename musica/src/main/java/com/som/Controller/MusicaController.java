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

import com.som.Model.Musica;
import com.som.Repository.MusicaRepository;

@RestController
@RequestMapping("/musica")
public class MusicaController {
	
	@Autowired
	private MusicaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Musica>> getAll() {
		return ResponseEntity.ok(repository.findAll());
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getbid(@PathVariable int id) {
		
		Optional<Musica> musicaExist = repository.findById(id);
		
			if (musicaExist.isEmpty())
					return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
		return ResponseEntity.ok(musicaExist.get());
	}
	
	@PostMapping
	public ResponseEntity<Musica> post(@RequestBody Musica musica){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(musica));
	}
	
	@PutMapping
	public ResponseEntity<Musica> put(@PathVariable Musica MusicaAtualizado){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(MusicaAtualizado));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id){
		repository.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}	

}
 