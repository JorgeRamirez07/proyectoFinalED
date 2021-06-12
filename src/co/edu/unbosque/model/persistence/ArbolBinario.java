package co.edu.unbosque.model.persistence;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase ArbolBinario que implementa una serializacion
 */
public class ArbolBinario implements Serializable {

    private NodoArbol raiz;
    private int cantidadNodos;

    /**
     * metodo constructor
     */
    public ArbolBinario() {
        cantidadNodos = 0;
        raiz = null;

    }

    /**
     * metodo boolean que nos indica si el arbol está vacio
     * @return retorna si la raiz es null
     */
    public boolean arbolVacio() {
        return raiz == null;
    }

    /**
     * metodo void que sirve para insertar una pelicula
     * @param pelicula de la clase pelicula que almacena las peliculas
     */
    public void insertar(Pelicula pelicula) {
        int cont = 0;
        NodoArbol newNodo = new NodoArbol(pelicula);
        if (arbolVacio()) {
            raiz = newNodo;
        } else {
            NodoArbol aux = raiz;
            while (aux != null) {
                newNodo.setPadre(aux);
                if (newNodo.getPelicula().getId() >= aux.getPelicula().getId()) {
                    aux = aux.getHijoDerecho();
                    // System.out.println(cont);
                    // System.out.println("Insert derecha");
                    cont++;
                } else {
                    // System.out.println("insert izquierda");
                    aux = aux.getHijoIzquierdo();
                }
            }
            if (newNodo.getPelicula().getId() < newNodo.getPadre().getPelicula().getId()) {

                newNodo.getPadre().setHijoIzquierdo(newNodo);
                cantidadNodos++;
            } else {

                newNodo.getPadre().setHijoDerecho(newNodo);
                cantidadNodos++;

            }
        }


    }

    /**
     * metodo boolean que sirve para eliminar
     * @param dato parametro tipo int que tiene el dato que vamos a eliminar
     * @return retorna si el dato se borró o no
     */
    public Boolean eliminar(int dato) {
        NodoArbol aux = raiz; //va a recorrer el arbol
        NodoArbol padre = raiz; //va a sabeer el padre del que estamos recorriendo
        boolean esHijoIzq = true; //para saber si es hijo izquierdo o derecho

        while (aux.getPelicula().getId() != dato) {
            padre = aux;
            if (dato < aux.getPelicula().getId()) {
                esHijoIzq = true;
                aux = aux.getHijoIzquierdo();
            } else {
                esHijoIzq = false;
                aux = aux.getHijoDerecho();
            }
            if (aux == null) {
                return false;
            }
        }
        //si ecuentra el nodo
        if (aux.getHijoIzquierdo() == null && aux.getHijoDerecho() == null) { //para saber si ese nodo es una hoja
            if (aux == raiz) { //para saber si solo tengo un nodo
                raiz = null;
            } else if (esHijoIzq) {
                padre.setHijoIzquierdo(null);
            } else {
                padre.setHijoDerecho(null);
            }
        } else if (aux.getHijoDerecho() == null) { //se reacomoda los punteros
            if (aux == raiz) {
                raiz = aux.getHijoIzquierdo();
            } else if (esHijoIzq) {
                padre.setHijoIzquierdo(aux.getHijoIzquierdo());
            } else {
                padre.setHijoDerecho(aux.getHijoIzquierdo());
            }
        } else if (aux.getHijoIzquierdo() == null) {
            if (aux == raiz) {
                raiz = aux.getHijoDerecho();
            } else if (esHijoIzq) {
                padre.setHijoIzquierdo(aux.getHijoDerecho());
            } else {
                padre.setHijoDerecho(aux.getHijoIzquierdo());
            }
        } else {
            NodoArbol reemplazo = obtenerNodoReemplaz(aux); // remplazar el nodo que vamos a eliminar
            if (aux == raiz) {
                raiz = reemplazo;
            } else if (esHijoIzq) {
                padre.setHijoIzquierdo(reemplazo);
            } else {
                padre.setHijoDerecho(reemplazo);
            }
            reemplazo.setHijoIzquierdo(aux.getHijoIzquierdo());
        }

        return true;

    }


    /**
     * metodo de tipo arraylist que que nos ayuda a recorrer en preorden
     * @param nodo parametro qde tipo NodoArbol que tiene el nodo que vamos a recorrer
     * @param a de tipo arraylist que sirve para almacenar el resultado
     * @return  retorna el valor del parametro a
     */
    public ArrayList recorerPreOrden(NodoArbol nodo, ArrayList a) {
        if (nodo != null) {
            a.add(nodo.getPelicula());
            recorerPreOrden(nodo.getHijoIzquierdo(), a);
            recorerPreOrden(nodo.getHijoDerecho(), a);
        }
        return a;
    }

    /**
     * metodo de tipo NodoArbol que realiza la busqueda
     * @param a parametro entero que almacena el valor que se va a buscar
     * @return retorna el valor buscado
     */
    public NodoArbol busqueda(int a) {
        NodoArbol aux = raiz;
        while (aux.getPelicula().getClave() != a) {
            if (a < aux.getPelicula().getClave()) {
                aux = aux.getHijoIzquierdo();
            } else {
                aux = aux.getHijoDerecho();
            }
            if (aux == null) { //saber si ya estamos en el fina
                return null;
            }
        }
        return aux;
    }

