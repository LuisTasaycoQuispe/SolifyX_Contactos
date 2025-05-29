package solify.core.meta.solifyx.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import solify.core.meta.solifyx.model.User;
import solify.core.meta.solifyx.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Flux<User> findAll() {
        return userRepository.findAll();
    }



    public Mono<User> findByCorreoAndContrasena(String correo, String contrasena) {
    return userRepository.findByCorreoAndContrasena(correo, contrasena);
}

    public Mono<User> findById(Integer id) {
        return userRepository.findById(id);
    }


    public Mono<User> findByCodigo(String codigo) {
        return userRepository.findByCodigo(codigo);
    }
    
    
    public Mono<User> save(User user) {
        return userRepository.save(user);
    }

    public Mono<Void> deleteById(Integer id) {
        return userRepository.deleteById(id);
    }
}
