package com.algaworks.awpag.awpag.domain.repository;

import com.algaworks.awpag.awpag.domain.model.cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<cliente, Long>  {


    //List<cliente> findByNome(String nome);

    List<cliente> findByNomeContaining(String nome);

}
