package com.portfolio.usuarios.dto;
import jakarta.validation.constraints.*;
public record UsuarioRequest(
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 80, message = "El nombre debe tener entre 2 y 80 caracteres")
    String nombre,
    @NotBlank(message = "El correo electrónico es obligatorio")
    @Email(message = "El correo electrónico no tiene un formato válido")
    @Size(max = 160, message = "El correo no puede superar los 160 caracteres")
    String email,
    @NotNull(message = "La edad es obligatoria")
    @Min(value = 18, message = "La edad mínima es 18")
    @Max(value = 120, message = "La edad máxima es 120")
    Integer edad
) {}
