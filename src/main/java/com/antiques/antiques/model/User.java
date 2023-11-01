package com.antiques.antiques.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
@Entity
@Table(name="USERS")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public boolean hasName() {
        return name != null && !"".equals(name.trim());
    }

    public boolean hasSurname() {
        return surname != null && !"".equals(surname.trim());
    }

    public boolean hasMail() {
        return mail != null && !"".equals(mail.trim());
    }

}
