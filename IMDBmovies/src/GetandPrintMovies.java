
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Aaron Gaynor
 * @since September 2, 2014
 * Everything is tested and working according to specifications.
 */
public class GetandPrintMovies {
    Deque movieDeque = new Deque();
    String urlString = null;
    URL urlObject = null;
    String urlData;
    JSONObject movieData;
    
    /**
     * This method takes a movie title and opens a URL stream to receive a JSONObject
     * representing that movie's data. It depends on nothing.(This method was built
     * using the preexisting structure in "ExampleWebAPICall" by Dr Christopher Starr.
     * @param inputString this is the movie title
     * @return movieData this is the JSONObject represent the movie's data
     */
    public JSONObject getMovieData(String inputString) {

		try {
			// get rid of the white spaces in a URL string
			inputString = inputString.replace(" ", "+");
			
			//now add the parameters for the web app call
			urlString = "http://www.omdbapi.com/?t=" + inputString + "&r=JSON"; //XML is also supported
			
			//create the URL object so that a web connection can be opened.
			URL urlObject = new URL(urlString);
			
			//connect the open connection to the scanner
			Scanner urlStream = new Scanner(urlObject.openStream());

			//request the return value from the server
			urlData = urlStream.nextLine();
                        movieData = new JSONObject(urlData);

		} catch (Exception e) {
			System.out.println(e);
		}
		return movieData;
	}
    
    /**
     * This method puts the JSONObject representing the movie data into the Deque
     * movieDeque. It depends on the class Deque.
     * @param movieData this is the JSONObject representing the movie data 
     */
    public void queueMovie(JSONObject movieData){
        movieDeque.addLast(movieData);
    }

    
    public static void main(String[] args) {
        GetandPrintMovies currentRun = new GetandPrintMovies();
        
        try {
            File file = new File("MovieTitles.txt");
            Scanner fileReader = new  Scanner(file);
            while(fileReader.hasNextLine()){
                JSONObject movieJSON = currentRun.getMovieData(fileReader.nextLine());
                currentRun.queueMovie(movieJSON);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GetandPrintMovies.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        DequeIterator newIterator = currentRun.movieDeque.iterator();
        while(newIterator.hasNext()){
            System.out.println(newIterator.next());
        }
    
       
    }
}
