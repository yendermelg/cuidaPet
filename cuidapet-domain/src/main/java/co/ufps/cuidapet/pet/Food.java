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

    public static Food of(String foodText) {

        String[] partes = foodText.split("\n");

        Marca marca = Marca.valueOf(
                partes[0].replace("Marca: ", "")
                        .trim()
                        .toUpperCase()
        );

        TipoComida tipo = TipoComida.valueOf(
                partes[1].replace("Tipo: ", "")
                        .trim()
                        .toUpperCase()
        );

        int cantidadDiaria = Integer.parseInt(
                partes[2].replace("Cantidad Diario: ", "")
                        .trim()
        );

        String unidadMedida = partes[3]
                .replace("Unidad de Medida: ", "")
                .trim();

        String horario = partes[4]
                .replace("Horario: ", "")
                .trim();

        return new Food(
                marca,
                tipo,
                cantidadDiaria,
                unidadMedida,
                horario
        );
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
