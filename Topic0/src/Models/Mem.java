/**
 * Metodo manejo de la memoria
 * @autor Ing. Luis Pineda
 * @version 1.0
 * @since JDK 17.0.1
 */

package Models;

public class Mem {

    // Campo de la clase
    static String mem[][] = new String[20][10];

    /**
     * Inicializa la memoria de la aplicacion <br/>
     * Se llena todos los espacios con: "****"  <br/>
     *
     * @return Mensaje de inicializaicon satisfactoria
     */
    public static void inicializarMemoria() {
        for (int x = 0; x < mem.length; x++) {
            for (int y = 0; y < mem[x].length; y++) {
                mem[x][y] = "****";
            }
        }
        System.out.println("**********************************************************************");
        System.out.println("Se ha inicializado la memoria correctamente");
    }

    /**
     * Impresion en consola del estado actual de la memoria
     */
    public static void mostrarMemoria() {
        for (int x = 0; x < mem.length; x++) {
            System.out.print("|");
            for (int y = 0; y < mem[x].length; y++) {
                System.out.print(mem[x][y]);
                if (y != mem[x].length - 1) System.out.print("\t");
            }
            System.out.println("|");
        }
    }

    /**
     * Ingresa en la memoria el proceso de tipo Aplicativo
     *
     * @param tamApp Nombre del proceso tipo aplicativo
     * @param nomApp Tamaño que va a ocupar en memoria el proceso
     */
    public static void agregarProcesoApp(int tamApp, String nomApp) {
        int iniApp = 1;
        for (int x = 0; x < mem.length; x++) {
            for (int y = 0; y < mem[x].length; y++) {
                if (mem[x][y] == "****" && iniApp <= tamApp) {
                    mem[x][y] = nomApp;
                    iniApp++;
                }
            }
        }
    }

    /**
     * Ingresa en la memoria el proceso de tipo Sistema
     *
     * @param nomSys Nombre del proceso tipo sistema
     * @param tamSys Tamaño que va a ocupar en memoria el proceso
     */
    public static void agregarProcesoSys(int tamSys, String nomSys) {
        int iniSys = 1;
        for (int x = 0; x < mem.length; x++) {
            for (int y = 0; y < mem[x].length; y++) {
                if (mem[x][y] == "****" && iniSys <= tamSys) {
                    mem[x][y] = nomSys;
                    iniSys++;
                }
            }
        }
    }

    /**
     * Dato numerico de la memoria disponible
     *
     * @return Entero de memoria disponible
     */
    public static int memDisponible() {
        int dispo = 0;
        for (int x = 0; x < mem.length; x++) {
            for (int y = 0; y < mem[x].length; y++) {
                if (mem[x][y] == "****") {
                    dispo++;
                }
            }
        }
        return dispo;
    }

    /**
     * Elimina un proceso de la memoria y deja el espacio libre
     *
     * @param proceso
     */
    public static void eliminarProceso(String proceso) {
        for (int x = 0; x < mem.length; x++) {
            for (int y = 0; y < mem[x].length; y++) {
                if (mem[x][y].equals(proceso.toLowerCase())) {
                    mem[x][y] = "****";
                }
            }
        }
    }

    /**
     * Unifica los espacios libres luego de eliminar un proceso
     */
    public static void desfragmentar() {
        for (int x = 0; x < mem.length; x++) {
            for (int y = 0; y < mem[x].length; y++) {
            }
        }
    }
}
