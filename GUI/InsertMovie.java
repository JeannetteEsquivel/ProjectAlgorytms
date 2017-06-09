/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Bussines.FileBussines;
import Domain.Movie;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author johana
 */
public class InsertMovie extends JInternalFrame implements ActionListener {

    private JLabel jlbCode;
    private JTextField jtfCode;
    private JLabel jlbTitle;
    private JTextField jtfTitle;
    private JLabel jlbGender;
    private JLabel jlbTotal;
    private JTextField jtfTotal;
    private JLabel jlbSubtitle;
    private JLabel jlbPremier;
    private JComboBox jcbSubtitle;
    private JComboBox jcbPremier;
    private JComboBox jcbGenero;
    private JButton jbtInsertar;

    public InsertMovie() {
        super();
        this.setLayout(null);
        this.setSize(new Dimension(250, 400));
        this.setClosable(true);
        init();
        this.setVisible(true);
    }//const

    private void init() {
        this.jlbCode = new JLabel("Codigo: ");
        this.jlbCode.setBounds(10, 10, 200, 100);
        this.add(this.jlbCode);
        this.jtfCode = new JTextField(10);
        this.jtfCode.setBounds(90, 50, 100, 20);
        this.add(this.jtfCode);

        this.jlbTitle = new JLabel("Titulo: ");
        this.jlbTitle.setBounds(10, 30, 100, 100);
        this.add(this.jlbTitle);
        this.jtfTitle = new JTextField(10);
        this.jtfTitle.setBounds(90, 70, 100, 20);
        this.add(this.jtfTitle);

        this.jcbGenero = new JComboBox();
        this.jcbGenero.setBounds(90, 90, 100, 20);
        this.add(jcbGenero);

        this.jcbGenero.addItem("Drama");
        this.jcbGenero.addItem("Comedy");
        this.jcbGenero.addItem("Childish");
        this.jcbGenero.addItem("Action");
        this.jcbGenero.addItem("Romance");
        this.jcbGenero.addItem("Fiction");

        this.jlbGender = new JLabel("Genero: ");
        this.jlbGender.setBounds(10, 50, 100, 100);
        this.add(this.jlbGender);

        this.jlbTotal = new JLabel("Total: ");
        this.jlbTotal.setBounds(10, 80, 100, 100);
        this.add(this.jlbTotal);
        this.jtfTotal = new JTextField(10);
        this.jtfTotal.setBounds(90, 120, 100, 20);
        this.add(this.jtfTotal);

        this.jcbSubtitle = new JComboBox();
        this.jcbSubtitle.setBounds(90, 140, 100, 20);
        this.add(jcbSubtitle);

        this.jcbSubtitle.addItem("SI");
        this.jcbSubtitle.addItem("NO");

        this.jcbPremier = new JComboBox();
        this.jcbPremier.setBounds(90, 170, 100, 20);
        this.add(jcbPremier);

        this.jcbPremier.addItem("SI");
        this.jcbPremier.addItem("NO");

        this.jlbSubtitle = new JLabel("Subtitulo: ");
        this.jlbSubtitle.setBounds(10, 100, 100, 100);
        this.add(this.jlbSubtitle);

        this.jlbPremier = new JLabel("Premier: ");
        this.jlbPremier.setBounds(10, 130, 100, 100);
        this.add(this.jlbPremier);

        this.jbtInsertar = new JButton("Ingresar");
        this.jbtInsertar.addActionListener(this);
        this.jbtInsertar.setBounds(65, 250, 100, 20);
        this.add(this.jbtInsertar);

    }//init

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbtInsertar) {
            String genero = "";
            genero = (String) this.jcbGenero.getSelectedItem();
            if (genero == "Drama") {
                genero = "1000";
            } else if (genero == "Comedy") {
                genero = "2000";
            } else if (genero == "Childish") {
                genero = "3000";
            } else if (genero == "Action") {
                genero = "4000";
            } else if (genero == "Romance") {
                genero = "5000";
            } else if (genero == "Fiction") {
                genero = "6000";
            }

            String Subtitle = "";
            Subtitle = (String) this.jcbSubtitle.getSelectedItem();
            if (Subtitle == "SI") {
                Subtitle = 1 + "";
            } else if (Subtitle == "NO") {
                Subtitle = 0 + "";
            }

            String premier = "";
            premier = (String) this.jcbPremier.getSelectedItem();
            if (premier == "SI") {
                premier = 1 + "";
            } else if (premier == "NO") {
                premier = 0 + "";
            }

            FileBussines ab = new FileBussines();
            String cod = (this.jtfCode.getText() + "");
            Movie pelicula = new Movie((this.jtfCode.getText()), this.jtfTitle.getText(),
                    genero, this.jtfTotal.getText(), Subtitle, premier);
            ab.insertMovie(pelicula);
        }//if jbtInsertar

    }//actionPerformed

}//class
