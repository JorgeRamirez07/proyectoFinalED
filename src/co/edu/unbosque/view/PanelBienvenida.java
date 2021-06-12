package co.edu.unbosque.view;

import com.sun.deploy.panel.JavaPanel;

import javax.swing.*;
import java.awt.*;

/**
 * clase que contiene el panel de bienvenida
 */
public class PanelBienvenida extends JavaPanel {
    private JLabel l1;
    private JButton comenzar;

    /**
     * metodo constructor
     */
    public PanelBienvenida() {
        setLayout(null);
        setVisible(true);
        setBackground(Color.green);
        inicializarComponentes();
    }

    /**
     * metodo que inicializa los componentes del panel
     */
    private void inicializarComponentes() {


        comenzar = new JButton(devolverImagenButton("comenzar", "png", 300, 300));
        comenzar.setRolloverIcon(devolverImagenButton("comenzar1", "png", 300, 300));
        comenzar.setBackground(Color.WHITE);
        comenzar.setBorder(null);
        comenzar.setActionCommand("COMENZAR");
        comenzar.setBounds(335, 450, 240, 100);
        add(comenzar);

        l1 = new JLabel();
        devolverImagenLabel("Bienvenido", "gif", 900, 700, l1);
        l1.setBounds(0, 0, 900, 700);
        add(l1);

    }

    /**
     * metodo que trae la imagen al panel
     * @param src parametro que conecta el tipo de imagen
     * @param tipo parametro que hace referencia al tipo de la imagen
     * @param escalax parametro que hace referencia a la escala en el eje x
     * @param escalay parametro que hace referencia a la escala en el eje y
     * @param b parametro que hace referencia al label donde se insertará
     *
     */
    public void devolverImagenLabel(String src, String tipo, int escalax, int escalay, JLabel b) {
        ImageIcon imagen1 = new ImageIcon(getClass().getResource("/images/" + src + "." + tipo));
        ImageIcon icon = new ImageIcon(imagen1.getImage().getScaledInstance(escalax, escalay, Image.SCALE_DEFAULT));
        b.setIcon(icon);
    }

    /**
     *
     * metodo que trae la imagen al boton
     * @param src parametro que conecta el tipo de imagen
     * @param tipo parametro que hace referencia al tipo de la imagen
     * @param escalax parametro que hace referencia a la escala en el eje x
     * @param escalay parametro que hace referencia a la escala en el eje y
     * @return retorna la imagen al boton
     */
    public ImageIcon devolverImagenButton(String src, String tipo, int escalax, int escalay) {
        ImageIcon imagen1 = new ImageIcon(getClass().getResource("/images/" + src + "." + tipo));
        ImageIcon icon = new ImageIcon(imagen1.getImage().getScaledInstance(escalax, escalay, Image.SCALE_DEFAULT));
        return icon;
    }

    /**
     *metodo tipo get que nos trae el label
     * @return nos retorna el label
     */
    public JLabel getL1() {
        return l1;
    }


    /**
     * metodo tipo set que nos actualiza el label
     * @param l1 parametro tipo JLabel
     */
    public void setL1(JLabel l1) {
        this.l1 = l1;
    }

    /**
     * metodo tipo get que nos trae el label
     * @return nos retorna el JButton
     */
    public JButton getComenzar() {
        return comenzar;
    }

    /**
     * metodo tipo set que nos actualiza el label
     * @param comenzar parametro tipo JButton
     */
    public void setComenzar(JButton comenzar) {
        this.comenzar = comenzar;
    }
}
