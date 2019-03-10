/**
 * Created by esmasert on 25.01.2018.
 */

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class setImage {

    public testAES object;

    public static List<String> CRA = new ArrayList<>();
    public static List<String> CGA = new ArrayList<>();
    public static List<String> CBA = new ArrayList<>();

    public static List<Integer> RedInteger = new ArrayList<>();
    public static List<Integer> GreenInteger = new ArrayList<>();
    public static List<Integer> BlueInteger = new ArrayList<>();
    public File a;


    public setImage() {

        object = new testAES();

        CRA = object.getEncryptedWholeRed();
        CGA = object.getEncryptedWholeGreen();
        CBA = object.getEncryptedWholeBlue();

        for (String k :CRA){
            RedInteger.add(Integer.valueOf(k,16));
        }
        System.out.println(RedInteger);

        for (String k :CGA){
            GreenInteger.add(Integer.valueOf(k,16));
        }
        System.out.println(GreenInteger);

        for (String k :CBA){
            BlueInteger.add(Integer.valueOf(k,16));
        }
        System.out.println(BlueInteger);


        //image dimension
        int width = 42;
        int height = 32;

        //create buffered image object img
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        //file object
        File f = null;
        //create random image pixel by pixel

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                int a = (int) (Math.random() * 256); //alpha
                int r = (int) (RedInteger.get(y*width+x)); //red
                int g = (int) (GreenInteger.get(y*width+x)); //green
                int b = (int) (BlueInteger.get(y*width+x)); //blue

                int p = (a << 24) | (r << 16) | (g << 8) | b; //pixel

                img.setRGB(x, y, p);
            }
        }

        //write image
        try {
            f = new File("/Users/esmasert/Desktop/OutputExample.png");
            ImageIO.write(img, "png", f);
            a=f;
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

    }

    static public void main(String args[]) throws Exception {

        setImage obj = new setImage();

    }

    public File getEncyptedPicture() {


        System.out.println("BUU: " + a);

        return a;
    }
}
