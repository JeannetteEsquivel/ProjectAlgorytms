/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author jeannette
 */
public class CircularList {
    private Nodo head;
    private Nodo tail;
    private Nodo node;
    private int size;
    Nodo nodo;

    public CircularList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }//constructor

    public void insertInOrder(Movie pelicula) {
        
        Nodo newNodeCountry = new Nodo(pelicula);
        Nodo node = this.getHead();

        while (node != null && node.getMovie().getTitle().compareTo(newNodeCountry.getMovie().getTitle()) < 0) {
            if (node == this.getTail()) {
                break;
            }//if para saber si llego al final de la lista
            node = node.getNext();
        }//while para recorrer la lista

        if (getSize() == 0) {
            this.setHead(newNodeCountry);
            this.setTail(newNodeCountry);
            this.getTail().setNext(this.getHead());
            this.getHead().setPrev(this.getTail());
        } else {
            if (node == this.getHead()) {
                if (node.getMovie().getTitle().compareTo(newNodeCountry.getMovie().getTitle()) > 0) {
                    newNodeCountry.setNext(this.getHead());
                    newNodeCountry.setPrev(this.getTail());
                    this.getHead().setPrev(newNodeCountry);
                    this.setHead(newNodeCountry);
                    this.getTail().setNext(this.getHead());
                    this.getHead().setPrev(this.getTail());
                } else {
                    newNodeCountry.setPrev(this.getHead());
                    newNodeCountry.setNext(this.getTail());
                    this.getHead().setNext(newNodeCountry);
                    this.setTail(newNodeCountry);
                    this.getTail().setNext(this.getHead());
                    this.getHead().setPrev(this.getTail());
                }//if si el nuevo nodo va antes o despues de head
            } else {
                if (node == this.getTail() && node.getMovie().getTitle().compareTo(newNodeCountry.getMovie().getTitle()) < 0) {
                    newNodeCountry.setPrev(this.getTail());
                    newNodeCountry.setNext(this.getHead());
                    this.getTail().setNext(newNodeCountry);
                    this.setTail(newNodeCountry);
                    this.getHead().setPrev(this.getTail());
                    this.getTail().setNext(this.getHead());
                } else {
                    node.getPrev().setNext(newNodeCountry);
                    newNodeCountry.setPrev(node.getPrev());
                    newNodeCountry.setNext(node);
                    node.setPrev(newNodeCountry);
                }//if para saber si el nuevo nodo va despues de tail o esta en medio de la lista
            }//if el en que posicion va el nuevo nodo
        }//if la lista esta llena o no
        this.setSize(this.getSize() + 1);
    }//fin method


    public void printList() {
        Nodo temp = this.getHead();
        //System.out.println("List size: " + this.getSize());
        System.err.print(this.getTail().getMovie().getTitle() + "<-->");
        if (this.getSize() > 0) {
            while (temp != this.getTail()) {
                System.err.print(temp.getMovie().getTitle() + "<-->");
                temp = temp.getNext();
                if (temp == this.getTail()) {
                    System.err.print(temp.getMovie().getTitle() + "<-->");
                }//if
            }//while
            //System.err.println(this.getHead().getPelicula().getTitulo());
        }//if
    }//end Method

    public Nodo getHead() {
        return head;
    }

    public void setHead(Nodo head) {
        this.head = head;
    }

    public Nodo getTail() {
        return tail;
    }

    public void setTail(Nodo tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Nodo getNode() {
        return node;
    }

    public void setNode(Nodo node) {
        this.node = node;
    } 
}//class
