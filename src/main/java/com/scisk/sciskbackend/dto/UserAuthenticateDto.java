package com.scisk.sciskbackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthenticateDto {

    @Schema(description = "Email de l'utilisateur")
    private String email;

    @Schema(description = "Mot de passe de l'utilisateur")
    private String password;
}
