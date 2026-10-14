package com.portfolio.usuarios.controller;
import com.portfolio.usuarios.dto.UsuarioRequest;
import com.portfolio.usuarios.model.Usuario;
import com.portfolio.usuarios.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final UsuarioService service;
    public UsuarioController(UsuarioService service) { this.service = service; }
    @GetMapping public List<Usuario> listar() { return service.listar(); }
    @GetMapping("/{id}") public Usuario buscarPorId(@PathVariable Long id) { return service.buscarPorId(id); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public Usuario crear(@Valid @RequestBody UsuarioRequest request) { return service.crear(request); }
    @PutMapping("/{id}")
    public Usuario actualizar(@PathVariable Long id, @Valid @RequestBody UsuarioRequest request) {
        return service.actualizar(id, request);
    }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) { service.eliminar(id); }
}
