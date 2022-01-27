/**
 * Manejo de excepciones de la memoria
 * @autor Ing. Luis Pineda
 * @version 1.0
 * @since JDK 17.0.1
 */

package Exceptions;

public class MemoryOverflowExeption extends Exception{
    /**
     * Manejo de la excepcion de la memoria
     */
    public MemoryOverflowExeption(String msg) {
            super(msg);
        }
}
