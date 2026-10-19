package es.centro.incidencias;

import java.util.Locale;

/**
 *  Clase Incidencia que puede estar abierta o no,
 *  <p>Cada incidencia tiene un identificador con formato INC-xxx, un titulo, su prioridad y el estado.</p>
 */
public final class Incidencia {

    private final String id;
    private final String titulo;
    private final String prioridad;
    private final boolean abierta;

    /**
     * Crea una incidencia
     * @param id identificado con formato INC-xxx
     * @param titulo titulo descriptivo
     * @param prioridad una prioridad que puede ser (alta|media|baja)
     * @param abierta el estado de la incidencia, puede crearse cerrada
     */
    public Incidencia(String id, String titulo, String prioridad, boolean abierta) {
        this.id = id;
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.abierta = abierta;
    }

    /**
     * Devuelve el id
     * @return identificador de la incidencia
     */
    public String getId() {
        return id;
    }

    /**
     * Devuelve  el titulo de la incidencia
     * @return titulo de la incidencia
     */
    public String getTitulo() {
        return titulo;
    }

    /**ç
     * Devuelve la prioridad de la incidencia
     * @return prioridad de la incidencia
     */
    public String getPrioridad() {
        return prioridad;
    }

    /**
     * Devuelve el estado de la incidencia
     * @return estado de la incidencia
     */
    public boolean isAbierta() {
        return abierta;
    }

    /**
     * Metodo para comprobar si el texto coincide con informacion de la incidencia
     *
     * <p>El metodo compara tanto en id como en titulo</p>
     * <p>El metodo no es case-sensitive</p>
     *
     * @param texto para la busqueda
     * @return si el id o el titulo cumplen el criterio
     */
    public boolean coincideCon(String texto) {
        String criterio = texto.toLowerCase(Locale.ROOT);
        return id.toLowerCase(Locale.ROOT).contains(criterio)
                || titulo.toLowerCase(Locale.ROOT).contains(criterio);
    }

}
