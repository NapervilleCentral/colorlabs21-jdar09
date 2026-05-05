
/**
 * Write a description of class parthenon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class parthenon
{
    public static void main(String[]args)
    {
        Picture cats = new Picture("images/temple.jpg");
        Picture canvas = new Picture("images/canvas.jpg");
        mirrorVertical(cats);
        cats.explore();
        copytoCanvas(cats, canvas);
        canvas.explore();
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
        for (int y = 0; y < source.getHeight()/4; y++)
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
    public static void copytoCanvas(Picture source, Picture target)
    {
        Pixel sourcePix = null;
        Pixel targetPix = null;
       
        //loop through all the columns; targetX is starting point on canvas; sourceX+=2 smaller
                                                            //source x+=.5 larger, copy every pixel 2x, cast as int in getPixel and setColor
        for (int sourceX = 0, targetX = 0; sourceX < source.getWidth(); sourceX++, targetX++)
        {
            //loop through the rows                                         sourceY += 2, copy every other pixel
                                                                           // sourceY += .5, copy  other pixel
            for (int sourceY = 0, targetY = 0; sourceY < source.getHeight(); sourceY++, targetY++)
            {
                sourcePix = source.getPixel(sourceX, sourceY);
                targetPix = target.getPixel(targetX, targetY);
                targetPix.setColor(sourcePix.getColor());
            }
        }
    }
}

