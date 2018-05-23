package ee.erm.art.ermmemorygame;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import org.w3c.dom.Text;

import java.io.File;
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
        Question question = questionList.get(questionIndex);

        //setting correct/incorrect message
        int selectedValue = getIntent().getIntExtra("answeredQuestion", 0);
        TextView resultDescription = findViewById(R.id.resultDescription);
        if(Integer.valueOf(selectedValue).equals(questionList.get(questionIndex).getCorrectAnswer())){
            switch (MLString.getCurrentLanguage()){
                case English:
                    resultDescription.setText("Correct!");
                    break;
                case Russian:
                    resultDescription.setText("Правилно!");
                    break;
                case Estonian:
                    resultDescription.setText("Õige!");
                    break;
            }
        }
        else{
            switch (MLString.getCurrentLanguage()){
                case Estonian:
                    resultDescription.setText("Vale!");
                    break;
                case Russian:
                    resultDescription.setText("Неправилно!");
                    break;
                case English:
                    resultDescription.setText("Incorrect");
                    break;
            }
        }

        TextView questionDescription = findViewById(R.id.questionDescription);
        questionDescription.setText(question.getDescription());
        questionDescription.setMovementMethod(new ScrollingMovementMethod());

        ImageButton nextButton = findViewById(R.id.questionForward);

        ImageView imageView = findViewById(R.id.descriptionImage);
       // Bitmap bmImg = BitmapFactory.decodeFile("p1.jpg");
        imageView.setImageDrawable(getDrawable(getDrawableImage()));


        nextButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.questionForward) {
            if(questionIndex + 1 < questionList.size()) {
                Intent intent = new Intent(QuestionDescriptionActivity.this, QuestionActivity.class);
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
    private int getDrawableImage(){
        switch (questionIndex){
            case 0:
                return R.drawable.p1;
            case 1:
                return R.drawable.p2;
            case 2:
                return R.drawable.p3;
            case 3:
                return R.drawable.p4;
            case 4:
                return R.drawable.p5;
            case 5:
                return R.drawable.p6;
            case 6:
                return R.drawable.p7;
            case 7:
                return R.drawable.p8;
            case 8:
                return R.drawable.p9;
            case 9:
                return R.drawable.p10;
            default:
                return R.drawable.ic_bg_pink;
        }
    }
}
