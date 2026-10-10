package project.fitness.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.fitness.Repo.ActivityRepo;
import project.fitness.Repo.UserRepository;
import project.fitness.dto.ActivityRequest;
import project.fitness.dto.ActivityResponse;
import project.fitness.model.Activity;
import project.fitness.model.User;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityService {
    private final ActivityRepo activityRepo;
    private final UserRepository userRepository;

    public ActivityResponse trackActivity(ActivityRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("invalid user" + request.getUserId()));
        Activity activity = Activity.builder()
                .type(request.getType())
                .user(user)
                .duration(request.getDuration())
                .caloriesBurned(request.getCaloriesBurned())
                .startTime(request.getStartTime())
                .additionalMetrices(request.getAdditionalMetrics())
                .build();
        Activity savedActivity = activityRepo.save(activity);
        return mapToResponse(savedActivity);
    }

    private ActivityResponse mapToResponse(Activity activity) {
        ActivityResponse response = new ActivityResponse();
        response.setId(activity.getId());
        response.setUserId(activity.getUser().getId());
        response.setType(activity.getType());
        response.setDuration(activity.getDuration());
        response.setCaloriesBurned(activity.getCaloriesBurned());
        response.setStartTime(activity.getStartTime());
        response.setAdditionalMetrics(activity.getAdditionalMetrices());
        response.setCreatedAt(activity.getCreatedAt());
        response.setUpdatedAt(activity.getUpdatedAt());
        // set the other fields from your Activity entity
        return response;
    }


//    this method is made by me
//    public List<ActivityResponse> retriveActivity(String userId)
//
//    {
//       return activityRepo.findByUserId(userId)
//        .stream()
//        .map(this::mapToResponse)
//        .toList();
//
//    }

    public List<ActivityResponse> getUserActivities(String userId) {
        List<Activity> activityList = activityRepo.findByUserId(userId);
        return activityList.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());

    }
}
