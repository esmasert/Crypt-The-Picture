import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by esmasert on 3.03.2018.
 */

public class AESObj {

    public static List<String> MainKey = Arrays.asList("54", "68", "61", "74", "73", "20", "6D", "79", "20", "4B", "75", "6E", "67", "20", "46", "75");

    public static int[] mainListInteger = new int[16];

    public static int countXOR = 0;
    public static int countMUL = 0;

    public static String[] RoundKey1BU = new String[16];
    public static String[] RoundKey2BU = new String[16];
    public static String[] RoundKey3BU = new String[16];
    public static String[] RoundKey4BU = new String[16];
    public static String[] RoundKey5BU = new String[16];
    public static String[] RoundKey6BU = new String[16];
    public static String[] RoundKey7BU = new String[16];
    public static String[] RoundKey8BU = new String[16];
    public static String[] RoundKey9BU = new String[16];
    public static String[] RoundKey10BU = new String[16];

    public static int[][] empty = new int[4][4];
    public static int[][] subByte2D = new int[4][4];

    public static int[] AddRoundKeyStateMatrix = new int[16];
    public static List<String> AddRoundKeyStateMatrixString = new ArrayList<>();

    public static int row = 0, col = 0, countRcon = 0;
    public static String Rcon = "";
    public static String hold = "", hold2 = "", hold3 = "", hold4 = "";

    public static List<String> SubbyteList = new ArrayList<>();

    public static List<String> MainList = new ArrayList<>();
    public static List<String> MainList2 = new ArrayList<>();
    public static List<String> veryLastList = new ArrayList<>();


    public static List<String> shiftColumnList = new ArrayList<>();
    public static List<String> lastList = new ArrayList<>();
    public static List<String> transposedList = new ArrayList<>();



    public static List<String> afterMixColList = new ArrayList<>();
    public static List<String> gW3 = new ArrayList<String>();

    public static List<String> newArray = new ArrayList<>(); //Use Arraylist inside

    public static List<String> listRoundKey0 = new ArrayList<String>();
    public static List<String> listRoundKey1 = new ArrayList<String>();
    public static List<String> listRoundKey2 = new ArrayList<String>();
    public static List<String> listRoundKey3 = new ArrayList<String>();

    public static List<List<String>> finalPartRoundKey = new ArrayList<>();

    public static List<String> RoundKeyList = new ArrayList<String>();

    public static List<String> RoundKey1 = new ArrayList<String>();
    public static List<String> RoundKey2 = new ArrayList<String>();
    public static List<String> RoundKey3 = new ArrayList<String>();
    public static List<String> RoundKey4 = new ArrayList<String>();
    public static List<String> RoundKey5 = new ArrayList<String>();
    public static List<String> RoundKey6 = new ArrayList<String>();
    public static List<String> RoundKey7 = new ArrayList<String>();
    public static List<String> RoundKey8 = new ArrayList<String>();
    public static List<String> RoundKey9 = new ArrayList<String>();
    public static List<String> RoundKey10 = new ArrayList<String>();

    public static List<String> RoundKey1BUP = new ArrayList<String>();
    public static List<String> RoundKey2BUP = new ArrayList<String>();
    public static List<String> RoundKey3BUP = new ArrayList<String>();
    public static List<String> RoundKey4BUP = new ArrayList<String>();
    public static List<String> RoundKey5BUP = new ArrayList<String>();
    public static List<String> RoundKey6BUP = new ArrayList<String>();
    public static List<String> RoundKey7BUP = new ArrayList<String>();
    public static List<String> RoundKey8BUP = new ArrayList<String>();
    public static List<String> RoundKey9BUP = new ArrayList<String>();
    public static List<String> RoundKey10BUP = new ArrayList<String>();


