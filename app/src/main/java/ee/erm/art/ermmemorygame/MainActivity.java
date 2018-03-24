package ee.erm.art.ermmemorygame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    private List<Question> questionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question);
    }

    @Override
    protected void onStart() {
        super.onStart();
        questionList = QuestionReader.getQuestions(this);

        for(Question question : questionList) {
            Log.i("ERM", question.toString());
        }

        Log.i("ERM", "");
    }
}