package com.rafael.graphql.resolver.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.rafael.graphql.entity.Rol;
import com.rafael.graphql.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RolQueryResolver implements GraphQLQueryResolver {

    @Autowired
    RolRepository rolRepository;

    public List<Rol> obtenerRoles(){
        return rolRepository.findAll();
    }

    public Rol obtenerRolPorId(Long id){
        Optional<Rol> rol = rolRepository.findById(id);
        if(rol.isPresent()){
            return rol.get();
        }
        return null;
    }
}
