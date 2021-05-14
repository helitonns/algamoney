package com.algaworks.algamoney.service;

import com.algaworks.algamoney.model.Lancamento;
import com.algaworks.algamoney.model.Pessoa;
import com.algaworks.algamoney.repository.PessoaRepository;
import com.algaworks.algamoney.service.exception.PessoaInexistenteOuInativaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.algaworks.algamoney.repository.LancamentoRepository;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepositiry;

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

        return lancamentoRepositiry.save(lancamento);
    }

}