    public static int[][] sbox = new int[][]{

            {0x63, 0x7C, 0x77, 0x7B, 0xF2, 0x6B, 0x6F, 0xC5, 0x30, 0x01, 0x67, 0x2B, 0xFE, 0xD7, 0xAB, 0x76},
            {0xCA, 0x82, 0xC9, 0x7D, 0xFA, 0x59, 0x47, 0xF0, 0xAD, 0xD4, 0xA2, 0xAF, 0x9C, 0xA4, 0x72, 0xC0},
            {0xB7, 0xFD, 0x93, 0x26, 0x36, 0x3F, 0xF7, 0xCC, 0x34, 0xA5, 0xE5, 0xF1, 0x71, 0xD8, 0x31, 0x15},
            {0x04, 0xC7, 0x23, 0xC3, 0x18, 0x96, 0x05, 0x9A, 0x07, 0x12, 0x80, 0xE2, 0xEB, 0x27, 0xB2, 0x75},
            {0x09, 0x83, 0x2C, 0x1A, 0x1B, 0x6E, 0x5A, 0xA0, 0x52, 0x3B, 0xD6, 0xB3, 0x29, 0xE3, 0x2F, 0x84},
            {0x53, 0xD1, 0x00, 0xED, 0x20, 0xFC, 0xB1, 0x5B, 0x6A, 0xCB, 0xBE, 0x39, 0x4A, 0x4C, 0x58, 0xCF},
            {0xD0, 0xEF, 0xAA, 0xFB, 0x43, 0x4D, 0x33, 0x85, 0x45, 0xF9, 0x02, 0x7F, 0x50, 0x3C, 0x9F, 0xA8},
            {0x51, 0xA3, 0x40, 0x8F, 0x92, 0x9D, 0x38, 0xF5, 0xBC, 0xB6, 0xDA, 0x21, 0x10, 0xFF, 0xF3, 0xD2},
            {0xCD, 0x0C, 0x13, 0xEC, 0x5F, 0x97, 0x44, 0x17, 0xC4, 0xA7, 0x7E, 0x3D, 0x64, 0x5D, 0x19, 0x73},
            {0x60, 0x81, 0x4F, 0xDC, 0x22, 0x2A, 0x90, 0x88, 0x46, 0xEE, 0xB8, 0x14, 0xDE, 0x5E, 0x0B, 0xDB},
            {0xE0, 0x32, 0x3A, 0x0A, 0x49, 0x06, 0x24, 0x5C, 0xC2, 0xD3, 0xAC, 0x62, 0x91, 0x95, 0xE4, 0x79},
            {0xE7, 0xC8, 0x37, 0x6D, 0x8D, 0xD5, 0x4E, 0xA9, 0x6C, 0x56, 0xF4, 0xEA, 0x65, 0x7A, 0xAE, 0x08},
            {0xBA, 0x78, 0x25, 0x2E, 0x1C, 0xA6, 0xB4, 0xC6, 0xE8, 0xDD, 0x74, 0x1F, 0x4B, 0xBD, 0x8B, 0x8A},
            {0x70, 0x3E, 0xB5, 0x66, 0x48, 0x03, 0xF6, 0x0E, 0x61, 0x35, 0x57, 0xB9, 0x86, 0xC1, 0x1D, 0x9E},
            {0xE1, 0xF8, 0x98, 0x11, 0x69, 0xD9, 0x8E, 0x94, 0x9B, 0x1E, 0x87, 0xE9, 0xCE, 0x55, 0x28, 0xDF},
            {0x8C, 0xA1, 0x89, 0x0D, 0xBF, 0xE6, 0x42, 0x68, 0x41, 0x99, 0x2D, 0x0F, 0xB0, 0x54, 0xBB, 0x16}
    };


