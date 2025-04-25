package solify.core.meta.solifyx.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table("contactos")
public class Contactos {
    @Id
    private Integer Id;
    private String apodo;
    private String direccion_eth;
    private Integer personaId;
    private String stado;

}
