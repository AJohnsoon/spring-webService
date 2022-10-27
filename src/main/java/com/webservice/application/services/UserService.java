package com.webservice.application.services;

import com.webservice.application.entities.User;
import com.webservice.application.repositories.UserRepository;
import com.webservice.application.services.exceptions.DatabaseException;
import com.webservice.application.services.exceptions.ResourceNotFoudException;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> userObject = userRepository.findById(id);
        return userObject.orElseThrow(() -> new ResourceNotFoudException(id));
    }

    public User insert(User obj){
       return userRepository.save(obj);
    }

    public void delete(Long id){
        try{
            userRepository.deleteById(id);
        }
        catch(EmptyResultDataAccessException e){
            throw new ResourceNotFoudException(id);
        }
        catch(DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User user){
        try{
            User entity = userRepository.getReferenceById(id);
            updateData(entity, user);
            return userRepository.save(entity);    
        }
        catch(EntityNotFoundException e){
            e.printStackTrace();
            throw new ResourceNotFoudException(id);
        }
    }

    private void updateData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }
}
