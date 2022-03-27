package com.nickrocky.cqr.data;

import com.nickrocky.cqr.exception.InvalidCQRException;
import com.nickrocky.cqr.util.EncodingScheme;
import com.nickrocky.cqr.util.PackageType;

import lombok.Getter;

@Getter
public class CQRConfig {

    private final PackageType[][] colors;
    private final int size; //this is the width and height since they are the same
    private final EncodingScheme scheme;

    public CQRConfig(PackageType[][] colors, int size){
        this.colors = colors;
        this.size = size;
        scheme = EncodingScheme.getEncoding(colors[0][8]);
        System.out.println("Encoding Scheme is : " + scheme.name());
    }

    public void validate() throws InvalidCQRException{
        boolean c =checkCyanSignifier();
        boolean m = checkMagentaSignifier();
        boolean y = checkYellowSignifier();
    }

    boolean checkMagentaSignifier(){
        for(int i = 0; i < 7; i++){
            if(colors[0][i] != PackageType.MAGENTA) return false;
        }
        if(colors[1][0] != PackageType.MAGENTA
        || colors[1][6] != PackageType.MAGENTA){
            return false;
        }
        for(int i = 0; i < 3; i++){
            if(colors[1][0] != PackageType.MAGENTA
                    || colors[1][2] != PackageType.MAGENTA
                    || colors[1][3] != PackageType.MAGENTA
                    || colors[1][4] != PackageType.MAGENTA
                    || colors[1][6] != PackageType.MAGENTA){
                return false;
            }
        }
        if(colors[5][0] != PackageType.MAGENTA
                || colors[5][6] != PackageType.MAGENTA){
            return false;
        }
        for(int i = 0; i < 7; i++){
            if(colors[6][i] != PackageType.MAGENTA) return false;
        }
        return true;
    }

    boolean checkCyanSignifier(){
        return false;
    }

    boolean checkYellowSignifier(){
        return false;
    }


}
