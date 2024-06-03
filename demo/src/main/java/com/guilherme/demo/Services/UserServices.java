package com.guilherme.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.guilherme.demo.Repositorie.UserRepositorie;
import com.guilherme.demo.Services.Exceptions.DatabaseException;
import com.guilherme.demo.Services.Exceptions.ResourceNotFoundException;
import com.guilherme.demo.entities.User;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserServices {
    
    @Autowired
    private UserRepositorie repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        /*
            obj.get(); returnava o obj buscado
            caso não encontra-se, lançava error 500
            orElseThrow() se n tiver vai lançar a minha exceção
         */
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));   
    }

    public User insert(User obj){
        return repository.save(obj);
    }
    public void delete(Long id){
        try{
            repository.deleteById(id);
        }catch(EmptyResultDataAccessException e){
            //user don't exists 
            throw new ResourceNotFoundException(id);
        }catch(DataIntegrityViolationException e){
            //user have oder
            throw new DatabaseException(e.getMessage());
        }
    }
    public User update(Long id, User obj){
        try{
            /*
            aqui ele prepara o obj a ser mechido para dai mecher no BD,
            ao contrário de usar findbyid que traz o obj
            */
            User entity = repository.getReferenceById(id);
            update(entity,obj);
            return repository.save(obj);

        }catch(EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void update(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setPhone(obj.getPhone());
        entity.setEmail(obj.getEmail());
        
    }
}
