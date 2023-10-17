package com.som.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.som.Model.Produtora;

@Repository
public interface ProdutoraRepository extends JpaRepository<Produtora, Integer>{

}
