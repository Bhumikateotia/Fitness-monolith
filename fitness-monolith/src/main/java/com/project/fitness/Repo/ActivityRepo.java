package project.fitness.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import project.fitness.model.Activity;

import java.util.List;

public interface ActivityRepo extends JpaRepository<Activity, String> {
    List<Activity> findByUserId(String userId);
}
