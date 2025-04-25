package solify.core.meta.solifyx.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import solify.core.meta.solifyx.model.Contactos;

public interface ContactosRepository extends ReactiveCrudRepository<Contactos, Integer> {
    Flux<Contactos> findByPersonaId(Integer personaId);  

    @Query("SELECT * FROM contactos WHERE persona_id IN (SELECT id FROM person WHERE codigo = :codigo)")
    Flux<Contactos> findByCodigoPersona(String codigo);
}
