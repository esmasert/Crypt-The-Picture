import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by esmasert on 20.04.2018.
 */

public class DecryptAES {

    public static List<String> list = Arrays.asList("29","C3","50","5F","57","14","20","F6","40","22","99","B3","1A","02","D7","3A");

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

    public static List<String> hexList = new ArrayList<>();
    public static List<String> MainList = new ArrayList<>();
    public static List<String> MainList2 = new ArrayList<>();

    public static List<String> OylesineBirList = new ArrayList<>();


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

    public static int[][] sboxInverse = new int[][]{

            {0x52, 0x09, 0x6a, 0xd5, 0x30, 0x36, 0xa5, 0x38, 0xbf, 0x40, 0xa3, 0x9e, 0x81, 0xf3, 0xd7, 0xfb},
            {0x7c, 0xe3, 0x39, 0x82, 0x9b, 0x2f, 0xff, 0x87, 0x34, 0x8e, 0x43, 0x44, 0xc4, 0xde, 0xe9, 0xcb},
            {0x54, 0x7b, 0x94, 0x32, 0xa6, 0xc2, 0x23, 0x3d, 0xee, 0x4c, 0x95, 0x0b, 0x42, 0xfa, 0xc3, 0x4e},
            {0x08, 0x2e, 0xa1, 0x66, 0x28, 0xd9, 0x24, 0xb2, 0x76, 0x5b, 0xa2, 0x49, 0x6d, 0x8b, 0xd1, 0x25},
            {0x72, 0xf8, 0xf6, 0x64, 0x86, 0x68, 0x98, 0x16, 0xd4, 0xa4, 0x5c, 0xcc, 0x5d, 0x65, 0xb6, 0x92},
            {0x6c, 0x70, 0x48, 0x50, 0xfd, 0xed, 0xb9, 0xda, 0x5e, 0x15, 0x46, 0x57, 0xa7, 0x8d, 0x9d, 0x84},
            {0x90, 0xd8, 0xab, 0x00, 0x8c, 0xbc, 0xd3, 0x0a, 0xf7, 0xe4, 0x58, 0x05, 0xb8, 0xb3, 0x45, 0x06},
            {0xd0, 0x2c, 0x1e, 0x8f, 0xca, 0x3f, 0x0f, 0x02, 0xc1, 0xaf, 0xbd, 0x03, 0x01, 0x13, 0x8a, 0x6b},
            {0x3a, 0x91, 0x11, 0x41, 0x4f, 0x67, 0xdc, 0xea, 0x97, 0xf2, 0xcf, 0xce, 0xf0, 0xb4, 0xe6, 0x73},
            {0x96, 0xac, 0x74, 0x22, 0xe7, 0xad, 0x35, 0x85, 0xe2, 0xf9, 0x37, 0xe8, 0x1c, 0x75, 0xdf, 0x6e},
            {0x47, 0xf1, 0x1a, 0x71, 0x1d, 0x29, 0xc5, 0x89, 0x6f, 0xb7, 0x62, 0x0e, 0xaa, 0x18, 0xbe, 0x1b},
            {0xfc, 0x56, 0x3e, 0x4b, 0xc6, 0xd2, 0x79, 0x20, 0x9a, 0xdb, 0xc0, 0xfe, 0x78, 0xcd, 0x5a, 0xf4},
            {0x1f, 0xdd, 0xa8, 0x33, 0x88, 0x07, 0xc7, 0x31, 0xb1, 0x12, 0x10, 0x59, 0x27, 0x80, 0xec, 0x5f},
            {0x60, 0x51, 0x7f, 0xa9, 0x19, 0xb5, 0x4a, 0x0d, 0x2d, 0xe5, 0x7a, 0x9f, 0x93, 0xc9, 0x9c, 0xef},
            {0xa0, 0xe0, 0x3b, 0x4d, 0xae, 0x2a, 0xf5, 0xb0, 0xc8, 0xeb, 0xbb, 0x3c, 0x83, 0x53, 0x99, 0x61},
            {0x17, 0x2b, 0x04, 0x7e, 0xba, 0x77, 0xd6, 0x26, 0xe1, 0x69, 0x14, 0x63, 0x55, 0x21, 0x0c, 0x7d}
    };


