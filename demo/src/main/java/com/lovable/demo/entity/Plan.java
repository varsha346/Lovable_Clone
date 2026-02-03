package com.lovable.demo.entity;
import jakarta.persistence.Column;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @Column(unique = true)
    String razorPriceId;

    Integer maxProjects;
    Integer maxTokensPerDay;
    Integer maxPreviews;//maxi previews allowed to user
    Boolean unlimitedAi;//unlimited access to LLM ai

    Boolean active;

}
