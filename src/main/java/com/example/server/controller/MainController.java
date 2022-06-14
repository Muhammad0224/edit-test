package com.example.server.controller;

import com.example.server.entity.Answer;
import com.example.server.entity.Test;
import com.example.server.entity.Variant;
import com.example.server.payload.TestDto;
import com.example.server.payload.UpdateTestDto;
import com.example.server.repository.AnswerRepository;
import com.example.server.repository.TestRepository;
import com.example.server.repository.VariantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class MainController {
    private final VariantRepository variantRepository;
    private final TestRepository testRepository;
    private final AnswerRepository answerRepository;

    @GetMapping("/variant/{lang}")
    private List<Variant> getVariants(@PathVariable String lang) {
        return variantRepository.findAllByLang(lang);
    }

    @GetMapping("/test/variant/{id}")
    private List<TestDto> getTests(@PathVariable Integer id) {
        Optional<Variant> optionalVariant = variantRepository.findById(id);
        if (!optionalVariant.isPresent())
            return null;

        List<Test> tests = testRepository.findAllByVariantIdOrderByTestNumber(id);
        List<TestDto> res = new ArrayList<>();

        for (Test test : tests) {
            res.add(new TestDto(test.getId(), test.getText(), test.getTestNumber(), test.getVariant(),
                    test.getDescription(), answerRepository.findAllByTestIdOrderByAnswerNumber(test.getId())));
        }
        return res;
    }

    @GetMapping("/test/{id}")
    private Test getTest(@PathVariable Integer id) {
        Optional<Test> optionalTest = testRepository.findById(id);
        if (!optionalTest.isPresent())
            return null;
        return optionalTest.get();
    }

    @PostMapping("/test/update")
    private Test updateTest(@RequestBody UpdateTestDto dto) {
        Optional<Test> optionalTest = testRepository.findById(dto.getId());
        if (!optionalTest.isPresent())
            return null;
        Test test = optionalTest.get();
        test.setText(dto.getText());
        test.setDescription(dto.getDescription());

        for (Answer dtoAnswer : dto.getAnswers()) {
            Optional<Answer> optionalAnswer = answerRepository.findById(dtoAnswer.getId());
            if (optionalAnswer.isPresent()) {
                Answer answer = optionalAnswer.get();
                answer.setText(dtoAnswer.getText());
                answer.setTrue(dtoAnswer.isTrue());
                answerRepository.save(answer);
            }
        }

        testRepository.save(test);
        return test;
    }
}
