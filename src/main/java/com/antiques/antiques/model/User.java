package com.antiques.antiques.model;

import java.math.BigDecimal;
import java.util.Objects;

public class User {

    private int id;
    private String name;
    private String surname;
    private int age;
    private String nick;
    private String mail;
    private BigDecimal account;

    public User() {
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

    public BigDecimal getAccount() {
        return account;
    }

    public void setAccount(BigDecimal account) {
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
}
