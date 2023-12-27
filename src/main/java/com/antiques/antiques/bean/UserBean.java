package com.antiques.antiques.bean;

import com.antiques.antiques.model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 {@link User} entity.
 */

@Stateless
public class UserBean {

    @PersistenceContext
    private EntityManager em;

    public List<User> getAllUsers() {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    public User find(Long id) {
        return em.find(User.class, id);
    }

    public User merge(User user) {
        return em.merge(user);
    }

    public void persist(User user) {
        em.persist(user);
    }

    public void remove(User user) {
        User attached = find(user.getId());
        em.remove(attached);
    }

    public void addNewUser(User user) {
        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setSurname(user.getSurname());
        newUser.setAge(user.getAge());
        newUser.setNick(user.getNick());
        newUser.setMail(user.getMail());
        newUser.setAccount(user.getAccount());
        this.em.persist(newUser);
    }

}
