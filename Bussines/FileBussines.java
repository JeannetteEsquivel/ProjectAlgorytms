/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussines;

import Data.FileData;
import Domain.CircularList;
import Domain.Movie;

/**
 *
 * @author johana
 */
public class FileBussines {

    FileData fileData;

    public FileBussines() {
        fileData = new FileData();
    }//const

    public void insertMovie(Movie movie) {
        this.fileData.insertMovie(movie);
    }//insertMovie

     public CircularList readFile() {
        return this.fileData.readFile();
    }//readFile
<<<<<<< HEAD

    public Movie searchMovie(String movie) {
        return this.fileData.searchMovie(movie);
    }//searchMovie
=======
>>>>>>> 98040511a6ae6cfac34441f8896babb432596b1a
    
}//class
