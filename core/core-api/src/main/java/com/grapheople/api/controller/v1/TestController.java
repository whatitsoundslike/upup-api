package com.grapheople.api.controller.v1;

import com.grapheople.domain.user.db.service.UserDBService;
import com.grapheople.domain.user.enums.Gender;
import com.grapheople.domain.user.enums.Country;
import com.grapheople.domain.user.enums.SocialLoginProvider;
import com.grapheople.domain.user.vo.User;
import com.grapheople.domain.workout.db.service.WorkoutDBService;
import com.grapheople.domain.workout.enums.WorkoutType;
import com.grapheople.domain.workout.vo.Workout;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final UserDBService userDBService;
    private final WorkoutDBService workoutDBService;

    @GetMapping("/api/v1/test/setup")
    public String setup() {
        // Create Users
        User user1 = User.builder()
                .name("홍길동")
                .nickname("길동")
                .email("gildong@example.com")
                .birthDate(LocalDate.of(1990, 1, 1))
                .gender(Gender.MALE)
                .country(Country.REPUBLIC_OF_KOREA)
                .socialLoginProvider(SocialLoginProvider.GOOGLE)
                .socialLoginProviderId("google-uid-001")
                .build();
        userDBService.save(user1);

        User user2 = User.builder()
                .name("김영희")
                .nickname("영희")
                .email("younghee@example.com")
                .birthDate(LocalDate.of(1992, 5, 10))
                .gender(Gender.FEMALE)
                .country(Country.REPUBLIC_OF_KOREA)
                .socialLoginProvider(SocialLoginProvider.APPLE)
                .socialLoginProviderId("apple-uid-002")
                .build();
        userDBService.save(user2);

        // Create Workouts
        workoutDBService.save(Workout.builder()
                .name("걷기")
                .workoutType(WorkoutType.WALKING)
                .build());

        workoutDBService.save(Workout.builder()
                .name("러닝")
                .workoutType(WorkoutType.RUNNING)
                .build());

        workoutDBService.save(Workout.builder()
                .name("싸이클")
                .workoutType(WorkoutType.CYCLING)
                .build());

        workoutDBService.save(Workout.builder()
                .name("하이킹")
                .workoutType(WorkoutType.HIKING)
                .build());

        return "Setup completed";
    }
}
