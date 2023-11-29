package net.atos.proyecto_atos.excepciones;

import org.springframework.http.HttpStatus;

public class BlogAppException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private HttpStatus estado;
    private String mensaje;

    public BlogAppException(HttpStatus estado, String mensaje) {
        super();
        this.estado = estado;
        this.mensaje = mensaje;
    }

    public BlogAppException(HttpStatus estado, String mensaje, String mensaje1) {
        super();
        this.estado = estado;
        this.mensaje = mensaje1;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public HttpStatus getEstado() {
        return estado;
    }

    public void setEstado(HttpStatus estado) {
        this.estado = estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}

