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
 * @author johana
 *
 *
 */
public class SearchMovie extends JInternalFrame {

    JTable jtbPrueba;
    DefaultTableModel dtmModeloPrueba;
    CircularList drama;
    CircularList action, comedy, fiction, chilidish, romance, ListaGeneral;

    public SearchMovie() {
        super("Listado General");
        this.ListaGeneral = new CircularList();
        this.drama = new CircularList();
        comedy = new CircularList();
        chilidish = new CircularList();
        action = new CircularList();
        romance = new CircularList();
        fiction = new CircularList();

        this.setClosable(true);
        this.setLayout(new FlowLayout());
        this.setSize(800, 600);
        init();
        this.setVisible(true);
    }//constructor

    public void init() {
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

        clasificar(drama);
        clasificar(comedy);
        clasificar(chilidish);
        clasificar(action);
        clasificar(romance);
        clasificar(fiction);

        this.jtbPrueba = new JTable(this.dtmModeloPrueba);
        JScrollPane scrollPane = new JScrollPane(this.jtbPrueba);
        this.getContentPane().add(scrollPane);
    }//public void init()

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

}//fin clase Entrar
