package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que contiene la ventana principal del programa
 */
public class VentanaPrincipal extends JFrame {

    private PanelBienvenida panelBienvenida;
    private PanelAgregarFilm panelAgregarFilm;
    private PanelModificarFilm panelModificarFilm;
    private PanelMenu panelMenu;
    private PanelTabla panelTabla;
    private PanelBuscarDebut panelBuscarDebut;
    private PanelBuscarGenero panelBuscarGenero;
    private PanelBuscarTitulo panelBuscarTitulo;
    private PanelEliminarFilm panelEliminarFilm;
    private PanelBuscarCostoso panelBuscarCostoso;
    private PanelBuscarClasificaciones panelBuscarClasificaciones;
    private PanelBuscarVersiones panelBuscarVersiones;

    /**
     * metodo constructor
     */
    public VentanaPrincipal() {
        setTitle("TVBosque");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new BorderLayout(10, 10));
        inicializarComponentes();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * metodo que inicializa los componentes
     */
    private void inicializarComponentes() {
        panelBienvenida = new PanelBienvenida();
        getContentPane().add(panelBienvenida);

        panelMenu = new PanelMenu();
        panelAgregarFilm = new PanelAgregarFilm();
        panelTabla = new PanelTabla();
        panelModificarFilm = new PanelModificarFilm();
        panelBuscarDebut = new PanelBuscarDebut();
        panelBuscarGenero = new PanelBuscarGenero();
        panelBuscarTitulo = new PanelBuscarTitulo();
        panelEliminarFilm = new PanelEliminarFilm();
        panelBuscarCostoso = new PanelBuscarCostoso();
        panelBuscarClasificaciones = new PanelBuscarClasificaciones();
        panelBuscarVersiones = new PanelBuscarVersiones();
    }

    /**
     * metodo que genera un mensaje de alerta
     * @param title parametro String que contiene el titulo
     * @param message parametro String que contiene el mensaje
     * @param icon parametro Icon que contiene el icono a mostrar
     */
    public void mensajeAlerta(String title, String message, Icon icon) {

        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE, icon);
    }

    /**
     * metodo que trae la imagen al panel
     * @param src parametro que conecta el tipo de imagen
     * @param tipo parametro que hace referencia al tipo de la imagen
     * @param escalax parametro que hace referencia a la escala en el eje x
     * @param escalay parametro que hace referencia a la escala en el eje y
     * @return retorna la imagen a enseñar
     */
    public ImageIcon devolverImagenButton(String src, String tipo, int escalax, int escalay) {
        ImageIcon imagen1 = new ImageIcon(getClass().getResource("/images/" + src + "." + tipo));
        ImageIcon icon = new ImageIcon(imagen1.getImage().getScaledInstance(escalax, escalay, Image.SCALE_DEFAULT));
        return icon;
    }

    /**
     * metodo que nos trae el panelBienvenida
     * @return retorna el panel de Bienvenida
     */
    public PanelBienvenida getPanelBienvenida() {
        return panelBienvenida;
    }

    public void setPanelBienvenida(PanelBienvenida panelBienvenida) {
        this.panelBienvenida = panelBienvenida;
    }
    /**
     * metodo que nos trae el panelBienvenida
     * @return retorna el panel de Bienvenida
     */
    public PanelMenu getPanelMenu() {
        return panelMenu;
    }

    public void setPanelMenu(PanelMenu panelMenu) {
        this.panelMenu = panelMenu;
    }
    /**
     * metodo que nos trae el panelBienvenida
     * @return retorna el panel de Bienvenida
     */
    public PanelAgregarFilm getPanelAgregarFilm() {
        return panelAgregarFilm;
    }

    public void setPanelAgregarFilm(PanelAgregarFilm panelAgregarFilm) {
        this.panelAgregarFilm = panelAgregarFilm;
    }
    /**
     * metodo que nos trae el panelBienvenida
     * @return retorna el panel de Bienvenida
     */
    public PanelTabla getPanelTabla() {
        return panelTabla;
    }


    /**
     * metodo que nos trae el panelModificarFilm
     * @return retorna el panel de modificar la film
     */
    public PanelModificarFilm getPanelModificarFilm() {
        return panelModificarFilm;
    }

    /**
     * metodo que nos trae el panelBuscarDebut
     * @return retorna el panel de buscar el debut
     */
    public PanelBuscarDebut getPanelBuscarDebut() {
        return panelBuscarDebut;
    }
    /**
     * metodo que nos trae el panelBuscarGenero
     * @return retorna el panel de buscar por genero
     */
    public PanelBuscarGenero getPanelBuscarGenero() {
        return panelBuscarGenero;
    }
    /**
     * metodo que nos trae el panelBuscarTitulo
     * @return retorna el panel para buscar el titulo
     */
    public PanelBuscarTitulo getPanelBuscarTitulo() {
        return panelBuscarTitulo;
    }
    /**
     * metodo que nos trae el panelEliminarFilm
     * @return retorna el panel de eliminar films
     */
    public PanelEliminarFilm getPanelEliminarFilm() {
        return panelEliminarFilm;
    }
    /**
     * metodo que nos trae el panelBuscarCostoso
     * @return retorna el panel de buscar la pelicula mas costosa
     */
    public PanelBuscarCostoso getPanelBuscarCostoso() {
        return panelBuscarCostoso;
    }
    /**
     * metodo que nos trae el panelBuscarClasificaciones
     * @return retorna el panel de buscar por clasificacion
     */
    public PanelBuscarClasificaciones getPanelBuscarClasificaciones() {
        return panelBuscarClasificaciones;
    }
    /**
     * metodo que nos trae el panelBuscarVersiones
     * @return retorna el panel de buscar por versiones
     */
    public PanelBuscarVersiones getPanelBuscarVersiones() {
        return panelBuscarVersiones;
    }
}
