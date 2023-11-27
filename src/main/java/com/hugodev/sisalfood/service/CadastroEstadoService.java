package com.hugodev.sisalfood.service;

import com.hugodev.sisalfood.entities.Estado;
import com.hugodev.sisalfood.exception.EntidadeEmUsoException;
import com.hugodev.sisalfood.exception.EntidadeNaoEncontradaException;
import com.hugodev.sisalfood.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroEstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public Estado salvar(Estado estado) {
        return estadoRepository.save(estado);
    }

    public void excluir(Long estadoId) {
        try {
            estadoRepository.deleteById(estadoId);
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException
                    (String.format("Não há Estado com id %d cadastrado no sistema!", estadoId));

        } catch (DataIntegrityViolationException e){
            throw new EntidadeEmUsoException
                    (String.format("Estado de código %d não pode ser removido, pois está em uso", estadoId));
        }
    }
}
