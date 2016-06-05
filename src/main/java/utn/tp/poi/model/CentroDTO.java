package utn.tp.poi.model;

import java.util.Set;

public class CentroDTO {
    private int comuna;
    private String zonas;
    private String director;
    private String domicilio;
    private String telefono;
    private Set<ServicioDTO> servicios;

    public int getComuna() {
        return comuna;
    }

    public void setComuna(int comuna) {
        this.comuna = comuna;
    }

    public String getZonas() {
        return zonas;
    }

    public void setZonas(String zonas) {
        this.zonas = zonas;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Set<ServicioDTO> getServicios() {
        return servicios;
    }

    public void setServicios(Set<ServicioDTO> servicios) {
        this.servicios = servicios;
    }
}
