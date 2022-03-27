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
        //BufferedImage bufImage = ImageIO.read(new File("zackqr.png"));
        //CQRCode cqrCode = new CQRCode(bufImage, bufImage.getHeight(), bufImage.getWidth());
        //CQRReader reader = new CQRReader(cqrCode);
        //reader.read();
        /*for(PackageType[] p : cqrCode.getColorInput()){
            for(PackageType pack : p){
                System.out.println(pack.name()+ " ");
            }
            System.out.println();
        }*/
        // Well look at mr smarty pants over here figuring out the coloring schema for the padding you know what as a prize you get this. Im proud of you. Like seriously it took two monkey's until an absurd hour to set up this encoding nice Anyways how has life been, like seriously are you doing well how about the ranch do you plan to go back to it one day. Good bye
        CQRWriter cqrWriter = new CQRWriter("zackqr.png", EncodingScheme.CHARACTER_FULL, "Hackabull 2022 Colored QR Codes.aaa");
        cqrWriter.createCQRCode();

    }

}
