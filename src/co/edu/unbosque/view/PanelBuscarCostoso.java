package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

/**
 * panel que contiene PanelBuscaeCostoso
 */
public class PanelBuscarCostoso extends JPanel {

    private JLabel[] labels;
    private JTextField[] textFields;
    private JButton[] buttons;
    private JTable table;
    private JScrollPane sp;

    /**
     * metodo constructor
     */
    public PanelBuscarCostoso() {
        setLayout(null);
        setVisible(false);
        setBackground(new Color(157, 205, 90));
        inicializarComponentes();
    }

    /**
     * metodo que sirve para inicializar los componentes del panel
     */
    private void inicializarComponentes() {
        labels = new JLabel[2];
        iniciarLabelTexto(0, "Buscar ejemplar mas costoso:", 5, 10, 30, 600, 25, Color.white);
        iniciarLabelTexto(1, "Ingrese genero para el filtro: ", 95, 90, 23, 400, 17, Color.black);


        textFields = new JTextField[1];
        iniciarTextArea(0, 340, 90, 23, 200);


        buttons = new JButton[2];
        inicializarBotones(buttons, "BUSQUEDA_COST", 0, "Buscar", 610, 80, 150, 40,
                Color.WHITE, new Color(24, 34, 51), new Color(24, 34, 51), 17, true, true);
        inicializarBotones(buttons, "VOlVER_AÑO", 1, "Volver", 360, 600, 150, 40,
                Color.WHITE, new Color(24, 34, 51), new Color(24, 34, 51), 17, true, true);

        table = new JTable();
        table.setBounds(10, 170, 860, 420);
        sp = new JScrollPane(table);
        sp.setBounds(10, 170, 860, 420);
        sp.setVisible(false);
        add(sp);

    }

    /**
     * metodo que sirve para iniciar el label de texto
     * @param pos parametro que indica los valores de posicion
     * @param texto parametro que contiene el texto a insertar
     * @param x parametro que indica los valores en el eje x
     * @param y parametro que indica los valores en el eje y
     * @param alto parametro que indica los valores de alto del label
     * @param ancho parametro que indica los valores de ancho del label
     * @param tamanioLetra parametro que indica el tamaño de las letras
     * @param colorLetra parametro que indica el color de las letras
     */
    public void iniciarLabelTexto(int pos, String texto, int x, int y, int alto, int ancho, int tamanioLetra, Color colorLetra) {
        labels[pos] = new JLabel(texto);
        labels[pos].setBounds(x, y, ancho, alto);
        labels[pos].setFont(new Font("Century Gothic", Font.PLAIN, tamanioLetra));
        labels[pos].setForeground(colorLetra);
        add(labels[pos]);
    }

    /**
     * metodo que devuelve los botones
     * @param pos parametro que indica los valores de la posicion del boton
     * @return retorna el boton
     */
    public JButton devolverBoton(int pos) {
        return buttons[pos];
    }

    /**
     * metodo que inicializa los botones
     * @param bot parametro para poder crear un arreglos de botones
     * @param command parametro que tiene los command para los botones
     * @param pos parametro que indica los valores de posicion
     * @param name parametro que nos indica los nombres
     * @param x parametro que indica los valores en el eje x
     * @param y parametro que indica los valores en el eje y
     * @param xB  parametro que indica los valores en el eje xB
     * @param yB parametro que indica los valores en el eje yB
     * @param color parametro que indica los colores
     * @param color2 parametro que indica los colores
     * @param letra parametro que indica la letra
     * @param tamanio parametro que indica el tamanio de los botones
     * @param visible parametro que indica la visibilidad
     * @param enable parametro que indica que no está disponible
     */
    public void inicializarBotones(JButton[] bot, String command, int pos, String name, int x, int y, int xB,
                                   int yB, Color color, Color color2, Color letra, int tamanio, boolean visible, boolean enable) {
        bot[pos] = new JButton(name);
        bot[pos].setBackground(color);
        bot[pos].setActionCommand(command);
        bot[pos].setEnabled(enable);
        bot[pos].setVisible(visible);
        bot[pos].setBorder(null);
        bot[pos].setCursor(new Cursor(Cursor.HAND_CURSOR));
        bot[pos].setBounds(x, y, xB, yB);
        bot[pos].setForeground(letra);
        bot[pos].setFont(new Font("Century Gothic", Font.PLAIN, tamanio));
        MouseListener ml = new MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Component c = evt.getComponent();
                c.setBackground(color2);
                c.setForeground(color);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                Component c = evt.getComponent();
                c.setBackground(color);
                c.setForeground(color2);
            }
        };
        bot[pos].addMouseListener(ml);
        add(bot[pos]);
    }

    /**
     metodo que inicializa el TextArea
     * @param pos  parametro que indica los valores de posicion
     * @param x parametro que indica los valores en el eje x
     * @param y parametro que indica los valores en el eje y
     * @param alto parametro que indica los valores de alto del label
     * @param ancho parametro que indica los valores de ancho del label
     */
    public void iniciarTextArea(int pos, int x, int y, int alto, int ancho) {
        textFields[pos] = new JTextField();
        textFields[pos].setBounds(x, y, ancho, alto);
        add(textFields[pos]);
    }

    /**
     metodo que nos sirve para ver la tabla
     * @param matriz parametro en el cual están los valores de la matriz
     * @param headder parametro en el cual están los valores de los headder
     */
    public void verTabla(String[][] matriz, String[] headder) {
        DefaultTableModel model = new DefaultTableModel(matriz, headder);
        table.setModel(model);
        sp.setVisible(true);
        devolverBoton(1).setVisible(true);
    }

    /**
     * metodo que nos permite verificar los datos
     * @return retorna true or false segun sea el caso
     */
    public boolean verficarDatos() {
        if (!textFields[0].getText().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * metodo que captura los datos del genero
     * @return retorn el texto del genero
     */
    public String capturarGenero() {
        return textFields[0].getText();
    }

    /**
     * metodo tipo get que nos trae la tabla
     * @return retorna la tabla
     */
    public JTable getTable() {
        return table;
    }
    /**
     * metodo tipo get que nos trae el JCrollPane
     * @return retorna el scroll
     */
    public JScrollPane getSp() {
        return sp;
    }
    /**
     * metodo tipo booleano  que nos valida si el usuario ingresó un numero o no
     * @param m pametro string que almacena el dato a analizar
     * @return returna true or false segun sea el caso
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

}
