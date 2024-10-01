package com.example.survey.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.survey.model.SurveyForm;
import com.example.survey.model.SurveyRepository;

@Service
public class SurveyService {
    @Autowired
    private SurveyRepository surveyRepository;

    public List<SurveyForm> findAll() {
        return this.surveyRepository.findAll();
    }

    @Transactional
    public Long save(SurveyForm entity) {
        surveyRepository.save(entity);

        return entity.getId();
    }
}
