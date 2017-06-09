/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Domain.Logic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author jeannette
 */
public class MainWindow extends JFrame implements ActionListener {

    private JComboBox jcbGenero;
    private JDesktopPane desktopPane;
    private JMenuBar jmbMenu;
    private JMenu jmOpciones;
    private JMenuItem jmiInsertMovie, jmiListadoGeneral, jmiListaPorgenero, jmiSearchMovie;

    public MainWindow() {
        super("Renta de Peliculas");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.desktopPane = new JDesktopPane();
        this.desktopPane.setLayout(null);
        this.init();
        this.getContentPane().add(this.desktopPane);
        this.setVisible(true);
    } //constructor

    public void init() {

        this.jmbMenu = new JMenuBar();
        this.setJMenuBar(this.jmbMenu);

        this.jmOpciones = new JMenu("Menu");
        this.jmbMenu.add(this.jmOpciones);

        this.jmiListaPorgenero = new JMenuItem("Peliculas por genero");
        this.jmiListaPorgenero.addActionListener(this);
        this.jmOpciones.add(this.jmiListaPorgenero);

        this.jmiSearchMovie = new JMenuItem("Buscar Pelicula");
        this.jmiSearchMovie.addActionListener(this);
        this.jmOpciones.add(this.jmiSearchMovie);

        this.jmiListadoGeneral = new JMenuItem("Listado General");
        this.jmiListadoGeneral.addActionListener(this);
        this.jmOpciones.add(this.jmiListadoGeneral);

        this.jmiInsertMovie = new JMenuItem("Insertar Pelicula");
        this.jmiInsertMovie.addActionListener(this);
        this.jmOpciones.add(this.jmiInsertMovie);

    }//public void init()

    @Override
    public void actionPerformed(ActionEvent e) {
        Logic logica = new Logic();
        if (e.getSource() == this.jmiInsertMovie) {
            InsertMovie insert = new InsertMovie();
            this.desktopPane.add(insert);
        } else if (e.getSource() == this.jmiListadoGeneral) {

            SearchMovie search = new SearchMovie();

            this.desktopPane.add(search);
            search.show();

        } else if (e.getSource() == this.jmiListaPorgenero) {
            ChooseLists elegirlista = new ChooseLists(this);
            this.desktopPane.add(elegirlista);
            elegirlista.show();
        } else if (e.getSource() == this.jmiSearchMovie) {
            Search i = new Search();
            this.desktopPane.add(i);

        }//else-if

    }//public void actionPerformed(ActionEvent e) 

    public JDesktopPane getDesktopPane() {
        return desktopPane;
    }//getDesktopPane
}//fin clase ventana