    public AESObj(List<String> Plainlist){


        countRcon++;
        RoundKey1 = roundKey(MainKey);
        countRcon++;

        for (int i = 0; i < 16; i++) {
            RoundKey1BU[i] = RoundKey1.get(i);
            RoundKey1BUP.add(RoundKey1BU[i]);
        }

        RoundKey2 = roundKey(RoundKey1);
        countRcon++;

        for (int i = 0; i < 16; i++) {
            RoundKey2BU[i] = RoundKey2.get(i);
            RoundKey2BUP.add(RoundKey2BU[i]);
        }

        RoundKey3 = roundKey(RoundKey2);
        countRcon++;

        for (int i = 0; i < 16; i++) {
            RoundKey3BU[i] = RoundKey3.get(i);
            RoundKey3BUP.add(RoundKey3BU[i]);
        }

        RoundKey4 = roundKey(RoundKey3);
        countRcon++;

        for (int i = 0; i < 16; i++) {
            RoundKey4BU[i] = RoundKey4.get(i);
            RoundKey4BUP.add(RoundKey4BU[i]);
        }

        RoundKey5 = roundKey(RoundKey4);
        countRcon++;

        for (int i = 0; i < 16; i++) {
            RoundKey5BU[i] = RoundKey5.get(i);
            RoundKey5BUP.add(RoundKey5BU[i]);
        }

        RoundKey6 = roundKey(RoundKey5);
        countRcon++;

        for (int i = 0; i < 16; i++) {
            RoundKey6BU[i] = RoundKey6.get(i);
            RoundKey6BUP.add(RoundKey6BU[i]);
        }

        RoundKey7 = roundKey(RoundKey6);
        countRcon++;

        for (int i = 0; i < 16; i++) {
            RoundKey7BU[i] = RoundKey7.get(i);
            RoundKey7BUP.add(RoundKey7BU[i]);
        }

        RoundKey8 = roundKey(RoundKey7);
        countRcon++;

        for (int i = 0; i < 16; i++) {
            RoundKey8BU[i] = RoundKey8.get(i);
            RoundKey8BUP.add(RoundKey8BU[i]);
        }

        RoundKey9 = roundKey(RoundKey8);
        countRcon++;

        for (int i = 0; i < 16; i++) {
            RoundKey9BU[i] = RoundKey9.get(i);
            RoundKey9BUP.add(RoundKey9BU[i]);
        }

        RoundKey10 = roundKey(RoundKey9);

        for (int i = 0; i < 16; i++) {
            RoundKey10BU[i] = RoundKey10.get(i);
            RoundKey10BUP.add(RoundKey10BU[i]);
        }

        for (int i = 0; i < 16; i++) {

            mainListInteger[i] = Integer.parseInt(Plainlist.get(i), 16);
        }

        MainList = subBytes(addRoundKey(MainKey, Plainlist));
        shiftRows();
        mixColumns();

        Plainlist = afterMixColList;
        MainList = subBytes(addRoundKey(RoundKey1BUP, Plainlist));
        shiftRows();
        mixColumns();

        Plainlist = afterMixColList;
        MainList = subBytes(addRoundKey(RoundKey2BUP, Plainlist));
        shiftRows();
        mixColumns();

        Plainlist = afterMixColList;
        MainList = subBytes(addRoundKey(RoundKey3BUP, Plainlist));
        shiftRows();
        mixColumns();

        Plainlist = afterMixColList;
        MainList = subBytes(addRoundKey(RoundKey4BUP, Plainlist));
        shiftRows();
        mixColumns();

        Plainlist = afterMixColList;
        MainList = subBytes(addRoundKey(RoundKey5BUP, Plainlist));
        shiftRows();
        mixColumns();

        Plainlist = afterMixColList;
        MainList = subBytes(addRoundKey(RoundKey6BUP, Plainlist));
        shiftRows();
        mixColumns();

        Plainlist = afterMixColList;
        MainList = subBytes(addRoundKey(RoundKey7BUP, Plainlist));
        shiftRows();
        mixColumns();

        Plainlist = afterMixColList;
        MainList = subBytes(addRoundKey(RoundKey8BUP, Plainlist));
        shiftRows();
        mixColumns();

        Plainlist = afterMixColList;
        MainList = subBytes(addRoundKey(RoundKey9BUP, Plainlist));
        lastList = shiftRows();

        veryLastList = addRoundKey(RoundKey10BUP, transPose(lastList));

    }


    public static List<String> getLastList(){

        return veryLastList;
    }



    static public void main(String args[]) {


    }

