package org.spree.core.users;

import java.time.LocalDate;
import java.util.Calendar;

import static java.time.LocalDate.now;
import static java.time.Period.between;

public class JpaUser implements User {


    private String id;
    private String name;
    private String password;
    private Calendar birthDate;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public int age() {
        return between(now(), LocalDate.from(birthDate.toInstant())).getYears();
    }

    @Override
    public int longitude() {
        return 0;
    }

    @Override
    public int latitude() {
        return 0;
    }

    @Override
    public void setToken(String token) {

    }

    @Override
    public String getToken() {
        return null;
    }
}
