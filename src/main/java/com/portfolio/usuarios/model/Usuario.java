package com.portfolio.usuarios.model;
import jakarta.persistence.*;
@Entity
@Table(name = "usuarios", uniqueConstraints = @UniqueConstraint(name = "uk_usuarios_email", columnNames = "email"))
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 80)
    private String nombre;
    @Column(nullable = false, length = 160, unique = true)
    private String email;
    @Column(nullable = false)
    private Integer edad;
    protected Usuario() {}
    public Usuario(String nombre, String email, Integer edad) {
        this.nombre = nombre; this.email = email; this.edad = edad;
    }
    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public Integer getEdad() { return edad; }
    public void actualizar(String nombre, String email, Integer edad) {
        this.nombre = nombre; this.email = email; this.edad = edad;
    }
}
