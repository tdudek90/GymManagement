package pl.tomekdudek.GymManagement.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tomekdudek.GymManagement.model.User;

import java.util.Optional;

/**
 * Created by Tomek on 2017-11-06.
 */
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByName(String name);
}
