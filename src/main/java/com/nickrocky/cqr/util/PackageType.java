package com.nickrocky.cqr.util;

import lombok.RequiredArgsConstructor;

import java.awt.*;

@RequiredArgsConstructor
public enum PackageType {
    WHITE(255, 255, 255),
    GRAY(128, 128,128),
    BLACK(0,0,0),
    DARK_GRAY(64,64,64),
    RED(255, 0,0), //yellow + magenta
    DARK_RED(128, 0,0),
    GREEN(0, 255, 0), // yellow + cyan
    DARK_GREEN(0,128, 0),
    BLUE(0,0, 255), // magenta + cyan
    DARK_BLUE(0,0, 128),
    YELLOW(255, 255, 0),
    DARK_YELLOW(128, 128, 0),
    MAGENTA(255, 0, 255),
    DARK_MAGENTA(128, 0, 128),
    CYAN(0, 255, 255),
    DARK_CYAN(0, 128, 128);

    private final int r,g,b;

    public Color getRGB(){
        return new Color(r,g,b);
    }

}
