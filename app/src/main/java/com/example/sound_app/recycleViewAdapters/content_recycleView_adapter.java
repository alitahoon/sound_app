package com.example.sound_app.recycleViewAdapters;

import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sound_app.R;
import com.example.sound_app.databinding.ContentRecycleviewLayoutBinding;
import com.example.sound_app.objects.sounds;

import java.util.ArrayList;

public class content_recycleView_adapter extends RecyclerView.Adapter<content_recycleView_adapter.sound> {
    ArrayList<sounds> soundList=new ArrayList<>();
    String RCV_type;

    public content_recycleView_adapter(String RCV_type,ArrayList<sounds> soundList) {
        this.soundList = soundList;
        this.RCV_type = RCV_type;
    }

    @NonNull
    @Override
    public sound onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ContentRecycleviewLayoutBinding binding=ContentRecycleviewLayoutBinding.inflate(LayoutInflater.from(parent.getContext()));
        sound s=new sound(binding);
        return s;

    }

    @Override
    public void onBindViewHolder(@NonNull sound holder, int position) {
        sounds s=soundList.get(position);
        if (RCV_type.equals("content")){
            sounds newSound=soundList.get(position);
            holder.binding.contentAlbumTitle.setText(s.getAlbum()+"...");
            holder.binding.contentElementTitle.setText(s.getTitle()+"....");
            Drawable img=Drawable.createFromPath(s.getPath());
            holder.binding.elementBackground.setBackground(img);
        }else if (RCV_type.equals("genre")){

        }
    }

    @Override
    public int getItemCount() {
        return soundList.size();
    }

    class sound extends RecyclerView.ViewHolder{
    com.example.sound_app.databinding.ContentRecycleviewLayoutBinding binding;

    public sound(@NonNull ContentRecycleviewLayoutBinding itemView) {
        super(itemView.getRoot());
        binding= itemView;

    }
}
    //get sound img from the path
    private byte[] getAlbumArt(String uri){
        MediaMetadataRetriever mmr=new MediaMetadataRetriever();
        mmr.setDataSource(uri);
        byte[] art=mmr.getEmbeddedPicture();
        return art;
    }

}
