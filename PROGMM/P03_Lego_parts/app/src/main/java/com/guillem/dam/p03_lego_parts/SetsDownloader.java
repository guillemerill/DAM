package com.guillem.dam.p03_lego_parts;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.PatternMatcher;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SetsDownloader extends AsyncTask<Void, String, Boolean> {
    public Context context;
    public SetsDownloader(Context context) { this.context = context; }

    private OnSetsLoadedListener listener = null;
    public void setOnSetsLoadedListener(OnSetsLoadedListener listener) {
        this.listener = listener;
    }

    private ProgressDialog pDialog;

    @Override protected void onPreExecute() {
        pDialog = new ProgressDialog(context);
        pDialog.setMessage("Downloading file. Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setMax(100);
        pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pDialog.setCancelable(true);
        pDialog.setTitle("Please wait...");
        String msg = "Updating sets...";
        pDialog.setMessage(msg);
        pDialog.setCancelable(true);
        pDialog.show();
    }

    @Override protected Boolean doInBackground(Void... params) {
        int count;
        try {
            // http://stucom.flx.cat/get_set_parts.php
            URL url = new URL("https://rebrickable.com/api/v3/lego/colors/?key=b4e0697ce3d5cf21af1088e9bd238dd");
            URLConnection connection = url.openConnection();
            connection.connect();
            int lengthOfFile = connection.getContentLength();
            pDialog.setMax(lengthOfFile);
            InputStream input = new BufferedInputStream(url.openStream(), 8192);
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte data[] = new byte[1024];
            long total = 0;
            while ((count = input.read(data)) != -1) {
                total += count;
                publishProgress("" + (int) ((total * 100) / lengthOfFile));
                output.write(data, 0, count);
            }
            input.close();
            output.flush();
            String xml = new String(output.toByteArray());
            System.out.println(xml);
        } catch (Exception e) {
            Log.e("Error: ", e.getMessage());
            return false;
        }

        return true;
    }

    protected void onProgressUpdate(String... progress) {
        pDialog.setProgress(Integer.parseInt(progress[0]));
    }

    @Override public void onPostExecute(Boolean result) {
        pDialog.dismiss();
        if (listener != null) listener.onSetsLoaded(result);
    }

    public interface OnSetsLoadedListener {
        public void onSetsLoaded(boolean ok);
    }
}
