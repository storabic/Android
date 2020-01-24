package com.example.list5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.content.Context;
import java.util.ArrayList;

import java.sql.Array;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listViewMain = (ListView)findViewById(R.id.lvMain);
        ArrayList<android.content.pm.PackageInfo> apps = (ArrayList<android.content.pm.PackageInfo>)getPackageManager().getInstalledPackages(PackageManager.GET_META_DATA);
        ArrayList<String> names = new ArrayList<String>();
        for (android.content.pm.PackageInfo app: apps) {
            names.add(app.packageName);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        listViewMain.setAdapter(adapter);
    }
}
