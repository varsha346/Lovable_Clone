package com.lovable.demo.Service;

import com.lovable.demo.Dto.Subscription.PlanResponse;

import java.util.List;

public interface PlanService {

    List<PlanResponse> getAllActivePlans();
}
