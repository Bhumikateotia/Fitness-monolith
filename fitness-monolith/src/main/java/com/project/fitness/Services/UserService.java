package project.fitness.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.fitness.Repo.UserRepository;
import project.fitness.dto.RegisterRequest;
import project.fitness.dto.UserResponse;
import project.fitness.model.User;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserResponse register(RegisterRequest registerRequest) {
//        create the user object automatically and we can write the field in any order but in constructor their is fixed order sequence
        User user = User.builder()
                .email(registerRequest.getEmail())
                .password(registerRequest.getPassword())
                .firstname(registerRequest.getFirstname())
                .lastname(registerRequest.getLastname())

                .build();
//        User user= new User(
//                "X01",
//                registerRequest.getEmail(),
//                registerRequest.getPassword(),
//                registerRequest.getFirstname(),
//                registerRequest.getLastname(),
//                Instant.parse("2025-12-08T14:49:41.208Z").atZone(ZoneOffset.UTC).toLocalDateTime(),
//                Instant.parse("2025-12-08T14:49:41.208Z").atZone(ZoneOffset.UTC).toLocalDateTime(),
//                List.of(),
//                List.of()
//
//        );
        User savedUser = userRepository.save(user);
        return mapToResponse(savedUser);
    }

    private UserResponse mapToResponse(User savedUser) {
        UserResponse response = new UserResponse();
        response.setId(savedUser.getId());
        response.setEmail(savedUser.getEmail());
        response.setPassword(savedUser.getPassword());
        response.setFirstname(savedUser.getFirstname());
        response.setLastname(savedUser.getLastname());
        response.setCreatedAt(savedUser.getCreatedAt());
        response.setUpdatedAt(savedUser.getUpdatedAt());
        return response;

    }

//    this is my own method


}
