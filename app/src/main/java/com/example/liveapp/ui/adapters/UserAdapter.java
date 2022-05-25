package com.example.liveapp.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.liveapp.R;
import com.example.liveapp.ui.models.UserModel;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private List<UserModel> userModels;
    private Context context;
    private ItemClickListener clickListener;

    public UserAdapter(List<UserModel> userModels, Context context, ItemClickListener clickListener) {
        this.userModels = userModels;
        this.context = context;
        this.clickListener = clickListener;

    }

    public void addItems(List<UserModel> userModels1) {
            userModels.clear();
            userModels.addAll(userModels1);
            notifyDataSetChanged();

        }


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.textView.setText(userModels.get(position).getStrCategory());

        Glide.with(context)
                .load(userModels.get(position).getStrCategoryThumb())
                .into(holder.imageView);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onItemClick(userModels.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return userModels.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageView);

        }

    }

    public interface ItemClickListener {
        public void onItemClick(UserModel userModel);
    }
}
