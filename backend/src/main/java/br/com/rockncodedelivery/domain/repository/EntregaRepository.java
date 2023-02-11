package br.com.rockncodedelivery.domain.repository;

import br.com.rockncodedelivery.domain.entities.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {}