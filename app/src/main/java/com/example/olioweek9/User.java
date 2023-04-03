package com.example.olioweek9;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;

public class User implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private String degreeProgram;

    private int image;

    private ArrayList<String> completedCourses = new ArrayList<>();


    public User(String firstName, String lastName, String email, String degreeProgram, int image, ArrayList<String> completedCourses){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.degreeProgram = degreeProgram;
        this.image = image;
        this.completedCourses = completedCourses;
    }

    public static final Comparator<User> sortByLastName = new Comparator<User>() {
        @Override
        public int compare(User user, User t1) {
            return user.lastName.compareTo(t1.lastName);
        }
    };

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getEmail(){
        return email;
    }

    public String getDegreeProgram(){
        return degreeProgram;
    }

    public int getImage() {
        return image;
    }

    public ArrayList<String> getCompletedCourses() {
        return completedCourses;
    }



}

