package com.tuya.test.scheme;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.tuya.test.home.HomeActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView goToDetails;
    WebView webView;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        goToDetails = findViewById(R.id.tv_goto_details);
        goToDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PackageManager packageManager = getPackageManager();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tuya://home:8888/homeActivity"));
                List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, 0);
                boolean isValid = !activities.isEmpty();
                if (isValid) {
                    startActivity(intent);
                }else {
                    Toast.makeText(context,"不存在",Toast.LENGTH_SHORT).show();
                }
            }
        });

        webView = findViewById(R.id.wb_webview);

        WebSettings webSettings = webView.getSettings();
        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式

        webView.loadUrl("file:///android_asset/webview.html");



    }
}
