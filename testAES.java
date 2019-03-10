import java.util.ArrayList;
import java.util.List;

/**
 * Created by esmasert on 18.04.2018.
 */
public class testAES {

    public static List<String> CryptRedArray = new ArrayList<>();
    public static List<String> CryptGreenArray = new ArrayList<>();
    public static List<String> CryptBlueArray = new ArrayList<>();

    public static List<String> CryptedWholeRedArray = new ArrayList<>();
    public static List<String> CryptedWholeGreenArray = new ArrayList<>();
    public static List<String> CryptedWholeBlueArray = new ArrayList<>();

    private int[] pixRed;
    private int[] pixGreen;
    private int[] pixBlue;

    public AESObj objRed;
    public AESObj objGreen;
    public AESObj objBlue;

    public pixListAsil pixList;

    public testAES(){

        pixList = new pixListAsil();

        pixRed = pixList.getIntArrayRed();
        pixGreen = pixList.getIntArrayGreen();
        pixBlue = pixList.getIntArrayBlue();


        List<String> pixRedArray = new ArrayList<String>();
        for (int i : pixRed)
        {
            pixRedArray.add(String.valueOf(i));
        }

        List<String> pixGreenArray = new ArrayList<String>();
        for (int i : pixGreen)
        {
            pixGreenArray.add(String.valueOf(i));
        }

        List<String> pixBlueArray = new ArrayList<String>();
        for (int i : pixBlue)
        {
            pixBlueArray.add(String.valueOf(i));
        }


        System.out.println("\n"+pixRedArray);

        System.out.println(pixGreenArray);

        System.out.println(pixBlueArray);


        for(int i=0; i<(pixBlueArray.size()/16); i++) {


            //System.out.println("\n Encyrpted Arrays between: " + i*16+ " And " + (i+1)*16 + ": ");


            objRed = new AESObj(pixRedArray.subList(i*16,(i+1)*16));

            CryptRedArray = objRed.getLastList();

            //System.out.println(" Encyrpted RedArray: " + CryptRedArray);


            for (String k : CryptRedArray){

                CryptedWholeRedArray.add(k);

            }

            objGreen = new AESObj(pixGreenArray.subList(i*16,(i+1)*16));

            CryptGreenArray = objGreen.getLastList();

            //System.out.println(" Encyrpted GreenArray: " + CryptGreenArray);


            for (String k : CryptGreenArray){

                CryptedWholeGreenArray.add(k);

            }

            objBlue = new AESObj(pixBlueArray.subList(i*16,(i+1)*16));

            CryptBlueArray = objBlue.getLastList();

            //System.out.println(" Encyrpted BlueArray: " + CryptBlueArray);

            for (String k : CryptBlueArray){

                CryptedWholeBlueArray.add(k);

            }

        }

        System.out.println(" WHOLE Encyrpted RedArray: " + CryptedWholeRedArray);

        System.out.println(" WHOLE Encyrpted GreenArray: " + CryptedWholeGreenArray);

        System.out.println(" WHOLE Encyrpted BlueArray: " + CryptedWholeBlueArray);

    }

    static public void main(String args[]) throws Exception {

        new testAES();
    }

    public List<String> getEncryptedWholeRed() {
        return CryptedWholeRedArray;
    }
    public List<String> getEncryptedWholeGreen() {
        return CryptedWholeGreenArray;
    }
    public List<String> getEncryptedWholeBlue() {
        return CryptedWholeBlueArray;
    }

}
