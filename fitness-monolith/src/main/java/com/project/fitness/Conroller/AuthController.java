package project.fitness.Conroller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.fitness.Services.UserService;
import project.fitness.dto.RegisterRequest;
import project.fitness.dto.UserResponse;

//define end points for business logic
@RestController
//define this mapping at controller level not to define with each every method
@RequestMapping("/api/auth")
//initialize all the constructor
//@AllArgsConstructor
//only final constructor are initialize we dont need manually to generate the cons
@RequiredArgsConstructor
public class AuthController {
    private final UserService userservice;

    @PostMapping("/register")
//    wrap in the user response entity
//    public UserResponse register(@RequestBody RegisterRequest registerRequest)
//    {
//        return userservice.register(registerRequest);
//    }
    public ResponseEntity<UserResponse> register(@RequestBody RegisterRequest registerRequest) {
        return ResponseEntity.ok(userservice.register(registerRequest));
    }
//    this is my own apii
//    @PostMapping("/Activities")
//    public UserResponse track(@RequestBody Activity activity)
//    {
//        return userservice.track_Activity(activity);
//    }
}
