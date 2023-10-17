package com.som.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.som.Model.Musica;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Integer> {

}
