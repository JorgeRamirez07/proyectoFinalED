package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.ArbolBinario;
import co.edu.unbosque.model.persistence.OperacionArchivo;
import co.edu.unbosque.model.persistence.Pelicula;

import java.util.ArrayList;

/**
 * clase que almacena metodos para poder crer un arbol binario
 */
public class ArbolBinarioDAO {
    private ArbolBinario arbolBinario[];
    private OperacionArchivo operacion;

    /**
     * metodo constructor
     */
    public ArbolBinarioDAO() {
        arbolBinario = null;
        operacion = new OperacionArchivo();
    }

    /**
     * metodo void que sirve para leer los datos del csv
     * @throws ClassNotFoundException lanza una excepcion si no hay nada que leer
     */
    public void leerDatosCsv() throws ClassNotFoundException {
        if (operacion.obtener() == null) {
            arbolBinario = operacion.leerCsv();
            operacion.escribir(arbolBinario);
        } else {
            arbolBinario = operacion.obtener();
        }
    }
    //Requerimiento 2

    /**
     * metodo void que sirve para agregar una pelicula
     * @param pelicula parametro que almacenará las peliculas
     * @throws ClassNotFoundException lanza una excepcion dado caso que no se pueda agregar debido a
     * que ya existe en el sistema
     */
    public void agregarPelicula(Pelicula pelicula) throws ClassNotFoundException {
        System.out.println("el tamanio antes es " + arbolBinario[arbolBinario.length - 1].getCantidadNodos());
        arbolBinario[arbolBinario.length - 1].insertar(pelicula);
        System.out.println("el tamanio antes es " + arbolBinario[arbolBinario.length - 1].getCantidadNodos());
        operacion.escribir(arbolBinario);
    }

    /**
     *metodo boolean que sirve para editar una pelicula buscandola por id
     * @param id parametro entero que almacena los id
     * @param film parametro de la clase pelicula que almacena la informacion de la pelicula
     * @return retorna la confirmacion si fue encontrada o no la pelicula
     * y si fue encontrada fue exitosamente editada
     * @throws ClassNotFoundException genera una excepcion dado caso no haya sido encontrado la clase
     */
    public boolean editarPelicula(int id, Pelicula film) throws ClassNotFoundException {
        for (int i = 0; i <= arbolBinario.length - 1; i++) {
            if (arbolBinario[i].busqueda(id) != null) {
                arbolBinario[i].busqueda(id).setPelicula(film);
                System.out.println("Pelicula encontrada");
                operacion.escribir(arbolBinario);
                return true;
            }
        }
        System.out.println("Pelicula no encontrada");

        return false;
    }

    /**
     * metodo String que filtra segun por la fecha de publicacion
     * @param anioInicio parametro entero del año de lanzada de la pelicula
     * @param anioFinal parametro entero del año en cual se dejó de mostrar la peli
     * @return retorna la filtracion por fecha de publicacion
     */
    public String[][] filtrarSegunfechaPublicacion(int anioInicio, int anioFinal){
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        for(int i=0;i<=arbolBinario.length-1;i++){
            arbolBinario[i].cantidadPeliculasSegunFechaPublicacion(arbolBinario[i].getRaiz(),anioInicio,anioFinal,peliculas);
        }
        String filtroPelicula[][] = new String[peliculas.size()][10];
        for(int i=0;i<peliculas.size();i++){
            filtroPelicula[i][0] = peliculas.get(i).getTitulo();
            filtroPelicula[i][1] = peliculas.get(i).getEstudio();
            filtroPelicula[i][2] = peliculas.get(i).getEstado();
            filtroPelicula[i][3] = peliculas.get(i).getVersion();
            filtroPelicula[i][4] = String.valueOf(peliculas.get(i).getPrecio());
            filtroPelicula[i][5] = peliculas.get(i).getClasificacion();
            filtroPelicula[i][6] = peliculas.get(i).getAnio();
            filtroPelicula[i][7] = peliculas.get(i).getGenero();
            filtroPelicula[i][8] = peliculas.get(i).getFechaPublicacion();
            filtroPelicula[i][9] = String.valueOf(peliculas.get(i).getId());
        }

        return filtroPelicula;

    }

