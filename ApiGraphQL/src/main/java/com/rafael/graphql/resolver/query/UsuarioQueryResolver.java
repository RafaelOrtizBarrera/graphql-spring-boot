package com.rafael.graphql.resolver.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.rafael.graphql.entity.Usuario;
import com.rafael.graphql.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UsuarioQueryResolver implements GraphQLQueryResolver {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> obtenerUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario obtenerUsuarioPorRut(Long rut) {
        Optional<Usuario> opUsuario = usuarioRepository.findById(rut);
        if (opUsuario.isPresent()) {
            return opUsuario.get();
        }
        return null;
    }
}
