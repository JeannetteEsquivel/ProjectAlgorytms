/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Domain.CircularList;
import Domain.Logic;
import Domain.Nodo;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jeannette
 */
public class UploadAlist extends JInternalFrame implements ActionListener {

    JTable jtbPrueba;
    DefaultTableModel dtmModeloPrueba;
    CircularList action, comedy, fiction, chilidish, romance,drama;

    public UploadAlist(CircularList lista) {

        super("Listado General");

        this.drama = new CircularList();
        comedy = new CircularList();
        chilidish = new CircularList();
        action = new CircularList();
        romance = new CircularList();
        fiction = new CircularList();

        //this.desktopPane = new JDesktopPane();
        this.setClosable(true);
        this.setLayout(new FlowLayout());
        this.setSize(800, 600);
        init(lista);
        this.setVisible(true);
    }//constructor

    public void init(CircularList lista) {
        this.dtmModeloPrueba = new DefaultTableModel(0, 0);

        Logic logica = new Logic();
        drama = logica.Drama();
        comedy = logica.Comedy();
        chilidish = logica.Childisch();
        action = logica.Action();
        romance = logica.Romance();
        fiction = logica.Fiction();

        this.dtmModeloPrueba = new DefaultTableModel();
        this.dtmModeloPrueba.addColumn("Codigo");
        this.dtmModeloPrueba.addColumn("Titulo");
        this.dtmModeloPrueba.addColumn("Genero");
        this.dtmModeloPrueba.addColumn("Total");
        this.dtmModeloPrueba.addColumn("Subtitulo");
        this.dtmModeloPrueba.addColumn("Premier");

        clasificar(lista);

        this.jtbPrueba = new JTable(this.dtmModeloPrueba);
        JScrollPane scrollPane = new JScrollPane(this.jtbPrueba);
        this.getContentPane().add(scrollPane);

    }//public void init()

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void clasificar(CircularList ListaActual) {
        Nodo head = null;
        Nodo tail = ListaActual.getTail();
        Nodo temp = ListaActual.getHead();
        int size = 0;
        
        while (temp != tail) {
            this.dtmModeloPrueba.addRow(new Object[]{temp.getMovie().getCode(), 
                temp.getMovie().getTitle(), temp.getMovie().getGender(), 
                temp.getMovie().getTotal(), temp.getMovie().getSubtitle(),
                temp.getMovie().getPremier()});
            temp = temp.getNext();
        }
        if (temp == tail) {
            this.dtmModeloPrueba.addRow(new Object[]{temp.getMovie().getCode(), 
                temp.getMovie().getTitle(), temp.getMovie().getGender(), 
                temp.getMovie().getTotal(), temp.getMovie().getSubtitle(),
                temp.getMovie().getPremier()});
        }//if

    }//clasificar

}//class
