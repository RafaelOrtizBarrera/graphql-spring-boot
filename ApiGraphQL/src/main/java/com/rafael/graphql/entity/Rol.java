package com.rafael.graphql.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "ROL", schema = "USUARIO")
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Rol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROL_SEQ")
    @SequenceGenerator(sequenceName = "ROL_ID_SEQ", allocationSize = 1, name = "ROL_SEQ")
    @Column(name="ID", unique=true, nullable=false, columnDefinition = "serial")
    @EqualsAndHashCode.Include
    private Long id;
    @Column(name="nombre", nullable=false, columnDefinition = "varchar", length = 100)
    private String nombre;
    @ManyToMany(mappedBy = "roles")
    private Set<Usuario> usuarios;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "ROL_PERFIL",
            joinColumns = @JoinColumn(name = "ID_ROL"),
            inverseJoinColumns = @JoinColumn(name = "ID_PERFIL"))
    private Set<Perfil> perfiles;
}
