package project.fitness.Conroller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.fitness.Services.ActivityService;
import project.fitness.dto.ActivityRequest;
import project.fitness.dto.ActivityResponse;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
@RequiredArgsConstructor
public class ActivityController {
    private final ActivityService activityService;

    @PostMapping("/{userId}")
    public ResponseEntity<ActivityResponse> track(@RequestBody ActivityRequest request) {
        return ResponseEntity.ok(activityService.trackActivity(request));
    }


//    this method is made by me
//    @GetMapping("/user/{id}")
//    public ResponseEntity<List<ActivityResponse>> RetriveActivity(@PathVariable("id") String userId)
//    {
//        return ResponseEntity.ok(activityService.retriveActivity(userId));
//    }


//    two concepts we learn first request header and the custom repo method

    @GetMapping
    public ResponseEntity<List<ActivityResponse>> getUserActivities(@RequestHeader("X-User-ID") String userId) {
        return ResponseEntity.ok(activityService.getUserActivities(userId));
    }

}
