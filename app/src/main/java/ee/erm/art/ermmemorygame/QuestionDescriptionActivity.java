package ee.erm.art.ermmemorygame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;
import java.util.List;

/**
 * Created by teras on 24.03.18.
 */

public class QuestionDescriptionActivity extends AppCompatActivity implements View.OnClickListener {

    private List<Question> questionList;
    private Integer questionIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_desc);

        questionList = (List<Question>)getIntent().getSerializableExtra("question");
        questionIndex = getIntent().getIntExtra("questionIndex", 0);

        Button nextButton = findViewById(R.id.questionForward);

        //nextButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.questionForward) {
            if(questionIndex + 1 < questionList.size()) {
                Intent intent = new Intent(QuestionDescriptionActivity.this, QuestionDescriptionActivity.class);
                intent.putExtra("question", (Serializable) questionList);
                intent.putExtra("questionIndex", questionIndex + 1);
                finish();
                startActivity(intent);
            }
            else {
                Intent intent = new Intent(QuestionDescriptionActivity.this, ResultActivity.class);
                finish();
                startActivity(intent);
            }
        }
        else if(view.getId() == R.id.reset) {
            finish();
        }
    }
}
