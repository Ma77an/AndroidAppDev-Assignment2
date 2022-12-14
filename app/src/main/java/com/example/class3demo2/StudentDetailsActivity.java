package com.example.class3demo2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.class3demo2.model.Model;
import com.example.class3demo2.model.Student;

public class StudentDetailsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);
        int pos = 0;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            pos = extras.getInt("pos");
        }

        Student st = Model.instance().getStudent(pos);

        TextView nameTv = findViewById(R.id.details_name_tv);
        TextView idTv = findViewById(R.id.details_id_tv);
        TextView phoneTv = findViewById(R.id.details_phone_tv);
        TextView addressTv = findViewById(R.id.details_address_tv);
        CheckBox cb = findViewById(R.id.details_cb);
        Button editBtn = findViewById(R.id.details_edit_btn);

        nameTv.setText("Name: " + st.name);
        idTv.setText("ID: " + st.id);
        phoneTv.setText("Phone: " + st.phone);
        addressTv.setText("Address: " + st.address);
        cb.setChecked(st.cb);


        int finalPos = pos;
        cb.setOnClickListener(view -> {
            setResult(finalPos);
            st.cb = cb.isChecked();
        });


        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), EditStudentActivity.class);
                i.putExtra("pos", finalPos);
                startActivityForResult(i, 0);
                onActivityResult(0, finalPos, null);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int pos, @Nullable Intent data) {
        super.onActivityResult(requestCode, pos, data);
        setResult(pos);
        if (pos < 0) {
            setResult(pos);
            finish();
        } else {
            Student st = Model.instance().getStudent(pos);
            TextView nameTv = findViewById(R.id.details_name_tv);
            TextView idTv = findViewById(R.id.details_id_tv);
            TextView phoneTv = findViewById(R.id.details_phone_tv);
            TextView addressTv = findViewById(R.id.details_address_tv);
            CheckBox cb = findViewById(R.id.details_cb);
            Button editBtn = findViewById(R.id.details_edit_btn);

            nameTv.setText("Name: " + st.name);
            idTv.setText("ID: " + st.id);
            phoneTv.setText("Phone: " + st.phone);
            addressTv.setText("Address: " + st.address);
            cb.setChecked(st.cb);
        }

    }
}