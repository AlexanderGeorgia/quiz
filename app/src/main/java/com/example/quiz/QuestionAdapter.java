package com.example.quiz;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder> {

    private final ArrayList<Question> questionArrayList;

    public QuestionAdapter(@NonNull ArrayList<Question> questionArrayList) {
        super();

        this.questionArrayList = questionArrayList;
    }

    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_layout, parent, false);

        return new QuestionViewHolder(view);
    }




    public static class QuestionViewHolder extends RecyclerView.ViewHolder {

        private final TextView questions;
        private final TextView tv_question;
        private final AppCompatButton option1;
        private final AppCompatButton option2;
        private final AppCompatButton option3;
        private final AppCompatButton option4;

        public QuestionViewHolder(@NonNull View itemView) {
            super(itemView);

            questions = itemView.findViewById(R.id.questions);
            tv_question = itemView.findViewById(R.id.tv_question);
            option1 = itemView.findViewById(R.id.option1);
            option2 = itemView.findViewById(R.id.option2);
            option3 = itemView.findViewById(R.id.option3);
            option4 = itemView.findViewById(R.id.option4);

            itemView.setOnClickListener(v -> {});
        }
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {
        Question question = questionArrayList.get(position);
        Log.d("kora", question.toString());

        holder.questions.setText((position+1) + "/10");
        holder.tv_question.setText(question.getQuestion());
        holder.option1.setText(question.getOption1());
        holder.option2.setText(question.getOption2());
        holder.option3.setText(question.getOption3());
        holder.option4.setText(question.getOption4());

        if (question.getOption1().equals(question.getAnswer())){
            holder.option1.setBackgroundResource(R.drawable.round_back_red10);
            holder.option1.setTextColor(Color.WHITE);
        }
        if (question.getOption2().equals(question.getAnswer())){
            holder.option2.setBackgroundResource(R.drawable.round_back_red10);
            holder.option2.setTextColor(Color.WHITE);
        }
        if (question.getOption3().equals(question.getAnswer())){
            holder.option3.setBackgroundResource(R.drawable.round_back_red10);
            holder.option3.setTextColor(Color.WHITE);
        }
        if (question.getOption4().equals(question.getAnswer())){
            holder.option4.setBackgroundResource(R.drawable.round_back_red10);
            holder.option4.setTextColor(Color.WHITE);
        }

        if (question.getOption1().equals(question.getCorrectAnswer())){
            holder.option1.setBackgroundResource(R.drawable.round_back_green10);
            holder.option1.setTextColor(Color.WHITE);
        }
        if (question.getOption2().equals(question.getCorrectAnswer())){
            holder.option2.setBackgroundResource(R.drawable.round_back_green10);
            holder.option2.setTextColor(Color.WHITE);
        }
        if (question.getOption3().equals(question.getCorrectAnswer())){
            holder.option3.setBackgroundResource(R.drawable.round_back_green10);
            holder.option3.setTextColor(Color.WHITE);
        }
        if (question.getOption4().equals(question.getCorrectAnswer())){
            holder.option4.setBackgroundResource(R.drawable.round_back_green10);
            holder.option4.setTextColor(Color.WHITE);
        }

    }

    @Override
    public int getItemCount() {
        return questionArrayList.size();
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