    final static int[] LogTable = { 0, 0, 25, 1, 50, 2, 26, 198, 75, 199, 27, 104, 51, 238, 223, 3, 100, 4, 224, 14, 52,
            141, 129, 239, 76, 113, 8, 200, 248, 105, 28, 193, 125, 194, 29, 181, 249, 185, 39, 106, 77, 228, 166, 114,
            154, 201, 9, 120, 101, 47, 138, 5, 33, 15, 225, 36, 18, 240, 130, 69, 53, 147, 218, 142, 150, 143, 219, 189,
            54, 208, 206, 148, 19, 92, 210, 241, 64, 70, 131, 56, 102, 221, 253, 48, 191, 6, 139, 98, 179, 37, 226, 152,
            34, 136, 145, 16, 126, 110, 72, 195, 163, 182, 30, 66, 58, 107, 40, 84, 250, 133, 61, 186, 43, 121, 10, 21,
            155, 159, 94, 202, 78, 212, 172, 229, 243, 115, 167, 87, 175, 88, 168, 80, 244, 234, 214, 116, 79, 174, 233,
            213, 231, 230, 173, 232, 44, 215, 117, 122, 235, 22, 11, 245, 89, 203, 95, 176, 156, 169, 81, 160, 127, 12,
            246, 111, 23, 196, 73, 236, 216, 67, 31, 45, 164, 118, 123, 183, 204, 187, 62, 90, 251, 96, 177, 134, 59,
            82, 161, 108, 170, 85, 41, 157, 151, 178, 135, 144, 97, 190, 220, 252, 188, 149, 207, 205, 55, 63, 91, 209,
            83, 57, 132, 60, 65, 162, 109, 71, 20, 42, 158, 93, 86, 242, 211, 171, 68, 17, 146, 217, 35, 32, 46, 137,
            180, 124, 184, 38, 119, 153, 227, 165, 103, 74, 237, 222, 197, 49, 254, 24, 13, 99, 140, 128, 192, 247, 112,
            7 };

    final static int[] AlogTable = { 1, 3, 5, 15, 17, 51, 85, 255, 26, 46, 114, 150, 161, 248, 19, 53, 95, 225, 56, 72,
            216, 115, 149, 164, 247, 2, 6, 10, 30, 34, 102, 170, 229, 52, 92, 228, 55, 89, 235, 38, 106, 190, 217, 112,
            144, 171, 230, 49, 83, 245, 4, 12, 20, 60, 68, 204, 79, 209, 104, 184, 211, 110, 178, 205, 76, 212, 103,
            169, 224, 59, 77, 215, 98, 166, 241, 8, 24, 40, 120, 136, 131, 158, 185, 208, 107, 189, 220, 127, 129, 152,
            179, 206, 73, 219, 118, 154, 181, 196, 87, 249, 16, 48, 80, 240, 11, 29, 39, 105, 187, 214, 97, 163, 254,
            25, 43, 125, 135, 146, 173, 236, 47, 113, 147, 174, 233, 32, 96, 160, 251, 22, 58, 78, 210, 109, 183, 194,
            93, 231, 50, 86, 250, 21, 63, 65, 195, 94, 226, 61, 71, 201, 64, 192, 91, 237, 44, 116, 156, 191, 218, 117,
            159, 186, 213, 100, 172, 239, 42, 126, 130, 157, 188, 223, 122, 142, 137, 128, 155, 182, 193, 88, 232, 35,
            101, 175, 234, 37, 111, 177, 200, 67, 197, 84, 252, 31, 33, 99, 165, 244, 7, 9, 27, 45, 119, 153, 176, 203,
            70, 202, 69, 207, 74, 222, 121, 139, 134, 145, 168, 227, 62, 66, 198, 81, 243, 14, 18, 54, 90, 238, 41, 123,
            141, 140, 143, 138, 133, 148, 167, 242, 13, 23, 57, 75, 221, 124, 132, 151, 162, 253, 28, 36, 108, 180, 199,
            82, 246, 1 };



