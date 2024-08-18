package dev.alfrendosilalahi.common.dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersResponseDTO {

    private List<UserResponseDTO> users;

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class UserResponseDTO {

        private String username;

        private String email;

    }

}
