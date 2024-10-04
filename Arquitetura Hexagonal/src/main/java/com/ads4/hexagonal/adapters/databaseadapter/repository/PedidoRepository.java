package com.ads4.hexagonal.adapters.databaseadapter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ads4.hexagonal.adapters.databaseadapter.entities.PedidoEntity;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, Integer >{
    
}
