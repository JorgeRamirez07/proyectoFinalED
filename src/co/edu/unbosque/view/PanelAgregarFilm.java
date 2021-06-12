package co.edu.unbosque.view;

import co.edu.unbosque.model.persistence.Pelicula;
import jdk.nashorn.internal.ir.Labels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.util.Random;

/**
 *Clase que contiene panel film
 */
public class PanelAgregarFilm extends JPanel {
    private JLabel fondo;
    private JLabel[] labes;
    private JTextField[] textFields;
    private JButton boton;

    /**
     *metodo constructor de la clase
     */
    public PanelAgregarFilm() {
        setLayout(null);
        setVisible(false);
        setBackground(Color.green);
        inicializarComponentes();
    }

    /**
     *metodo que inicializa los componentes del panel
     */
    private void inicializarComponentes() {
        labes = new JLabel[10];
        iniciarLabelTexto(0, "Agregar flim:", 5, 10, 30, 300, 25, Color.white);
        iniciarLabelTexto(1, "Nombre: ", 15, 80, 23, 300, 17, Color.black);
        iniciarLabelTexto(2, "Estudio: ", 15, 130, 23, 300, 17, Color.black);
        iniciarLabelTexto(3, "Estado: ", 15, 180, 23, 300, 17, Color.black);
        iniciarLabelTexto(4, "Version: ", 15, 230, 23, 300, 17, Color.black);
        iniciarLabelTexto(5, "Precio(valor numerico):", 15, 280, 23, 300, 17, Color.black);
        iniciarLabelTexto(6, "Clasificacion: ", 15, 330, 23, 300, 17, Color.black);
        iniciarLabelTexto(7, "Anio: ", 15, 380, 23, 300, 17, Color.black);
        iniciarLabelTexto(8, "Genero: ", 15, 430, 23, 300, 17, Color.black);
        iniciarLabelTexto(9, "Fecha de publicacion: ", 15, 480, 23, 300, 17, Color.black);

        textFields = new JTextField[9];
        iniciarTextArea(0, 230, 80, 23, 300);
        iniciarTextArea(1, 230, 130, 23, 300);
        iniciarTextArea(2, 230, 180, 23, 300);
        iniciarTextArea(3, 230, 230, 23, 300);
        iniciarTextArea(4, 230, 280, 23, 300);
        iniciarTextArea(5, 230, 330, 23, 300);
        iniciarTextArea(6, 230, 380, 23, 300);
        iniciarTextArea(7, 230, 430, 23, 300);
        iniciarTextArea(8, 230, 480, 23, 300);

        boton = new JButton("Guardar");
        MouseListener ml = new MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Component c = evt.getComponent();
                c.setBackground(new Color(24, 34, 51));
                c.setForeground(Color.WHITE);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                Component c = evt.getComponent();
                c.setBackground(Color.white);
                c.setForeground(new Color(24, 34, 51));
            }
        };

        boton.setActionCommand("GUARDAR_NUEVA_PELICULA");
        boton.addMouseListener(ml);
        boton.setBackground(Color.WHITE);
        boton.setBounds(230, 550, 100, 40);
        add(boton);

        fondo = new JLabel();
        devolverImagenLabel("menu", "png", 900, 700, fondo);
        fondo.setBounds(0, 0, 900, 700);
        add(fondo);
    }

    /**
     * metodo que trae la imagen al panel
     * @param src parametro que conecta el tipo de imagen
     * @param tipo parametro que hace referencia al tipo de la imagen
     * @param escalax parametro que hace referencia a la escala en el eje x
     * @param escalay parametro que hace referencia a la escala en el eje y
     * @param b parametro que hace referencia al label donde se insertará
     */
    public void devolverImagenLabel(String src, String tipo, int escalax, int escalay, JLabel b) {
        ImageIcon imagen1 = new ImageIcon(getClass().getResource("/images/" + src + "." + tipo));
        ImageIcon icon = new ImageIcon(imagen1.getImage().getScaledInstance(escalax, escalay, Image.SCALE_DEFAULT));
        b.setIcon(icon);
    }

    /**
     * metodo que inicializa el JtextArea
     * @param pos parametro entero que indica la posicion de este
     * @param x parametro que hace referencia a la coordenada en eje x
     * @param y parametro que hace referencia a la coordenada en eje y
     * @param alto parametro que hace referencia a las medidas del alto
     * @param ancho parametro que hace referencia a las medidas del ancho
     */
    public void iniciarTextArea(int pos, int x, int y, int alto, int ancho) {
        textFields[pos] = new JTextField();
        textFields[pos].setBounds(x, y, ancho, alto);
        add(textFields[pos]);
    }

    /**
     * metodo que sirve para iniciar  el label del texto
     * @param pos parametro entero que indica la posicion de este
     * @param texto parametro que contiene el texto
     * @param x parametro que hace referencia a la coordenada en eje x
     * @param y parametro que hace referencia a la coordenada en eje y
     * @param alto parametro que hace referencia a las medidas del alto
     * @param ancho  parametro que hace referencia a las medidas del ancho
     * @param tamanioLetra parametro que hace referencia a las medidas del tamaño de letras
     * @param colorLetra parametro que hace referencia al color de letras
     */
    public void iniciarLabelTexto(int pos, String texto, int x, int y, int alto, int ancho, int tamanioLetra, Color colorLetra) {
        labes[pos] = new JLabel(texto);
        labes[pos].setBounds(x, y, ancho, alto);
        labes[pos].setFont(new Font("Century Gothic", Font.PLAIN, tamanioLetra));
        labes[pos].setForeground(colorLetra);
        add(labes[pos]);
    }

    /**
     * metodo que valida el text field
     * @return retorna si el contador es 1 o 0
     */
    public int validarTextField() {
        int cont = 0;
        for (int i = 0; i < textFields.length; i++) {
            if (!textFields[i].getText().isEmpty()) {
                cont++;
                if (i == 4 && !esNumero(textFields[i].getText())) {
                    cont--;
                }
            }
        }
        return cont;
    }

    /**
     * metodo que ayuda a capturar datos
     * @return retorna que los datos hayan sido capturados
     */
    public Pelicula capturarDatos() {
        Random rnd = new Random();
        Pelicula film = new Pelicula(textFields[0].getText(), textFields[1].getText(), textFields[2].getText(), textFields[3].getText(),
                Integer.parseInt(textFields[4].getText()), textFields[5].getText(), textFields[6].getText(), textFields[7].getText(),
                textFields[8].getText(), rnd.nextInt(280000) + 1000 - rnd.nextInt(50), 0);
        return film;
    }

    /**
     * metodo que confirma si escribió un numero o no
     * @param m parametro string que almacena el valor ingresado
     * @return retorna true o false segun sea el caso
     */
    private boolean esNumero(String m) {
        try {
            Integer.parseInt(m);
            return true;
        } catch (NumberFormatException nfe) {
            System.out.println("Entrada invalida.");
            return false;
        }
    }

    /**
     * metodo tipo get que trae el boton
     * @return retorna el boton a usar
     */
    public JButton getBoton() {
        return boton;
    }
}
