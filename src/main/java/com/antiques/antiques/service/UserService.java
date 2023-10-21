package com.antiques.antiques.service;

import com.antiques.antiques.model.User;
import com.github.adminfaces.template.exception.BusinessException;
import jakarta.ejb.Stateless;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import static com.github.adminfaces.template.util.Assert.has;


@Stateless
public class UserService implements Serializable  {

    List<User> usersList;

    public List<User> getUsersList() {
        return usersList;
    }

    public void insert (User user) {
        validate(user);
        user.setId(usersList.stream().mapToInt(User::getId).max().getAsInt()+1);
        usersList.add(user);
    }

    public void validate(User user) {
        BusinessException be = new BusinessException();
        if(!user.hasName()) {
            be.addException(new BusinessException("User name cannot be empty!"));
        }
        if(!user.hasSurname()) {
            be.addException(new BusinessException("User surname cannot be empty!"));
        }
        if(!user.hasMail()) {
            be.addException(new BusinessException("User mail cannot be empty!"));
        }
        if(has(be.getExceptionList())) {
            throw be;
        }
    }

    public void remove(User user) {
        usersList.remove(user);
    }

    public User findById(int id) {
        return usersList.stream()
                .filter(u -> Objects.equals(u.getId(), id))
                .findFirst()
                .orElseThrow(() -> new BusinessException("User with id: " + id + " doesn't exist"));
    }

    public void update(User user) {
        validate(user);
        usersList.remove(user);
        usersList.add(user);
    }

}
