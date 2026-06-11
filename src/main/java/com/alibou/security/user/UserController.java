package com.alibou.security.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PatchMapping
    public ResponseEntity<?> changePassword(
          @RequestBody ChangePasswordRequest request,
          Principal connectedUser
    ) {
        service.changePassword(request, connectedUser);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/profile")
    public ResponseEntity<ProfileResponse> getProfile(Principal connectedUser) {
        System.out.println("This is working");
        return ResponseEntity.ok(service.getProfile(connectedUser));
    }

    @PatchMapping("/profile")
    public ResponseEntity<?> changePassword(@RequestBody UpdateProfileRequest request,
                                            Principal connectedUser){
        return ResponseEntity.ok(
                service.updateProfile(request, connectedUser));
    }
}
