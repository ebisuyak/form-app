package com.example.survey.controller;

import com.example.survey.model.SurveyForm;
import com.example.survey.service.SurveyService;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/survey")
public class SurveyController {
    @Autowired
    private SurveyService surveyService;

    @GetMapping("/input")
    public String showInputForm(Model model) {
        model.addAttribute("surveyForm", new SurveyForm());
        return "input";
    }

    @PostMapping("/completion")
    public String showCompletion(Model model, SurveyForm surveyForm) {
        surveyForm.setCreateDateTime(LocalDateTime.now());
        surveyService.save(surveyForm);

        return "completion";
    }

    @GetMapping("/list")
    public String listSurveys(Model model) {
        model.addAttribute("surveys", surveyService.findAll());
        return "list";
    }
}
