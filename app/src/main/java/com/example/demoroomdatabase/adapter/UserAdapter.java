package com.example.demoroomdatabase.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demoroomdatabase.R;
import com.example.demoroomdatabase.UpdateProductActivity;
import com.example.demoroomdatabase.entity.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {
    private Context context;
    private List<User> userList;

    public UserAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater inflater = LayoutInflater.from(context);
//        View view = inflater.inflate(R.layout.user_view, parent, false);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvId.setText(String.valueOf(userList.get(position).getId()));
        holder.tvName.setText(userList.get(position).getName());
        
        holder.tvEmail.setText(userList.get(position).getEmail());

        if (holder.btnUpdate != null) {
            holder.btnUpdate.setOnClickListener(v -> {
                Intent intent = new Intent(context, UpdateProductActivity.class);
                intent.putExtra("USER_ID", userList.get(position).getId());  // Truyền ID sản phẩm
                intent.putExtra("USER_NAME", userList.get(position).getName());
                intent.putExtra("USER_EMAIL", userList.get(position).getEmail());
                intent.putExtra("USER_PASSWORD", userList.get(position).getPassword());
                context.startActivity(intent);
            });
        }else {
            Log.e("UserAdapter", "btnUpdate is null for position: " + position);
        }

        //holder.btnUpdate.setOnClickListener(view -> listener.onUpdateClick(userList.get(position).id));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvId, tvName, tvEmail;
        Button btnUpdate;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tvId);
            tvName = itemView.findViewById(R.id.tvName);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            btnUpdate = itemView.findViewById(R.id.btnUpdate);
        }
    }
}

