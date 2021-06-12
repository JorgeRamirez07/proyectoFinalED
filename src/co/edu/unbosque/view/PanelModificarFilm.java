package co.edu.unbosque.view;

import co.edu.unbosque.model.persistence.Pelicula;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

/**
 * Clase que contiene el panel ModificarFilm
 */
public class PanelModificarFilm extends JPanel {

    private JLabel fondo;
    private JLabel[] labes;
    private JTextField[] textFields;
    private JButton guardar_modifi;

    /**
     * metodo constructor
     */
    public PanelModificarFilm() {
        setLayout(null);
        setVisible(false);
        setBackground(Color.green);
        inicializarComponentes();
    }

    /**
     * metodo que inicializa los componentes del panel
     */
    private void inicializarComponentes() {
        labes = new JLabel[10];
        iniciarLabelTexto(0, "Modificar flim:", 5, 10, 30, 300, 25, Color.white);
        iniciarLabelTexto(1, "Id pelicula a editar: ", 15, 50, 23, 300, 17, Color.black);
        iniciarLabelTexto(1, "Nombre: ", 15, 100, 23, 300, 17, Color.black);
        iniciarLabelTexto(2, "Estudio: ", 15, 150, 23, 300, 17, Color.black);
        iniciarLabelTexto(3, "Estado: ", 15, 200, 23, 300, 17, Color.black);
        iniciarLabelTexto(4, "Version: ", 15, 250, 23, 300, 17, Color.black);
        iniciarLabelTexto(5, "Precio(valor numerico):", 15, 300, 23, 300, 17, Color.black);
        iniciarLabelTexto(6, "Clasificacion: ", 15, 350, 23, 300, 17, Color.black);
        iniciarLabelTexto(7, "Año: ", 15, 400, 23, 300, 17, Color.black);
        iniciarLabelTexto(8, "Genero: ", 15, 450, 23, 300, 17, Color.black);
        iniciarLabelTexto(9, "Fecha de publicacion: ", 15, 500, 23, 300, 17, Color.black);

        textFields = new JTextField[10];
        iniciarTextArea(0, 230, 100, 23, 300);
        iniciarTextArea(1, 230, 150, 23, 300);
        iniciarTextArea(2, 230, 200, 23, 300);
        iniciarTextArea(3, 230, 250, 23, 300);
        iniciarTextArea(4, 230, 300, 23, 300);
        iniciarTextArea(5, 230, 350, 23, 300);
        iniciarTextArea(6, 230, 400, 23, 300);
        iniciarTextArea(7, 230, 450, 23, 300);
        iniciarTextArea(8, 230, 500, 23, 300);
        iniciarTextArea(9, 230, 50, 23, 300);

        guardar_modifi = new JButton("Guardar");
        MouseListener ml = new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                Component c = evt.getComponent();
                c.setBackground(new Color(24, 34, 51));
                c.setForeground(Color.WHITE);
            }

            public void mouseExited(MouseEvent evt) {
                Component c = evt.getComponent();
                c.setBackground(Color.white);
                c.setForeground(new Color(24, 34, 51));
            }
        };
        guardar_modifi.setActionCommand("GUARDAR_EDITAR_PELICULA");
        guardar_modifi.addMouseListener(ml);
        guardar_modifi.setBackground(Color.WHITE);
        guardar_modifi.setBounds(230, 570, 100, 40);
        add(guardar_modifi);

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
     * metodo para validar que el TextField no esté vacio
     * @return returna un valor entero que notifica si está vacio o no
     */
    public int validarTextField() {
        int cont = 0;
        for (int i = 0; i < textFields.length; i++) {
            if (!textFields[i].getText().isEmpty()) {
                cont++;
                if (i == 4 && !esNumero(textFields[i].getText()) || i == 9 && !esNumero(textFields[i].getText())) {
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
                textFields[8].getText(), Integer.parseInt(textFields[9].getText()), 0);
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
     * @return retorna el exitoso guardado de la modificacion
     */
    public JButton getGuardar_modifi() {
        return guardar_modifi;
    }
}
