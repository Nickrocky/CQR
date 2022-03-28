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
        BufferedImage bufImage = ImageIO.read(new File("beemovie.png"));
        CQRCode cqrCode = new CQRCode(bufImage, bufImage.getHeight(), bufImage.getWidth());
        CQRReader reader = new CQRReader(cqrCode);
        reader.read();
    }

}