    public static int[][] Galois9 = new int[][]{

            {0x00,0x09,0x12,0x1b,0x24,0x2d,0x36,0x3f,0x48,0x41,0x5a,0x53,0x6c,0x65,0x7e,0x77},
            {0x90,0x99,0x82,0x8b,0xb4,0xbd,0xa6,0xaf,0xd8,0xd1,0xca,0xc3,0xfc,0xf5,0xee,0xe7},
            {0x3b,0x32,0x29,0x20,0x1f,0x16,0x0d,0x04,0x73,0x7a,0x61,0x68,0x57,0x5e,0x45,0x4c},
            {0xab,0xa2,0xb9,0xb0,0x8f,0x86,0x9d,0x94,0xe3,0xea,0xf1,0xf8,0xc7,0xce,0xd5,0xdc},
            {0x76,0x7f,0x64,0x6d,0x52,0x5b,0x40,0x49,0x3e,0x37,0x2c,0x25,0x1a,0x13,0x08,0x01},
            {0xe6,0xef,0xf4,0xfd,0xc2,0xcb,0xd0,0xd9,0xae,0xa7,0xbc,0xb5,0x8a,0x83,0x98,0x91},
            {0x4d,0x44,0x5f,0x56,0x69,0x60,0x7b,0x72,0x05,0x0c,0x17,0x1e,0x21,0x28,0x33,0x3a},
            {0xdd,0xd4,0xcf,0xc6,0xf9,0xf0,0xeb,0xe2,0x95,0x9c,0x87,0x8e,0xb1,0xb8,0xa3,0xaa},
            {0xec,0xe5,0xfe,0xf7,0xc8,0xc1,0xda,0xd3,0xa4,0xad,0xb6,0xbf,0x80,0x89,0x92,0x9b},
            {0x7c,0x75,0x6e,0x67,0x58,0x51,0x4a,0x43,0x34,0x3d,0x26,0x2f,0x10,0x19,0x02,0x0b},
            {0xd7,0xde,0xc5,0xcc,0xf3,0xfa,0xe1,0xe8,0x9f,0x96,0x8d,0x84,0xbb,0xb2,0xa9,0xa0},
            {0x47,0x4e,0x55,0x5c,0x63,0x6a,0x71,0x78,0x0f,0x06,0x1d,0x14,0x2b,0x22,0x39,0x30},
            {0x9a,0x93,0x88,0x81,0xbe,0xb7,0xac,0xa5,0xd2,0xdb,0xc0,0xc9,0xf6,0xff,0xe4,0xed},
            {0x0a,0x03,0x18,0x11,0x2e,0x27,0x3c,0x35,0x42,0x4b,0x50,0x59,0x66,0x6f,0x74,0x7d},
            {0xa1,0xa8,0xb3,0xba,0x85,0x8c,0x97,0x9e,0xe9,0xe0,0xfb,0xf2,0xcd,0xc4,0xdf,0xd6},
            {0x31,0x38,0x23,0x2a,0x15,0x1c,0x07,0x0e,0x79,0x70,0x6b,0x62,0x5d,0x54,0x4f,0x46}
    };


