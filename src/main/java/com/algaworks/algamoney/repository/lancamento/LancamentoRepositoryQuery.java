package com.algaworks.algamoney.repository.lancamento;

import com.algaworks.algamoney.model.Lancamento;
import com.algaworks.algamoney.repository.filter.LancamentoFilter;
import com.algaworks.algamoney.repository.projection.ResumoLancamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LancamentoRepositoryQuery {
    
    public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable );
    public Page<ResumoLancamento> resumir (LancamentoFilter lancamentoFilter, Pageable pageable );
}
