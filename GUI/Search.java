/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Bussines.FileBussines;
import Domain.Movie;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author johana
 */
public class Search extends JInternalFrame implements ActionListener {

    private JLabel jlbMovie;
    private JTextField jtfMovie;
    private JButton jbtnSearch;

    public Search() {
        super();
        this.setLayout(new FlowLayout());
        this.setSize(new Dimension(200, 150));
        this.setClosable(true);
        init();
        this.setVisible(true);
    }//const

    private void init() {
        this.jlbMovie = new JLabel("NombrePelicula: ");
        this.add(this.jlbMovie);
        this.jtfMovie = new JTextField(10);
        this.add(this.jtfMovie);

        this.jbtnSearch = new JButton("Buscar");
        this.jbtnSearch.addActionListener(this);
        this.add(this.jbtnSearch);

    }//init

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbtnSearch) {
            FileBussines ab = new FileBussines();
            Movie pelicula = new Movie();

            JOptionPane.showMessageDialog(null, ab.searchMovie(jtfMovie.getText()));

        }//if
    } //action  
}//clase
