package com.example.olioweek9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class AddUserActivity extends AppCompatActivity {

    private EditText firstNameInput;
    private EditText lastNameInput;
    private EditText emailInput;
    private String degreeChoice;

    private Button button;

    private CheckBox cbBachelor, cbMaster, cbDoctor, cbSwimMaster;

    private int image;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        firstNameInput = findViewById(R.id.editFirstName);
        lastNameInput = findViewById(R.id.editLastName);
        emailInput = findViewById(R.id.editEmail);
        cbBachelor = findViewById(R.id.cbBachelor);
        cbMaster = findViewById(R.id.cbMaster);
        cbDoctor = findViewById(R.id.cbDoctor);
        cbSwimMaster = findViewById(R.id.cbSwimMaster);
        button = findViewById(R.id.btnAddUser);

        context = this;
    }


    public void addUser(View view){
        ArrayList<String> completedCourses = new ArrayList<>();

        RadioGroup rgDegreeType = findViewById(R.id.rgDegreeType);

        switch (rgDegreeType.getCheckedRadioButtonId()) {
            case R.id.rbTietotekniikka:
                degreeChoice = "Tietotekniikka";

                break;
            case R.id.rbTuotantotalous:
                degreeChoice = "Tuotantotalous";

                break;
            case R.id.rbLaskennallinenTekniikka:
                degreeChoice = "Laskennallinen tekniikka";

                break;
            case R.id.rbSahkotekniikka:
                degreeChoice = "Sähkötekniikka";

                break;
        }

        RadioGroup rgGenderType = findViewById(R.id.rgGenderType);

        switch (rgGenderType.getCheckedRadioButtonId()) {
            case R.id.rbFemale:
                image = R.drawable.female_icon;
                break;

            case R.id.rbMan:
                image = R.drawable.man_icon;
                break;

            case R.id.rbOtherGender:
                image = R.drawable.neutral_icon;
                break;
        }

        if (cbBachelor.isChecked()) {
            completedCourses.add("Kandidaatin tutkinto");
        }
        if (cbMaster.isChecked()) {
            completedCourses.add("Diplomi-insinöörin tutkinto");
        }
        if (cbDoctor.isChecked()) {
            completedCourses.add("Tekniikan tohtorin tutkinto");
        }
        if (cbSwimMaster.isChecked()) {
            completedCourses.add("Uimamaisteri");
        }

        /*System.out.println(completedCourses.size());
        for (String text : completedCourses){
            System.out.println(text);
        } */
        User user = new User(firstNameInput.getText().toString(), lastNameInput.getText().toString(), emailInput.getText().toString(), degreeChoice, image, completedCourses);
        /*System.out.println(user.getCompletedCourses().size());
        for (String text : user.getCompletedCourses()){
            System.out.println(text);
        } */
        UserStorage.getInstance().addUser(user);
        UserStorage.getInstance().saveUsers(context);
        /*System.out.println(user.getCompletedCourses().size());
        for (String text : user.getCompletedCourses()){
            System.out.println(text);
        } */




    }






}