    public static int[][] Galois11 = new int[][]{

            {0x00,0x0b,0x16,0x1d,0x2c,0x27,0x3a,0x31,0x58,0x53,0x4e,0x45,0x74,0x7f,0x62,0x69},
            {0xb0,0xbb,0xa6,0xad,0x9c,0x97,0x8a,0x81,0xe8,0xe3,0xfe,0xf5,0xc4,0xcf,0xd2,0xd9},
            {0x7b,0x70,0x6d,0x66,0x57,0x5c,0x41,0x4a,0x23,0x28,0x35,0x3e,0x0f,0x04,0x19,0x12},
            {0xcb,0xc0,0xdd,0xd6,0xe7,0xec,0xf1,0xfa,0x93,0x98,0x85,0x8e,0xbf,0xb4,0xa9,0xa2},
            {0xf6,0xfd,0xe0,0xeb,0xda,0xd1,0xcc,0xc7,0xae,0xa5,0xb8,0xb3,0x82,0x89,0x94,0x9f},
            {0x46,0x4d,0x50,0x5b,0x6a,0x61,0x7c,0x77,0x1e,0x15,0x08,0x03,0x32,0x39,0x24,0x2f},
            {0x8d,0x86,0x9b,0x90,0xa1,0xaa,0xb7,0xbc,0xd5,0xde,0xc3,0xc8,0xf9,0xf2,0xef,0xe4},
            {0x3d,0x36,0x2b,0x20,0x11,0x1a,0x07,0x0c,0x65,0x6e,0x73,0x78,0x49,0x42,0x5f,0x54},
            {0xf7,0xfc,0xe1,0xea,0xdb,0xd0,0xcd,0xc6,0xaf,0xa4,0xb9,0xb2,0x83,0x88,0x95,0x9e},
            {0x47,0x4c,0x51,0x5a,0x6b,0x60,0x7d,0x76,0x1f,0x14,0x09,0x02,0x33,0x38,0x25,0x2e},
            {0x8c,0x87,0x9a,0x91,0xa0,0xab,0xb6,0xbd,0xd4,0xdf,0xc2,0xc9,0xf8,0xf3,0xee,0xe5},
            {0x3c,0x37,0x2a,0x21,0x10,0x1b,0x06,0x0d,0x64,0x6f,0x72,0x79,0x48,0x43,0x5e,0x55},
            {0x01,0x0a,0x17,0x1c,0x2d,0x26,0x3b,0x30,0x59,0x52,0x4f,0x44,0x75,0x7e,0x63,0x68},
            {0xb1,0xba,0xa7,0xac,0x9d,0x96,0x8b,0x80,0xe9,0xe2,0xff,0xf4,0xc5,0xce,0xd3,0xd8},
            {0x7a,0x71,0x6c,0x67,0x56,0x5d,0x40,0x4b,0x22,0x29,0x34,0x3f,0x0e,0x05,0x18,0x13},
            {0xca,0xc1,0xdc,0xd7,0xe6,0xed,0xf0,0xfb,0x92,0x99,0x84,0x8f,0xbe,0xb5,0xa8,0xa3}
    };


