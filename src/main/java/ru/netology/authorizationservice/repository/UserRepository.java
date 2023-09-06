package ru.netology.authorizationservice.repository;

import org.springframework.stereotype.Repository;
import ru.netology.authorizationservice.domain.Authorities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Repository
public class UserRepository {
    private ConcurrentMap<String, String> users;
    private final String ADMIN = "admin";
    private final String EDITOR = "editor";
    private final String READER = "reader";

    public UserRepository() {
        this.users = new ConcurrentHashMap<>();
        addUsers();
    }

    private void addUsers() {
        users.put(ADMIN, "123");
        users.put(EDITOR, "456");
        users.put(READER, "789");
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (users.containsKey(user) & password.equals(users.get(user))) {
            switch (user) {
                case ADMIN:
                    return new ArrayList<>(Arrays.asList(Authorities.READ, Authorities.DELETE, Authorities.WRITE));
                case EDITOR:
                    return new ArrayList<>(Arrays.asList(Authorities.READ, Authorities.WRITE));

                case READER:
                    return new ArrayList<>(Arrays.asList(Authorities.READ));

            }
        }
        return new ArrayList<>();
    }
}
