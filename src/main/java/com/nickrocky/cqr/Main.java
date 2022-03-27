package com.nickrocky.cqr;

import com.nickrocky.cqr.data.CQRCode;
import com.nickrocky.cqr.util.EncodingScheme;
import com.nickrocky.cqr.util.PackageType;
import lombok.SneakyThrows;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {

    @SneakyThrows
    public static void main(String... args){
        //BufferedImage bufImage = ImageIO.read(new File("first_cqr.png"));
        //CQRCode cqrCode = new CQRCode(bufImage, bufImage.getHeight(), bufImage.getWidth());
        /*for(PackageType[] p : cqrCode.getColorInput()){
            for(PackageType pack : p){
                System.out.println(pack.name()+ " ");
            }
            System.out.println();
        }*/
        CQRWriter cqrWriter = new CQRWriter("zackqr.png", EncodingScheme.CHARACTER_FULL, "I dont know encode something monkey");
        cqrWriter.createCQRCode();

    }

}
