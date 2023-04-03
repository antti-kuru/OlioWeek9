package com.example.olioweek9;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {
     ImageView userImage;
     TextView userName, userEmail, userDegree, userCompletedCourses;

     LinearLayout linearLayout;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        userImage = itemView.findViewById(R.id.imageView);
        userName = itemView.findViewById(R.id.txtUserName);
        userEmail = itemView.findViewById(R.id.txtUserEmail);
        userDegree = itemView.findViewById(R.id.txtUserDegree);
        userCompletedCourses = itemView.findViewById(R.id.txtCompletedCourses);
        linearLayout = itemView.findViewById(R.id.linLayout);


    }
}
