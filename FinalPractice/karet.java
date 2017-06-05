// Copyright Karat, Inc. 2016-2017 - Please do not distribute or republish.

import java.io.*;
import java.util.*;

/*
 * The image you get is known to have N rectangles of 0s on a background of 1s. Write a function that takes in the image and outputs the coordinates of all the 0 rectangles -- top-left and bottom-right; or top-left, width and height.
 */

class karet {
  
   static List<Integer> coords = new ArrayList<>();
  // Sample out
  static int[][] image = {  
    {1, 1, 1, 1, 1, 1, 1},
    {1, 1, 1, 1, 1, 1, 1},
    {1, 1, 1, 0, 0, 0, 1},
    {1, 0, 1, 0, 0, 0, 1},
    {1, 0, 1, 1, 1, 1, 1},
    {1, 0, 1, 0, 0, 1, 1},
    {1, 1, 1, 0, 0, 1, 1},
    {1, 1, 1, 1, 1, 1, 1},
  };  
  
  // Row = 2, column = 3 
  // OR
  // x = 3, y = 2
  
  // Sample output:  [ 2, 3, 3, 5 ], [ 3, 1, 5, 1 ], [ 5, 3, 6, 4 ]
  // Your function here
  
  
  public static List<Integer> findZeroCoordinates(int[] [] img){
    for(int r=0; r<image.length; r++){
          for(int c=0; c<image[0].length; c++){
              if(image[r][c]==0){
                  System.out.println("r" + r + "c" +c);
                  helper (r,c,image);
              }
          }
      }
      return coords;
  }
  
  public static void helper(int r, int c, int[][] image){
        int rlimit=r;
        int climit=c;
        //Find right limit
        for(int i=r+1; i<image.length; i++){
            if(image[i][c]==0)
            {    
                rlimit=i;
            } 
            else
            break;
        }
        //Find lower limit
         for(int j=c+1; j<image[0].length; j++){
         if(image[r][j]==0)
            {    climit=j;
            } 
            else
            break;
        }
        
        // Check zeroes

            for(int i=r; i<=rlimit; i++){
                for(int j=c; j<=climit; j++){
                    if(image[i][j]==0){
                        image[i][j]=1;
                    }
                }
            }
        coords.add(r);
        coords.add(c);
        coords.add(rlimit);
        coords.add(climit);
        
        System.out.println(coords);
  }
  
  public static void main(String[] args){
      findZeroCoordinates(image);
      
  }
  
}