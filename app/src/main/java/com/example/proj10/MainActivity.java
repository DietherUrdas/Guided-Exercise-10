package com.example.proj10;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    WebView browser; AutoCompleteTextView suggestedURL; ArrayAdapter adapter; Button submit, back, home;
    String [] urls = {"www.google.com","www.yahoo.com","www.facebook.com","www.youtube.com","www.instagram.com","www.tiktok.com"};
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        browser = findViewById(R.id.webView);
        suggestedURL = findViewById(R.id.actvURLGE10);
        submit = findViewById(R.id.btnOpenURLGE10);
        back = findViewById(R.id.back);
        home = findViewById(R.id.home);

        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,urls);
        suggestedURL.setThreshold(2);
        suggestedURL.setAdapter(adapter);
        initializeWebView();
        loadWebURL();

    }
    public void initializeWebView(){
        browser.getSettings().setLoadsImagesAutomatically(true);
        browser.getSettings().setJavaScriptEnabled(true);
        browser.setWebViewClient(new WebViewClient());
        browser.setScrollBarStyle(browser.SCROLLBARS_INSIDE_OVERLAY); }
    public void loadWebURL(){
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = suggestedURL.getText().toString();
                if(!url.startsWith("www.") && !url.startsWith("https://") ){
                    url = "www." + url; } if(!url.startsWith("https://") ){
                    url = "https://" + url; } browser.loadUrl(url);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (browser.canGoBack()) {
                    browser.goBack();
                }
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                browser.loadUrl("https://www.google.com");
            }
        });
    }
}