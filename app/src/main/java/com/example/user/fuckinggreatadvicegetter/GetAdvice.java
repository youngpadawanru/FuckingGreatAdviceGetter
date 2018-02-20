package com.example.user.fuckinggreatadvicegetter;


import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetAdvice extends AsyncTask<Void, Void, String> {
    private final String url = "http://fucking-great-advice.ru/api/random"; //Цензурная версия сервиса не работает
    private JSONObject jsonObject;
    private String string;

    @Override
    protected String doInBackground(Void... params) {
        try {
            jsonObject = new JSONObject(new String(getUrlBytes(url)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            string = jsonObject.getString("text");
        } catch (JSONException je) {
            je.printStackTrace();
        }
        return string;
    }

    @Override
    protected void onPostExecute(String string) {
        super.onPostExecute(string);
    }

    private byte[] getUrlBytes(String inUrl) throws IOException {
        URL url = new URL(inUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            InputStream in = connection.getInputStream();
            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new IOException(connection.getResponseMessage() + ": with " + inUrl);
            }
            int bytesRead;
            byte[] buffer = new byte[1024];
            while ((bytesRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, bytesRead);
            }
            out.close();
            return out.toByteArray();
        } finally {
            connection.disconnect();
        }
    }
}
