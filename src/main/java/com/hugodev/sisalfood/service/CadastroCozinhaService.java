package com.hugodev.sisalfood.service;

import com.hugodev.sisalfood.entities.Cozinha;
import com.hugodev.sisalfood.exception.EntidadeEmUsoException;
import com.hugodev.sisalfood.exception.EntidadeNaoEncontradaException;
import com.hugodev.sisalfood.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroCozinhaService {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Cozinha salvar(Cozinha cozinha) {
        return cozinhaRepository.save(cozinha);
    }

    public void excluir(Long cozinhaId) {
        try {
            cozinhaRepository.deleteById(cozinhaId);

        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException
                    (String.format("Não existe um cadastro de cozinha com código %d", cozinhaId));

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException
                    (String.format("Cozinha de código %d não pode ser removida, pois está em uso", cozinhaId));
        }
    }

}
