package com.hugodev.sisalfood.api.controller;

import com.hugodev.sisalfood.entities.Permissao;
import com.hugodev.sisalfood.exception.EntidadeNaoEncontradaException;
import com.hugodev.sisalfood.repository.PermissaoRepository;
import com.hugodev.sisalfood.service.CadastroPermissaoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissoes")
public class PermissaoController {

    @Autowired
    private PermissaoRepository permissaoRepository;

    @Autowired
    private CadastroPermissaoService cadastroPermissao;

    @GetMapping
    public List<Permissao> listar() {
        return permissaoRepository.findAll();
    }

    @GetMapping("/{permissaoId}")
    public ResponseEntity<Permissao> buscar(@PathVariable Long permissaoId) {
        Permissao permissao = permissaoRepository.findById(permissaoId).orElse(null);
        if (permissao != null) {
            return ResponseEntity.ok(permissao);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Permissao adicionar(@RequestBody Permissao permissao) {
        return cadastroPermissao.salvar(permissao);
    }

    @PutMapping("/{permissaoId}")
    public ResponseEntity<Permissao> atualizar(@PathVariable Long permissaoId,
                                               @RequestBody Permissao permissao) {
        Permissao permissaoAtual = permissaoRepository.findById(permissaoId).orElse(null);

        if (permissaoAtual != null) {
            BeanUtils.copyProperties(permissao, permissaoAtual, "id");
            permissaoAtual = cadastroPermissao.salvar(permissaoAtual);
            return ResponseEntity.ok(permissaoAtual);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{permissaoId}")
    public ResponseEntity<Permissao> remover(@PathVariable Long permissaoId) {

        try {
            cadastroPermissao.excluir(permissaoId);
            return ResponseEntity.noContent().build();

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
