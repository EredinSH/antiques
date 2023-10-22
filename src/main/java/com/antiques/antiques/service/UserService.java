package com.antiques.antiques.service;

import com.antiques.antiques.model.User;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class UserService {

    @PersistenceContext
    private EntityManager entityManager;
    public List<User> loadAllUsers() {
        return this.entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    public void addNewUser(User user) {

        User newUser = new User();
        newUser.setId(user.getId());
        newUser.setName(user.getName());
        newUser.setSurname(user.getSurname());
        newUser.setAge(user.getAge());
        newUser.setNick(user.getNick());
        newUser.setMail(user.getMail());
        newUser.setAccount(user.getAccount());


        this.entityManager.persist(newUser);
    }

    public void updateUser(List<User> user) {
        user.forEach(entityManager::merge);
    }

    public void deleteUser(User user) {
        if (entityManager.contains(user)) {
            entityManager.remove(user);
        } else {
            User managedUser = entityManager.find(User.class, user.getId());
            if (managedUser != null) {
                entityManager.remove(managedUser);
            }
        }
    }

}
