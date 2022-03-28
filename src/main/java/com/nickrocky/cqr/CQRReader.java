package com.nickrocky.cqr;

import com.nickrocky.cqr.data.CQRCode;
import com.nickrocky.cqr.data.CharacterSet;
import com.nickrocky.cqr.util.EncodingScheme;
import com.nickrocky.cqr.util.PackageType;

import java.util.List;

public class CQRReader {

    private EncodingScheme scheme;
    private List<PackageType> data;
    private CQRCode code;

    public CQRReader(CQRCode code){
        this.data = code.getPayload();
        this.scheme = code.getConfig().getScheme();
        this.code = code;
    }

    public void read(){
        switch (scheme){
            case CHARACTER_FULL:
                System.out.println("The Payload Is!");
                System.out.println(dumpTextPayload());
                break;
        }
    }

    private String dumpTextPayload(){
        String payload = "";
        int x = code.getWidth()-1;
        int y = x;

        for(int i = 0; i < data.size(); i+=2){
            String s = CharacterSet.getFromPackage(data.get(i), data.get(i+1));
            //System.out.println("i " + i + " X: " + x + " Y: " + y + " " + data.get(i+1) + " " + data.get(i) + " : Char: " + s);
            payload+=s;
            String nextChar = CharacterSet.getFromPackage(data.get(i+2), data.get(i+3));
            if(nextChar == "a"){
                String a,b,c;
                b = CharacterSet.getFromPackage(data.get(i+4), data.get(i+5));

                if(b == "a"){
                    break;
                }
            }
            x--;


        }
        return payload;
    }
}