    public static List<String> transPose(List<String> list ){

        transposedList.clear();

        for (int i = 0; i < 4; i++) {

            transposedList.add(list.get(i));
            transposedList.add(list.get(i+4));
            transposedList.add(list.get(i+8));
            transposedList.add(list.get(i+12));
        }

        return transposedList;
    }

    public static String turnHex(int num) {

        // For storing remainder
        int rem;
        // For storing result
        String str = "";
        // Digits in hexadecimal number system
        char hex[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        while (num > 0) {
            rem = num % 16;
            str = hex[rem] + str;
            num = num / 16;
        }

        return str;
    }

    public static List<String> subBytes(List<String> tempList) {

        SubbyteList.clear();

        for (int i = 0; i < tempList.size(); i++) {

            switch (tempList.get(i).charAt(0)) {
                case '0':
                    row = 0;
                    break;
                case '1':
                    row = 1;
                    break;
                case '2':
                    row = 2;
                    break;
                case '3':
                    row = 3;
                    break;
                case '4':
                    row = 4;
                    break;
                case '5':
                    row = 5;
                    break;
                case '6':
                    row = 6;
                    break;
                case '7':
                    row = 7;
                    break;
                case '8':
                    row = 8;
                    break;
                case '9':
                    row = 9;
                    break;
                case 'A':
                    row = 10;
                    break;
                case 'B':
                    row = 11;
                    break;
                case 'C':
                    row = 12;
                    break;
                case 'D':
                    row = 13;
                    break;
                case 'E':
                    row = 14;
                    break;
                case 'F':
                    row = 15;
                    break;
                default:
                    row = Integer.parseInt(null);
                    break;
            }

            if (tempList.get(i).length() == 2) {

                switch (tempList.get(i).charAt(1)) {
                    case '0':
                        col = 0;
                        break;
                    case '1':
                        col = 1;
                        break;
                    case '2':
                        col = 2;
                        break;
                    case '3':
                        col = 3;
                        break;
                    case '4':
                        col = 4;
                        break;
                    case '5':
                        col = 5;
                        break;
                    case '6':
                        col = 6;
                        break;
                    case '7':
                        col = 7;
                        break;
                    case '8':
                        col = 8;
                        break;
                    case '9':
                        col = 9;
                        break;
                    case 'A':
                        col = 10;
                        break;
                    case 'B':
                        col = 11;
                        break;
                    case 'C':
                        col = 12;
                        break;
                    case 'D':
                        col = 13;
                        break;
                    case 'E':
                        col = 14;
                        break;
                    case 'F':
                        col = 15;
                        break;
                    default:
                        col = Integer.parseInt(null);
                        break;
                }

            } else {
                col = row;
                row = 0;
            }

            SubbyteList.add(turnHex(sbox[row][col]));

        }

        return SubbyteList;
    }

    public static List<String> roundKey(List<String> key) {

        newArray.clear();

        newArray.add(key.get(13));

        newArray.add(key.get(14));

        newArray.add(key.get(15));

        newArray.add(key.get(12));

        gW3 = subBytes(newArray);

        switch (countRcon) {
            case 1:
                Rcon = "1";
                break;
            case 2:
                Rcon = "2";
                break;
            case 3:
                Rcon = "4";
                break;
            case 4:
                Rcon = "8";
                break;
            case 5:
                Rcon = "10";
                break;
            case 6:
                Rcon = "20";
                break;
            case 7:
                Rcon = "40";
                break;
            case 8:
                Rcon = "80";
                break;
            case 9:
                Rcon = "1B";
                break;
            case 10:
                Rcon = "36";
                break;
            case 11:
                Rcon = "6C";
                break;
            default:
                Rcon = "0";
                break;
        }

        String XORconstant = hexXOR(gW3.get(0),Rcon);

        listRoundKey0.add(hexXOR(key.get(0),XORconstant));
        listRoundKey0.add(hexXOR(key.get(1),gW3.get(1)));
        listRoundKey0.add(hexXOR(key.get(2),gW3.get(2)));
        listRoundKey0.add(hexXOR(key.get(3),gW3.get(3)));

        listRoundKey1.add(hexXOR(listRoundKey0.get(0),key.get(4)));
        listRoundKey1.add(hexXOR(listRoundKey0.get(1),key.get(5)));
        listRoundKey1.add(hexXOR(listRoundKey0.get(2),key.get(6)));
        listRoundKey1.add(hexXOR(listRoundKey0.get(3),key.get(7)));

        listRoundKey2.add(hexXOR(listRoundKey1.get(0),key.get(8)));
        listRoundKey2.add(hexXOR(listRoundKey1.get(1),key.get(9)));
        listRoundKey2.add(hexXOR(listRoundKey1.get(2),key.get(10)));
        listRoundKey2.add(hexXOR(listRoundKey1.get(3),key.get(11)));

        listRoundKey3.add(hexXOR(listRoundKey2.get(0),key.get(12)));
        listRoundKey3.add(hexXOR(listRoundKey2.get(1),key.get(13)));
        listRoundKey3.add(hexXOR(listRoundKey2.get(2),key.get(14)));
        listRoundKey3.add(hexXOR(listRoundKey2.get(3),key.get(15)));

        finalPartRoundKey.add(listRoundKey0);
        finalPartRoundKey.add(listRoundKey1);
        finalPartRoundKey.add(listRoundKey2);
        finalPartRoundKey.add(listRoundKey3);

        RoundKeyList.clear();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                RoundKeyList.add(finalPartRoundKey.get(i).get(j));
            }
        }

