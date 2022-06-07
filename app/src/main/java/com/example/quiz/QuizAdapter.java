package com.example.quiz;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.QuizViewHolder> {

    private final ArrayList<Quiz> quizArrayList;
    private final Context context;

    public QuizAdapter(@NonNull ArrayList<Quiz> quizArrayList, Context context) {
        super();

        this.quizArrayList = quizArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public QuizViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quiz_layout, parent, false);

        return new QuizViewHolder(view);
    }

    public class QuizViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener {

        private final TextView tv_start_time;
        private final TextView tv_end_time;
        private final TextView correctAnswers;
        private final TextView incorrectAnswers;

        public QuizViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_start_time = itemView.findViewById(R.id.tv_start_time);
            tv_end_time = itemView.findViewById(R.id.tv_end_time);
            correctAnswers = itemView.findViewById(R.id.correctAnswers);
            incorrectAnswers = itemView.findViewById(R.id.incorrectAnswers);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v == itemView){
                ArrayList<Question> questionArrayList = quizArrayList.get(getAdapterPosition()).getQuestions();

                Intent intent = new Intent(context, SeeQuestionsActivity.class);
                intent.putParcelableArrayListExtra("questions", questionArrayList);

                context.startActivity(intent);
            }
        }
    }

    @Override
    public void onBindViewHolder(@NonNull QuizViewHolder holder, int position) {
        Quiz quiz = quizArrayList.get(position);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        String startTime = simpleDateFormat.format(new Date(-quiz.getStartTime()));
        String endTime = simpleDateFormat.format(new Date(quiz.getEndTime()));

        holder.tv_start_time.setText("Started at " + startTime);
        holder.tv_end_time.setText("Ended at " + endTime);
        holder.correctAnswers.setText("Correct Answers: " + quiz.getCorrectAnswers());
        holder.incorrectAnswers.setText("Wrong Answers: " + quiz.getInCorrectAnswers());
    }

    @Override
    public int getItemCount() {
        return quizArrayList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
