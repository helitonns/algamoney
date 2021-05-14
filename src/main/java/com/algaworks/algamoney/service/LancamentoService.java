package com.algaworks.algamoney.service;

import com.algaworks.algamoney.model.Lancamento;
import com.algaworks.algamoney.model.Pessoa;
import com.algaworks.algamoney.repository.PessoaRepository;
import com.algaworks.algamoney.service.exception.PessoaInexistenteOuInativaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.algaworks.algamoney.repository.LancamentoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    //--------------------------------------------------------------------------
    public Lancamento salvar(Lancamento lancamento) {
        try {
            Pessoa pessoa = pessoaRepository.findById(lancamento.getPessoa().getCodigo()).get();
            if (pessoa == null || pessoa.isInativo()) {
                throw new PessoaInexistenteOuInativaException();
            }
        } catch (Exception e) {
            throw new PessoaInexistenteOuInativaException();
        }
        return lancamentoRepository.save(lancamento);
    }

    public Lancamento atualizar(Long codigo, Lancamento lancamento) {
        try {
            Lancamento lancamentoSalvo = buscarLancamentoExistente(codigo);
            if (!lancamento.getPessoa().equals(lancamentoSalvo.getPessoa())) {
                validarPessoa(lancamento);
            }

            BeanUtils.copyProperties(lancamento, lancamentoSalvo, "codigo");

            return lancamentoRepository.save(lancamentoSalvo);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private void validarPessoa(Lancamento lancamento) {
        Pessoa pessoa = null;
        if (lancamento.getPessoa().getCodigo() != null) {
            pessoa = pessoaRepository.findById(lancamento.getPessoa().getCodigo()).get();
        }

        if (pessoa == null || pessoa.isInativo()) {
            throw new PessoaInexistenteOuInativaException();
        }
    }

    private Lancamento buscarLancamentoExistente(Long codigo) {
        try {
            Lancamento lancamentoSalvo = lancamentoRepository.findById(codigo).get();
            if (lancamentoSalvo == null) {
                throw new IllegalArgumentException();
            }
            return lancamentoSalvo;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

}
