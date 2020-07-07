package com.search.demo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button fab = findViewById(R.id.search);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAggregateSearch();
            }
        });
    }

    private void startAggregateSearch() {
        // uid, pid 合作方自行修改
        String uid = "test_uid";
        String pid = "test_pid";

        Uri uri = Uri.parse("aggregatesearch://keyword");
        Uri.Builder builder = uri.buildUpon();
        builder.appendQueryParameter("pid", pid);
        builder.appendQueryParameter("uid", uid);
        uri = builder.build();

        Intent intent = new Intent(Intent.ACTION_SEARCH);
        intent.setData(uri);
        intent.setPackage(getPackageName());

        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
