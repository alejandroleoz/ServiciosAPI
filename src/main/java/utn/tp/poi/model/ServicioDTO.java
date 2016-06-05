package utn.tp.poi.model;

public class ServicioDTO {
    private int diaSemana;
    private int horarioDesde;
    private int minutosDesde;
    private int horarioHasta;
    private int minutosHasta;

    public int getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(int diaSemana) {
        this.diaSemana = diaSemana;
    }

    public int getHorarioDesde() {
        return horarioDesde;
    }

    public void setHorarioDesde(int horarioDesde) {
        this.horarioDesde = horarioDesde;
    }

    public int getMinutosDesde() {
        return minutosDesde;
    }

    public void setMinutosDesde(int minutosDesde) {
        this.minutosDesde = minutosDesde;
    }

    public int getHorarioHasta() {
        return horarioHasta;
    }

    public void setHorarioHasta(int horarioHasta) {
        this.horarioHasta = horarioHasta;
    }

    public int getMinutosHasta() {
        return minutosHasta;
    }

    public void setMinutosHasta(int minutosHasta) {
        this.minutosHasta = minutosHasta;
    }
}
