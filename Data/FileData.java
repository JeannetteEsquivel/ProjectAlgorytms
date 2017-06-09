/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Domain.CircularList;
import Domain.Movie;
import com.csvreader.CsvReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import com.csvreader.CsvWriter;
import java.io.FileNotFoundException;

/**
 *
 * @author johanna
 *
 */
public class FileData {

    File file = new File("datos.csv");
    CircularList circularList;

    public FileData() {
        circularList = new CircularList();
    }//const
    
    public void insertMovie(Movie movie) {

        boolean alreadyExists = new File("datos").exists();

        if (alreadyExists) {
            File ArchivoEmpleados = new File("datos");
            ArchivoEmpleados.delete();
        }//if

        try {
            CsvWriter csvOutput = new CsvWriter(new FileWriter(file, true), ',');
            csvOutput.write((movie.getCode()));
            csvOutput.write(movie.getTitle());
            csvOutput.write(movie.getGender());
            csvOutput.write(movie.getTotal());
            csvOutput.write(movie.getSubtitle());
            csvOutput.write(movie.getPremier());
            csvOutput.endRecord();
            csvOutput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }//insertar

    public CircularList readFile() {
        ArrayList<Movie> lista1 = new ArrayList<>();
        try {
            CsvReader empleados_import = new CsvReader("datos.csv");
            empleados_import.readHeaders();
            
            while (empleados_import.readRecord()) {
                Movie peliNueva = new Movie();
                
                String code = empleados_import.get(0);
                String title = empleados_import.get(1);
                String gender = empleados_import.get(2);
                String total = empleados_import.get(3);
                String subtitle = empleados_import.get(4);
                String premier = empleados_import.get(5);
                
                peliNueva.setCode(code);
                peliNueva.setTitle(title);
                peliNueva.setGenero(gender);
                peliNueva.setTotal(total);
                peliNueva.setSubtitle(subtitle);
                peliNueva.setPremier(premier);

                circularList.insertInOrder(peliNueva);
                lista1.add(peliNueva);
            }
            empleados_import.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return circularList;
    }//LeerArchivo 

<<<<<<< HEAD
    public Movie searchMovie(String movie) {
        java.util.List<Movie> listPelicula = new ArrayList<Movie>();
        try {
            CsvReader movie_import = new CsvReader("datos.csv");
            movie_import.readHeaders();
            while (movie_import.readRecord()) {
                String code = movie_import.get(0);
                String title = movie_import.get(1);
                String gender = movie_import.get(2);
                String total = movie_import.get(3);
                String subTitle = movie_import.get(4);
                String premier = movie_import.get(5);
                if (title.equals(movie)) {
                    Movie movie1 = new Movie(code, title, gender, total, subTitle, premier);
                    return movie1;
                }//if
            }//while
            movie_import.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }//buscar

=======
>>>>>>> 98040511a6ae6cfac34441f8896babb432596b1a
}//class
