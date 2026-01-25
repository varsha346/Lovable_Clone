package com.lovable.demo.Service;

import com.lovable.demo.Dto.Subscription.CheckoutRequest;
import com.lovable.demo.Dto.Subscription.CheckoutResponse;
import com.lovable.demo.Dto.Subscription.PortalResponse;
import com.lovable.demo.Dto.Subscription.SubscriptionResponse;
import com.lovable.demo.enums.SubscriptionStatus;

import java.time.Instant;

public interface SubscriptionService {
    SubscriptionResponse getCurrentSubscription();

    void activateSubscription(Long userId, Long planId, String subscriptionId, String customerId);

    void updateSubscription(String gatewaySubscriptionId, SubscriptionStatus status, Instant periodStart, Instant periodEnd, Boolean cancelAtPeriodEnd, Long planId);

    void cancelSubscription(String gatewaySubscriptionId);

    void renewSubscriptionPeriod(String subId, Instant periodStart, Instant periodEnd);

    void markSubscriptionPastDue(String subId);

    boolean canCreateNewProject();
}

