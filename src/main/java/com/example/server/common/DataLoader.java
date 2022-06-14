package com.example.server.common;

import com.example.server.entity.*;
import com.example.server.pojo.AnswersItem;
import com.example.server.pojo.Response;
import com.example.server.pojo.ResponseItem;
import com.example.server.pojo.TestsItem;
import com.example.server.repository.*;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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

//    private final AnswersRepository answersRepository;
//    private final QuestionRepository questionRepository;

    @Value("${spring.sql.init.mode}")
    private String initMode;

    @Override
    public void run(String... args) throws Exception {

        Gson gson = new Gson();
        if (initMode.equals("always")) {

//            Response response = gson.fromJson(new FileReader("C:\\Muhammad\\Projects\\edit-test\\server\\src\\main\\resources\\variant-uz.json"), Response.class);
////
////            for (ResponseItem item : response.getItems()) {
////                Variant variant = variantRepository.save(new Variant(item.getId(), "RU"));
////                for (TestsItem testItem : item.getTests()) {
////                    Test test = testRepository.save(new Test(
////                            testItem.getText(),
////                            testItem.getType(),
////                            testItem.getTypeimage(),
////                            testItem.getId(),
////                            variant));
////                    for (AnswersItem answersItem : testItem.getAnswers()) {
////                        answerRepository.save(new Answer(
////                                answersItem.getText(),
////                                answersItem.getId(),
////                                answersItem.isTrue(),
////                                test
////                        ));
////                    }
////                }
////            }
//
//            Response responseOZ = gson.fromJson(new FileReader("C:\\Muhammad\\Projects\\edit-test\\server\\src\\main\\resources\\variant-oz.json"), Response.class);
//            Response responseRU = gson.fromJson(new FileReader("C:\\Muhammad\\Projects\\edit-test\\server\\src\\main\\resources\\variant-ru.json"), Response.class);
//// todo saqlash uchun
//            for (ResponseItem item : response.getItems()) {
//                ResponseItem itemOZ = responseOZ.getItems().stream().filter(responseItem -> responseItem.getId() == item.getId()).findAny().get();
//                ResponseItem itemRU = responseRU.getItems().stream().filter(responseItem -> responseItem.getId() == item.getId()).findAny().get();
//
//                for (TestsItem test : item.getTests()) {
//                    TestsItem testOZ = itemOZ.getTests().stream().filter(testsItem -> testsItem.getId() == test.getId()).findAny().get();
//                    TestsItem testRU = itemRU.getTests().stream().filter(testsItem -> testsItem.getId() == test.getId()).findAny().get();
//
//                    Question question = questionRepository.save(new Question(
//                            test.getText(),
//                            testOZ.getText(),
//                            testRU.getText(),
//                            test.getType(),
//                            test.getTypeimage(),
//                            item.getId(),
//                            test.getId()
//                    ));
//
//                    for (AnswersItem answersItem : test.getAnswers()) {
//                        answersRepository.save(new Answers(
//                                answersItem.getText(),
//                                question,
//                                1,
//                                answersItem.isTrue() ? 1:0
//                                ));
//                    }
//
//                    for (AnswersItem answersItem : testOZ.getAnswers()) {
//                        answersRepository.save(new Answers(
//                                answersItem.getText(),
//                                question,
//                                2,
//                                answersItem.isTrue() ? 1:0
//                        ));
//                    }
//
//                    for (AnswersItem answersItem : testRU.getAnswers()) {
//                        answersRepository.save(new Answers(
//                                answersItem.getText(),
//                                question,
//                                3,
//                                answersItem.isTrue() ? 1:0
//                        ));
//                    }
//                }
//            }
//
//
////            response = gson.fromJson(new FileReader("C:\\Muhammad\\Projects\\edit-test\\server\\src\\main\\resources\\variant-oz.json"), Response.class);
////
////            for (ResponseItem item : response.getItems()) {
////                Variant variant = variantRepository.save(new Variant(item.getId(), "OZ"));
////                for (TestsItem testItem : item.getTests()) {
////                    Test test = testRepository.save(new Test(
////                            testItem.getText(),
////                            testItem.getType(),
////                            testItem.getTypeimage(),
////                            testItem.getId(),
////                            variant));
////                    for (AnswersItem answersItem : testItem.getAnswers()) {
////                        answerRepository.save(new Answer(
////                                answersItem.getText(),
////                                answersItem.getId(),
////                                answersItem.isTrue(),
////                                test
////                        ));
////                    }
////                }
////            }
////            response = gson.fromJson(new FileReader("C:\\Muhammad\\Projects\\edit-test\\server\\src\\main\\resources\\variant-uz.json"), Response.class);
////
////            for (ResponseItem item : response.getItems()) {
////                Variant variant = variantRepository.save(new Variant(item.getId(), "UZ"));
////                for (TestsItem testItem : item.getTests()) {
////                    Test test = testRepository.save(new Test(
////                            testItem.getText(),
////                            testItem.getType(),
////                            testItem.getTypeimage(),
////                            testItem.getId(),
////                            variant));
////                    for (AnswersItem answersItem : testItem.getAnswers()) {
////                        answerRepository.save(new Answer(
////                                answersItem.getText(),
////                                answersItem.getId(),
////                                answersItem.isTrue(),
////                                test
////                        ));
////                    }
////                }
////            }
//        } else {
////            List<Variant> variantUZ = variantRepository.findAllByLang("UZ");
////            File fileUz = new File("C:\\Muhammad\\Projects\\edit-test\\server\\src\\main\\resources\\variant-uz.json");
////
////            List<Variant> variantOZ = variantRepository.findAllByLang("OZ");
////            File fileOz = new File("C:\\Muhammad\\Projects\\edit-test\\server\\src\\main\\resources\\variant-oz.json");
////
////            List<Variant> variantRU = variantRepository.findAllByLang("RU");
////            File fileRu = new File("C:\\Muhammad\\Projects\\edit-test\\server\\src\\main\\resources\\variant-ru.json");
////
////            Response responseUZ = new Response();
////            List<ResponseItem> responseItemsUZ = new ArrayList<>();
////
////            for (Variant variant : variantUZ) {
////                ResponseItem responseItem = new ResponseItem();
////                responseItem.setId(variant.getVariantNumber());
////
////                List<TestsItem> testsItems = new ArrayList<>();
////
////                List<Test> tests = testRepository.findAllByVariantIdOrderByTestNumber(variant.getId());
////                for (Test test : tests) {
////                    TestsItem testsItem = new TestsItem();
////                    testsItem.setId(test.getTestNumber());
////                    testsItem.setText(test.getText());
////                    testsItem.setType(test.getType());
////                    testsItem.setTypeimage(test.getTypeImage());
////
////                    List<AnswersItem> answersItems = new ArrayList<>();
////
////                    List<Answer> answers = answerRepository.findAllByTestIdOrderByAnswerNumber(test.getId());
////                    for (Answer answer : answers) {
////                        AnswersItem answersItem = new AnswersItem();
////                        answersItem.setId(answer.getAnswerNumber());
////                        answersItem.setText(answer.getText());
////                        answersItem.setTrue(answer.isTrue());
////
////                        answersItems.add(answersItem);
////                    }
////
////                    testsItem.setAnswers(answersItems);
////                    testsItems.add(testsItem);
////                }
////
////                responseItem.setTests(testsItems);
////                responseItemsUZ.add(responseItem);
////            }
////            responseUZ.setItems(responseItemsUZ);
////            FileWriter writer = new FileWriter(fileUz);
////            writer.write(gson.toJson(responseUZ));
////            writer.flush();
////            writer.close();
////
////            Response responseOZ = new Response();
////            List<ResponseItem> responseItemsOZ = new ArrayList<>();
////
////            for (Variant variant : variantOZ) {
////                ResponseItem responseItem = new ResponseItem();
////                responseItem.setId(variant.getVariantNumber());
////
////                List<TestsItem> testsItems = new ArrayList<>();
////
////                List<Test> tests = testRepository.findAllByVariantIdOrderByTestNumber(variant.getId());
////                for (Test test : tests) {
////                    TestsItem testsItem = new TestsItem();
////                    testsItem.setId(test.getTestNumber());
////                    testsItem.setText(test.getText());
////                    testsItem.setType(test.getType());
////                    testsItem.setTypeimage(test.getTypeImage());
////
////                    List<AnswersItem> answersItems = new ArrayList<>();
////
////                    List<Answer> answers = answerRepository.findAllByTestIdOrderByAnswerNumber(test.getId());
////                    for (Answer answer : answers) {
////                        AnswersItem answersItem = new AnswersItem();
////                        answersItem.setId(answer.getAnswerNumber());
////                        answersItem.setText(answer.getText());
////                        answersItem.setTrue(answer.isTrue());
////
////                        answersItems.add(answersItem);
////                    }
////
////                    testsItem.setAnswers(answersItems);
////                    testsItems.add(testsItem);
////                }
////
////                responseItem.setTests(testsItems);
////                responseItemsOZ.add(responseItem);
////            }
////            responseOZ.setItems(responseItemsOZ);
////            writer = new FileWriter(fileOz);
////            writer.write(gson.toJson(responseOZ));
////            writer.flush();
////            writer.close();
////
////
////            Response responseRU = new Response();
////            List<ResponseItem> responseItemsRU = new ArrayList<>();
////
////            for (Variant variant : variantRU) {
////                ResponseItem responseItem = new ResponseItem();
////                responseItem.setId(variant.getVariantNumber());
////
////                List<TestsItem> testsItems = new ArrayList<>();
////
////                List<Test> tests = testRepository.findAllByVariantIdOrderByTestNumber(variant.getId());
////                for (Test test : tests) {
////                    TestsItem testsItem = new TestsItem();
////                    testsItem.setId(test.getTestNumber());
////                    testsItem.setText(test.getText());
////                    testsItem.setType(test.getType());
////                    testsItem.setTypeimage(test.getTypeImage());
////
////                    List<AnswersItem> answersItems = new ArrayList<>();
////
////                    List<Answer> answers = answerRepository.findAllByTestIdOrderByAnswerNumber(test.getId());
////                    for (Answer answer : answers) {
////                        AnswersItem answersItem = new AnswersItem();
////                        answersItem.setId(answer.getAnswerNumber());
////                        answersItem.setText(answer.getText());
////                        answersItem.setTrue(answer.isTrue());
////
////                        answersItems.add(answersItem);
////                    }
////
////                    testsItem.setAnswers(answersItems);
////                    testsItems.add(testsItem);
////                }
////
////                responseItem.setTests(testsItems);
////                responseItemsRU.add(responseItem);
////            }
////            responseRU.setItems(responseItemsRU);
////            writer = new FileWriter(fileRu);
////            writer.write(gson.toJson(responseRU));
////            writer.flush();
////            writer.close();
////
        }
    }

}
