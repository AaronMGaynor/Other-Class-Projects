/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pageranksim;

import java.util.Scanner;
import org.jblas.DoubleMatrix;
import org.jblas.ComplexDoubleMatrix;
import org.jblas.Eigen;
import org.jblas.ComplexDouble;
/**
 *
 * @author Aaron Gaynor
 */
public class Internet {
    private int n;
    private double alpha = .87;
    private Matrix linkMatrix;
    private Matrix WVector;
    private Matrix DVector;
    private Matrix CMatrix;
    private Matrix GMatrix;
    private Matrix PageRankVector;
    private Matrix PowerMethodVector;
    
    Internet(Scanner nextElement, int n){
        this.n = n;
        this.linkMatrix = buildMatrix(nextElement);
        this.linkMatrix.print();
        this.DVector = getDVector();
        this.WVector = getWVector();
        System.out.println("D Vector is");
        DVector.print();
        this.CMatrix = getCMatrix();
        System.out.println("C Matrix is");
        this.CMatrix.print();
        this.GMatrix = getGMatrix();
        System.out.println("G Matrix is");
        this.GMatrix.print();
        this.PageRankVector = getPageRankVector();
        System.out.println("Page Rank Vector is");
        this.PageRankVector.print();
        this.PowerMethodVector = getPowerMethodVector();
        System.out.println("Page Rank Vector from Power Method is ");
        this.PowerMethodVector.print();
    }
    public Matrix getMatrix(){
        return linkMatrix;
    }
    
    private Matrix buildMatrix(Scanner nextElement){
        Matrix buildingMatrix = new Matrix(this.n, this.n);
        for(int i = 0; i<this.n; i++){
            for(int j = 0; j<this.n; j++){
                System.out.printf("Enter element " + (j + 1) + " of row " + (i + 1) + ": ");
                buildingMatrix.setElement(i, j, nextElement.nextDouble());
            }
        }
        return buildingMatrix;
    }
    
    private Matrix getWVector(){
        double[][] w = new double[1][this.n];
        for(int i=0; i< this.n; i++){
            w[0][i] = (1.0/(double) this.n);
        }
        Matrix WVector = new Matrix(w);
        System.out.println("WVector is");
        WVector.print();
        return WVector;
    }
    private Matrix getDVector(){
        Matrix DVector = new Matrix(this.n, 1);
        for(int i = 0; i<this.n; i++){
            double opposite = 0;
            for(int j = 0; j< this.n; j++){
                opposite += this.linkMatrix.getElement(i, j);
            }
            if(opposite == 1){
                DVector.setElement(i, 0, 0);
            }
            else{
                DVector.setElement(i, 0, 1);
            }
        }
        return DVector;
    }
    
    private Matrix getCMatrix(){
        Matrix matrixC = new Matrix(this.n, this.n);
        matrixC = Matrix.addMatrices(this.linkMatrix, Matrix.multiply(DVector, WVector));
        return matrixC;
    }
    
    private Matrix getGMatrix(){
        Matrix matrixG = new Matrix(this.n, this.n);
        for(int i = 0; i< this.n; i++){
            for(int j = 0; j< this.n; j++){
                matrixG.setElement(i, j, (this.alpha * this.CMatrix.getElement(i, j)) + ((1.0 - alpha) * WVector.getElement(0, i)));
            }
        }
        return matrixG;
    }
    
    //This section coded by adaptation from this source code in javascript: http://www.markhneedham.com/blog/2013/08/05/javajblas-calculating-eigenvector-centrality-of-an-adjacency-matrix/
    private Matrix getPageRankVector(){
        DoubleMatrix matrix = new DoubleMatrix(this.GMatrix.getNestedDoubleArray());
        ComplexDoubleMatrix eigenvalues = Eigen.eigenvalues(matrix);
        ComplexDoubleMatrix eigenvectors = Eigen.eigenvectors(matrix)[0];
        int index = -1;
        double[] values = eigenvalues.toDoubleArray();
        for(int i=0; i<values.length; i++){
            double valueAtI = Math.round(values[i] * Math.pow(10.0, 3))/(Math.pow(10.0, 3));
            if(valueAtI == 1.00){
                index = i;
            }
        }
        ComplexDoubleMatrix PageRankColumn = eigenvectors.getColumn(index);
        ComplexDouble[] PRvalues = PageRankColumn.toArray();
        double total = 0;
        for(int i=0; i<PRvalues.length; i++){
            total += PRvalues[i].abs();
        }
        
        double[][] PRvector = new double[PRvalues.length][1];
        for(int i=0; i<PRvalues.length; i++){
            PRvector[i][0] = PRvalues[i].abs()/total;
        }
        Matrix vectorToMatrix = new Matrix(PRvector);
        return vectorToMatrix;
    }
    
    private Matrix getPowerMethodVector(){
        Matrix piK = this.WVector;
        Matrix piKplus1 = piK;
        for(int i = 0; i<500; i++){
            piK = piKplus1;
            Matrix A = Matrix.scalarMultiply(this.alpha, Matrix.multiply(piK, this.linkMatrix));
            Matrix B = Matrix.scalarMultiply(this.alpha, Matrix.multiply(Matrix.multiply(piK, this.DVector), this.WVector));
            Matrix C = Matrix.scalarMultiply((1.0-this.alpha), this.WVector);
            piKplus1 = Matrix.addMatrices(A, Matrix.addMatrices(B, C));
        }
        Matrix.Normalize(piK);
        return piK;
    }
}
