package es.centro.incidencias;

import java.util.List;

/**
 * Clase GestorIncidencias
 * <p>Guarda la lista de incidencias y crea metodos para su filtrado por
 * distintos metodos como id {@link #buscarPorId(String)} o por texto {@link #buscar(String)}</p>
 */
public final class GestorIncidencias {

    private final List<Incidencia> incidencias;

    /**
     * Constructor del Gestor
     * <p>Inicializa la lista de incidencias con una lista hardcodeada</p>
     */
    public GestorIncidencias() {
        incidencias = List.of(
                new Incidencia("INC-001", "No se puede iniciar sesión", "alta", true),
                new Incidencia("INC-002", "Actualizar el navegador", "media", false),
                new Incidencia("INC-003", "Impresora sin conexión", "baja", true),
                new Incidencia("INC-004", "Fallo de red en el aula", "alta", true)
        );
    }

    /**
     * Metodo que devuelve la lista de incidencias
     * @return todas las incidencias
     */
    public List<Incidencia> listar() {
        return incidencias;
    }

    /**
     * Metodo que devuelve la lista de incidencias abiertas
     * <p>Usa un stream para devolver las incidencias abiertas</p>
     * @return incidencias abiertas
     */
    public List<Incidencia> listarAbiertas() {
        return incidencias.stream()
                .filter(Incidencia::isAbierta)
                .toList();
    }

    /**
     * Metodo que devuelve la lista que coincide con el texto pasado por parametro
     * <p>Usa un stream para comprobar cada incidencia con un metodo{@link Incidencia#coincideCon(String)}</p>
     * @see Incidencia#coincideCon(String)
     * @param texto para la busqueda
     * @return las incidencias que cumplen con la condicion
     */
    public List<Incidencia> buscar(String texto) {
        return incidencias.stream()
                .filter(incidencia -> incidencia.coincideCon(texto))
                .toList();
    }

    /**
     * Metodo que devuelve la Incidencia que contiene la id pasada por parametro
     * <p>El metodo no es case sensitive</p>
     * @param id para la busqueda
     * @return incidencia buscada o excepcion
     * @throws IncidenciaNoEncontradaException cuando no existe ninguna
     */
    public Incidencia buscarPorId(String id) throws IncidenciaNoEncontradaException {
        return incidencias.stream()
                .filter(incidencia -> incidencia.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(() -> new IncidenciaNoEncontradaException(id));
    }

    /**
     * Metodo que devuelve la incidencia que contiene la id pasada por parametro
     *
     * @param id para la busqueda
     * @return incidencia si existe o {@code null} si no
     * @deprecated Queda en desuso, utilizar {@link #buscarPorId(String)} en su lugar
     */
    @Deprecated(since = "1.0.0", forRemoval = false)
    public Incidencia obtenerIncidencia(String id) {
        try {
            return buscarPorId(id);
        } catch (IncidenciaNoEncontradaException excepcion) {
            return null;
        }
    }
}
