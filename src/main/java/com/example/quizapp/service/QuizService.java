package com.example.quizapp.service;

import com.example.quizapp.model.Quiz;
import com.example.quizapp.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class QuizService {
    private Map<Long, Quiz> quizzes = new HashMap<>();

    public Quiz createQuiz(Long quizId, String title) {
        Quiz quiz = new Quiz(quizId, title);
        quizzes.put(quizId, quiz);
        return quiz;
    }

    public void assignUserToQuiz(Long quizId, User user) {
        Quiz quiz = quizzes.get(quizId);
        if (quiz != null) {
            quiz.assignUser(user);
        }
    }

    public boolean canAttemptQuiz(Long quizId, User user) {
        Quiz quiz = quizzes.get(quizId);
        if (quiz != null && quiz.getAssignedUsers().contains(user)) {
            return true;
        } else {
            return false;
        }
    }

    public void attemptQuiz(Long quizId, User user) {
        if (canAttemptQuiz(quizId, user)) {
            user.incrementAttempts(quizId);
        } else {
            throw new RuntimeException("Max attempts has reached");
        }
    }
}
