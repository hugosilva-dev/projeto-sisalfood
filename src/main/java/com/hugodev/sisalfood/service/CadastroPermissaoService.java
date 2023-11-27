package com.hugodev.sisalfood.service;

import com.hugodev.sisalfood.entities.Permissao;
import com.hugodev.sisalfood.exception.EntidadeNaoEncontradaException;
import com.hugodev.sisalfood.repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroPermissaoService {

    @Autowired
    private PermissaoRepository permissaoRepository;

    public Permissao salvar(Permissao permissao){
        return  permissaoRepository.save(permissao);
    }

    public void excluir(Long permissaoId) {
        try {
            permissaoRepository.deleteById(permissaoId);

        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException
                    (String.format("Não existe uma forma de pagamento com código %d", permissaoId));
        }
    }
}