    /**
     * metodo String que filtra la pelicula segun el genero de la pelicula
     * @param genero parametro String que almacena los datos del genero de la pelicula
     * @return el genero que se buscaba despues de aplicado el filtro
     */
    //Requerimiento 6
    public String [][] filtrarSegunGenero(String genero){
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        for(int i=0;i<=arbolBinario.length-1;i++){
            arbolBinario[i].cantidadPeliculasSegunGenero(arbolBinario[i].getRaiz(),genero,peliculas);
        }
        String filtroPelicula[][] = new String[peliculas.size()][10];
        for(int i=0;i<peliculas.size();i++){
            filtroPelicula[i][0] = peliculas.get(i).getTitulo();
            filtroPelicula[i][1] = peliculas.get(i).getEstudio();
            filtroPelicula[i][2] = peliculas.get(i).getEstado();
            filtroPelicula[i][3] = peliculas.get(i).getVersion();
            filtroPelicula[i][4] = String.valueOf(peliculas.get(i).getPrecio());
            filtroPelicula[i][5] = peliculas.get(i).getClasificacion();
            filtroPelicula[i][6] = peliculas.get(i).getAnio();
            filtroPelicula[i][7] = peliculas.get(i).getGenero();
            filtroPelicula[i][8] = peliculas.get(i).getFechaPublicacion();
            filtroPelicula[i][9] = String.valueOf(peliculas.get(i).getId());
        }

        return filtroPelicula;
    }

    /**
     * metodo String que filtra la pelicula segun el titulo
     * @param titulo parametro string que almacena el valor de titulo
     * @return retorna el titulo que estaba buscando por el filtro
     */
    //Requerimiento 7
    public String [][] filtrarSeguntitulo(String titulo){
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        for(int i=0;i<=arbolBinario.length-1;i++){
            arbolBinario[i].cantidadPeliculasSegunTitulo(arbolBinario[i].getRaiz(),titulo,peliculas);
        }
        String filtroPelicula[][] = new String[peliculas.size()][10];
        for(int i=0;i<peliculas.size();i++){
            filtroPelicula[i][0] = peliculas.get(i).getTitulo();
            filtroPelicula[i][1] = peliculas.get(i).getEstudio();
            filtroPelicula[i][2] = peliculas.get(i).getEstado();
            filtroPelicula[i][3] = peliculas.get(i).getVersion();
            filtroPelicula[i][4] = String.valueOf(peliculas.get(i).getPrecio());
            filtroPelicula[i][5] = peliculas.get(i).getClasificacion();
            filtroPelicula[i][6] = peliculas.get(i).getAnio();
            filtroPelicula[i][7] = peliculas.get(i).getGenero();
            filtroPelicula[i][8] = peliculas.get(i).getFechaPublicacion();
            filtroPelicula[i][9] = String.valueOf(peliculas.get(i).getId());
        }

        return filtroPelicula;

    }

    /**
     * metodo void que elimina una pelicula por el id
     * @param id parametro int que almacena los id
     */
    //Requerimiento 8
    public void eliminarPelicula(int id){
        boolean bandera = false;
        for(int i=0;i<=arbolBinario.length-1;i++){
            if(arbolBinario[i].eliminar(id)){
                System.out.println("Eliminada correctamente");
                bandera = true;
                operacion.escribir(arbolBinario);
                break;
            }
        }
        if(!bandera){
            System.out.println("No se encontro");
        }
    }

    /**
     * metodo string que  muestra los ejemplares mas costosos segun el genero
     * @param genero parametro de tipo string que almacena los generos
     * @return retorna el ejemplar mas costoso
     */
    //Requerimiento 9
    public String [][] filtarValorMasCostosoDadoGenero(String genero){
        String aux[][] = filtrarSegunGenero(genero);
        int n = aux.length-1;
        sort(aux,0,n);
        return aux;
    }

    /**
     * metodo que filtra segun las clasificaciones indicadas
     * @param clasificacion parametro string que almacena segun la clasificacion
     * @return retorna el ejemlar que el usuario estaba buscando segun el filtro
     */
    //Requerimiento 10
    public String[][] filtrarDadoClasificacion(String clasificacion){
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        for(int i=0;i<=arbolBinario.length-1;i++){
            arbolBinario[i].cantidadPeliculasSegunClasificacion(arbolBinario[i].getRaiz(),clasificacion,peliculas);

        }
        String filtroPelicula[][] = new String[peliculas.size()][10];
        for (int i = 0; i < peliculas.size(); i++) {
            filtroPelicula[i][0] = peliculas.get(i).getTitulo();
            filtroPelicula[i][1] = peliculas.get(i).getEstudio();
            filtroPelicula[i][2] = peliculas.get(i).getEstado();
            filtroPelicula[i][3] = peliculas.get(i).getVersion();
            filtroPelicula[i][4] = String.valueOf(peliculas.get(i).getPrecio());
            filtroPelicula[i][5] = peliculas.get(i).getClasificacion();
            filtroPelicula[i][6] = peliculas.get(i).getAnio();
            filtroPelicula[i][7] = peliculas.get(i).getGenero();
            filtroPelicula[i][8] = peliculas.get(i).getFechaPublicacion();
            filtroPelicula[i][9] = String.valueOf(peliculas.get(i).getId());
        }

        return filtroPelicula;
    }

