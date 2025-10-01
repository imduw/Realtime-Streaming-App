package com.vku.app.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreationRequest {
    private String name;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
}
