
/**
 * Kevin Hayes
 * Test Picture Classes
 *
 * @author (Kevin Hayes)
 * @version (10-19-2016)
 */
import java.awt.*; //imports color library
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
public class TestPicture17
{

    /**
     * main method, to test the picture
     *
     */
  public static void main(String[] args)
  {
      //opens picture using a dialog box
      /**
     String fileName = FileChooser.pickAFile();
     Picture pictObj = new Picture(fileName);
     pictObj.explore();
    **/
     //opens a pictue using a path
     //Picture apic = new Picture("C:\\Users\\khayes\\Favorites\\Documents\APCS- Java\chap03\Curriclum 2013\Picture Color labs\images\\beach.jpg");
     
     //IMPORTANT!!!!!!!!! relative paths
     //relative path            dir/folder/file
     Picture apic = new Picture("images\\beach.jpg");
     Picture ferris1 = new Picture("images/2000 ferris wheel2.jpg");
     Picture ferris2 = new Picture("images/2000 ferris wheel2.jpg");
     Picture ferris3 = new Picture("images/2000 ferris wheel2.jpg");
     Picture moto = new Picture ("images/redMotorcycle.jpg");
     
      Picture pic1 = new Picture("images\\snowman.jpg");
      Picture pic2 = new Picture("images\\robot.jpg");
      Picture pic3 = new Picture("images\\snowman.jpg");
      Picture pic4 = new Picture("images\\caterpillar.jpg");
         
      pic1.explore();
      
     
     Pixel[] pixels1;
     pixels1=pic1.getPixels();
     int red,blue,green;
     for (Pixel spot1 : pixels1)
         {
          //System.out.println(spot1);
          
          red = spot1.getRed();
          
          red = (int) (red * 0.5);
          
          spot1.setRed(red);
          
          blue = spot1.getBlue();
         green = spot1.getGreen();
         blue = (int) (blue * 1.5);
         
         spot1.setBlue(blue);
         
         green = (int)(green * 0.25);
         spot1.setGreen(green);
         }
         pic1.explore(); 
    
         pic2.explore();
     Pixel[] pixels2;
     pixels2=pic2.getPixels();

     for (Pixel spot1 : pixels2)
     {
         red = spot1.getRed();
          
          red = (255-red);
          
          spot1.setRed(red);
          
          blue = spot1.getBlue();
         green = spot1.getGreen();
         blue = (255-blue);
         
         spot1.setBlue(blue);
         
         green = (255-green);
         spot1.setGreen(green);
     }
     pic2.explore();
     
     //grayscale
     
     pic3.explore();
     Pixel[] pixels3;
     pixels3=pic3.getPixels();
     int avg=0;
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
     pic3.explore();
     
     
 /**    
     p.maxBlue();
      p.explore();
      pic2.negate();
p.explore();
p2. adjustRed(10);
p2.explore();
p.grayscale();
p.explore();    
     //apic.explore(); displays picture
     ferris1.explore();
     
     //ARRAY NOT ON TEST
     //makes an array of pixels
     Pixel[] pixels;
     //gets pixels from picture and assigns to pixels array
     //MUST FOR EVERY PICTURE
     pixels = ferris1.getPixels();
     
     Pixel[] mpixels;
     mpixels=moto.getPixels();

     for (Pixel spot1 : mpixels)
         {
          //System.out.println(spot1);
          
          red = spot1.getRed();
          
          red = (int) (red * 0.25);
          
          spot1.setRed(red);
         }
         moto.explore(); 
    
     for (Pixel spot3 : mpixels)
     {
         blue = spot3.getBlue();
         green = spot3.getGreen();
         blue = (int) (blue * Math.random());
         
         spot3.setBlue(blue);
         
         green = (int)(green * Math.random());
         spot3.setGreen(green);
     }
         moto.explore();
        /**
    
     //how many pixels or how large array
    System.out.println("This is a large array"+pixels.length  );
    
    //BLACK=0
    //WHITE=255

    /*
        //access each index
    System.out.println(pixels[17]);
    //access each pixel
    Pixel spot = ferris1.getPixel(100,100);
    Pixel spot2 = ferris1.getPixel(433,283);
    Pixel ferris17=pixels[17];
    ferris17.setRed(240);
    ferris17.setGreen(160);
    ferris17.setBlue(200);
    
    Color newColor=new Color (255,99,71);
    
    spot.setColor(newColor);
    spot2.setColor(Color.blue);
    ferris1.explore();
    
    System.out.println(pixels[17].getColor());
    System.out.println(spot);
    
    for (int i=0; i<10000; i++)
        {
            Pixel yuck = ferris1.getPixel((int)(Math.random()*500), (int)(Math.random()*500));
            yuck.setColor(Color.green);
        }
/*
    pixels[17].setColor(Color.blue);
    spot.setColor(new Color(252,252,252));
    pixels[500034].setColor(Color.blue);

    ferris1.explore();
/*
   // loop to access indexes of array or collection

    //for each loop spot  is a ?
    for (Pixel spot : pixels)
    System.out.println( spot );


   
 /**/

 /**
  * Method to clear red from picture
  * @param none
  * @return none
  */
 /*
    for (Pixel pixelObj : pixels)
        {
            //set the red value of the current pixel to the new value
           

        }
    ferris1.explore();
    
/**/
 /**
  * Method to reduce red from picture by a factor of n
  * @param none
  * @return none
  */

/*
int value;
final double  FACTOR = .5;
    for (Pixel pixelObj : pixels)
    {

        //get the redvalue
        value = pixelObj.getRed();
        //System.out.println(value);

        //decrease the red value by 50%
        
        //set the red value of the current pixel to the new value
        

    }
    // use new picture when changing or it will make changes to 
    // pic you already changed
    ferris1.explore();
    ferris2.explore();

  /**/ 
    //write/save a picture as a file
    ferris1.write("images/ferris11.jpg");

    /**/
  }//main
}//class
