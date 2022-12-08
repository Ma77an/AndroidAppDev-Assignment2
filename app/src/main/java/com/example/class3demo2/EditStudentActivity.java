package com.example.class3demo2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.class3demo2.model.Model;
import com.example.class3demo2.model.Student;

import java.util.List;

public class EditStudentActivity extends AppCompatActivity {
    List<Student> data;

    int pos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            pos = extras.getInt("pos");
        }

        Student st = Model.instance().getStudent(pos);

        TextView nameTv = findViewById(R.id.edit_name_tv);
        TextView nameEt = findViewById(R.id.edit_name_et);
        TextView idTv = findViewById(R.id.edit_id_tv);
        TextView idEt = findViewById(R.id.edit_id_et);
        TextView phoneTv = findViewById(R.id.edit_phone_tv);
        TextView phoneEt = findViewById(R.id.edit_phone_et);
        TextView addressTv = findViewById(R.id.edit_address_tv);
        TextView addressEt = findViewById(R.id.edit_address_et);
        CheckBox cb = findViewById(R.id.edit_cb);


        nameEt.setText(st.name);
        idEt.setText(st.id);
        phoneEt.setText(st.phone);
        addressEt.setText(st.address);
        cb.setChecked(st.cb);


        Button saveBtn = findViewById(R.id.edit_save_btn);
        Button deleteBtn = findViewById(R.id.edit_delete_btn);
        Button cancelBtn = findViewById(R.id.edit_cancel_btn);

        int finalPos = pos;
        saveBtn.setOnClickListener(view -> {
            st.name = nameEt.getText().toString();
            st.id = idEt.getText().toString();
            st.phone = phoneEt.getText().toString();
            st.address = addressEt.getText().toString();
            st.cb = cb.isChecked();

            Model.instance().updateStudent(finalPos, st);
            setResult(finalPos);
            finish();
        });

        cancelBtn.setOnClickListener(view -> {
            setResult(finalPos);
            finish();
        });

        deleteBtn.setOnClickListener(view -> {
            Model.instance().deleteStudent(finalPos);
            setResult(-finalPos);
            finish();
        });
    }

    @Override
    public void onBackPressed() {
        setResult(pos);
        finish();
    }
}
