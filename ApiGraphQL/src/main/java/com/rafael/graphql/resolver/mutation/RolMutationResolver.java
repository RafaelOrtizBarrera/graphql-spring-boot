package com.rafael.graphql.resolver.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.rafael.graphql.entity.Perfil;
import com.rafael.graphql.entity.Rol;
import com.rafael.graphql.repository.PerfilRepository;
import com.rafael.graphql.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RolMutationResolver implements GraphQLMutationResolver {

    @Autowired
    RolRepository rolRepository;

    @Autowired
    PerfilRepository perfilRepository;

    public Rol crearRol(String nombre){
        Rol rol = new Rol();
        rol.setNombre(nombre);
        return rolRepository.save(rol);
    }

    public Rol actualizarRol(Rol rol){
        Optional<Rol> optRol = rolRepository.findById(rol.getId());
        if(optRol.isPresent()){
            Rol updRol = optRol.get();
            updRol.setNombre(rol.getNombre());
            return rolRepository.save(updRol);
        }
        return null;
    }

    public Rol eliminarRol(Long id){
        Optional<Rol> rol = rolRepository.findById(id);
        if(rol.isPresent()){
            rolRepository.delete(rol.get());
            return rol.get();
        }
        return null;
    }

    public Rol addPerfil(Long id, Long idPerfil){
        Optional<Rol> optRol = rolRepository.findById(id);
        Optional<Perfil> optPerfil = perfilRepository.findById(idPerfil);
        if(optRol.isPresent() && optPerfil.isPresent()){
            Rol rol = optRol.get();
            rol.getPerfiles().add(optPerfil.get());
            return rolRepository.save(rol);
        }
        return null;
    }

}
