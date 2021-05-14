package com.algaworks.algamoney.repository;

import com.algaworks.algamoney.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
    
}
