package solify.core.meta.solifyx.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table("person")
public class User {
    @Id
    private Integer Id;
    private String usuario;
    private String mensaje;
    private String correo;
    private String codigo;
    private String contrasena;
    private String stado;
    
}
