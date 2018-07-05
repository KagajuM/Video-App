package com.example.mkagaju.itube;

import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

class Samples {
//    public static final Uri IPHONE_X_URI = Uri.parse("https://www.youtube.com/watch?v=K4wEI5zhHB0&t=1s");
//    public static final Uri VIMEO_URI = Uri.parse("https://vimeo.com/channels/staffpicks/122375452");
    public final static List<String> videoList = new ArrayList<String>();

    public static final List<String> getVideoList() {
        videoList.add("K4wEI5zhHB0&t=1s"); //Iphone X
        videoList.add("Y5bsiYuTUSA&t=2s"); //Nest Thermostat
        videoList.add("ErHKzMOVgYA"); //Nikon
        videoList.add("L5FIAniosZU"); //Iphone 8, Product Red
        videoList.add("38UaU3sIci0"); //How to sell on ebay
        videoList.add("nlgo-lMayw0"); //Fashion, ebay
        videoList.add("RDpOB-OXypQ"); //Macbook Pro
        return videoList;
    }
}

