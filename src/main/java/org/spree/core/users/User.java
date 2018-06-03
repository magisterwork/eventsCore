package org.spree.core.users;

public interface User {

    String getId();
    String getName();
    String getPassword();
    int age();
    int longitude();
    int latitude();

    void setToken(String token);
    String getToken();
}
