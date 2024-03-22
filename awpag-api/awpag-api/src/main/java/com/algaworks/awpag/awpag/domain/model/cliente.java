package com.algaworks.awpag.awpag.domain.model;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Entity
//@Table (name= "tab_cliente")    ==> Caso o nome da tabela fosse diferente de cliente
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
public class cliente {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nome;
        private String email;
        @Column(name="fone") // necessário quando o nome da coluna é diferente
        private String telefone;
}
