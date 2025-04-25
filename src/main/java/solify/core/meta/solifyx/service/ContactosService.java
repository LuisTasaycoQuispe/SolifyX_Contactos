package solify.core.meta.solifyx.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import solify.core.meta.solifyx.model.Contactos;
import solify.core.meta.solifyx.repository.ContactosRepository;

@Service
public class ContactosService {

    private final ContactosRepository contactosRepository;

    public ContactosService(ContactosRepository contactosRepository) {
        this.contactosRepository = contactosRepository;
    }

    public Flux<Contactos> findByCodigoPersona(String codigo) {
        return contactosRepository.findByCodigoPersona(codigo);
    }
    

    public Mono<Contactos> save(Contactos contacto) {
        return contactosRepository.save(contacto);
    }
}
