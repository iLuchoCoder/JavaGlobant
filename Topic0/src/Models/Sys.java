/**
 * Proceso de sistema implementa interface Proc
 * @autor Ing. Luis Pineda
 * @version 1.0
 * @since JDK 17.0.1
 */

package Models;

import java.util.Formatter;

public class Sys implements Proc {

    /**
     * Metodo a implementar para obtener el tamaño del proceso.
     */
    @Override
    public int tamProceso() {
        int num= (int)(Math.random()*(5-15+1)+15);
        return num;
    }

    /**
     * Metodo a implementar para obtener el consecutivo del proceso
     */
    @Override
    public String conseProc(int conseActual) {
        Formatter fmt = new Formatter();
        fmt.format("%03d",conseActual);
        return "s"+fmt;
    }
}
