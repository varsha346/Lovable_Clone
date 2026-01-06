package com.lovable.demo.Dto.Subscription;

public record PlanLimitsResponse(
        String planName,
        Integer maxTokenPerDay,
        Integer maxProjects,
        Boolean unlimited
){
}
