package com.rafael.graphql.resolver.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.rafael.graphql.entity.Rol;
import com.rafael.graphql.entity.Usuario;
import com.rafael.graphql.exception.RecursoExistenteException;
import com.rafael.graphql.repository.RolRepository;
import com.rafael.graphql.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;

@Component
public class UsuarioMutationResolver implements GraphQLMutationResolver {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    RolRepository rolRepository;

    public Usuario crearUsuario(Usuario usuario) throws RecursoExistenteException {

        if (usuarioRepository.existsById(usuario.getRut())) {
            throw new RecursoExistenteException("Ya existe un usuario registrado con el rut: " + usuario.getRut());
        }
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(usuario.getNombre());
        nuevoUsuario.setRut(usuario.getRut());
        nuevoUsuario.setDv(usuario.getDv());
        nuevoUsuario.setApellido(usuario.getApellido());
        nuevoUsuario.setEmail(usuario.getEmail());
        return usuarioRepository.save(nuevoUsuario);
    }

    public Usuario actualizarUsuario(Long rut, String email) {
        Optional<Usuario> usuario = usuarioRepository.findById(rut);
        if (usuario.isPresent()) {
            Usuario updUsuario = usuario.get();
            updUsuario.setEmail(email);
            return usuarioRepository.save(updUsuario);
        }
        return null;
    }

    public Usuario eliminarUsuario(Long rut) {
        Optional<Usuario> usuario = usuarioRepository.findById(rut);
        if (usuario.isPresent()) {
            usuarioRepository.delete(usuario.get());
            return usuario.get();
        }
        return null;
    }

    public Usuario addRol(Long rut, Long idRol) {
        Optional<Usuario> optUsuario = usuarioRepository.findById(rut);
        Optional<Rol> optRol = rolRepository.findById(idRol);
        if (optUsuario.isPresent() && optRol.isPresent()) {
            Usuario usuario = optUsuario.get();
            Set<Rol> roles = usuario.getRoles();
            roles.add(optRol.get());
            usuario.setRoles(roles);
            return usuarioRepository.save(usuario);
        }
        return null;
    }

}
