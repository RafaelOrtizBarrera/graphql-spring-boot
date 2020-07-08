package com.rafael.graphql.resolver.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.rafael.graphql.entity.Perfil;
import com.rafael.graphql.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PerfilQueryResolver implements GraphQLQueryResolver {

    @Autowired
    PerfilRepository perfilRepository;

    public List<Perfil> obtenerPerfiles(){
        return perfilRepository.findAll();
    }

    public Perfil obtenerPerfilPorId(Long id){
        Optional<Perfil> perfil = perfilRepository.findById(id);
        if(perfil.isPresent()){
            return perfil.get();
        }
        return null;
    }
}
