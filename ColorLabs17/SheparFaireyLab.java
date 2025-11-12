
/**
 * Write a description of class SheparFaireyLab here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

public class SheparFaireyLab
{
    /**
     * main method, to test the picture
     *  
     */
    public static void main(String[] args)
    {
        
         //opens selfie picture 
          /*
         String fileName = FileChooser.pickAFile();
         Picture pictObj = new Picture(fileName);
         pictObj.explore();
         */
        
         //relative path
         Picture apic = new Picture("images\\beach.jpg");
         //change with selfie picture
         Picture me = new Picture("images/beach.jpg");
         Picture me1 = new Picture("images/beach.jpg");
         Picture me2 = new Picture("images/beach.jpg");
         
         Pixel [] pixels1;
         pixels1=me.getPixels();
         int red, green, blue,avg ;
         
         /*
         //method 1
         for (Pixel spot1 : pixels1)
         {
             red = spot1.getRed();
             green = spot1.getGreen();
             blue = spot1.getBlue();
             
             avg = (red+blue+green)/3;
             
             spot1.setColor(new Color (avg,avg,avg));
         }
         
         for (Pixel spot1 : pixels1)
         {
            red = spot1.getRed();
             if (red<63)
                spot1.setColor(new Color (0,0,139));
             else if (red>=63 && red<127)
                 spot1.setColor(Color.red);
             else if (red>=127 && red<191)
                 spot1.setColor(new Color (173,216,230));
             else if (red>=191 && red<=255)
                 spot1.setColor(new Color (245,245,245));
         }
         me.explore();
         me.write("images/SFtry1");
         
         //method 2
         pixels1=me1.getPixels();
         */
         int prev=0, max=0, min=0;
         //method 2
         /*
         for (Pixel spot1 : pixels1)
         {
             red = spot1.getRed();
             green = spot1.getGreen();
             blue = spot1.getBlue();
             
             avg = (red+blue+green)/3;
             
             if (avg>prev && avg>max)
                 max=avg;
             else if (avg<min)
                 min=avg;
             prev = avg;
             spot1.setColor(new Color (avg,avg,avg));
         }
         
         int range = max-min;
         double sections = range/4;
         
         for (Pixel spot1 : pixels1)
         {
             red = spot1.getRed();
             if (red<(int)sections)
                spot1.setColor(new Color (0,0,139));
             else if (red>=(int)sections && red<(int)(2*sections))
                 spot1.setColor(Color.red);
             else if (red>=(int)(2*sections) && red<(int)(3*sections))
                 spot1.setColor(new Color (173,216,230));
             else if (red>=(int)(3*sections) && red<=(int)(4*sections))
                 spot1.setColor(new Color (245,245,245));
         }
         
         me1.explore();
         me.write("images/SFtry2");
         
         */
        
        //method three
        pixels1=me2.getPixels();
         for (Pixel spot1 : pixels1)
         {
             red = spot1.getRed();
             green = spot1.getGreen();
             blue = spot1.getBlue();
             
             avg = (red+blue+green)/3;
             
             if (avg>prev && avg>max)
                 max=avg;
             else if (avg<min)
                 min=avg;
             prev = avg;
             spot1.setColor(new Color (avg,avg,avg));
         }
         
         int range = max-min;
         double sections = range/4;
         
         for (Pixel spot1 : pixels1)
         {
             red = spot1.getRed();
             if (red<(int)sections)
                spot1.setColor(new Color (0,0,139));
             else if (red>=(int)sections && red<(int)(2*sections))
                 spot1.setColor(Color.red);
             else if (red>=(int)(2*sections) && red<(int)(3*sections))
                 spot1.setColor(new Color (173,216,230));
             else if (red>=(int)(3*sections) && red<=(int)(4*sections))
                 spot1.setColor(new Color (245,245,245));
         }
         /**
          * method 2 change
          * 
          */
         
         /**
          * custom color palette
          */

        //copy of pic!! rename pic!!
        //object.write("images/SFtry1");
    }//main       
}//class
