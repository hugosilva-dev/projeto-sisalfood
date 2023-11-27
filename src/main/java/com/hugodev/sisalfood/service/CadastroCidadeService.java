package com.hugodev.sisalfood.service;

import com.hugodev.sisalfood.entities.Cidade;
import com.hugodev.sisalfood.entities.Estado;
import com.hugodev.sisalfood.exception.EntidadeNaoEncontradaException;
import com.hugodev.sisalfood.repository.CidadeRepository;
import com.hugodev.sisalfood.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroCidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    public Cidade salvar(Cidade cidade) {

        Long estadoId = cidade.getEstado().getId();
        Estado estado = estadoRepository.findById(estadoId).orElse(null);

        if (estado == null) {
            throw new EntidadeNaoEncontradaException
                    (String.format("Não existe cadastro de estado com código %d", estadoId));
        }
        cidade.setEstado(estado);
        return cidadeRepository.save(cidade);
    }

    public void excluir(Long cidadeId) {
        try {
            cidadeRepository.deleteById(cidadeId);
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException
                    (String.format("Não há Estado com id %d cadastrado no sistema!", cidadeId));
        }
    }
}
