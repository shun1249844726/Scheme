package com.tuya.test.scheme;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

/**
 * Created by xushun
 * 2018/5/14.
 */

public class GoodsDetailActivity extends AppCompatActivity {
    private static final String TAG = "GoodsDetailActivity";
    TextView goodsDetails;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_goods_details);
        goodsDetails = findViewById(R.id.tv_goods_details);

        Uri uri = getIntent().getData();
        if (uri != null){
            // 完整的url信息
            String url = uri.toString();
            Log.i(TAG, "url: " + uri);
            goodsDetails.setText(url);


            String scheme = uri.getScheme();
            Log.i(TAG, "scheme: " + scheme);

            // host部分
            String host = uri.getHost();
            Log.i(TAG, "host: " + host);
            //port部分
            int port = uri.getPort();
            Log.i(TAG, "host: " + port);
            // 访问路径
            String path = uri.getPath();
            Log.i(TAG, "path: " + path);
            List<String> pathSegments = uri.getPathSegments();
            // Query部分
            String query = uri.getQuery();
            Log.i(TAG, "query: " + query);
            //获取指定参数值
            String goodsId = uri.getQueryParameter("goodsId");
            Log.i(TAG, "goodsId: " + goodsId);

            String goodDes = uri.getQueryParameter("goodDes");
            Log.i(TAG, "goodDes: " + goodDes);

        }
    }
}
