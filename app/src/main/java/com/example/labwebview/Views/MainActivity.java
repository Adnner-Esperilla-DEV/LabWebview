package com.example.labwebview.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.labwebview.Interfaces.WebAppInterface;
import com.example.labwebview.R;

import java.security.Key;

public class MainActivity extends AppCompatActivity {

    private static String DIRECTION = "https://www.youtube.com/watch?v=8T2JKVulOe8&list=RD8T2JKVulOe8&start_radio=1&ab_channel=10MinuteMusic";
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        settings();
    }

    private void settings() {
        WebView webView = (WebView) findViewById(R.id.webView);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.addJavascriptInterface(new WebAppInterface(this,webView,webView),"Android");
        webView.setWebViewClient(new MyWebViewClient());

        webView.loadUrl(DIRECTION);
    }

    private  class MyWebViewClient extends android.webkit.WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        WebView webView = (WebView)findViewById(R.id.webView);
        if((keyCode== KeyEvent.KEYCODE_BACK) && webView.canGoBack()){
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}