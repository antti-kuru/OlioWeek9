package com.example.olioweek9;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private Context context;
    private ArrayList<User> users = new ArrayList<>();



    public UserListAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater.from(context).inflate(R.layout.user_view, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        List<User> userList = users;
        Collections.sort(userList, User.sortByLastName);
        holder.userName.setText(users.get(position).getFirstName() + " " + users.get(position).getLastName());
        holder.userDegree.setText(users.get(position).getDegreeProgram());
        holder.userEmail.setText(users.get(position).getEmail());
        holder.userImage.setImageResource(users.get(position).getImage());

        if(users.get(position).getCompletedCourses().size() != 0) {
            holder.userCompletedCourses.setText("Suoritetut tutkinnot:");
            for (String course : users.get(position).getCompletedCourses()) {
                TextView tv = new TextView(this.context);
                tv.setText("-" + course);
                holder.linearLayout.addView(tv);
            }
        }



    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
