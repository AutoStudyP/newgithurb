package com.example.btn_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        LinearLayout layout = (LinearLayout)findViewById(R.id.SelsectPage) ;
        Button select=(Button)findViewById(R.id.button2);
        RadioButton dog =(RadioButton)findViewById(R.id.DogButton);
        RadioButton cat =(RadioButton)findViewById(R.id.CatButton);
        RadioButton rabbit =(RadioButton)findViewById(R.id.RabbitButton);
        RadioGroup rg1=(RadioGroup) findViewById(R.id.RG1);
        ImageView im1=(ImageView) findViewById(R.id.imageView1);


        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {// 체크가 바뀌는 순간을 리스닝 하는것임.
                // b가 1이면 체크된상태 1이 아니면 체크인상태
                if (b){  //boolean 값이 1이면 시작 ..  check box is.checked 와 동일한 현상.
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_LONG).show();
                    layout.setVisibility(View.VISIBLE);
                    //layout.setVisibility(0); 0과 같은 값임 visible
                }
                else{
                    Toast.makeText(getApplicationContext(),"Un Checked",Toast.LENGTH_LONG).show();
                    layout.setVisibility(View.GONE);
                }
            }
        });


         select.setOnClickListener(new View.OnClickListener() { //버튼을 누르는 순간에 동작을 정의해야해서 한거임
             @Override
             public void onClick(View view) {
                 if (rg1.getCheckedRadioButtonId()==R.id.DogButton){    //라디오그룹에서 어떤 라디오버튼을 클릭했는지 확인해주는 메소드
                     im1.setImageResource(R.drawable.doggi);
                 }
                 else if (rg1.getCheckedRadioButtonId()==R.id.CatButton){
                     im1.setImageResource(R.drawable.kitty);
                 }
                 else{
                     im1.setImageResource(R.drawable.rabbits);
                 }
             }
         });
    }
}