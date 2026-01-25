package com.lovable.demo.mapper;

import com.lovable.demo.Dto.Subscription.PlanResponse;
import com.lovable.demo.Dto.Subscription.SubscriptionResponse;
import com.lovable.demo.entity.Plan;
import com.lovable.demo.entity.Subscription;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {
    SubscriptionResponse toSubscriptionResponse(Subscription subscription);

    PlanResponse toPlanResponse(Plan plan);
}