    public static int[][] Galois13 = new int[][]{

            {0x00,0x0d,0x1a,0x17,0x34,0x39,0x2e,0x23,0x68,0x65,0x72,0x7f,0x5c,0x51,0x46,0x4b},
            {0xd0,0xdd,0xca,0xc7,0xe4,0xe9,0xfe,0xf3,0xb8,0xb5,0xa2,0xaf,0x8c,0x81,0x96,0x9b},
            {0xbb,0xb6,0xa1,0xac,0x8f,0x82,0x95,0x98,0xd3,0xde,0xc9,0xc4,0xe7,0xea,0xfd,0xf0},
            {0x6b,0x66,0x71,0x7c,0x5f,0x52,0x45,0x48,0x03,0x0e,0x19,0x14,0x37,0x3a,0x2d,0x20},
            {0x6d,0x60,0x77,0x7a,0x59,0x54,0x43,0x4e,0x05,0x08,0x1f,0x12,0x31,0x3c,0x2b,0x26},
            {0xbd,0xb0,0xa7,0xaa,0x89,0x84,0x93,0x9e,0xd5,0xd8,0xcf,0xc2,0xe1,0xec,0xfb,0xf6},
            {0xd6,0xdb,0xcc,0xc1,0xe2,0xef,0xf8,0xf5,0xbe,0xb3,0xa4,0xa9,0x8a,0x87,0x90,0x9d},
            {0x06,0x0b,0x1c,0x11,0x32,0x3f,0x28,0x25,0x6e,0x63,0x74,0x79,0x5a,0x57,0x40,0x4d},
            {0xda,0xd7,0xc0,0xcd,0xee,0xe3,0xf4,0xf9,0xb2,0xbf,0xa8,0xa5,0x86,0x8b,0x9c,0x91},
            {0x0a,0x07,0x10,0x1d,0x3e,0x33,0x24,0x29,0x62,0x6f,0x78,0x75,0x56,0x5b,0x4c,0x41},
            {0x61,0x6c,0x7b,0x76,0x55,0x58,0x4f,0x42,0x09,0x04,0x13,0x1e,0x3d,0x30,0x27,0x2a},
            {0xb1,0xbc,0xab,0xa6,0x85,0x88,0x9f,0x92,0xd9,0xd4,0xc3,0xce,0xed,0xe0,0xf7,0xfa},
            {0xb7,0xba,0xad,0xa0,0x83,0x8e,0x99,0x94,0xdf,0xd2,0xc5,0xc8,0xeb,0xe6,0xf1,0xfc},
            {0x67,0x6a,0x7d,0x70,0x53,0x5e,0x49,0x44,0x0f,0x02,0x15,0x18,0x3b,0x36,0x21,0x2c},
            {0x0c,0x01,0x16,0x1b,0x38,0x35,0x22,0x2f,0x64,0x69,0x7e,0x73,0x50,0x5d,0x4a,0x47},
            {0xdc,0xd1,0xc6,0xcb,0xe8,0xe5,0xf2,0xff,0xb4,0xb9,0xae,0xa3,0x80,0x8d,0x9a,0x97}
    };


    public static int[][] Galois14 = new int[][]{

            {0x00,0x0e,0x1c,0x12,0x38,0x36,0x24,0x2a,0x70,0x7e,0x6c,0x62,0x48,0x46,0x54,0x5a},
            {0xe0,0xee,0xfc,0xf2,0xd8,0xd6,0xc4,0xca,0x90,0x9e,0x8c,0x82,0xa8,0xa6,0xb4,0xba},
            {0xdb,0xd5,0xc7,0xc9,0xe3,0xed,0xff,0xf1,0xab,0xa5,0xb7,0xb9,0x93,0x9d,0x8f,0x81},
            {0x3b,0x35,0x27,0x29,0x03,0x0d,0x1f,0x11,0x4b,0x45,0x57,0x59,0x73,0x7d,0x6f,0x61},
            {0xad,0xa3,0xb1,0xbf,0x95,0x9b,0x89,0x87,0xdd,0xd3,0xc1,0xcf,0xe5,0xeb,0xf9,0xf7},
            {0x4d,0x43,0x51,0x5f,0x75,0x7b,0x69,0x67,0x3d,0x33,0x21,0x2f,0x05,0x0b,0x19,0x17},
            {0x76,0x78,0x6a,0x64,0x4e,0x40,0x52,0x5c,0x06,0x08,0x1a,0x14,0x3e,0x30,0x22,0x2c},
            {0x96,0x98,0x8a,0x84,0xae,0xa0,0xb2,0xbc,0xe6,0xe8,0xfa,0xf4,0xde,0xd0,0xc2,0xcc},
            {0x41,0x4f,0x5d,0x53,0x79,0x77,0x65,0x6b,0x31,0x3f,0x2d,0x23,0x09,0x07,0x15,0x1b},
            {0xa1,0xaf,0xbd,0xb3,0x99,0x97,0x85,0x8b,0xd1,0xdf,0xcd,0xc3,0xe9,0xe7,0xf5,0xfb},
            {0x9a,0x94,0x86,0x88,0xa2,0xac,0xbe,0xb0,0xea,0xe4,0xf6,0xf8,0xd2,0xdc,0xce,0xc0},
            {0x7a,0x74,0x66,0x68,0x42,0x4c,0x5e,0x50,0x0a,0x04,0x16,0x18,0x32,0x3c,0x2e,0x20},
            {0xec,0xe2,0xf0,0xfe,0xd4,0xda,0xc8,0xc6,0x9c,0x92,0x80,0x8e,0xa4,0xaa,0xb8,0xb6},
            {0x0c,0x02,0x10,0x1e,0x34,0x3a,0x28,0x26,0x7c,0x72,0x60,0x6e,0x44,0x4a,0x58,0x56},
            {0x37,0x39,0x2b,0x25,0x0f,0x01,0x13,0x1d,0x47,0x49,0x5b,0x55,0x7f,0x71,0x63,0x6d},
            {0xd7,0xd9,0xcb,0xc5,0xef,0xe1,0xf3,0xfd,0xa7,0xa9,0xbb,0xb5,0x9f,0x91,0x83,0x8d}
    };




