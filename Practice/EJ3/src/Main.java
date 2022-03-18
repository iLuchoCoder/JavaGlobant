import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        ArrayList Vehiculos = new ArrayList();

        Scanner lector=new Scanner(System.in);

        while (true) {
            System.out.println("**********************************************************************");
            System.out.println("Digite 1, 2 o 3 segun sea su preferencia");
            System.out.println("1 - Agregar vehiculo al Array");
            System.out.println("2 - Ver vehiculos");
            System.out.println("3 - Salir");
            System.out.println("**********************************************************************");
            String ans = lector.nextLine();
            if(ans.equals("3")){
                break;
            }
            else{
                if(ans.equals("1"))
                {
                    Vehiculo novo = new Vehiculo();
                    System.out.println("Escriba el tipo de Vehiculo: Estandar, Cabriolet, Campero, Bus");
                    ans = lector.nextLine();
                    novo.setTipoVehiculo(ans);
                    System.out.println("Digite la intensidad del 1 al 10 del pito");
                    ans = lector.nextLine();
                    novo.setIntensidadPito(Integer.parseInt(ans));
                    System.out.println("Digite la intensidad del 1 al 10 del acelerador");
                    ans = lector.nextLine();
                    novo.setIntensidadAcelerar(Integer.parseInt(ans));
                    System.out.println("Digite la intensidad del 1 al 10 del freno");
                    ans = lector.nextLine();
                    novo.setIntensidadFrenar(Integer.parseInt(ans));
                    System.out.println("Digite true o false, si tiene doble traccion");
                    ans = lector.nextLine();
                    novo.setTieneDobleTrac(ans);
                    System.out.println("Digite true o false, si remueve el techo");
                    ans = lector.nextLine();
                    novo.setRemoverTecho(ans);
                    System.out.println("Digite true o false, si pone el techo");
                    ans = lector.nextLine();
                    novo.setPonerTecho(ans);
                    Vehiculos.add(novo);
                }
                if(ans.equals("2")){
                    for (int i=0;i< Vehiculos.size();i++) {
                        System.out.println("**" + "ID-" + i + "**");
                        Vehiculo temp = (Vehiculo) Vehiculos.get(i);
                        System.out.println(temp.toString());
                        System.out.println("****************");
                    }
                    Thread.sleep(5000);
                }
            }
        }
    }
}
