package project.fitness.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.fitness.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
