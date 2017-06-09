/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Domain.Logic;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;

/**
 *
 * @author jeannette
 */
public class ChooseLists extends JInternalFrame implements ActionListener {

    private JComboBox jcbCooseeList;
    private JButton jbtnAgregar;
    private MainWindow mainWindow;

    public ChooseLists(MainWindow main) {
        super("Elegir Genero");
        this.setClosable(true);
        this.setLayout(new FlowLayout());
        this.setSize(300, 300);
        this.mainWindow = main;
        init();
        this.setVisible(true);
    }//const

    public void init() {
        this.jcbCooseeList = new JComboBox();
        this.add(jcbCooseeList);

        this.jcbCooseeList.addItem("Drama");
        this.jcbCooseeList.addItem("Comedy");
        this.jcbCooseeList.addItem("Childish");
        this.jcbCooseeList.addItem("Action");
        this.jcbCooseeList.addItem("Romance");
        this.jcbCooseeList.addItem("Fiction");

        this.jbtnAgregar = new JButton("Agregar");
        this.jbtnAgregar.addActionListener(this);
        this.add(this.jbtnAgregar);
    }//init

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbtnAgregar) {
            String genero = "";
            genero = (String) this.jcbCooseeList.getSelectedItem();

            Logic logica = new Logic();
            if (genero == "Drama") {

                UploadAlist cargarUnaLista = new UploadAlist(logica.Drama());
                this.mainWindow.getDesktopPane().removeAll();//quita lo que hay en el desk
                this.mainWindow.getDesktopPane().add(cargarUnaLista);
                cargarUnaLista.show();

            } else if (genero == "Drama") {
                UploadAlist cargarUnaLista = new UploadAlist(logica.Drama());
                this.mainWindow.getDesktopPane().removeAll();//quita lo que hay en el desk
                this.mainWindow.getDesktopPane().add(cargarUnaLista);
                cargarUnaLista.show();
            } else if (genero == "Comedy") {
                UploadAlist cargarUnaLista = new UploadAlist(logica.Comedy());
                this.mainWindow.getDesktopPane().removeAll();//quita lo que hay en el desk
                this.mainWindow.getDesktopPane().add(cargarUnaLista);
                cargarUnaLista.show();
            } else if (genero == "Childish") {
                UploadAlist cargarUnaLista = new UploadAlist(logica.Childisch());
                this.mainWindow.getDesktopPane().removeAll();//quita lo que hay en el desk
                this.mainWindow.getDesktopPane().add(cargarUnaLista);
                cargarUnaLista.show();
            } else if (genero == "Action") {
                UploadAlist cargarUnaLista = new UploadAlist(logica.Action());
                this.mainWindow.getDesktopPane().removeAll();//quita lo que hay en el desk
                this.mainWindow.getDesktopPane().add(cargarUnaLista);
                cargarUnaLista.show();
            } else if (genero == "Romance") {
                UploadAlist cargarUnaLista = new UploadAlist(logica.Romance());
                this.mainWindow.getDesktopPane().removeAll();//quita lo que hay en el desk
                this.mainWindow.getDesktopPane().add(cargarUnaLista);
                cargarUnaLista.show();
            } else if (genero == "Fiction") {
                UploadAlist cargarUnaLista = new UploadAlist(logica.Fiction());
                this.mainWindow.getDesktopPane().removeAll();//quita lo que hay en el desk
                this.mainWindow.getDesktopPane().add(cargarUnaLista);
                cargarUnaLista.show();
            }
            //

        }//if boton
    }//actionPerformed

}//class
