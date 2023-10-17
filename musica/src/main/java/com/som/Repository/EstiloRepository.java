package com.som.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.som.Model.Estilo;

@Repository
public interface EstiloRepository extends JpaRepository<Estilo, Integer>{

}
