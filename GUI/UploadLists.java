/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Domain.CircularList;
import java.awt.FlowLayout;
import java.io.IOException;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jeannette
 */
public class UploadLists extends JInternalFrame {

    private JComboBox jcbGenero;
    CircularList listComedy, listChildish, listAction, listRomance, listFiction,listDrama;
    JTable jtbPrueba;
    DefaultTableModel dtmModeloPrueba;

    public UploadLists() throws IOException, ClassNotFoundException {
        super();
        this.setSize(500, 500);
        this.setLayout(new FlowLayout());
        listDrama = new CircularList();
        listComedy = new CircularList();
        listChildish = new CircularList();
        listAction = new CircularList();
        listRomance = new CircularList();
        listFiction = new CircularList();
        init();
        this.setVisible(true);
    }//const

    private void init() throws IOException, ClassNotFoundException {
        this.dtmModeloPrueba = new DefaultTableModel(0, 0);

        this.dtmModeloPrueba.addColumn("Codigo");
        this.dtmModeloPrueba.addColumn("Titulo");
        this.dtmModeloPrueba.addColumn("Genero");
        this.dtmModeloPrueba.addColumn("Total");
        this.dtmModeloPrueba.addColumn("Subtitulo");
        this.dtmModeloPrueba.addColumn("Premier");
        this.listAction.printList();

    }//init

}//class