        listRoundKey0.clear();
        listRoundKey1.clear();
        listRoundKey2.clear();
        listRoundKey3.clear();
        finalPartRoundKey.clear();

        return RoundKeyList;
    }

    public static List<String> addRoundKey(List<String> roundList, List<String> ourMainlist) {

        AddRoundKeyStateMatrixString.clear();

        for (int i = 0; i < 16; i++) {
            AddRoundKeyStateMatrix[i] = Integer.parseInt(roundList.get(i),16) ^ Integer.parseInt(ourMainlist.get(i),16);

            if (turnHex(AddRoundKeyStateMatrix[i]) != "") {
                AddRoundKeyStateMatrixString.add(turnHex(AddRoundKeyStateMatrix[i]));
            }
            else {
                AddRoundKeyStateMatrixString.add("0");
            }
        }

        return AddRoundKeyStateMatrixString;
    }


    public static List<String> shiftRows() {

        MainList2.clear();

        MainList2.add(MainList.get(0));
        MainList2.add(MainList.get(4));
        MainList2.add(MainList.get(8));
        MainList2.add(MainList.get(12));
        MainList2.add(MainList.get(1));
        MainList2.add(MainList.get(5));
        MainList2.add(MainList.get(9));
        MainList2.add(MainList.get(13));
        MainList2.add(MainList.get(2));
        MainList2.add(MainList.get(6));
        MainList2.add(MainList.get(10));
        MainList2.add(MainList.get(14));
        MainList2.add(MainList.get(3));
        MainList2.add(MainList.get(7));
        MainList2.add(MainList.get(11));
        MainList2.add(MainList.get(15));



        for (int i = 1; i < 4; i++) {

            if (i == 1) {

                hold = MainList2.get(i * 4);

                hold2 = MainList2.get((i * 4) + 1);

                MainList2.set((i * 4), hold2);

                hold3 = MainList2.get((i * 4) + 2);

                MainList2.set((i * 4) + 1, hold3);

                hold4 = MainList2.get((i * 4) + 3);

                MainList2.set((i * 4) + 2, hold4);

                MainList2.set((i * 4) + 3, hold);

            } else if (i == 2) {

                hold = MainList2.get(i * 4);

                hold2 = MainList2.get((i * 4) + 1);

                hold3 = MainList2.get((i * 4) + 2);

                MainList2.set((i * 4), hold3);

                hold4 = MainList2.get((i * 4) + 3);

                MainList2.set((i * 4) + 1, hold4);

                MainList2.set((i * 4) + 2, hold);

                MainList2.set((i * 4) + 3, hold2);

            } else if (i == 3) {

                hold = MainList2.get(i * 4);

                hold2 = MainList2.get((i * 4) + 1);

                hold3 = MainList2.get((i * 4) + 2);

                hold4 = MainList2.get((i * 4) + 3);

                MainList2.set((i * 4), hold4);

                MainList2.set((i * 4) + 1, hold);

                MainList2.set((i * 4) + 2, hold2);

                MainList2.set((i * 4) + 3, hold3);

            } else {
                System.out.println("Impossible");

            }
        }

        for (int i = 0; i < 16; i++) {

            if (MainList2.get(i) == "") {

                MainList2.set(i, "00");
            }
        }

        shiftColumnList = MainList2;

        return shiftColumnList;

    }

    public static String multiplicationMIXCOLUM(int a, int b) {

        String result = "";
        String result0st = "";

        int result2 =0 ;

        String binaryA = "";
        while (a > 0) {
            binaryA = (a % 2) + binaryA;
            a = a / 2;
        }

        if(b==0){

            result0st = "0";
            return result0st;
        }

        String binaryB = "";
        String binaryBOther = "";

        while (b > 0) {
            binaryB = (b % 2) + binaryB;
            b = b / 2;
        }

        if (Integer.parseInt(binaryA, 2) == 1) {

            if(binaryB.length()<8) {

                binaryB = StringUtils.leftPad(Integer.toBinaryString(Integer.parseInt(binaryB,2)), 8, '0');

            }

            result = binaryB;

        } else if (Integer.parseInt(binaryA, 2) == 2) {

            if (binaryB.length() < 8) {

                binaryBOther = StringUtils.leftPad(Integer.toBinaryString(Integer.parseInt(binaryB, 2)), 8, '0');

                result = Integer.toBinaryString(Integer.parseInt(binaryBOther, 2) << 1);

            } else {

                result = Integer.toBinaryString(Integer.parseInt(binaryB, 2) << 1);
            }

            if (binaryB.length() == 8) {

                result = result.substring(1);
            }

            int newResult = Integer.parseInt(result, 2);

            if(binaryB.length()<8) {

                if (binaryBOther.charAt(0) == '1') {

                    newResult = newResult ^ Integer.parseInt("00011011", 2);

                }
            }else{

                if (binaryB.charAt(0) == '1') {

                    newResult = newResult ^ Integer.parseInt("00011011", 2);
                }
            }

            result = "";
            while (newResult > 0) {
                result = (newResult % 2) + result;
                newResult = newResult / 2;
            }

            if(result.length()>8) {

                result2 = Integer.parseInt(result, 2);

                result = "";
                while (result2 > 0) {
                    result = (result2 % 2) + result;
                    result2 = result2 / 2;
                }

                result = result.substring(1);

            }

            if(result.length()<8) {

                result = StringUtils.leftPad(Integer.toBinaryString(Integer.parseInt(result,2)), 8, '0');
            }


        } else if (Integer.parseInt(binaryA, 2) == 3) {

            if (binaryB.length() < 8) {

                binaryBOther = StringUtils.leftPad(Integer.toBinaryString(Integer.parseInt(binaryB, 2)), 8, '0');

                result = Integer.toBinaryString(Integer.parseInt(binaryBOther, 2) << 1);

            } else {

                result = Integer.toBinaryString(Integer.parseInt(binaryB, 2) << 1);
            }

            if (binaryB.length() == 8) {

                result = result.substring(1);
            }

            int newResult = Integer.parseInt(result, 2);

            if(binaryB.length()<8) {

                if (binaryBOther.charAt(0) == '1') {

                    newResult = newResult ^ Integer.parseInt("00011011", 2);

                }
            }else{

                if (binaryB.charAt(0) == '1') {

                    newResult = newResult ^ Integer.parseInt("00011011", 2);
                }
            }

            result = "";
            while (newResult > 0) {
                result = (newResult % 2) + result;
                newResult = newResult / 2;
            }

            if(result.length()>8) {

                result2 = Integer.parseInt(result, 2);

                result = "";
                while (result2 > 0) {
                    result = (result2 % 2) + result;
                    result2 = result2 / 2;
                }

                result = result.substring(1);
            }

            if(result.length()<8) {

                result = StringUtils.leftPad(Integer.toBinaryString(Integer.parseInt(result,2)), 8, '0');
            }

            int anlikResult = Integer.parseInt(result, 2) ^ Integer.parseInt(binaryB, 2) ;

            result = "";
            while (anlikResult > 0) {
                result = (anlikResult % 2) + result;
                anlikResult = anlikResult / 2;
            }

        }
        else{

            System.out.println("ERROR IN MIXCOLUMN");

        }

        return result;
    }



    public static void mixColumns() {

        afterMixColList.clear();

        int[][] mixColumns, mainList;
        int[][] tempList = new int[4][4];

        mixColumns = new int[][]{

                {2, 1, 1, 3},
                {3, 2, 1, 1},
                {1, 3, 2, 1},
                {1, 1, 3, 2}
        };

        mainList = hexToInteger(shiftColumnList);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 1; j++) {
                tempList[i][j] = mainList[i][j];
            }
        }

        for (int j = 0; j < 4; j++) {

            for (int i = 0; i < 4; i++) {

                countMUL = Integer.parseInt(multiplicationMIXCOLUM(mixColumns[i][j], tempList[i][0]), 2);

                countXOR = countXOR ^ countMUL;
            }

            afterMixColList.add(turnHex(countXOR));
            countXOR = 0;
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 2; j++) {

                tempList[i][j] = mainList[i][j];
            }
        }

        for (int j = 0; j < 4; j++) {

            for (int i = 0; i < 4; i++) {

                countMUL = Integer.parseInt(multiplicationMIXCOLUM(mixColumns[i][j], tempList[i][1]), 2);

                countXOR = countXOR ^ countMUL;
            }

            afterMixColList.add(turnHex(countXOR));

            countXOR = 0;
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 2; j < 3; j++) {
                tempList[i][j] = mainList[i][j];

            }
        }

        for (int j = 0; j < 4; j++) {

            for (int i = 0; i < 4; i++) {

                countMUL = Integer.parseInt(multiplicationMIXCOLUM(mixColumns[i][j], tempList[i][2]), 2);

                countXOR = countXOR ^ countMUL;
            }

            afterMixColList.add(turnHex(countXOR));

            countXOR = 0;
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 3; j < 4; j++) {
                tempList[i][j] = mainList[i][j];
            }
        }

        for (int j = 0; j < 4; j++) {

            for (int i = 0; i < 4; i++) {

                countMUL = Integer.parseInt(multiplicationMIXCOLUM(mixColumns[i][j], tempList[i][3]), 2);

                countXOR = countXOR ^ countMUL;
            }

            afterMixColList.add(turnHex(countXOR));

            countXOR = 0;
        }

        for (int i = 0; i < 16; i++) {

            if (afterMixColList.get(i) == "") {

                afterMixColList.set(i, "00");
            }
        }
    }

    public static int[][] hexToInteger(List<String> listToConvert) {

        for(int i=0; i<4;i++) {
            for (int j = 0; j < 4; j++) {

                if(listToConvert.get((i * 4) + j)==""){

                    subByte2D[i][j] = 0;
                    continue;
                }

                subByte2D[i][j] =   Integer.parseInt(listToConvert.get((i * 4) + j), 16);
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                empty[i][j] = subByte2D[i][j];
            }
        }
        return empty;
    }

    public static String hexXOR(String  a, String b) {

        if (a == ""){
            a = "0";
        }

        if (b == ""){
            b = "0";
        }

        int value = Integer.parseInt(a, 16);

        int value2 = Integer.parseInt(b, 16);

        int resultI = value^value2;

        String resultS = turnHex(resultI);

        return resultS;
    }

}













