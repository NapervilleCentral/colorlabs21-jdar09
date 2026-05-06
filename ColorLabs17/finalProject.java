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
        copytoCanvas(chamog, canvas, 0, 0);
        mirrorVertical(cham1);
        cham1.explore();
        copytoCanvas(cham1, canvas, 1000, 0);
        grayscale(cham2);
        copytoCanvas(cham2, canvas, 2000, 0);
        enlarge(cham3, canvas, 0, 0, 0, 1000);
        canvas.explore();
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
    public static void enlarge(Picture source, Picture target, double sourceX, int targetX, double sourceY, int targetY)
    {
        Pixel sourcePix = null;
        Pixel targetPix = null;
        if (sourceX==source.getWidth() || sourceY==source.getHeight())
            return;
        else
            {
                sourcePix = source.getPixel((int)sourceX, (int)sourceY);
                targetPix = target.getPixel(targetX, targetY);
                targetPix.setColor(sourcePix.getColor());
                enlarge(source, target, sourceX+=.5,targetX++, sourceY+=.5, targetY++);
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