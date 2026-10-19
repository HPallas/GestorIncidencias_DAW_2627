package es.centro.incidencias;

/**
 * Excepcion creada para cuando el identificador no existe
 */
public class IncidenciaNoEncontradaException extends Exception {
    /**
     * Crea una incidencia personalizada con el id pasado
     *
     * @param id Para la personalización del {@code Exception}
     */
    public IncidenciaNoEncontradaException(String id) {
        super("No existe ninguna incidencia con el identificador " + id + ".");
    }
}
