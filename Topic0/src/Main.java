/**
 * Main de la aplicacion
 * @autor Ing. Luis Pineda
 * @version 1.0
 * @since JDK 17.0.1
 */

import Exceptions.MemoryOverflowExeption;
import Models.App;
import Models.Mem;
import Models.Sys;

import java.util.Scanner;

public class Main {
    // Consecutivos de Aplicacion y Sistema
    static int conseActApp = 1;
    static int conseActSys = 1;

    public static void menu(){
        System.out.println("**********************************************************************");
        System.out.println("CA - Crear proceso Aplicacion");
        System.out.println("CS - Crear proceso Sistema");
        System.out.println("D + ID Proceso - Para eliminar el proceso");
        System.out.println("SALIR - Para terminar aplicacion");
        System.out.println("Escribe el comando:");
        System.out.println("**********************************************************************");
    }

    public static void main(String[] args) throws MemoryOverflowExeption{
        Mem memory = new Mem();
        memory.inicializarMemoria();
        Scanner lector=new Scanner(System.in);
        while(true){
            try{
                menu();
                String ans = lector.nextLine();
                if(ans.toUpperCase().equals("SALIR")){
                    break;
                }
                else{
                    if(ans.toUpperCase().equals("CA")){
                        App napp = new App();
                        int tamApp = napp.tamProceso();
                        String nomApp = napp.conseProc(conseActApp);
                        if(tamApp>memory.memDisponible()){
                            throw new MemoryOverflowExeption("Memoria llena, libera espacio");
                        }
                        else{

                            memory.agregarProcesoApp(tamApp,nomApp);
                            conseActApp++;
                            memory.mostrarMemoria();
                        }
                    }
                    if(ans.toUpperCase().equals("CS")){
                        Sys nsys = new Sys();
                        int tamSys = nsys.tamProceso();
                        String nomSys = nsys.conseProc(conseActSys);
                        if(tamSys>memory.memDisponible()){
                            throw new MemoryOverflowExeption("Memoria llena, libera espacio");
                        }
                        else{
                            memory.agregarProcesoSys(tamSys, nomSys);
                            conseActSys++;
                            memory.mostrarMemoria();
                        }
                    }
                    if(ans.startsWith("D") || ans.startsWith("d")){
                        break;
                    }
                }
            }
            catch (MemoryOverflowExeption ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}