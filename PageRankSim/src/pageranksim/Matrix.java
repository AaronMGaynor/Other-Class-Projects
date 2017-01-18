/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pageranksim;

import static java.lang.Math.abs;

/**
 *
 * @author Aaron Gaynor
 */
public class Matrix {
    private double[][] MatrixArray;
    private int m;
    private int n;
    
    Matrix(int rows, int columns){
        this.m = rows;
        this.n = columns;
        this.MatrixArray = new double[this.m][this.n];
    }
    Matrix(double[][] data){
        this.MatrixArray = data;
        this.m = data.length;
        this.n = data[0].length;
    }
    public double getElement(int row, int column){
        return this.MatrixArray[row][column];
    }
    public void setElement(int row, int column, double x){
        this.MatrixArray[row][column] = x;
    }
    
    public static Matrix multiply(Matrix one, Matrix other){
        if(one.n == other.m){
            Matrix newMatrix = new Matrix(one.m, other.n);
            for(int i = 0; i < one.m; i++){
                for(int j = 0; j <other.n; j++){
                    for(int k = 0; k < one.n; k++){
                        double x = newMatrix.getElement(i, j);
                        double y = one.getElement(i, k) * other.getElement(k, j);
                        newMatrix.setElement(i, j, (x + y));
                    }
                }
            }
            return newMatrix;
        }
        else{
            System.out.println("Matrices not Multiplicable");
        }
        return null;
    }
    
    public static Matrix scalarMultiply(double scalar, Matrix operand){
        Matrix newMatrix = operand;
        for(int i = 0; i < operand.m; i++){
            for(int j = 0; j < operand.n; j++){
                operand.setElement(i, j, scalar * operand.getElement(i, j));
            }
        }
        return newMatrix;
    }
    
    public static Matrix addMatrices(Matrix one, Matrix other){
       Matrix sum = new Matrix(one.m, one.n);
       if((one.m == other.m) && (one.n == other.n)){
           for(int i = 0; i < one.m; i++){
               for(int j = 0; j < one.n; j++){
                   double x = one.getElement(i, j) + other.getElement(i, j);
                   sum.setElement(i, j, x);
               }
           }
           return sum;
       }
       else{
            return null;
       }
    }
        
    public double[][] getNestedDoubleArray(){
        return this.MatrixArray;
    }
    
    public static long sum (Matrix in){
        long sum = 0;
        for(int i = 0; i < in.m; i++){
            for(int j = 0; j< in.n; j++){
                sum += abs(in.getElement(i, j));
            }
        }
        return sum;
    }
    
    public static Matrix Normalize(Matrix in){
        Matrix Normalized = in;
        double sum = 0;
        for(int i = 0; i < in.m; i++){
            for(int j = 0; j< in.n; j++){
                sum += abs(in.getElement(i, j));
            }
        }
        for(int k = 0; k < Normalized.m; k++){
            for(int l = 0; l < Normalized.n; l++){
                Normalized.setElement(k, l, abs(Normalized.getElement(k, l)/sum));
            }
        }
        return Normalized;
    }
    
    
    public static double max(Matrix in){
        double max = in.getElement(0,0);
        for(int i = 0; i < in.m; i++){
            for(int j = 0; j < in.n; j++){
                if(max < in.getElement(i,j)){
                    max = in.getElement(i, j);
                }
            }
        }
        return max;
    }
    
    public static double min(Matrix in){
        double min = in.getElement(0, 0);
        for(int i = 0; i < in.m; i++){
            for(int j = 0; j < in.n; j++){
                if(min > in.getElement(i,j)){
                    min = in.getElement(i, j);
                }
            }
        }
        return min;
    }
    
    public void print(){
        for(int i = 0; i < this.m; i++){
            System.out.print("{ ");
            for(int j = 0; j < this.n; j++){
                System.out.print(this.getElement(i, j) + " ");
            }
            System.out.println(" }");
        }
    }
}
