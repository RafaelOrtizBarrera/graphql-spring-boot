package com.rafael.graphql.resolver.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.rafael.graphql.entity.Perfil;
import com.rafael.graphql.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PerfilMutationResolver implements GraphQLMutationResolver {

    @Autowired
    PerfilRepository perfilRepository;

    public Perfil crearPerfil(String nombre) {
        Perfil perfil = new Perfil();
        perfil.setNombre(nombre);
        return perfilRepository.save(perfil);
    }

    public Perfil actualizarPerfil(Perfil perfil){
        Optional<Perfil> optPerfil = perfilRepository.findById(perfil.getId());
        if(optPerfil.isPresent()){
            Perfil updPerfil = optPerfil.get();
            updPerfil.setNombre(perfil.getNombre());
            return perfilRepository.save(updPerfil);
        }
        return null;
    }

    public Perfil eliminarPerfil(Long id){
        Optional<Perfil> perfil = perfilRepository.findById(id);
        if(perfil.isPresent()){
            perfilRepository.delete(perfil.get());
            return perfil.get();
        }
        return null;
    }
}
