
package solify.core.meta.solifyx.rest;

import java.util.Map;
import reactor.core.publisher.Mono;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import solify.core.meta.solifyx.model.User;
import solify.core.meta.solifyx.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserRest {

    private final UserService userService;

    public UserRest(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public Mono<User> login(@RequestParam String correo, @RequestParam String contrasena) {
        return userService.findByCorreoAndContrasena(correo, contrasena);
    }

    @GetMapping
    public Flux<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<User>> getUserById(@PathVariable Integer id) {
        return userService.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping("/registrar")
    public Mono<User> createUser(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/codigo/{codigo}")
    public Mono<ResponseEntity<?>> getUserByCodigo(@PathVariable String codigo) {
        return userService.findByCodigo(codigo)
                .map(user -> ResponseEntity.ok(user));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<User>> updateUser(@PathVariable Integer id, @RequestBody User user) {
        return userService.findById(id)
                .flatMap(existing -> {
                    user.setId(id);
                    return userService.save(user);
                })
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

}
