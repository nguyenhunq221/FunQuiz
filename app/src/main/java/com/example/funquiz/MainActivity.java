package com.example.funquiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.ArrayList;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView txt_question;
    private TextView txtContent_question;
    private TextView txtAnswer1,txtAnswer2,txtAnswer3,txtAnswer4;
    private List<Question> mListQuestion;
    private Question mQuestion;
    private int currentQuestion =0;
    ImageButton imgbtnHome;
    ImageButton btn_mute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        MediaPlayer mediaPlayer=MediaPlayer.create(MainActivity.this,R.raw.music);
        mediaPlayer.start();
        btn_mute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying() && mediaPlayer !=null) {
                    mediaPlayer.pause();
                    btn_mute.setImageResource(R.drawable.mute1);
                }
                else {
                    mediaPlayer.start();
                    btn_mute.setImageResource(R.drawable.unmute);
                }
            }
        });
        imgbtnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);
                if(mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
            }
        });
        mListQuestion =getListQuestion();
        if(mListQuestion.isEmpty()){
            return;
        }
        setDataQuestion(mListQuestion.get(currentQuestion));

    }

    private void setDataQuestion(Question question) {
        if(question==null){
            return;
        }

        mQuestion=question;

        txtAnswer1.setBackgroundResource(R.drawable.bg_blue_coner_30);
        txtAnswer2.setBackgroundResource(R.drawable.bg_blue_coner_30);
        txtAnswer3.setBackgroundResource(R.drawable.bg_blue_coner_30);
        txtAnswer4.setBackgroundResource(R.drawable.bg_blue_coner_30);


        String titleQuestion= "Question " + question.getNumber();
        txt_question.setText(titleQuestion);

        txtContent_question.setText(question.getContent());

        txtAnswer1.setText(question.getListAnswer().get(0).getContent());
        txtAnswer2.setText(question.getListAnswer().get(1).getContent());
        txtAnswer3.setText(question.getListAnswer().get(2).getContent());
        txtAnswer4.setText(question.getListAnswer().get(3).getContent());

        txtAnswer1.setOnClickListener(this);
        txtAnswer2.setOnClickListener(this);
        txtAnswer3.setOnClickListener(this);
        txtAnswer4.setOnClickListener(this);


    }

    private  void anhXa(){
        txt_question=(TextView) findViewById(R.id.txt_question);
        txtContent_question=(TextView) findViewById(R.id.txt_question_content);
        txtAnswer1=(TextView) findViewById(R.id.txt_answer1);
        txtAnswer2=(TextView) findViewById(R.id.txt_answer2);
        txtAnswer3=(TextView) findViewById(R.id.txt_answer3);
        txtAnswer4=(TextView) findViewById(R.id.txt_answer4);
        imgbtnHome=(ImageButton) findViewById(R.id.img_backhome);
        btn_mute=(ImageButton) findViewById(R.id.imgbtn_mute);
    }
    private List<Question> getListQuestion() {
            List<Question> list=new ArrayList<>();

        List<Answer> answerList1= new ArrayList<>();
        answerList1.add(new Answer("Argentina",true));
        answerList1.add(new Answer("Nhật Bản",false));
        answerList1.add(new Answer("Bồ Đào Nha",false));
        answerList1.add(new Answer("Chile",false));

        List<Answer> answerList2= new ArrayList<>();
        answerList2.add(new Answer("Pele",true));
        answerList2.add(new Answer("Cristiano Ronaldo",false));
        answerList2.add(new Answer("Luka Modric",false));
        answerList2.add(new Answer("Maradona",false));

        List<Answer> answerList3= new ArrayList<>();
        answerList3.add(new Answer("Thái Lan",false));
        answerList3.add(new Answer("Trung Quốc",false));
        answerList3.add(new Answer("Lào",false));
        answerList3.add(new Answer("Việt Nam",true));

        List<Answer> answerList4= new ArrayList<>();
        answerList4.add(new Answer("Sadio Mane",true));
        answerList4.add(new Answer("Son Heung Min",false));
        answerList4.add(new Answer("Ronaldo",false));
        answerList4.add(new Answer("Baloteli",false));

        List<Answer> answerList5= new ArrayList<>();
        answerList5.add(new Answer("Brazil",false));
        answerList5.add(new Answer("Myanmar",false));
        answerList5.add(new Answer("Uruguay",true));
        answerList5.add(new Answer("Baloteli",false));

        List<Answer> answerList6= new ArrayList<>();
        answerList6.add(new Answer("Newell's Old Boys",true));
        answerList6.add(new Answer("NewYork city",false));
        answerList6.add(new Answer("Sao Paolo",false));
        answerList6.add(new Answer("Barcelona",false));

        list.add(new Question(1,"Messi là người nước nào?",answerList1));
        list.add(new Question(2,"Ai được mệnh danh là vua bóng đá?",answerList2));
        list.add(new Question(3,"Nước nào vô địch AFF cup 2018?",answerList3));
        list.add(new Question(4,"Ai là cầu thủ lập hat-trick nhanh nhất lịch sử Ngoại hạng Anh?",answerList4));
        list.add(new Question(5,"Đội tuyển nào vô địch kì World Cup đầu tiên năm 1930?",answerList5));
        list.add(new Question(6,"Messi dành cả sự nghiệp thi đấu cho Barcelona, nhưng đâu là đội bóng thời niên thiếu của anh?",answerList6));

        return  list;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.txt_answer1:
                txtAnswer1.setBackgroundResource(R.drawable.bg_orange_coner_30);
                checkAnswer(txtAnswer1,mQuestion,mQuestion.getListAnswer().get(0));
                break;
            case R.id.txt_answer2:
                txtAnswer2.setBackgroundResource(R.drawable.bg_orange_coner_30);
                checkAnswer(txtAnswer2,mQuestion,mQuestion.getListAnswer().get(1));
                break;
            case R.id.txt_answer3:
                txtAnswer3.setBackgroundResource(R.drawable.bg_orange_coner_30);
                checkAnswer(txtAnswer3,mQuestion,mQuestion.getListAnswer().get(2));
                break;
            case R.id.txt_answer4:
                txtAnswer4.setBackgroundResource(R.drawable.bg_orange_coner_30);
                checkAnswer(txtAnswer4,mQuestion,mQuestion.getListAnswer().get(3));
                break;
        }
    }
    private  void checkAnswer(TextView textView,Question question, Answer answer) {

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(answer.isCorrect()){
                        textView.setBackgroundResource(R.drawable.bg_green_coner_30);
                        nextQuestion();
                    }
                    else {
                        textView.setBackgroundResource(R.drawable.bg_red_coner_30);
                        showAnswerCorrect(question);
                        gameOver();
                    }
                }
            },1000);
    }

    private void gameOver() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showDialog("Game Over");
            }
        },1000);
    }

    private void showAnswerCorrect(Question question) {
        if(question==null || question.getListAnswer()==null || question.getListAnswer().isEmpty()){
            return;
        }
        if (question.getListAnswer().get(0).isCorrect()){
            txtAnswer1.setBackgroundResource(R.drawable.bg_green_coner_30);
        }
        else if(question.getListAnswer().get(1).isCorrect()){
            txtAnswer2.setBackgroundResource(R.drawable.bg_green_coner_30);
        }
        else if(question.getListAnswer().get(2).isCorrect()){
            txtAnswer3.setBackgroundResource(R.drawable.bg_green_coner_30);
        }
        else if(question.getListAnswer().get(3).isCorrect()){
            txtAnswer4.setBackgroundResource(R.drawable.bg_green_coner_30);
        }
    }

    private void nextQuestion() {
        if(currentQuestion==mListQuestion.size()-1){
            showDialog("You win");
        }

        else {
            currentQuestion ++;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    setDataQuestion(mListQuestion.get(currentQuestion));

                }
            },1000);

        }

    }
    private void showDialog(String message){
        AlertDialog.Builder builder =new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setCancelable(false);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                currentQuestion=0;
                setDataQuestion(mListQuestion.get(currentQuestion));
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }

}