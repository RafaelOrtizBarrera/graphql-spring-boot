package com.rafael.graphql.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "USUARIO", schema = "USUARIO")
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(name="rut", unique=true, nullable=false, columnDefinition = "integer")
    private Long rut;
    @Column(name="dv", nullable=false, columnDefinition = "char", length = 1)
    private String dv;
    @Column(name="nombre", nullable=false, columnDefinition = "varchar", length = 150)
    private String nombre;
    @Column(name="apellido", nullable=false, columnDefinition = "varchar", length = 150)
    private String apellido;
    @Column(name="email", nullable=false, columnDefinition = "varchar", length = 150)
    private String email;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "USUARIO_ROL",
            joinColumns = @JoinColumn(name = "RUT"),
            inverseJoinColumns = @JoinColumn(name = "ID_ROL"))
    private Set<Rol> roles;
}
