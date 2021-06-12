package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Clase que contiene el panelTabla
 */
public class PanelTabla extends JPanel {

    private JTable tablaDatos;
    private JButton volver;

    /**
     * metodo constructor
     */
    public PanelTabla() {
        setLayout(null);
        setVisible(false);
        setBackground(new Color(157, 205, 90));
        inicializarComponentes();
    }

    /**
     * metodo que incializa los Componentes
     */
    private void inicializarComponentes() {

        tablaDatos = new JTable();
        tablaDatos.setBounds(20, 20, 840, 570);
        JScrollPane sp = new JScrollPane(tablaDatos);
        sp.setBounds(20, 20, 840, 570);
        add(sp);

        volver = new JButton("Volver a menu");
        volver = new JButton("Guardar");
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
        volver.setActionCommand("VOLVER_TABLA");
        volver.addMouseListener(ml);
        volver.setBackground(Color.WHITE);
        volver.setBounds(400, 600, 100, 40);
        add(volver);
    }

    /**
     *metodo tipo get que nos trae la tabla de datos
     * @return retorna la tabla de datos
     */
    public JTable getTablaDatos() {
        return tablaDatos;
    }

    /**
     * metodo que nos trae el boton de devolver
     * @return retorna el boton de volver
     */
    public JButton getVolver() {
        return volver;
    }
}
