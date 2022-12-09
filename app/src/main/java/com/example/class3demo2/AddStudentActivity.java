package com.example.class3demo2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.class3demo2.model.Model;
import com.example.class3demo2.model.Student;

public class AddStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        EditText nameEt = findViewById(R.id.add_name_et);
        EditText idEt = findViewById(R.id.add_id_et);
        EditText phoneEt = findViewById(R.id.add_phone_et);
        EditText addressEt = findViewById(R.id.add_address_et);
        CheckBox cb = findViewById(R.id.add_cb);
        Button saveBtn = findViewById(R.id.add_save_btn);
        Button cancelBtn = findViewById(R.id.add_cancel_btn);

        saveBtn.setOnClickListener(view -> {
            String name = nameEt.getText().toString();
            String id = idEt.getText().toString();
            String phone = phoneEt.getText().toString();
            String address = addressEt.getText().toString();
            boolean cbVal = cb.isChecked();

            Student st = new Student(name, id, "", phone, address, cbVal);
            int pos = Model.instance().addStudent(st);
            setResult(pos);
            finish();
        });

        cancelBtn.setOnClickListener(view -> finish());
    }
}