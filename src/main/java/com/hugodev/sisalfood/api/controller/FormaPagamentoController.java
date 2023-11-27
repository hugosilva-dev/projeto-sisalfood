package com.hugodev.sisalfood.api.controller;

import com.hugodev.sisalfood.entities.FormaPagamento;
import com.hugodev.sisalfood.exception.EntidadeNaoEncontradaException;
import com.hugodev.sisalfood.repository.FormaPagamentoRepository;
import com.hugodev.sisalfood.service.CadastroFormaPagamentoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamentos")
public class FormaPagamentoController {

    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;

    @Autowired
    private CadastroFormaPagamentoService cadastroFormaPagamento;

    @GetMapping
    public List<FormaPagamento> listar() {
        return formaPagamentoRepository.findAll();
    }

    @GetMapping("/{formaPagamentoId}")
    public ResponseEntity<FormaPagamento> buscar(@PathVariable Long formaPagamentoId) {
        FormaPagamento formaPagamento = formaPagamentoRepository.findById(formaPagamentoId).orElse(null);
        if (formaPagamento != null) {
            return ResponseEntity.ok(formaPagamento);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FormaPagamento adicionar(@RequestBody FormaPagamento formaPagamento) {
        return cadastroFormaPagamento.salvar(formaPagamento);
    }

    @PutMapping("/{formaPagamentoId}")
    public ResponseEntity<FormaPagamento> atualizar(@PathVariable Long formaPagamentoId,
                                                    @RequestBody FormaPagamento formaPagamento) {
        FormaPagamento formaPagamentoAtual = formaPagamentoRepository.findById(formaPagamentoId).orElse(null);

        if (formaPagamentoAtual != null) {
            BeanUtils.copyProperties(formaPagamento, formaPagamentoAtual, "id");
            formaPagamentoAtual = cadastroFormaPagamento.salvar(formaPagamentoAtual);
            return ResponseEntity.ok(formaPagamentoAtual);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{formaPagamentoId}")
    public ResponseEntity<FormaPagamento> remover(@PathVariable Long formaPagamentoId) {

        try {
            cadastroFormaPagamento.excluir(formaPagamentoId);
            return ResponseEntity.noContent().build();

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
