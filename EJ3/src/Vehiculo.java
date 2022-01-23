public class Vehiculo {

    public String tipoVehiculo;
    public int pitar;
    public int acelerar;
    public int frenar;
    public String dobletrac;
    public String retecho;
    public String potecho;

    public void setTipoVehiculo(String tipoV){
        tipoVehiculo = tipoV;
    }

    public String getTipoVehiculo(){
        return tipoVehiculo;
    }

    public void setIntensidadPito(int intPito){
        pitar = intPito;
    }

    public int getIntensidadPito(){
        return pitar;
    }

    public void setIntensidadAcelerar(int intAcelerar){
        acelerar = intAcelerar;
    }

    public int getIntensidadAcelerar(){
        return acelerar;
    }

    public void setIntensidadFrenar(int intFrenar){
        frenar = intFrenar;
    }

    public int getIntensidadFrenar(){
        return frenar;
    }

    public void setTieneDobleTrac(String boolDT){
        dobletrac = boolDT;
    }

    public String getTieneDobleTrac(){
        return dobletrac;
    }

    public void setRemoverTecho(String boolRT){
        retecho = boolRT;
    }

    public String getRemoverTecho(){
        return retecho;
    }

    public void setPonerTecho(String boolPT){
        potecho = boolPT;
    }

    public String getPonerTecho(){
        return potecho;
    }

    public String toString(){
        return "["+tipoVehiculo+","+pitar+","+acelerar+","+frenar+","+dobletrac+","+retecho+","+potecho+"]";
    }
}
