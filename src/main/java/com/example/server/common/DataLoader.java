package com.example.server.common;

import com.example.server.entity.Answer;
import com.example.server.entity.Test;
import com.example.server.entity.Variant;
import com.example.server.pojo.AnswersItem;
import com.example.server.pojo.Response;
import com.example.server.pojo.ResponseItem;
import com.example.server.pojo.TestsItem;
import com.example.server.repository.AnswerRepository;
import com.example.server.repository.TestRepository;
import com.example.server.repository.VariantRepository;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileReader;

/**
 * @author Murtazayev Muhammad
 * @since 25.12.2021
 */
@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final VariantRepository variantRepository;
    private final TestRepository testRepository;
    private final AnswerRepository answerRepository;

    @Override
    public void run(String... args) throws Exception {
        Gson gson = new Gson();

        Response response = gson.fromJson(new FileReader("C:\\Muhammad\\Projects\\edit-test\\server\\src\\main\\resources\\variant-ru.json"), Response.class);

        for (ResponseItem item : response.getItems()) {
            Variant variant = variantRepository.save(new Variant(item.getId(), "RU"));
            for (TestsItem testItem : item.getTests()) {
                Test test = testRepository.save(new Test(
                        testItem.getText(),
                        testItem.getType(),
                        testItem.getTypeimage(),
                        testItem.getId(),
                        variant));
                for (AnswersItem answersItem : testItem.getAnswers()) {
                    answerRepository.save(new Answer(
                            answersItem.getText(),
                            answersItem.getId(),
                            answersItem.isTrue(),
                            test
                    ));
                }
            }
        }
        response = gson.fromJson(new FileReader("C:\\Muhammad\\Projects\\edit-test\\server\\src\\main\\resources\\variant-oz.json"), Response.class);

        for (ResponseItem item : response.getItems()) {
            Variant variant = variantRepository.save(new Variant(item.getId(), "OZ"));
            for (TestsItem testItem : item.getTests()) {
                Test test = testRepository.save(new Test(
                        testItem.getText(),
                        testItem.getType(),
                        testItem.getTypeimage(),
                        testItem.getId(),
                        variant));
                for (AnswersItem answersItem : testItem.getAnswers()) {
                    answerRepository.save(new Answer(
                            answersItem.getText(),
                            answersItem.getId(),
                            answersItem.isTrue(),
                            test
                    ));
                }
            }
        }
        response = gson.fromJson(new FileReader("C:\\Muhammad\\Projects\\edit-test\\server\\src\\main\\resources\\variant-uz.json"), Response.class);

        for (ResponseItem item : response.getItems()) {
            Variant variant = variantRepository.save(new Variant(item.getId(), "UZ"));
            for (TestsItem testItem : item.getTests()) {
                Test test = testRepository.save(new Test(
                        testItem.getText(),
                        testItem.getType(),
                        testItem.getTypeimage(),
                        testItem.getId(),
                        variant));
                for (AnswersItem answersItem : testItem.getAnswers()) {
                    answerRepository.save(new Answer(
                            answersItem.getText(),
                            answersItem.getId(),
                            answersItem.isTrue(),
                            test
                    ));
                }
            }
        }
    }
}
