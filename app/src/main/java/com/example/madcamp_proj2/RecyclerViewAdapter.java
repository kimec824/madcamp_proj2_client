package com.example.madcamp_proj2;

import android.content.Context;
import android.graphics.Bitmap;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import static com.example.madcamp_proj2.Fragment2.recyclerView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    public ArrayList<FeedItem> feedItems = new ArrayList<FeedItem>();



    public RecyclerViewAdapter(){
    }


    // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.recyclerview_item, parent, false) ;
        RecyclerViewHolder vh = new RecyclerViewAdapter.RecyclerViewHolder(view) ;


        return vh ;
    }

    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

        FeedItem feed = feedItems.get(position);

        holder.onBind(feed);
    }


    // getItemCount() - 전체 데이터 갯수 리턴.
    @Override
    public int getItemCount() {
        return feedItems.size() ;
    }

    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(Bitmap icon, String name, String context, String image_path) {
        FeedItem item = new FeedItem();

        item.setIcon(icon);
        item.setName(name);
        item.setPhotoContext(context);
        item.setImagePath(image_path);
        //item.setStr(str);

        feedItems.add(item);
    }


    // 아이템 뷰를 저장하는 뷰홀더 클래스.
    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name;
        TextView tv_path;
        TextView tv_context;
        public ImageView iconImageView = null;

        public RecyclerViewHolder(View itemView) {
            super(itemView) ;

            // 뷰 객체에 대한 참조. (hold strong reference)
            iconImageView = (ImageView) itemView.findViewById(R.id.imageview);
            tv_name = (TextView) itemView.findViewById(R.id.textView3);
            tv_path = (TextView) itemView.findViewById(R.id.textView4);
            tv_context = (TextView) itemView.findViewById(R.id.textView5);

        }

        public void onBind(FeedItem feed) {
            // 아이템 내 각 위젯에 데이터 반영
            String url = "http://192.249.18.232:8080/photos/uploads/" ;
            //iconImageView.setImageBitmap(gridViewItem.getIcon());
            Glide.with(recyclerView).load(url+feed.getImagePath()).into(this.iconImageView);
            tv_name.setText(feed.getName());
            tv_path.setText(feed.getImagePath());
            tv_context.setText(feed.getPhotoConText());
        }
    }


}