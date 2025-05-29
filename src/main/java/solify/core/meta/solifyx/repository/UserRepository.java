package solify.core.meta.solifyx.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Mono;
import solify.core.meta.solifyx.model.User;

public interface UserRepository extends ReactiveCrudRepository<User, Integer> {

    Mono<User> findByCodigo(String codigo);
    Mono<User> findByCorreoAndContrasena(String correo, String contrasena);
}
