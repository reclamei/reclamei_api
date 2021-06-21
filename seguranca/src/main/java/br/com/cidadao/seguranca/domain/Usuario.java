package br.com.cidadao.seguranca.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(generator = "usuario_generator", strategy = SEQUENCE)
    @SequenceGenerator(allocationSize = 1, name = "usuario_generator", sequenceName = "seq_usuario")
    private Long id;

    @Column(length = 20, nullable = false)
    private String username;

    @Column(length = 30, nullable = false, unique = true)
    private String email;

    @Column(length = 20, nullable = false)
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_permissao", referencedColumnName = "id")
    private Permissao permissao;

}