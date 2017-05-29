package br.com.ufcg.sacc2017.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

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
