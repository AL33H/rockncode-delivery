package br.com.rockncodedelivery.domain.service.impl;

import br.com.rockncodedelivery.api.v1.dto.EntregadorRequest;
import br.com.rockncodedelivery.api.v1.dto.EntregadorResponse;
import br.com.rockncodedelivery.domain.entities.Entregador;
import br.com.rockncodedelivery.domain.repository.EntregadorRepository;
import br.com.rockncodedelivery.domain.service.EntregadorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EntregadorServiceImpl implements EntregadorService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private EntregadorRepository entregadorRepository;

    public EntregadorResponse criarEntregador(EntregadorRequest entregadorRequest) {
        Entregador entregador = modelMapper.map(entregadorRequest, Entregador.class);
        Entregador entregadorSalvo = entregadorRepository.save(entregador);
        EntregadorResponse entregadorResponse = modelMapper.map(entregadorSalvo, EntregadorResponse.class);
        return entregadorResponse;
    }

    public List<EntregadorResponse> listarEntregadores() {
        List<Entregador> entregadorList = (List<Entregador>) entregadorRepository.findAll();
        List<EntregadorResponse> entregadorResponseList = new ArrayList<>();
        entregadorList.forEach(entregador -> {
            EntregadorResponse entregadorResponse = modelMapper.map(entregador, EntregadorResponse.class);
            entregadorResponseList.add(entregadorResponse);
        });
        return entregadorResponseList;
    }

    public void deletarEntregador(Long id) throws Exception {
        Optional<Entregador> entregador = entregadorRepository.findById(id);
        entregadorRepository.deleteById(entregador.get().getId());
    }
}
