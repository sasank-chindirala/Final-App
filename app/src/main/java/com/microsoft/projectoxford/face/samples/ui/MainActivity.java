//
// Copyright (c) Microsoft. All rights reserved.
// Licensed under the MIT license.
//
// Microsoft Cognitive Services (formerly Project Oxford): https://www.microsoft.com/cognitive-services
//
// Microsoft Cognitive Services (formerly Project Oxford) GitHub:
// https://github.com/Microsoft/Cognitive-Face-Android
//
// Copyright (c) Microsoft Corporation
// All rights reserved.
//
// MIT License:
// Permission is hereby granted, free of charge, to any person obtaining
// a copy of this software and associated documentation files (the
// "Software"), to deal in the Software without restriction, including
// without limitation the rights to use, copy, modify, merge, publish,
// distribute, sublicense, and/or sell copies of the Software, and to
// permit persons to whom the Software is furnished to do so, subject to
// the following conditions:
//
// The above copyright notice and this permission notice shall be
// included in all copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED ""AS IS"", WITHOUT WARRANTY OF ANY KIND,
// EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
// MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
// NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
// LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
// OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
// WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
//
package com.microsoft.projectoxford.face.samples.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.microsoft.projectoxford.face.samples.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getString(R.string.subscription_key).startsWith("Please")) {
            new AlertDialog.Builder(this)
                    .setTitle(getString(R.string.add_subscription_key_tip_title))
                    .setMessage(getString(R.string.add_subscription_key_tip))
                    .setCancelable(false)
                    .show();
        }
    }

    public void detection(View view) {
        Intent intent = new Intent(this, DetectionActivity.class);
        startActivity(intent);
    }

    public void verification(View view) {
        Intent intent = new Intent(this, VerificationMenuActivity.class);
        startActivity(intent);
    }

    public void grouping(View view) {
        Intent intent = new Intent(this, GroupingActivity.class);
        startActivity(intent);
    }

    public void findSimilarFace(View view) {
        Intent intent = new Intent(this, FindSimilarFaceActivity.class);
        startActivity(intent);
    }

    public void identification(View view) {
        EditText Rollo = (EditText) findViewById(R.id.input_rollnumber);
        String Rollno = Rollo.getText().toString();
        EditText Course = (EditText) findViewById(R.id.input_COURSE);
        String course = Course.getText().toString();
        if (!course.isEmpty() && !Rollno.isEmpty() && Rollno.charAt(2) == '0'&&Rollno.charAt(0)=='1'&&(Rollno.charAt(1)=='5'||Rollno.charAt(1)=='6'||Rollno.charAt(1)=='7')&&Rollno.length()==6&&Rollno.charAt(3)<'9'&&course.charAt(0)<='Z'&&course.charAt(0)>='A'&&course.charAt(1)>='A'&&course.charAt(1)<='Z'&&course.length()<=7){
            Intent intent = new Intent(this, IdentificationActivity.class);
            startActivity(intent);
        } else {
            Context context = getApplicationContext();
            CharSequence text = "Please enter valid Credentials";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
}