    /**
     * metodo String que filtra segun la version que seleccione el usuario
     * @param version parametro string que almacena las versiones
     * @return retorna la version que busca el usuario
     */
    //Requerimiento 11
    public String[][] filtrarDadoVersion(String version){
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        for(int i=0;i<=arbolBinario.length-1;i++){
            arbolBinario[i].cantidadPeliculasSegunVersion(arbolBinario[i].getRaiz(),version,peliculas);
        }
        String filtroPelicula[][] = new String[peliculas.size()][10];
        for(int i=0;i<peliculas.size();i++){
            filtroPelicula[i][0] = peliculas.get(i).getTitulo();
            filtroPelicula[i][1] = peliculas.get(i).getEstudio();
            filtroPelicula[i][2] = peliculas.get(i).getEstado();
            filtroPelicula[i][3] = peliculas.get(i).getVersion();
            filtroPelicula[i][4] = String.valueOf(peliculas.get(i).getPrecio());
            filtroPelicula[i][5] = peliculas.get(i).getClasificacion();
            filtroPelicula[i][6] = peliculas.get(i).getAnio();
            filtroPelicula[i][7] = peliculas.get(i).getGenero();
            filtroPelicula[i][8] = peliculas.get(i).getFechaPublicacion();
            filtroPelicula[i][9] = String.valueOf(peliculas.get(i).getId());
        }

        return filtroPelicula;
    }

    /**
     * metodo void que logra hacer que clasifique segun la necesidad
     * @param arr parametro de tipo string que almacena en arreglos
     * @param left parametro int que clasifica a la izquierda los datos
     * @param right parametro int que clasifica a la derecha los datos
     */
    private void sort(String arr[][], int left, int right){
        if(left < right){
            int middle = (left + right) / 2;

            sort(arr, left, middle);
            sort(arr, middle+1, right);

            merge(arr, left, middle, right);
        }
    }

    /**
     * metodo que une los datos para poder organizarlos
     * @param arr parametro string que almacena en arreglos
     * @param left parametro int que clasifica a la izquierda los datos
     * @param middle parametro int que clasifica al centro los datos
     * @param right parametro int que clasifica a la derecha los datos
     */
    private void merge(String arr[][], int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        String leftArray[] = new String [n1];
        String rightArray[] = new String [n2];

        for (int i=0; i < n1; i++) {
            leftArray[i] = arr[left+i][4];
        }
        for (int j=0; j < n2; j++) {
            rightArray[j] = arr[middle + j + 1][4];
        }

        int i = 0, j = 0;


        int k = left;


        while (i < n1 && j < n2) {
            if (Integer.parseInt(leftArray[i]) >= Integer.parseInt(rightArray[j])) {
                arr[k][4] = leftArray[i];
                i++;
            } else {
                arr[k][4] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i > n1) {
            arr[k][4] = leftArray[i];
            i++;
            k++;
        }
        while (j > n2) {
            arr[k][4] = rightArray[j];
            j++;
            k++;
        }
    }


    /**
     * metodo get de la variable arbol binario que nos trae los datos
     * @return retorna los datos del arbol binario
     */
    public ArbolBinario[] getArbolBinario() {
        return arbolBinario;
    }

    /**
     * metodo set  de la variable arbol binario que nos actualiza los datos
     * @param arbolBinario parametro arreglo de arbolbinario
     */
    public void setArbolBinario(ArbolBinario[] arbolBinario) {
        this.arbolBinario = arbolBinario;
    }

    /**
     * metodo get de la variable operacion que nos trae los datos
     * @return retorna los datos de la operacion
     */
    public OperacionArchivo getOperacion() {
        return operacion;
    }

    /**
     * metodo set de la variable operacion que nos actualiza los datos
     * @param operacion parametro que actualiza los datos de OperacionArchivo
     */
    public void setOperacion(OperacionArchivo operacion) {
        this.operacion = operacion;
    }


}
