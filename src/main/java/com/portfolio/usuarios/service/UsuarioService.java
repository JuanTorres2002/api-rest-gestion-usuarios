package com.portfolio.usuarios.service;
import com.portfolio.usuarios.dto.UsuarioRequest;
import com.portfolio.usuarios.model.Usuario;
import com.portfolio.usuarios.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
@Service
public class UsuarioService {
    private final UsuarioRepository repository;
    public UsuarioService(UsuarioRepository repository) { this.repository = repository; }
    public List<Usuario> listar() { return repository.findAll(); }
    public Usuario buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe un usuario con ese ID"));
    }
    public Usuario crear(UsuarioRequest request) {
        String email = request.email().trim().toLowerCase();
        if (repository.existsByEmailIgnoreCase(email)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ya existe un usuario con ese correo electrónico");
        }
        return repository.save(new Usuario(request.nombre().trim(), email, request.edad()));
    }
    public Usuario actualizar(Long id, UsuarioRequest request) {
        Usuario usuario = buscarPorId(id);
        String email = request.email().trim().toLowerCase();
        if (repository.existsByEmailIgnoreCase(email) && !usuario.getEmail().equalsIgnoreCase(email)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ya existe un usuario con ese correo electrónico");
        }
        usuario.actualizar(request.nombre().trim(), email, request.edad());
        return repository.save(usuario);
    }
    public void eliminar(Long id) { repository.delete(buscarPorId(id)); }
}
