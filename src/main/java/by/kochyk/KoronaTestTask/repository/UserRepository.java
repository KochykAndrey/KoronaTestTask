package by.kochyk.KoronaTestTask.repository;

import by.kochyk.KoronaTestTask.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}