/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import Bussines.FileBussines;
import java.util.ArrayList;

/**
 *
 * @author jeannette
 */
public class Logic {

    CircularList action, comedy, fiction, chilidish, romance, ListaGeneral,drama;

    public Logic() {
        this.drama = new CircularList();
        comedy = new CircularList();
        chilidish = new CircularList();
        action = new CircularList();
        romance = new CircularList();
        fiction = new CircularList();
        clasificar();
    }//constructor

    public void clasificar() {
        FileBussines archivo = new FileBussines();
        archivo.readFile();
        ArrayList<Movie> lista1 = new ArrayList<>();
        ListaGeneral = archivo.readFile();

        Nodo head = null;
        Nodo tail = ListaGeneral.getTail();
        Nodo temp = ListaGeneral.getHead();
        int size = 0;

        while (temp != tail) {
            if (temp.getMovie().getGender().equals("1000")) {
                drama.insertInOrder(temp.getMovie());
            } else if (temp.getMovie().getGender().equals("2000")) {
                comedy.insertInOrder(temp.getMovie());
            } else if (temp.getMovie().getGender().equals("3000")) {
                chilidish.insertInOrder(temp.getMovie());
            } else if (temp.getMovie().getGender().equals("4000")) {
                action.insertInOrder(temp.getMovie());
            } else if (temp.getMovie().getGender().equals("5000")) {
                romance.insertInOrder(temp.getMovie());
            } else if (temp.getMovie().getGender().equals("6000")) {
                fiction.insertInOrder(temp.getMovie());
            }

            temp = temp.getNext();
        }
        if (temp == tail) {
            if (temp.getMovie().getGender().equals("1000")) {
                drama.insertInOrder(temp.getMovie());
            } else if (temp.getMovie().getGender().equals("2000")) {
                comedy.insertInOrder(temp.getMovie());
            } else if (temp.getMovie().getGender().equals("3000")) {
                chilidish.insertInOrder(temp.getMovie());
            } else if (temp.getMovie().getGender().equals("4000")) {
                action.insertInOrder(temp.getMovie());
            } else if (temp.getMovie().getGender().equals("5000")) {
                romance.insertInOrder(temp.getMovie());
            } else if (temp.getMovie().getGender().equals("6000")) {
                fiction.insertInOrder(temp.getMovie());
            }

        }
        
    }
    
    public CircularList Drama(){
        return this.drama;
    }
    
    public CircularList Comedy(){
        return this.comedy;
    }
    
    public CircularList Childisch(){
        return this.chilidish;
    }
    
    public CircularList Action(){
        return this.action;
    }
    
    public CircularList Romance(){
        return this.romance;
    }
    
    public CircularList Fiction(){
        return this.fiction;
    }
}//class
