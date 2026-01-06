package com.lovable.demo.Service.Impl;

import com.lovable.demo.Dto.Subscription.PlanResponse;
import com.lovable.demo.Service.PlanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {
    @Override
    public List<PlanResponse> getAllActivePlans() {
        return List.of();
    }
}
