package com.algaworks.algamoney.service;

import com.algaworks.algamoney.model.Pessoa;
import com.algaworks.algamoney.repository.PessoaRepository;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;
    
    //--------------------------------------------------------------------------

    public Pessoa buscarPessoaPeloCodigo(Long codigo) {
        Optional<Pessoa> pessoaSalva;
        pessoaSalva = pessoaRepository.findById(codigo);
        return pessoaSalva.get();
    }
    
    public Pessoa atualizar(Long codigo, Pessoa pessoa) {
        try {
            Pessoa pessoaSalva = buscarPessoaPeloCodigo(codigo);
            BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");
            return pessoaRepository.save(pessoaSalva);
        } catch (Exception e) {
            throw new EmptyResultDataAccessException(1);
        }
    }

    public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
        Pessoa pessoaSalva = buscarPessoaPeloCodigo(codigo);
        pessoaSalva.setAtivo(ativo);
        pessoaRepository.save(pessoaSalva);
    }
}
