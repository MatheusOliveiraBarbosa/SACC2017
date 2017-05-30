package br.com.ufcg.sacc2017.util;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;


/**
 * Created by WitaloCarlos on 27/05/2017.
 */

public class JSONRawReader {

    Context context;


    public JSONRawReader(Context context) {
        this.context = context;
    }

    public JSONObject getJSONFromRaw(int resID) throws IOException, JSONException {

        if (resID == 0){
            throw new RuntimeException("O ID do arquivo não foi definido.");
        }

        JSONObject json = new JSONObject(readData(resID));

        return  json;
    }

    public JSONArray getJSONArrayFromRaw(int resID) throws IOException, JSONException {

        if (resID == 0){
            throw new RuntimeException("O ID do arquivo não foi definido.");
        }

        JSONArray json = new JSONArray(readData(resID));

        return  json;
    }

    private String readData(int resID) throws IOException {
        InputStream is = getContext().getResources().openRawResource(resID);

        Writer writer = new StringWriter();

        char[] buffer = new char[1024];

        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int bufferLine;
            while ((bufferLine = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, bufferLine);
            }
        } finally {
            is.close();
        }

        String data = writer.toString();

        if (data == null){
            throw new RuntimeException("Nenhum dado foi convertido.");
        }

        return data;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
