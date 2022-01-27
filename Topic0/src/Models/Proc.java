/**
 * Interfase para los procesos a utilizar en la memoria
 * @autor Ing. Luis Pineda
 * @version 1.0
 * @since JDK 17.0.1
 */

package Models;

public interface Proc {

    /**
     * Metodo a implementar para obtener el tamaño del proceso.
     */
    public int tamProceso();

    /**
     * Metodo a implementar para obtener el consecutivo del proceso
     */
    public String conseProc(int conseAct);
}
