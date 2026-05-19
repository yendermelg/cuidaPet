package co.ufps.cuidapet.pet;

public class Hygiene {
    private Frecuencia frecuenciaDucha;
    private Frecuencia cuidadoDental;
    private Frecuencia limpiezaOidos;
    private Frecuencia frecuenciaCepillado;
    private String recomendaciones;

    public Hygiene(Frecuencia frecuenciaBano,
                   Frecuencia cuidadoDental,
                   Frecuencia limpiezaOidos,
                   Frecuencia cepillado,
                   String recomendaciones) {
        this.frecuenciaDucha = frecuenciaBano;
        this.cuidadoDental = cuidadoDental;
        this.limpiezaOidos = limpiezaOidos;
        this.frecuenciaCepillado = cepillado;
        this.recomendaciones = recomendaciones;
    }

    public Frecuencia getFrecuenciaDucha() {
        return frecuenciaDucha;
    }

    public void setFrecuenciaDucha(Frecuencia frecuenciaDucha) {
        this.frecuenciaDucha = frecuenciaDucha;
    }

    public Frecuencia getCuidadoDental() {
        return cuidadoDental;
    }

    public void setCuidadoDental(Frecuencia cuidadoDental) {
        this.cuidadoDental = cuidadoDental;
    }

    public Frecuencia getLimpiezaOidos() {
        return limpiezaOidos;
    }

    public void setLimpiezaOidos(Frecuencia limpiezaOidos) {
        this.limpiezaOidos = limpiezaOidos;
    }

    public Frecuencia getFrecuenciaCepillado() {
        return frecuenciaCepillado;
    }

    public void setFrecuenciaCepillado(Frecuencia frecuenciaCepillado) {
        this.frecuenciaCepillado = frecuenciaCepillado;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public static Hygiene of(String hygieneText) {

        String[] partes = hygieneText.split("\n");

        Frecuencia frecuenciaDucha = Frecuencia.valueOf(
                partes[0]
                        .replace("Frecuencia Ducha: ", "")
                        .trim()
                        .toUpperCase()
        );

        Frecuencia cuidadoDental = Frecuencia.valueOf(
                partes[1]
                        .replace("Cuidado Dental: ", "")
                        .trim()
                        .toUpperCase()
        );

        Frecuencia limpiezaOidos = Frecuencia.valueOf(
                partes[2]
                        .replace("Limpieza Oidos: ", "")
                        .trim()
                        .toUpperCase()
        );

        Frecuencia frecuenciaCepillado = Frecuencia.valueOf(
                partes[3]
                        .replace("Frecuencia Cepillado: ", "")
                        .trim()
                        .toUpperCase()
        );

        String recomendaciones = partes[4]
                .replace("Recomendaciones: ", "")
                .trim();

        return new Hygiene(
                frecuenciaDucha,
                cuidadoDental,
                limpiezaOidos,
                frecuenciaCepillado,
                recomendaciones
        );
    }

    @Override
    public String toString() {
        return "Frecuencia Ducha: " + this.getFrecuenciaDucha() + "\n" +
                "Cuidado Dental: " + this.getCuidadoDental() + "\n" +
                "Limpieza Oidos: " + this.getLimpiezaOidos() + "\n" +
                "Frecuencia Cepillado: " + this.getFrecuenciaCepillado() + "\n" +
                "Recomendaciones: " + this.getRecomendaciones();
    }
}
