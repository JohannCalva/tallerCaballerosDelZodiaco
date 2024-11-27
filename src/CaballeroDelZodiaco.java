public class CaballeroDelZodiaco {
    private int id;
    private String nombre;
    private String rango; //Bronce, plata, oro
    private String constelacion;
    private int nivelDePoder; //Valor entre 1 y 10
    private String misionAsignada;
    private int nivelDeDificultadMision; //Valor entre 1 y 5
    private double recompensaPorMision; //Monedas doradas

    public CaballeroDelZodiaco(int id, String nombre, String rango, String constelacion, int nivelDePoder, String misionAsignada, int nivelDeDificultadMision, double recompensaPorMision) {
        this.id = id;
        this.nombre = nombre;
        this.rango = rango;
        this.constelacion = constelacion;
        this.nivelDePoder = nivelDePoder;
        this.misionAsignada = misionAsignada;
        this.nivelDeDificultadMision = nivelDeDificultadMision;
        this.recompensaPorMision = recompensaPorMision;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public String getConstelacion() {
        return constelacion;
    }

    public void setConstelacion(String constelacion) {
        this.constelacion = constelacion;
    }

    public int getNivelDePoder() {
        return nivelDePoder;
    }

    public void setNivelDePoder(int nivelDePoder) {
        this.nivelDePoder = nivelDePoder;
    }

    public String getMisionAsignada() {
        return misionAsignada;
    }

    public void setMisionAsignada(String misionAsignada) {
        this.misionAsignada = misionAsignada;
    }

    public int getNivelDeDificultadMision() {
        return nivelDeDificultadMision;
    }

    public void setNivelDeDificultadMision(int nivelDeDificultadMision) {
        this.nivelDeDificultadMision = nivelDeDificultadMision;
    }

    public double getRecompensaPorMision() {
        return recompensaPorMision;
    }

    public void setRecompensaPorMision(double recompensaPorMision) {
        this.recompensaPorMision = recompensaPorMision;
    }

    public double calcularAporteAlFondoSantuario(){
        return recompensaPorMision * 0.10;
    }

    public double calcularImpuestoReinoAtena(){
        double recompensaAnual = recompensaPorMision;
        double impuesto;
        if(recompensaAnual > 200000){
            if(recompensaAnual <= 400000){
                impuesto = recompensaAnual * 0.25;
            }else{
                impuesto = recompensaAnual * 0.35;
            }
        }else{
            if(recompensaAnual > 100000){
                impuesto = recompensaAnual * 0.12;
            }else{
                impuesto = 0;
            }
        }
        return impuesto;
    }

    public double calcularRecompensaNeta(){
        double aporte = calcularAporteAlFondoSantuario();
        double impuesto = calcularImpuestoReinoAtena();
        return recompensaPorMision - aporte - impuesto;
    }
}
