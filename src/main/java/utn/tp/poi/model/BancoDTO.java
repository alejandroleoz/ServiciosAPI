package utn.tp.poi.model;

import java.util.Set;

public class BancoDTO {
    private String banco;
    private double x;
    private double y;
    private String sucursal;
    private String gerente;
    private Set<String> servicios;

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }

    public Set<String> getServicios() {
        return servicios;
    }

    public void setServicios(Set<String> servicios) {
        this.servicios = servicios;
    }
}
