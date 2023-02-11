package br.com.rockncodedelivery.domain.repository;

import br.com.rockncodedelivery.domain.entities.Entregador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregadorRepository extends JpaRepository<Entregador, Long> {
    void deleteById(long id);
}
