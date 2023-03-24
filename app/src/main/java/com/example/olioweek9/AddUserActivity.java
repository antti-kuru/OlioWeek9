package com.example.olioweek9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class AddUserActivity extends AppCompatActivity {

    private EditText firstNameInput;
    private EditText lastNameInput;
    private EditText emailInput;
    private String degreeChoice;

    private int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        firstNameInput = findViewById(R.id.editFirstName);
        lastNameInput = findViewById(R.id.editLastName);
        emailInput = findViewById(R.id.editEmail);
    }


    public void addUser(View view){


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


        User user = new User(firstNameInput.getText().toString(), lastNameInput.getText().toString(), emailInput.getText().toString(), degreeChoice, image);
        UserStorage.getInstance().addUser(user);



    }






}