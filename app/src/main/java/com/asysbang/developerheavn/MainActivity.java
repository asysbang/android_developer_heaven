package com.asysbang.developerheavn;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.asysbang.developerheavn.constant.Cst;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static final String TAG = "MainActivity";

    private List<ResolveInfo> mCodes;

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCodes = loadAllCodes();
        mListView = (ListView) findViewById(R.id.main_list);
        mListView.setAdapter(new CodeAdapter());
        mListView.setOnItemClickListener(this);
    }

    private List<ResolveInfo> loadAllCodes() {
        PackageManager pm = getPackageManager();
        Intent intent = new Intent();
        intent.setAction(Cst.CODE_ACTION);
        intent.addCategory(Cst.CODE_CATEGORY);
        return pm.queryIntentActivities(intent, PackageManager.GET_ACTIVITIES);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ResolveInfo info = mCodes.get(position);
        Log.i(TAG,"============="+info.activityInfo.name);
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(getPackageName(),info.activityInfo.name));
        startActivity(intent);
    }

    private class CodeAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mCodes.size();
        }

        @Override
        public ResolveInfo getItem(int position) {
            return mCodes.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.adapter_main_list,null);
            TextView title = (TextView) convertView.findViewById(R.id.title);
            title.setText(mCodes.get(position).loadLabel(getPackageManager()));
            return convertView;
        }
    }
}
