import java.awt.*;
import java.util.*;
import java.util.List;
/**
 * Write a description of class finalProject here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class finalProject
{
   
    public static void main(String[] args)
    {
        Picture chamog = new Picture("images/ogchame.png");
        Picture canvas = new Picture("images/poster.png");
        Picture cham1 = new Picture("images/ogchame.png");
        Picture cham2 = new Picture("images/ogchame.png");
        Picture cham3 = new Picture("images/ogchame.png");
        Picture cham4 = new Picture("images/ogchame.png");
        Picture cham5 = new Picture("images/ogchame.png");
        copytoCanvas(chamog, canvas, 0, 0);
        mirrorVertical(cham1);
        cham1.explore();
        copytoCanvas(cham1, canvas, 1000, 0);
        grayscale(cham2);
        copytoCanvas(cham2, canvas, 2000, 0);
        enlarge(cham3, canvas, 0, 1000);
        sepia(cham4,0,0);
        cham4.explore();
        copytoCanvas(cham4, canvas, 1000,1000);
        recursive(cham5, canvas, 2000, 1000, 1);
        canvas.explore();
        canvas.write("images/poster.png");
    }
   
    //grayscale
     public static void grayscale(Picture source)
     {
     Pixel[] pixels3;
     pixels3=source.getPixels();
     int avg=0;
     int red, blue, green;
     for (Pixel spot1 : pixels3)
     {
         red = spot1.getRed();
         blue = spot1.getBlue();
         green = spot1.getGreen();
         
         avg = (red+blue+green)/3;
         
         spot1.setRed(avg);
         spot1.setBlue(avg);
         spot1.setGreen(avg);
     }
    }
    
    /**
     * Method to mirror on a vertical line in the middle of the picture based on the width
     */
    public static void mirrorVertical(Picture source)
    {
        int width = source.getWidth();
        int mirrorPoint = width / 2;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
       
        //loop through all the rows
        for (int y = 0; y < source.getHeight(); y++)
        {
            //loop from 0 to the middle
            for (int x = 0; x < mirrorPoint; x++)
            {
                leftPixel = source.getPixel(x, y);
                rightPixel = source.getPixel(width - 1 - x, y);
                rightPixel.setColor(leftPixel.getColor());
               
            }
        }
    }
    
    /**
     * Method to copy one picture to another
     * Add two ints to params
     */
    public static void enlarge(Picture source, Picture target, int x, int y)
    {
        Pixel sourcePix = null;
        Pixel targetPix = null;
       
        //loop through all the columns; targetX is starting point on canvas; sourceX+=2 smaller
                                                            //source x+=.5 larger, copy every pixel 2x, cast as int in getPixel and setColor
        for (double sourceX = 250, targetX = x; sourceX < source.getWidth()*3/4; sourceX+=.5, targetX++)
        {
            //loop through the rows                                         sourceY += 2, copy every other pixel
                                                                           // sourceY += .5, copy  other pixel
            for (double sourceY = 0, targetY = y; sourceY < source.getHeight()/2; sourceY+=.5, targetY++)
            {
                sourcePix = source.getPixel((int)sourceX, (int) sourceY);
                targetPix = target.getPixel( (int)targetX,(int) targetY);
                targetPix.setColor(sourcePix.getColor());
            }
        }
        /** recursive version
        Pixel sourcePix = null;
        Pixel targetPix = null;
        if (sourceX==3*source.getWidth()/4 || sourceY==3*source.getHeight()/4)
            return;
        else
            {
                sourcePix = source.getPixel((int)sourceX, (int)sourceY);
                targetPix = target.getPixel(targetX, targetY);
                targetPix.setColor(sourcePix.getColor());
                enlarge(source, target, sourceX+=.5,targetX++, sourceY+=.5, targetY++);
            }
            */
    } 
    
    public static void sepia(Picture source, int x, int y)
    {
        double sred = 0.88;
        double sgreen = 0.52;
        double sblue = 0.16;
        
       for (int sourceX =0, targetX = 0; sourceX < source.getWidth(); sourceX++, targetX++)
        {
            //loop through the rows                                         sourceY += 2, copy every other pixel
                                                                           // sourceY += .5, copy  other pixel
            for (int sourceY = 0, targetY = 0; sourceY < source.getHeight(); sourceY++, targetY++)
            {
                Pixel a = source.getPixel(sourceX,sourceY);
                int red = a.getRed();
            int green = a.getGreen();
            int blue = a.getBlue();
            int avg = (red+blue+green)/3;
            red = (int)(avg*sred);
            //System.out.println(a + "--" + green + "?" + avg);
            
            green = (int)(avg*sgreen);
            
            blue = (int)(avg*sblue);
           
            a.setColor(new Color(red,green,blue));
            
    
            }
        }
        
        }
       
    public static void recursive(Picture source, Picture target, int x, int y, int n)
    {
        Pixel sourcePix = null;
        Pixel targetPix = null;
       
        if (n>20)
            return;
        else
        {//loop through all the columns; targetX is starting point on canvas; sourceX+=2 smaller
                                                            //source x+=.5 larger, copy every pixel 2x, cast as int in getPixel and setColor
        for (double sourceX = 0, targetX = x; sourceX < source.getWidth(); sourceX+=n, targetX++)
        {
            //loop through the rows                                         sourceY += 2, copy every other pixel
                                                                           // sourceY += .5, copy  other pixel
            for (double sourceY = 0, targetY = y; sourceY < source.getHeight(); sourceY+=n, targetY++)
            {
                sourcePix = source.getPixel((int)sourceX, (int) sourceY);
                targetPix = target.getPixel( (int)targetX,(int) targetY);
                targetPix.setColor(sourcePix.getColor());
            }
        }
        recursive(source, target, x, y, n*2);
            }
    }
    /**
     * Method to copy one picture to another
     * Add two ints to params
     */

    public static void copytoCanvas(Picture source, Picture target, int x, int y)
    {
        Pixel sourcePix = null;
        Pixel targetPix = null;
       
        //loop through all the columns; targetX is starting point on canvas; sourceX+=2 smaller
                                                            //source x+=.5 larger, copy every pixel 2x, cast as int in getPixel and setColor
        for (int sourceX = 0, targetX = x; sourceX < source.getWidth(); sourceX++, targetX++)
        {
            //loop through the rows                                         sourceY += 2, copy every other pixel
                                                                           // sourceY += .5, copy  other pixel
            for (int sourceY = 0, targetY = y; sourceY < source.getHeight(); sourceY++, targetY++)
            {
                sourcePix = source.getPixel(sourceX, sourceY);
                targetPix = target.getPixel(targetX, targetY);
                targetPix.setColor(sourcePix.getColor());
            }
        }
    }
}