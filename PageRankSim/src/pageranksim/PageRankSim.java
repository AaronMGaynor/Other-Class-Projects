/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pageranksim;
import java.util.Scanner;
/**
 *
 * @author Aaron Gaynor
 */
public class PageRankSim {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("How many pages are in the internet?");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Internet nSize = new Internet(in, n);
    }
}
