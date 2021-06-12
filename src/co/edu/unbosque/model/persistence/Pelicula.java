package co.edu.unbosque.model.persistence;

import java.io.Serializable;

/**
 * Clase que almacena todas las propiedades de la pelicula
 */
public class Pelicula implements Serializable {
    private String titulo;
    private String estudio;
    private String estado;
    private String version;
    private int precio;
    private String clasificacion;
    private String anio;
    private String genero;
    private String fechaPublicacion;
    private int id;
    private int clave;

    /**
     * Metodo constructor
     * @param titulo parametro tipo string que almacena el titulo
     * @param estudio parametro tipo string que almacena el estudio productor de la pelicula
     * @param estado parametro tipo string que almacena el estado de la pelicula
     * @param version parametro tipo string que almacena la version de la pelicula
     * @param precio parametro tipo int que almacena el precio de la pelicula
     * @param clasificacion parametro tipo string que almacena la clasificacion de la pelicula
     * @param anio parametro tipo string que almacena el año en que se hizo
     * @param genero parametro tipo string que almacena el genero de la pelicula
     * @param fechaPublicacion parametro tipo string que almacena la fecha en que fue lanzada al publico
     * @param id parametro tipo int que almacena el id de referencia de la pelicula
     * @param clave parametro tipo int que almacena la clave de acceso a la pelicula
     */
    public Pelicula(String titulo, String estudio, String estado, String version, int precio, String clasificacion, String anio, String genero, String fechaPublicacion, int id, int clave) {
        this.titulo = titulo;
        this.estudio = estudio;
        this.estado = estado;
        this.version = version;
        this.precio = precio;
        this.clasificacion = clasificacion;
        this.anio = anio;
        this.genero = genero;
        this.fechaPublicacion = fechaPublicacion;
        this.id = id;
        this.clave = clave;
    }

    /**
     * metodo que inicializa los valores de la pelicula
     * @param titulo parametro string que almacena los datos en la variable de titulo
     */
    public Pelicula(String titulo) {
        this.titulo = titulo;
        this.estudio = "";
        this.estado = "";
        this.version = "version";
        this.precio = 1000;
        this.clasificacion = "clasificacion";
        this.anio = "anio";
        this.genero = "genero";
        this.fechaPublicacion = "fechaPublicacion";
        this.id = 1231231;
        this.clave = 0;
    }


    /**
     * metodo toString para establecer por defecto
     * @return retorna los valores en su respectivo orden
     */
    @Override
    public String toString() {
        return "Pelicula{" +
                "titulo='" + titulo + '\'' +
                ", estudio='" + estudio + '\'' +
                ", estado='" + estado + '\'' +
                ", version='" + version + '\'' +
                ", precio=" + precio +
                ", clasificacion='" + clasificacion + '\'' +
                ", anio='" + anio + '\'' +
                ", genero='" + genero + '\'' +
                ", fechaPublicacion='" + fechaPublicacion + '\'' +
                ", id=" + id +
                ", clave=" + clave +
                '}';
    }

    /**
     * metodo tipo get que nos trae el titulo de la pelicula
     * @return retorna el titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * metodo tipo set que nos actualiza el titulo de la pelicula
     * @param titulo parametro que almacena el titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * metodo tipo get que nos trae el estudio de la pelicula
     * @return retorna el estudio de produccion
     */
    public String getEstudio() {
        return estudio;
    }

    /**
     *metodo tipo set que nos actualiza el estudio de produccion de la pelicula
     * @param estudio parametro que almacena el estudio
     */
    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    /**
     *metodo tipo get que nos trae el estado de la pelicula
     * @return retorna el estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     *metodo tipo set que nos actualiza el estado de la pelicula
     * @param estado parametro que almacena el estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     *metodo tipo get que nos trae la version de la pelicula
     * @return retorna la version
     */
    public String getVersion() {
        return version;
    }

    /**
     *metodo tipo set que nos actualiza la version de la pelicula
     * @param version parametro que almacena la version
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     *metodo tipo get que nos trae el precio de la pelicula
     * @return retorna el precio
     */
    public int getPrecio() {
        return precio;
    }

    /**
     *metodo tipo set que nos actualiza el precio de la pelicula
     * @param precio parametro que almacena el precio
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     *metodo tipo get que nos trae el titulo de la pelicula
     * @return retorna la clasificacion
     */
    public String getClasificacion() {
        return clasificacion;
    }

    /**
     *metodo tipo set que nos actualiza la clasificacion de la pelicula
     * @param clasificacion parametro que almacena la clasificacion
     */
    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    /**
     *metodo tipo get que nos trae el año de la pelicula
     * @return retorna el año
     */
    public String getAnio() {
        return anio;
    }

    /**
     * metodo tipo set que nos actualiza el año de la pelicula
     * @param anio parametro que almacena el año
     */
    public void setAnio(String anio) {
        this.anio = anio;
    }

    /**
     *metodo tipo get que nos trae el titulo de la pelicula
     * @return retorna el genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     *metodo tipo set que nos actualiza el genero de la pelicula
     * @param genero parametro que almacena el genero
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     *metodo tipo get que nos trae el titulo de la pelicula
     * @return retorna la fecha de publicacion
     */
    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    /**
     *metodo tipo set que nos actualiza la fecha de publicacion de la pelicula
     * @param fechaPublicacion parametro que almacena la fecha de publiacion
     */
    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    /**
     *metodo tipo get que nos trae el id de la pelicula
     * @return retorna el id
     */
    public int getId() {
        return id;
    }

    /**
     *metodo tipo set que nos actualiza el id de la pelicula
     * @param id parametro que almacena el valor del id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *metodo tipo get que nos trae la clave de la pelicula
     * @return retorna el valor de la clave
     */
    public int getClave() {
        return clave;
    }

    /**
     *metodo tipo set que nos actualiza la clave  de la pelicula
     * @param clave parametro que almacena el valor de la clave
     */
    public void setClave(int clave) {
        this.clave = clave;
    }
}
