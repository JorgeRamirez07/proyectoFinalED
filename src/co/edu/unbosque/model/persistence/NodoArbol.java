package co.edu.unbosque.model.persistence;

import java.io.Serializable;

/**
 * Clase NodoArbol que contiene las propiedades del nodo
 */
public class NodoArbol implements Serializable {

    private Pelicula pelicula;
    private NodoArbol padre;
    private NodoArbol hijoIzquierdo;
    private NodoArbol hijoDerecho;

    /**
     * metodo constructor
     */
    public NodoArbol() {
        this.pelicula = null;
        this.padre = null;
        this.hijoDerecho = null;
        this.hijoIzquierdo = null;
    }

    /**
     * metodo para el nodoArbol que contiene pelicula
     * @param pelicula parametro  de la clase pelicula que tiene el valor de la pelicula
     */
    public NodoArbol(Pelicula pelicula) {
        this.pelicula = pelicula;
        this.padre = null;
        this.hijoDerecho = null;
        this.hijoIzquierdo = null;
    }

    /**
     * metodo get que nos trae la pelicula
     * @return retorna la pelicula
     */
    public Pelicula getPelicula() {
        return pelicula;
    }

    /**
     * metodo set que nos actualiza la pelicula
     * @param pelicula parametro que tienes los valores de las peliculas
     */
    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    /**
     *metodo tipo get que nos trae el hijo izquierdo
     * @return retorna el hijo izquierdo
     */
    public NodoArbol getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    /**
     *metodo tipo set que nos actualiza el valor del hijo izquierdo
     * @param hijoIzquierdo parametro que tiene el valor del hijo izquierdo
     */
    public void setHijoIzquierdo(NodoArbol hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    /**
     *metodo tipo get que nos trae el hijo derecho
     * @return retornal el hijo derecho
     */
    public NodoArbol getHijoDerecho() {
        return hijoDerecho;
    }

    /**
     *metodo tipo set que nos actualiza el valor del hijo derecho
     * @param hijoDerecho parametro que tiene el valor del hijo derecho
     */
    public void setHijoDerecho(NodoArbol hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    /**
     *metodo tipo get que nos trae el nodo padre
     * @return retorna el valor del nodo padre
     */
    public NodoArbol getPadre() {
        return padre;
    }

    /**
     *metodo tipo set que nos actualiza el valor del hijo izquierdo
     * @param padre parametro que tiene el valor del nodo padre
     */
    public void setPadre(NodoArbol padre) {
        this.padre = padre;
    }
}
