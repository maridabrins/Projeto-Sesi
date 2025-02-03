package com.sesi.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sesi.projeto.entities.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Long> {

}
