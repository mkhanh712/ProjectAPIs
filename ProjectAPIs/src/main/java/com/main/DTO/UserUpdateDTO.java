package com.main.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDTO {
    private String email;
    private String password; 
}
