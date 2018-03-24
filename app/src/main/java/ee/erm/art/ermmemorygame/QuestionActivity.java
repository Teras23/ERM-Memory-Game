package ee.erm.art.ermmemorygame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

/**
 * Created by teras on 24.03.18.
 */

public class QuestionActivity extends AppCompatActivity implements View.OnClickListener {

    private List<Question> questionList;
    private Integer questionIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question);

        questionList = (List<Question>)getIntent().getSerializableExtra("question");
        questionIndex = getIntent().getIntExtra("questionIndex", 0);
        TextView textView = findViewById(R.id.questionText);
        textView.setText(questionList.get(questionIndex).getQuestionText());

        ImageButton nextButton = findViewById(R.id.questionForward);
        ImageButton homeButton = findViewById(R.id.reset);

        nextButton.setOnClickListener(this);
        homeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.questionForward) {
            Intent intent = new Intent(QuestionActivity.this, QuestionDescriptionActivity.class);
            intent.putExtra("question", (Serializable) questionList);
            intent.putExtra("questionIndex", questionIndex);
            finish();
            startActivity(intent);
        }
        else if(view.getId() == R.id.reset) {
            finish();
        }
    }
}
