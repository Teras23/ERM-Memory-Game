package ee.erm.art.ermmemorygame;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private List<Question> questionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        readQuestions();

        Button estonianButton = findViewById(R.id.languageEE);
        Button russianButton = findViewById(R.id.languageRU);
        Button englishButton = findViewById(R.id.languageEN);

        estonianButton.setOnClickListener(this);
        russianButton.setOnClickListener(this);
        englishButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.languageEE) {
            MLString.setCurrentLanguage(MLString.Language.Estonian);
        }
        else if(view.getId() == R.id.languageRU) {
            MLString.setCurrentLanguage(MLString.Language.Russian);
        }
        else if(view.getId() == R.id.languageEN) {
            MLString.setCurrentLanguage(MLString.Language.English);
        }

        Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
        intent.putExtra("question", (Serializable)questionList);
        ResultActivity.userScore = 0;
        startActivity(intent);
    }

    private void readQuestions() {
        questionList = QuestionReader.getQuestions(this);

        for(Question question : questionList) {
            Log.i("ERM", question.toString());
        }
    }
}