    static public void main(String args[]) {

        hexList = list;

        countRcon++;
        RoundKey1 = roundKey(MainKey);
        System.out.println("\nRoundKey1: " + RoundKey1);
        countRcon++;

        for (int i = 0; i < 16; i++) {
            RoundKey1BU[i] = RoundKey1.get(i);
            RoundKey1BUP.add(RoundKey1BU[i]);
        }

        System.out.println("\nRoundKey1BUP: " + RoundKey1BUP);


        RoundKey2 = roundKey(RoundKey1);
        System.out.println("\nRoundKey2: " + RoundKey2);
        countRcon++;

        for (int i = 0; i < 16; i++) {
            RoundKey2BU[i] = RoundKey2.get(i);
            RoundKey2BUP.add(RoundKey2BU[i]);
        }

        RoundKey3 = roundKey(RoundKey2);
        System.out.println("\nRoundKey3: " + RoundKey3);
        countRcon++;

        for (int i = 0; i < 16; i++) {
            RoundKey3BU[i] = RoundKey3.get(i);
            RoundKey3BUP.add(RoundKey3BU[i]);
        }

        RoundKey4 = roundKey(RoundKey3);
        System.out.println("\nRoundKey4: " + RoundKey4);
        countRcon++;

        for (int i = 0; i < 16; i++) {
            RoundKey4BU[i] = RoundKey4.get(i);
            RoundKey4BUP.add(RoundKey4BU[i]);
        }

        RoundKey5 = roundKey(RoundKey4);
        System.out.println("\nRoundKey5: " + RoundKey5);
        countRcon++;

        for (int i = 0; i < 16; i++) {
            RoundKey5BU[i] = RoundKey5.get(i);
            RoundKey5BUP.add(RoundKey5BU[i]);
        }

        RoundKey6 = roundKey(RoundKey5);
        System.out.println("\nRoundKey6: " + RoundKey6);
        countRcon++;

        for (int i = 0; i < 16; i++) {
            RoundKey6BU[i] = RoundKey6.get(i);
            RoundKey6BUP.add(RoundKey6BU[i]);
        }

        RoundKey7 = roundKey(RoundKey6);
        System.out.println("\nRoundKey7: " + RoundKey7);
        countRcon++;

        for (int i = 0; i < 16; i++) {
            RoundKey7BU[i] = RoundKey7.get(i);
            RoundKey7BUP.add(RoundKey7BU[i]);
        }

        RoundKey8 = roundKey(RoundKey7);
        System.out.println("\nRoundKey8: " + RoundKey8);
        countRcon++;

        for (int i = 0; i < 16; i++) {
            RoundKey8BU[i] = RoundKey8.get(i);
            RoundKey8BUP.add(RoundKey8BU[i]);
        }

        RoundKey9 = roundKey(RoundKey8);
        System.out.println("\nRoundKey9: " + RoundKey9);
        countRcon++;

        for (int i = 0; i < 16; i++) {
            RoundKey9BU[i] = RoundKey9.get(i);
            RoundKey9BUP.add(RoundKey9BU[i]);
        }

        RoundKey10 = roundKey(RoundKey9);
        System.out.println("\nRoundKey10: " + RoundKey10);

        for (int i = 0; i < 16; i++) {
            RoundKey10BU[i] = RoundKey10.get(i);
            RoundKey10BUP.add(RoundKey10BU[i]);
        }

        System.out.println(sbox.length);
        System.out.println(hexList);

        for (int i = 0; i < 16; i++) {

            mainListInteger[i] = Integer.parseInt(list.get(i), 16);
        }

        //addRoundKey(MainKey, list);

        System.out.println("1. MATRIX");


        MainList = addRoundKey(RoundKey10BUP, list);

        //System.out.println("\n\nBURAYA BAK RoundKey:  "+RoundKey10BUP);
        //System.out.println("\n\nBURAYA BAK list:  "+list);

        System.out.println("\n\nBURAYA BAK:  "+MainList);
        //OylesineBirList= ReverseShiftRows();

        OylesineBirList= InvrssubBytes(ReverseShiftRows());


        System.out.println("\n\nLISTE BAKKK BAK:  "+OylesineBirList);



        ReverseMixColumns();

        System.out.println("2. MATRIX");


        list = afterMixColList;
        MainList = subBytes(addRoundKey(RoundKey1BUP, list));
        ReverseShiftRows();
        ReverseMixColumns();

        System.out.println("3. MATRIX");


        list = afterMixColList;
        MainList = subBytes(addRoundKey(RoundKey2BUP, list));
        ReverseShiftRows();
        ReverseMixColumns();

        System.out.println("4. MATRIX");


        list = afterMixColList;
        MainList = subBytes(addRoundKey(RoundKey3BUP, list));
        ReverseShiftRows();
        ReverseMixColumns();

        System.out.println("5. MATRIX");


        list = afterMixColList;
        MainList = subBytes(addRoundKey(RoundKey4BUP, list));
        ReverseShiftRows();
        ReverseMixColumns();

        System.out.println("6. MATRIX");

        list = afterMixColList;
        MainList = subBytes(addRoundKey(RoundKey5BUP, list));
        ReverseShiftRows();
        ReverseMixColumns();

        System.out.println("7. MATRIX");

        list = afterMixColList;
        MainList = subBytes(addRoundKey(RoundKey6BUP, list));
        ReverseShiftRows();
        ReverseMixColumns();

        System.out.println("8. MATRIX");

        list = afterMixColList;
        MainList = subBytes(addRoundKey(RoundKey7BUP, list));
        ReverseShiftRows();
        ReverseMixColumns();

        System.out.println("9. MATRIX");

        list = afterMixColList;
        MainList = subBytes(addRoundKey(RoundKey8BUP, list));
        ReverseShiftRows();
        ReverseMixColumns();

        System.out.println("10. MATRIX");

        list = afterMixColList;
        MainList = subBytes(addRoundKey(RoundKey9BUP, list));
        lastList = ReverseShiftRows();

        addRoundKey(RoundKey10BUP, transPose(lastList));
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

    public static List<String> InvrssubBytes(List<String> tempList) {

        System.out.println("TEMP LIST: "+tempList);

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

            SubbyteList.add(turnHex(sboxInverse[row][col]));

        }

        System.out.println("SUBBYTLE LIST: "+SubbyteList);

        return SubbyteList;




    }


