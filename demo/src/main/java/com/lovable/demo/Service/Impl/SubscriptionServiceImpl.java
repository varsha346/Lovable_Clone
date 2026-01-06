package com.lovable.demo.Service.Impl;

import com.lovable.demo.Dto.Subscription.CheckoutRequest;
import com.lovable.demo.Dto.Subscription.CheckoutResponse;
import com.lovable.demo.Dto.Subscription.PortalResponse;
import com.lovable.demo.Dto.Subscription.SubscriptionResponse;
import com.lovable.demo.Service.SubscriptionService;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Override
    public SubscriptionResponse getCurrentSubscription(Long userId) {
        return null;
    }

    @Override
    public CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request, Long userId) {
        return null;
    }

    @Override
    public PortalResponse openCustomerPortal(Long userId) {
        return null;
    }
}
