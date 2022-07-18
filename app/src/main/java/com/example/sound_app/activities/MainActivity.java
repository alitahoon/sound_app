package com.example.sound_app.activities;

import static androidx.core.content.ContentProviderCompat.requireContext;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;

import android.provider.MediaStore;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Toast;

import com.example.sound_app.R;
import com.example.sound_app.fragments.content_fragment;
import com.example.sound_app.objects.sounds;
import com.google.android.material.snackbar.Snackbar;

import java.security.Permission;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final int Request_code_for_Sounds=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) !=
                PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, Request_code_for_Sounds);
        }else
        {
            FragmentManager f=getSupportFragmentManager();
            FragmentTransaction ft=f.beginTransaction();
            ft.replace(R.id.fragment_content_container,new content_fragment().newInstance(ReadSounds()));
            ft.commit();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==Request_code_for_Sounds && grantResults.length>0){
            ReadSounds();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    //get sound data from content provider
    private ArrayList<sounds> ReadSounds(){
        ArrayList<sounds> soundList=new ArrayList<>();
        Uri uri= MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        String [] projection={
          MediaStore.Audio.Media.ARTIST,
          MediaStore.Audio.Media.ALBUM,
          MediaStore.Audio.Media.TITLE,
          MediaStore.Audio.Media.DATA,
          MediaStore.Audio.Media.DURATION,
        };
        Cursor c=getContentResolver().query(uri,projection,null,null);

        if (c.moveToFirst()){
            do {
                String ARTIST=c.getString(0);
                String ALBUM=c.getString(1);
                String TITLE=c.getString(2);
                String DATA=c.getString(3);
                String DURATION=c.getString(4);

                sounds s=new sounds(TITLE,DATA,ARTIST,ALBUM);
                soundList.add(s);
            }while (c.moveToNext());

        }else{
            Toast.makeText(this, "No Sounds Found", Toast.LENGTH_SHORT).show();
        }
        return  soundList;
    }


}