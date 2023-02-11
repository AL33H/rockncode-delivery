package br.com.rockncodedelivery.domain.repository;

import br.com.rockncodedelivery.domain.entities.Entregador;
import br.com.rockncodedelivery.external.dto.EntregadorResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntregadorRepository extends JpaRepository<Entregador, Long> {

    public List<Entregador> listarEntregadores();

    void deleteById (long id);
}
