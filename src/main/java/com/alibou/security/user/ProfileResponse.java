package com.alibou.security.user;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ProfileResponse {
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private Role role;
}
