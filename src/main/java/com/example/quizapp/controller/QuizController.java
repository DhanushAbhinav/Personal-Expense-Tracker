package.com.example.quizapp.controller;

import com.example.quizapp.model.User;
import com.example.quizapp.service.QuizService;

import org.springframework.web.bind.annotation.RequestHeader;
import com.example.quizapp.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController 
@RequestMapping("/api/quiz")
public class QuizController {
    private final QuizService quizService;
    private final UserService userService;

    public QuizController (QuizService quizService, UserService userService) {
        this.quizService=quizService;
        this.userService=userService;
    }

    @PostMapping("/create")
    public String createQuiz(@RequestParam Long quizId, @RequestParam String title) {
        quizService.createQuiz(quizId, title);
        return "Quiz created";
    }

    @PostMapping("/assign")

    public String assignUserToQuiz(@RequestParam Long quizId, @RequestParam Long userId) {
        User user = userService.getUser(userId);
        quizService.assignUserToQuiz(quizId, user);
        return "User assigned to quiz";
    }

    @PostMapping("/attempt")
    public String attemptQuiz(@RequestParam Long quizId, @RequestParam Long userId) {

        User user = userService.getUser(userId);
        try {
            quizService.attemptQuiz(quizId, user);
            return "quiz attempted";
        } catch (Exception e) {
            return e.getMessage();
        }
    }


}
