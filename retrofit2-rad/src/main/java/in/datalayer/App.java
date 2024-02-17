package in.datalayer;

import org.bson.Document;
import retrofit2.Call;
import retrofit2.Response;
import in.datalayer.sample1.Controller;
import in.datalayer.sample2.ListWrapper;
import in.datalayer.sample2.Question;
import in.datalayer.sample2.StackOverflowAPI;
import in.datalayer.sample2.StackOverflowService;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class App {
    public static void main(String[] args) throws Exception {
        Controller controller = new Controller();
        controller.start();

        StackOverflowAPI api = StackOverflowService.getStackOverflowAPI();
        Call<ListWrapper<Question>> questions = api.getQuestions();
        try {
            Response<ListWrapper<Question>> execute = questions.execute();
            ListWrapper<Question> body = execute.body();
            List<Question> items = body.items;
            for (Question question : items) {
                System.out.println("title: " + question.title);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}