    /**
     * metodo de tipo NodoArbol que nos da el nodo para reemplazarlo
     * @param aux parametro del tipo NodoArbol que contiene el nodo a reemplazar
     * @return retorna el nodo a reemplazar
     */
    private NodoArbol obtenerNodoReemplaz(NodoArbol aux) {
        NodoArbol reemplazarPadre = aux;
        NodoArbol reemplazo = aux;
        NodoArbol auxiliar = aux.getHijoDerecho();
        while (auxiliar != null) {
            reemplazarPadre = reemplazo;
            reemplazo = auxiliar;
            auxiliar = auxiliar.getHijoIzquierdo();
        }
        if (reemplazo != aux.getHijoDerecho()) { //para reacomodar los enlases
            reemplazarPadre.setHijoIzquierdo(reemplazo.getHijoDerecho());
            reemplazo.setHijoDerecho(aux.getHijoDerecho());
        }
        System.out.println("El nodo de reemplazo es " + reemplazo.getPelicula().getClave());
        return reemplazo;

    }

    /**
     * metodo void que nos da la cantidad de peliculas segun la fecha de publicacion
     * @param nodo parametro del tipo NodoArbol que nos da el nodo
     * @param anioInicio parametro int que contiene el valor del año de inicio de la publicacion
     * @param anioFinal parametro int que contiene el valor del año final de la publicacion
     * @param peliculas parametro de tipo ArrayList que almacena las peliculas
     */
    public void cantidadPeliculasSegunFechaPublicacion(NodoArbol nodo, int anioInicio, int anioFinal,ArrayList<Pelicula> peliculas){
        if(nodo!=null){
            cantidadPeliculasSegunFechaPublicacion(nodo.getHijoIzquierdo(), anioInicio,anioFinal, peliculas);
            String temp [] = nodo.getPelicula().getFechaPublicacion().split("/");
            if(temp.length==3){
                if(Integer.parseInt(temp[2])>= anioInicio&& Integer.parseInt(temp[2])<=anioFinal){
                    peliculas.add(nodo.getPelicula());
                }
            }

            cantidadPeliculasSegunFechaPublicacion(nodo.getHijoDerecho(), anioInicio,anioFinal,peliculas);
        }
    }

    /**
     * metodo de tipo void que nos muestra la cantidad de peliculas segun el titulo
     * @param nodo parametro de tipo NodoArbol que contiene el valor de nodo
     * @param titulo parametro string que contiene los titulos de las peliculas
     * @param peliculas parametro de tipo Arraylist que almacena las peliculas
     */
    public void cantidadPeliculasSegunTitulo(NodoArbol nodo, String titulo,ArrayList<Pelicula> peliculas){
        if(nodo!=null){
            cantidadPeliculasSegunTitulo(nodo.getHijoIzquierdo(), titulo, peliculas);
            if(nodo.getPelicula().getTitulo().startsWith(titulo)){
                peliculas.add(nodo.getPelicula());
            }

            cantidadPeliculasSegunTitulo(nodo.getHijoDerecho(), titulo,peliculas);
        }
    }

    /**
     * metodo void que nos muestra la cantidad de peliculas segun la clasificacion
     * @param nodo parametro del tipo NodoArbol que almacena el nodo
     * @param clasificacion parametro string que contiene la clasificacion de la pelicula
     * @param peliculas parametro de tipo Arraylist que almacena las peliculas
     */
    public void cantidadPeliculasSegunClasificacion(NodoArbol nodo, String clasificacion,ArrayList<Pelicula> peliculas){
        if(nodo!=null){
            cantidadPeliculasSegunClasificacion(nodo.getHijoIzquierdo(), clasificacion, peliculas);
            if(nodo.getPelicula().getClasificacion().equals(clasificacion)){
                peliculas.add(nodo.getPelicula());
            }
            cantidadPeliculasSegunClasificacion(nodo.getHijoDerecho(), clasificacion,peliculas);
        }
    }

    /**
     * metodo void que nos muestra la cantidad de peliculas segun la version
     * @param nodo parametro del tipo NodoArbol que almacena el nodo
     * @param version parametro string que contiene la version de la pelicula
     * @param peliculas parametro de tipo Arraylist que almacena las peliculas
     */
    public void cantidadPeliculasSegunVersion(NodoArbol nodo, String version,ArrayList<Pelicula> peliculas){
        if(nodo!=null){
            cantidadPeliculasSegunVersion(nodo.getHijoIzquierdo(), version, peliculas);
            if(nodo.getPelicula().getVersion().equals(version)){
                peliculas.add(nodo.getPelicula());
            }
            cantidadPeliculasSegunVersion(nodo.getHijoDerecho(), version,peliculas);
        }
    }


    /**
     * metodo void que nos muestra la cantidad de peliculas segun el genero
     * @param nodo parametro del tipo NodoArbol que almacena el nodo
     * @param genero parametro de tipo de string que almacena los generos de las peliculas
     * @param peliculas parametro de tipo Arraylist que almacena las peliculas
     */
    public void cantidadPeliculasSegunGenero(NodoArbol nodo, String genero,ArrayList<Pelicula> peliculas){
        if(nodo!=null){
            cantidadPeliculasSegunGenero(nodo.getHijoIzquierdo(), genero, peliculas);
            if(nodo.getPelicula().getGenero().equalsIgnoreCase(genero)){
                peliculas.add(nodo.getPelicula());
            }
            cantidadPeliculasSegunGenero(nodo.getHijoDerecho(), genero,peliculas);
        }
    }

    /**
     * metodo get que nos brindad la cantidad de nodos
     * @return retorna la cantidad de nodos
     */
    public int getCantidadNodos() {
        return cantidadNodos;
    }

    /**
     * metodo get que nos da la raiz del arbol
     * @return retorna la raiz
     */
    public NodoArbol getRaiz() {
        return raiz;
    }





}
