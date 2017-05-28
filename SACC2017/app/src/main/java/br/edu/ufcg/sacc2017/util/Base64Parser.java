package br.edu.ufcg.sacc2017.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;

/**
 * Created by WitaloCarlos on 27/05/2017.
 */

public class Base64Parser {

    public Bitmap parseToBitmap(String base64Image) {

        byte[] decodedString = Base64.decode(base64Image, Base64.DEFAULT);
        Bitmap bitmapImage = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

        return bitmapImage;

    }
}
