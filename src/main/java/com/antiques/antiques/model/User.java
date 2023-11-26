package com.antiques.antiques.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
@Entity
@Table(name="user")
public class User implements Serializable {

    @Id
    @GeneratedValue
    @Column(name= "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "age")
    private int age;
    @Column(name = "nick")
    private String nick;
    @Column(name = "mail")
    private String mail;
    @Column(name = "account")
    private Double account;

    public User() {
    }

    public User(Long id, String name, String surname, int age, String nick, String mail, Double account) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.nick = nick;
        this.mail = mail;
        this.account = account;
    }

    public User(String name, String surname, int age, String nick, String mail, Double account) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.nick = nick;
        this.mail = mail;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Double getAccount() {
        return account;
    }

    public void setAccount(Double account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(nick, user.nick) && Objects.equals(mail, user.mail) && Objects.equals(account, user.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, nick, mail, account);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", nick='" + nick + '\'' +
                ", mail='" + mail + '\'' +
                ", account=" + account +
                '}';
    }
}
