package com.client.ws.rasmooplus.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRecoveryCodeDto {

    @Email(message = "Campo 'email' precisa conter um email válido")
    @NotBlank(message = "Campo 'email' não pode estar vazio")
    private String email;
}
