package com.lovable.demo.Service;

import com.lovable.demo.Dto.Subscription.CheckoutRequest;
import com.lovable.demo.Dto.Subscription.CheckoutResponse;
import com.lovable.demo.Dto.Subscription.PortalResponse;
import com.lovable.demo.Dto.Subscription.SubscriptionResponse;

public interface SubscriptionService {
    SubscriptionResponse getCurrentSubscription(Long userId);

    CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request, Long userId);

    PortalResponse openCustomerPortal(Long userId);
}

