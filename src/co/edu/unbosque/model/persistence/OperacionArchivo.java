package co.edu.unbosque.model.persistence;

import java.io.*;

/**
 * Clase la cual hace las operaciones para leer el archivo
 */
public class OperacionArchivo {
    /**
     * metodo que lee el csv para hacer el arbol binario con los datos
     * @return retorna la correcta lectura del archivo csv
     */
    public ArbolBinario[] leerCsv(){
        int n = 0;
        int contadorEntrada = 0;
        int contadorArreglo = 0;
        int contadorCochino= 0;
        ArbolBinario arbol = new ArbolBinario();
        ArbolBinario[] arboles = new ArbolBinario[355];
        BufferedReader lectura = null;
        try {
            lectura = new BufferedReader(new FileReader("./Data/DVD.csv"));
            String linea = lectura.readLine();

            linea = lectura.readLine();
            while(linea!=null){
                String temp[] = linea.split(";");
                temp[4] = temp[4].substring(0,temp[4].length()-3);
                if(!comprobarNumero(temp[4])){
                   temp[4] = "0";
                }
                 if(!comprobarNumero(temp[9])){
                    temp[9] = "0";
                }
                System.out.println(n);
                Pelicula pelicula = new Pelicula(temp[0],temp[1],temp[2],temp[3],Integer.parseInt(temp[4]),
                        temp[5],temp[6],temp[7],temp[8],Integer.parseInt(temp[9]),n);
                arbol.insertar(pelicula);
                 if(contadorCochino==800&&n<284000){
                     arboles[contadorArreglo] = arbol;
                     contadorArreglo++;
                     arbol = null;
                     arbol = new ArbolBinario();
                     contadorCochino = 0;
                     contadorEntrada++;
                 }
                linea = lectura.readLine();
                n++;
                contadorCochino++;
            }

            arboles[contadorArreglo] = arbol;
            return arboles;
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * metodo que nos ayuda a obtener los datos correspondientes al csv
     * @return returna el objeto del archivo
     * @throws ClassNotFoundException lanza una excepcion en dado caso no se obtenga el dato
     */
    public ArbolBinario[] obtener() throws ClassNotFoundException {
        try {
            ObjectInputStream recuperar = new ObjectInputStream(new FileInputStream("./Data/arbol.dat"));
            ArbolBinario[] aux;
            aux = (ArbolBinario[]) recuperar.readObject();
            recuperar.close();
            return aux;
        } catch (EOFException e) {
            //e.printStackTrace();
            return null;
        }catch(IOException e) {
            //e.printStackTrace();
            return null;
        }
    }


    /**
     * metodo con el cual nos permite escribir en el archivo csv
     * @param arbol parametro arbol en el cual se va a almacenar los datos que serán escritos
     */
    public void escribir(ArbolBinario[] arbol) {
        try {
            ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream("./Data/arbol.dat"));
            escribir.writeObject(arbol);
            escribir.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * metodo que nos ayuda a comprobar el numero
     * @param n parametro string con el cual se almacena el dato
     * @return retorna true o false segun sea el caso
     */
    private boolean comprobarNumero(String n){
        try {
            Integer.parseInt(n);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
