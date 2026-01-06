package com.lovable.demo.Service.Impl;

import com.lovable.demo.Dto.Subscription.PlanLimitsResponse;
import com.lovable.demo.Dto.Subscription.UsageTodayResponse;
import com.lovable.demo.Service.UsageService;
import org.springframework.stereotype.Service;

@Service
public class UsageServiceImpl implements UsageService {
    @Override
    public UsageTodayResponse getTodayUsageOfUser(Long userId) {
        return null;
    }

    @Override
    public PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId) {
        return null;
    }
}
