package by.kochyk.KoronaTestTask.service;

import by.kochyk.KoronaTestTask.domain.User;

import java.util.List;

public interface UserService {

    public List<User> getUsers();

    User createUser(User user);

    User getUserById(Long userId);

}
