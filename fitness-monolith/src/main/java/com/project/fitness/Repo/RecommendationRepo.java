package project.fitness.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.fitness.model.Recommendation;

@Repository
public interface RecommendationRepo extends JpaRepository<Recommendation, String> {
}
