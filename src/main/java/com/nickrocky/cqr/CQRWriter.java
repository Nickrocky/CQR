package com.nickrocky.cqr;

import com.nickrocky.cqr.data.CharacterSet;
import com.nickrocky.cqr.util.EncodingScheme;
import com.nickrocky.cqr.util.PackageType;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.nickrocky.cqr.util.PackageType.*;

public class CQRWriter {

    private static final int MARKER_OFFSET = 17; //This is the size pixel wise of the locator markers


    private int qr_size;
    private String fileName;
    private final String character_payload;
    private final EncodingScheme scheme;

    public CQRWriter(String fileName, EncodingScheme scheme, String character_payload){
        this.scheme = scheme;
        this.fileName = fileName;
        this.character_payload = character_payload;
    }

    public void createCQRCode(){
        switch (scheme){
            case CHARACTER -> encodeCharacterPayload();
            case CHARACTER_FULL -> encodeFullCharacterPayload();
        }
    }

    private List<PackageType> dumpText(String payload){
        List<PackageType> payloadPackage = new ArrayList<>();
        for(char c : payload.toCharArray()){
            PackageType[] output = CharacterSet.getPackageFromChar(""+c);
            payloadPackage.add(output[0]);
            payloadPackage.add(output[1]);
        }
        return payloadPackage;
    }

    private void encodeCharacterPayload(){
    }

    private void encodeFullCharacterPayload(){
        List<PackageType> payloadInPackageTypes = dumpText(character_payload);
        for(int i = 10; i < 513; i+=2){
            if(payloadInPackageTypes.size() <= calcSectorSize(i)){
                qr_size = i;
                break;
            }
        }
        System.out.println("Symbol Size: " + qr_size);
        qr_size+=MARKER_OFFSET;
        BufferedImage brandNewQRCode = null;
        brandNewQRCode = new BufferedImage(qr_size, qr_size, BufferedImage.TYPE_INT_RGB);

        File file = null;
        //Set the encoding mode
        brandNewQRCode.setRGB(0, 8, (MAGENTA.getRGB().getRed()<<16 | MAGENTA.getRGB().getGreen()<<8 | MAGENTA.getRGB().getBlue()));
        applyBaseline(brandNewQRCode);
        applyData(brandNewQRCode, payloadInPackageTypes);
        try{
            file = new File(fileName);
            ImageIO.write(brandNewQRCode, "png", file);
        }catch (IOException e){

        }

    }

    private void applyData(BufferedImage image, List<PackageType> payload){
        int x = qr_size-1;
        int y = qr_size-1;
        int index = 0;
        for(PackageType data : payload){
            System.out.println("X: " + x + " Y: " + y + "");
            image.setRGB(x, y, (data.getRGB().getRed()<<16 | data.getRGB().getGreen()<<8 | data.getRGB().getBlue()));
            index++;
            if(x == 9 && y == 8) break;
            if(x == 9){
                y--;
                x = qr_size;
            }
            x--;
        }
        y = qr_size-10;
        x = 8;
        for(int i = index; i < payload.size(); i++){
            image.setRGB(x, y, (payload.get(i).getRGB().getRed()<<16 | payload.get(i).getRGB().getGreen()<<8 | payload.get(i).getRGB().getBlue()));
            index++;
            //System.out.println("X: " + x + " Y: " + y);
            if(x == 0 && y == 9) break;
            if(x == 0){
                y--;
                x = 8;
            }
            x--;
        }

        y = 8;
        x = qr_size - 8;
        for(int i = index; i < payload.size(); i++){
            image.setRGB(x, y, (payload.get(i).getRGB().getRed()<<16 | payload.get(i).getRGB().getGreen()<<8 | payload.get(i).getRGB().getBlue()));
            index++;
            System.out.println("X: " + x + " Y: " + y);
            if(x == 9 && y == 0) break;
            if(x == 9){
                y--;
                x = qr_size - 8;
            }
            x--;
        }


    }

    private void applyBaseline(BufferedImage image){
        int magentaPixel = (MAGENTA.getRGB().getRed()<<16 | MAGENTA.getRGB().getGreen()<<8 | MAGENTA.getRGB().getBlue());
        for(int x = 0; x < 7; x++){
            image.setRGB(x, 0, magentaPixel);
        }
        image.setRGB(0, 1, magentaPixel);
        image.setRGB(6, 1, magentaPixel);

        for(int x = 0; x < 3; x++){
            image.setRGB(0, x+2, magentaPixel);
            image.setRGB(2, x+2, magentaPixel);
            image.setRGB(3, x+2, magentaPixel);
            image.setRGB(4, x+2, magentaPixel);
            image.setRGB(6, x+2, magentaPixel);
        }

        image.setRGB(0, 5, magentaPixel);
        image.setRGB(6, 5, magentaPixel);
        for(int x = 0; x < 7; x++){
            image.setRGB(x, 6, magentaPixel);
        }

        int yellowPixel = (YELLOW.getRGB().getRed()<<16 | YELLOW.getRGB().getGreen()<<8 | YELLOW.getRGB().getBlue());
        for(int x = qr_size; x > (qr_size-7); x--){
            image.setRGB(x-1, 0, yellowPixel);
        }
        image.setRGB(qr_size-7, 1, yellowPixel);
        image.setRGB(qr_size-1, 1, yellowPixel);

        for(int x = 0; x < 3; x++){
            image.setRGB(qr_size-7, x+2, yellowPixel);
            image.setRGB(qr_size-5, x+2, yellowPixel);
            image.setRGB(qr_size-4, x+2, yellowPixel);
            image.setRGB(qr_size-3, x+2, yellowPixel);
            image.setRGB(qr_size-1, x+2, yellowPixel);
        }

        image.setRGB(qr_size-7, 5, yellowPixel);
        image.setRGB(qr_size-1, 5, yellowPixel);
        for(int x = qr_size; x > (qr_size-7); x--){
            image.setRGB(x-1, 6, yellowPixel);
        }

        int cyanPixel = (CYAN.getRGB().getRed()<<16 | CYAN.getRGB().getGreen()<<8 | CYAN.getRGB().getBlue());
        for(int x = 0; x < 7; x++){
            image.setRGB(x, qr_size-7, cyanPixel);
        }
        image.setRGB(0, qr_size-6, cyanPixel);
        image.setRGB(6, qr_size-6, cyanPixel);

        for(int x = qr_size-5; x < qr_size-2; x++){
            image.setRGB(0, x, cyanPixel);
            image.setRGB(2, x, cyanPixel);
            image.setRGB(3, x, cyanPixel);
            image.setRGB(4, x, cyanPixel);
            image.setRGB(6, x, cyanPixel);
        }

        image.setRGB(0, qr_size-2, cyanPixel);
        image.setRGB(6, qr_size-2, cyanPixel);
        for(int x = 0; x < 7; x++){
            image.setRGB(x, qr_size-1, cyanPixel);
        }
    }

    private int calcSectorSize(int width){
        return (int) ((Math.pow(width, 2)*2) + 30*width + 1);
    }

}
