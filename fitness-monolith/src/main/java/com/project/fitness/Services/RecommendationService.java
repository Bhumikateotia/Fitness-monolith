package project.fitness.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.fitness.Conroller.dto.RecommendationRequest;
import project.fitness.Repo.ActivityRepo;
import project.fitness.Repo.RecommendationRepo;
import project.fitness.Repo.UserRepository;
import project.fitness.model.Activity;
import project.fitness.model.Recommendation;
import project.fitness.model.User;

@Service
@RequiredArgsConstructor
public class RecommendationService {
    private final UserRepository userRepository;
    private final ActivityRepo activityRepo;
    private final RecommendationRepo recommendationRepo;

    public Recommendation generateRecommendation(RecommendationRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("user not found" + request.getUserId()));
        Activity activity = activityRepo.findById(request.getActivityId())
                .orElseThrow(() -> new RuntimeException("user not found" + request.getActivityId()));
        Recommendation recommendation = Recommendation.builder()
                .user(user)
                .activity(activity)
                .Improvements(request.getImprovements())
                .suggestions(request.getSuggestions())
                .safety(request.getSafety())
                .build();
//        Recommendation savedRecommendation=
        return recommendationRepo.save(recommendation);
    }
}
