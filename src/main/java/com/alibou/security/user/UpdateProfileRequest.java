package com.alibou.security.user;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UpdateProfileRequest {
    private String firstname;
    private String lastname;
}
