package com.example.survey.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "SURVEY")
@Data
public class SurveyForm {
    /** ID */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "survey_seq")
    @SequenceGenerator(name = "survey_seq", sequenceName = "survey_seq", allocationSize = 1)
    private Long id;

    @Column(name = "INPUT_NAME")
    private String name;

    @Column(name = "CONTACT")
    private String contact;

    @Column(name = "FEEDBACK", length = 1000)
    private String feedback;

    /** 作成日時 */
    @CreatedDate
    @Column(name = "CREATE_DATE_TIME")
    private LocalDateTime createDateTime;
}
