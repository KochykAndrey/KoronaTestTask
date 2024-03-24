package by.kochyk.KoronaTestTask.service;

import by.kochyk.KoronaTestTask.domain.User;
import by.kochyk.KoronaTestTask.domain.exception.UserException;
import by.kochyk.KoronaTestTask.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserException("Invalid user ID"));
    }

}
