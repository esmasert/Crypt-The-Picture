/**
 * Created by esmasert on 25.01.2018.
 */

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

class pixListAsil {

    BufferedImage image;
    int width;
    int height;
    private int[] intArrayRed;
    private int[] intArrayGreen;
    private int[] intArrayBlue;

    public static GUIComponents guiComp;

    public pixListAsil() {


        try {

            System.out.println("lkjfghjk:");

            File input = new File(guiComp.getPath());

            System.out.println(" PATH: "+ guiComp.getPath());

            image = ImageIO.read(input);

            width = image.getWidth();
            height = image.getHeight();
            setIntArrayRed(new int[width*height]);
            setIntArrayGreen(new int[width*height]);
            setIntArrayBlue(new int[width*height]);

            System.out.println(" WIDTH: "+ width);

            int count = 0;

            for(int i=0; i<height; i++){

                for(int j=0; j<width; j++){

                    Color c = new Color(image.getRGB(j, i));

                    getIntArrayRed()[count]= c.getRed();
                    intArrayGreen[count] = c.getGreen();
                    intArrayBlue[count] = c.getBlue();

                    count++;

                }
            }

        } catch (Exception e) {}

    }

    public int[] getIntArrayRed() {
        return intArrayRed;
    }

    public int[] getIntArrayGreen() {return intArrayGreen; }

    public int[] getIntArrayBlue() { return intArrayBlue;}

    public void setIntArrayRed(int[] intArrayRed) {
        this.intArrayRed = intArrayRed;
    }

    public void setIntArrayGreen(int[] intArrayGreen) {
        this.intArrayGreen = intArrayGreen;
    }

    public void setIntArrayBlue(int[] intArrayBlue) {
        this.intArrayBlue = intArrayBlue;
    }


    static public void main(String args[]) throws Exception {

        new pixListAsil();

    }

}