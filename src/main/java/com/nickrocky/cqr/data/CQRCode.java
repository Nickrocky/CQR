package com.nickrocky.cqr.data;

import com.nickrocky.cqr.exception.InvalidCQRException;
import com.nickrocky.cqr.util.PackageType;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;


import static com.nickrocky.cqr.util.PackageType.*;

@Getter

public class CQRCode {

    private PackageType[][] colorInput;
    private List<PackageType> payload;
    private final int height, width;

    private int[] magenta_reference;
    private int[] yellow_reference;
    private int[] cyan_reference, dark_magenta_reference, dark_cyan_reference, dark_yellow_reference, gray_reference, dark_red, dark_blue, dark_green;
    private CQRConfig config;

    public CQRCode(BufferedImage qrImage, int height, int width){

        //Color magenta = new Color(qrImage.getRGB(0, 0));
        //Color yellow = new Color(qrImage.getRGB(0, qrImage.getWidth()-1));
        //Color cyan = new Color(qrImage.getRGB(0, qrImage.getHeight()-1));
        Color magenta = new Color(qrImage.getRGB(0,0));
        Color cyan = new Color(qrImage.getRGB(0, qrImage.getHeight()-1));
        Color yellow = new Color(qrImage.getRGB(qrImage.getWidth()-1, 0));
        magenta_reference = rgbToCmyk(magenta);
        cyan_reference = rgbToCmyk(cyan);
        yellow_reference = rgbToCmyk(yellow);
        dark_magenta_reference = rgbToCmyk(magenta);
        dark_cyan_reference = rgbToCmyk(cyan);
        dark_yellow_reference = rgbToCmyk(yellow);
        gray_reference = new int[]{0,0,0,50};
        dark_magenta_reference[3] = 50;
        dark_cyan_reference[3] = 50;
        dark_yellow_reference[3] = 50;

        colorInput = new PackageType[width][height];
        //System.out.println("Magenta: " + magenta_reference[0] + " " + magenta_reference[1] + " "+ magenta_reference[2] + " " + magenta_reference[3]);
        //System.out.println("Cyan: " + cyan_reference[0] + " " + cyan_reference[1] + " "+ cyan_reference[2] + " " + cyan_reference[3]);
        //System.out.println("Yellow: " + yellow_reference[0] + " " + yellow_reference[1] + " "+ yellow_reference[2] + " " + yellow_reference[3]);
        for(int y = 0; y < qrImage.getHeight(); y++){
            for(int x = 0; x < qrImage.getWidth(); x++){
                Color color = new Color(qrImage.getRGB(x,y));
                colorInput[x][y] = convertToPackage(rgbToCmyk(color));
            }
        }
        this.height = height;
        this.width = width;
        payload = readInput(qrImage);

        config = new CQRConfig(colorInput, width);

    }

    private List<PackageType> readInput(BufferedImage image){
        List<PackageType> data = new ArrayList<>();
        for(int y = height-1; y > 9; y--){
            for(int x = width-1; x > 10; x--){
                //System.out.println("X: " + x + " Y: " + y);
                Color color = new Color(image.getRGB(x,y));
                PackageType p = convertToPackage(rgbToCmyk(color));
                data.add(p);
                //System.out.println("X: " + x + " Y: " + y + " " + p.name());
            }
        }
        for(int y = height-1; y > 8; y--){
            for(int x = 8; x > 9; x--){
                Color color = new Color(image.getRGB(x,y));
                PackageType p = convertToPackage(rgbToCmyk(color));
                data.add(p);
                //System.out.println("X: " + x + " Y: " + y + " " + p.name());
            }


        }
        for(int y = width-10; y > 9; y--){
            for(int x = 8; x > 0; x--){
                Color color = new Color(image.getRGB(x,y));
                PackageType p = convertToPackage(rgbToCmyk(color));
                data.add(p);
                //System.out.println("X: " + x + " Y: " + y + " " + p.name());
            }
        }

        return data;
    }

    private int[] rgbToCmyk(Color color) {
        double percentageR = color.getRed() / 255.0 * 100;
        double percentageG = color.getGreen() / 255.0 * 100;
        double percentageB = color.getBlue() / 255.0 * 100;

        double k = 100 - Math.max(Math.max(percentageR, percentageG), percentageB);

        if (k == 100) {
            return new int[]{ 0, 0, 0, 100 };
        }

        int c = (int)((100 - percentageR - k) / (100 - k) * 100);
        int m = (int)((100 - percentageG - k) / (100 - k) * 100);
        int y = (int)((100 - percentageB - k) / (100 - k) * 100);

        return new int[]{ c, m, y, (int)k };
    }

    PackageType convertToPackage(int[] cmyk){
        int cyan, magenta, yellow, key;
        cyan = cmyk[0];
        magenta = cmyk[1];
        yellow = cmyk[2];
        key = cmyk[3];

        if(cmyk[0] <= 20) cyan = 0;
        if(cmyk[1] <= 20) magenta = 0;
        if(cmyk[2] <= 20) yellow = 0;
        if(cmyk[3] > 50 && cmyk[3] <=80){
            key = 75;
        }else{
            if(key >= 30 && key < 50){
                key = 50;
            }else{
                key = 0;
            }
        }
        //if(cmyk[3] >= 30) key = 50;

        //System.out.println("Color: " + cyan + " " + magenta + " " + yellow + " " + key);

        if(cyan == magenta_reference[0] && magenta == magenta_reference[1] && yellow == magenta_reference[2]){
            if(key == 50) return DARK_MAGENTA;
            return PackageType.MAGENTA;
        }
        if(cyan == cyan_reference[0] && magenta == cyan_reference[1] && yellow == cyan_reference[2]){
            if(key == 50) return DARK_CYAN;
            return PackageType.CYAN;
        }
        if(cyan == yellow_reference[0] && magenta == yellow_reference[1] && yellow == yellow_reference[2]){
            if(key == 50) return DARK_YELLOW;
            return PackageType.YELLOW;
        }
        //green
        if(cyan == cyan_reference[0] && magenta == yellow_reference[1] && yellow == yellow_reference[2]){
            if(key == 50) return DARK_GREEN;
            return PackageType.GREEN;
        }
        //blue
        if(cyan == cyan_reference[0] && magenta == magenta_reference[1] && yellow == magenta_reference[2]){
            if(key == 50) return DARK_BLUE;
            return PackageType.BLUE;
        }
        //red
        if(cyan == magenta_reference[0] && magenta == magenta_reference[1] && yellow == yellow_reference[2]){
            if(key == 50) return DARK_RED;
            return PackageType.RED;
        }
        //white
        if(cyan == 0 && magenta == 0 && yellow == 0){
            if(key == 50) return GRAY;
            if(key == 75) return DARK_GRAY;
            return PackageType.WHITE;
        }
        if(cyan != 100 && magenta != 100 && yellow != 100) System.out.println("Misread color: " + cmyk[0] + " " + cmyk[1] + " " + cmyk[2] + " " + cmyk[3]);
        return PackageType.BLACK;
    }




}
