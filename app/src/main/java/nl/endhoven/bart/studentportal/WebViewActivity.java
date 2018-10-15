package nl.endhoven.bart.studentportal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        Intent intent = getIntent();
        //Get strings from selected PortalItem
        String url = intent.getStringExtra(MainActivity.URL);
        String title = intent.getStringExtra(MainActivity.TITLE);

        //Set title as toolbar text
        if (title != null) {
            setTitle(title);
        }

        // Display Webpage from Url
        if (url != null) {
            mWebView = (WebView) findViewById(R.id.webview);
            WebSettings webSettings = mWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);

            //mWebView = findViewById(R.id.webview);
            //mWebView.setWebViewClient(new WebViewClient());
            //mWebView.getSettings().setJavaScriptEnabled(true);
            mWebView.loadUrl(url);
        }
    }
}
