package solify.core.meta.solifyx.rest;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import solify.core.meta.solifyx.model.Contactos;
import solify.core.meta.solifyx.service.ContactosService;

@RestController
@RequestMapping("/api/contactos")
@CrossOrigin(origins = "*")
public class ContactosRest {

    private final ContactosService contactosService;

    public ContactosRest(ContactosService contactosService) {
        this.contactosService = contactosService;
    }

    @GetMapping("/codigo/{codigo}")
public Mono<ResponseEntity<?>> getContactosByCodigo(@PathVariable String codigo) {
    return contactosService.findByCodigoPersona(codigo)
        .collectList() 
        .flatMap(contactos -> {
            if (contactos.isEmpty()) {
                return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "Persona no tiene contactos registrados")));
            } else {
                return Mono.just(ResponseEntity.ok(contactos));
            }
        })
        .onErrorReturn(ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "Persona no encontrada")));
}

    @PostMapping
    public Mono<Contactos> createContacto(@RequestBody Contactos contacto) {
        return contactosService.save(contacto);
    }
}