    public static List<String> subBytes(List<String> tempList) {

        System.out.println("TEMP LIST: "+tempList);


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

        System.out.println("SUBBYTLE LIST: "+SubbyteList);

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

        System.out.println(AddRoundKeyStateMatrixString);

        return AddRoundKeyStateMatrixString;
    }


    public static List<String> ReverseShiftRows() {

        MainList2.clear();

        MainList2.add(MainList.get(0));
        MainList2.add(MainList.get(13));
        MainList2.add(MainList.get(10));
        MainList2.add(MainList.get(7));
        MainList2.add(MainList.get(4));
        MainList2.add(MainList.get(1));
        MainList2.add(MainList.get(14));
        MainList2.add(MainList.get(11));
        MainList2.add(MainList.get(8));
        MainList2.add(MainList.get(5));
        MainList2.add(MainList.get(2));
        MainList2.add(MainList.get(15));
        MainList2.add(MainList.get(12));
        MainList2.add(MainList.get(9));
        MainList2.add(MainList.get(6));
        MainList2.add(MainList.get(3));


        for (int i = 0; i < 16; i++) {

            if (MainList2.get(i) == "") {

                MainList2.set(i, "00");
            }
        }

        System.out.println("\nAFTER SHIFT ROWS: " + MainList2);


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


    public static int mul(int a, byte b) {

        int inda = (a < 0) ? (a + 256) : a;
        int indb = (b < 0) ? (b + 256) : b;

        if ((a != 0) && (b != 0)) {
            int index = (LogTable[inda] + LogTable[indb]);
            byte val = (byte) (AlogTable[index % 255]);
            return val;
        } else
            return 0;
    } // mul




    public static void ReverseMixColumns() {

        afterMixColList.clear();

        int[][] mixColumns, mainList;
        int[][] tempList = new int[4][4];

        mixColumns = new int[][]{

                {0x0e, 0x0b, 0x0d, 0x09},
                {0x09, 0x0e, 0x0b, 0x0d},
                {0x0d, 0x09, 0x0e, 0x0b},
                {0x0b, 0x0d, 0x09, 0x0e}
        };

        mainList = hexToInteger(shiftColumnList);

        ////// TEMP LIST1

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 1; j++) {
                tempList[i][j] = mainList[i][j];
            }
        }

