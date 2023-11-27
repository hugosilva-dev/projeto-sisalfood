package com.hugodev.sisalfood.service;

import com.hugodev.sisalfood.entities.Cozinha;
import com.hugodev.sisalfood.entities.Restaurante;
import com.hugodev.sisalfood.exception.EntidadeNaoEncontradaException;
import com.hugodev.sisalfood.repository.CozinhaRepository;
import com.hugodev.sisalfood.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroRestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Restaurante salvar(Restaurante restaurante) {
        Long cozinhaId = restaurante.getCozinha().getId();
        Cozinha cozinha = cozinhaRepository.findById(cozinhaId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format("Não existe cadastro de cozinha com código %d", cozinhaId)));

        restaurante.setCozinha(cozinha);
        return restauranteRepository.save(restaurante);
    }

    public void excluir(Long restauranteId) {
        try {
            restauranteRepository.deleteById(restauranteId);

        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException
                    (String.format("Não existe um cadastro de restaurante com código %d", restauranteId));

        }
    }
}
