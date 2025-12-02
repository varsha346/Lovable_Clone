package com.lovable.demo.Service;

import com.lovable.demo.Dto.Subscription.PlanLimitsResponse;
import com.lovable.demo.Dto.Subscription.UsageTodayResponse;

public interface UsageService {
    UsageTodayResponse getTodayUsageOfUser(Long userId);

    PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId);
}