        for (int j = 0; j < 4; j++) {

            for (int i = 0; i < 4; i++) {

                countMUL = Integer.parseInt(String.valueOf(mul(Integer.parseInt(String.valueOf(mixColumns[i][j]),16), (byte) tempList[i][0])), 2);

                countXOR = countXOR ^ countMUL;
            }

            afterMixColList.add(turnHex(countXOR));
            countXOR = 0;
        }

        ////// TEMP LIST2

        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 2; j++) {

                tempList[i][j] = mainList[i][j];
            }
        }

        for (int j = 0; j < 4; j++) {

            for (int i = 0; i < 4; i++) {

                countMUL = Integer.parseInt(String.valueOf(mul(Integer.parseInt(String.valueOf(mixColumns[i][j]),16), (byte) tempList[i][0])), 2);

                countXOR = countXOR ^ countMUL;
            }

            afterMixColList.add(turnHex(countXOR));

            countXOR = 0;
        }

        ////// TEMP LIST3

        for (int i = 0; i < 4; i++) {
            for (int j = 2; j < 3; j++) {
                tempList[i][j] = mainList[i][j];

            }
        }

        for (int j = 0; j < 4; j++) {

            for (int i = 0; i < 4; i++) {

                countMUL = Integer.parseInt(String.valueOf(mul(Integer.parseInt(String.valueOf(mixColumns[i][j]),16), (byte) tempList[i][0])), 2);

                countXOR = countXOR ^ countMUL;
            }

            afterMixColList.add(turnHex(countXOR));

            countXOR = 0;
        }

        ////// TEMP LIST4

        for (int i = 0; i < 4; i++) {
            for (int j = 3; j < 4; j++) {
                tempList[i][j] = mainList[i][j];
            }
        }

        for (int j = 0; j < 4; j++) {

            for (int i = 0; i < 4; i++) {

                countMUL = Integer.parseInt(String.valueOf(mul(Integer.parseInt(String.valueOf(mixColumns[i][j]),16), (byte) tempList[i][0])), 2);

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

        System.out.println("\n\nAFTER MIXCOLUMN:  " + afterMixColList);


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













