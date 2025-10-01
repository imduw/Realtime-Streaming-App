package com.vku.app.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateRequest {
    private String name;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
}
