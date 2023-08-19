//data precip maxima minima horas_insol temp_media um_relativa vel_vento
public class RegistroDoTempo {
    private int dia;
    private int mes;
    private int ano;
    private double precipitacao;
    private double tempMaxima;
    private double tempMinima;
    private double horasInsolacao;
    private double temperaturaMedia;
    private double umidadeRelativaDoAr;
    private double velocidadeDoVento;
    
    public RegistroDoTempo(int dia, int mes, int ano, double precipitacao, double tempMaxima, double tempMinima,
            double horasInsolacao, double temperaturaMedia, double umidadeRelativaDoAr, double velocidadeDoVento) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.precipitacao = precipitacao;
        this.tempMaxima = tempMaxima;
        this.tempMinima = tempMinima;
        this.horasInsolacao = horasInsolacao;
        this.temperaturaMedia = temperaturaMedia;
        this.umidadeRelativaDoAr = umidadeRelativaDoAr;
        this.velocidadeDoVento = velocidadeDoVento;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getPrecipitacao() {
        return precipitacao;
    }

    public void setPrecipitacao(double precipitacao) {
        this.precipitacao = precipitacao;
    }

    public double getTempMaxima() {
        return tempMaxima;
    }

    public void setTempMaxima(double tempMaxima) {
        this.tempMaxima = tempMaxima;
    }

    public double getTempMinima() {
        return tempMinima;
    }

    public void setTempMinima(double tempMinima) {
        this.tempMinima = tempMinima;
    }

    public double getHorasInsolacao() {
        return horasInsolacao;
    }

    public void setHorasInsolacao(double horasInsolacao) {
        this.horasInsolacao = horasInsolacao;
    }

    public double getTemperaturaMedia() {
        return temperaturaMedia;
    }

    public void setTemperaturaMedia(double temperaturaMedia) {
        this.temperaturaMedia = temperaturaMedia;
    }

    public double getUmidadeRelativaDoAr() {
        return umidadeRelativaDoAr;
    }

    public void setUmidadeRelativaDoAr(double umidadeRelativaDoAr) {
        this.umidadeRelativaDoAr = umidadeRelativaDoAr;
    }

    public double getVelocidadeDoVento() {
        return velocidadeDoVento;
    }

    public void setVelocidadeDoVento(double velocidadeDoVento) {
        this.velocidadeDoVento = velocidadeDoVento;
    }

    @Override
    public String toString() {
        return "RegistroDoTempo [ano=" + ano + ", dia=" + dia + ", horasInsolacao=" + horasInsolacao + ", mes=" + mes
                + ", precipitacao=" + precipitacao 
                + ", temperatura Maxima=" + tempMaxima + ", temperatura Minima=" + tempMinima
                + ", temperaturaMedia=" + temperaturaMedia + ", umidadeRelativaDoAr=" + umidadeRelativaDoAr
                + ", velocidadeDoVento=" + velocidadeDoVento + "]";
    }    
}
