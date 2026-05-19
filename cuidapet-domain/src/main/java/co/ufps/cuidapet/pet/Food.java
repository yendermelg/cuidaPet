package co.ufps.cuidapet.pet;

public class Food {
    private Marca marca;
    private TipoComida tipo;
    private int cantidadDiaria;
    private String unidadMedida;
    private String horario;

    public Food(Marca marca,
                TipoComida tipo,
                int cantidadDiaria,
                String unidadMedida,
                String horario) {
        this.marca = marca;
        this.tipo = tipo;
        this.cantidadDiaria = cantidadDiaria;
        this.unidadMedida = unidadMedida;
        this.horario = horario;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public TipoComida getTipo() {
        return tipo;
    }

    public void setTipo(TipoComida tipo) {
        this.tipo = tipo;
    }

    public int getCantidadDiaria() {
        return cantidadDiaria;
    }

    public void setCantidadDiaria(int cantidadDiaria) {
        this.cantidadDiaria = cantidadDiaria;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Marca: " + this.marca + "\n" +
                "Tipo: " + this.tipo + "\n" +
                "Cantidad Diario: " + this.cantidadDiaria + "\n" +
                "Unidad de Medida: " + this.unidadMedida + "\n" +
                "Horario: " + horario;
    }
}
