package com.rafael.graphql.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "PERFIL", schema = "USUARIO")
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERFIL_SEQ")
    @SequenceGenerator(sequenceName = "PERFIL_ID_SEQ", allocationSize = 1, name = "PERFIL_SEQ")
    @Column(name="ID", unique=true, nullable=false, columnDefinition = "serial")
    @EqualsAndHashCode.Include
    private Long id;
    @Column(name="nombre", nullable=false, columnDefinition = "varchar", length = 100)
    private String nombre;
    @ManyToMany(mappedBy = "perfiles")
    private Set<Rol> roles;
}
