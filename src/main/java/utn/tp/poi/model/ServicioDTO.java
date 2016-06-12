package utn.tp.poi.model;

import java.util.Set;

public class ServicioDTO {
    private String nombre;
    private Set<ServicioDTO.Horario> horarios;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(Set<Horario> horarios) {
        this.horarios = horarios;
    }

    public static class Horario {
        private int diaSemana;
        private int horaDesde;
        private int minutosDesde;
        private int horaHasta;
        private int minutosHasta;

        public int getDiaSemana() {
            return diaSemana;
        }

        public void setDiaSemana(int diaSemana) {
            this.diaSemana = diaSemana;
        }

        public int getHoraDesde() {
            return horaDesde;
        }

        public void setHoraDesde(int horarioDesde) {
            this.horaDesde = horarioDesde;
        }

        public int getMinutosDesde() {
            return minutosDesde;
        }

        public void setMinutosDesde(int minutosDesde) {
            this.minutosDesde = minutosDesde;
        }

        public int getHoraHasta() {
            return horaHasta;
        }

        public void setHoraHasta(int horarioHasta) {
            this.horaHasta = horarioHasta;
        }

        public int getMinutosHasta() {
            return minutosHasta;
        }

        public void setMinutosHasta(int minutosHasta) {
            this.minutosHasta = minutosHasta;
        }

    }

}
