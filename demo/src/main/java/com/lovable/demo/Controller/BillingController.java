package com.lovable.demo.Controller;
import com.lovable.demo.Dto.Project.*;
import com.lovable.demo.Dto.Subscription.*;
import com.lovable.demo.Service.FileService;
import com.lovable.demo.Service.PlanService;
import com.lovable.demo.Service.ProjectService;
import com.lovable.demo.Service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BillingController {

    private final PlanService planService;
    private final SubscriptionService subscriptionService;

    @GetMapping("/api/plans")
    public ResponseEntity<List<PlanResponse>> getAllPlans() {
        return ResponseEntity.ok(planService.getAllActivePlans());
    }

    @GetMapping("/api/me/subscription")
    public ResponseEntity<SubscriptionResponse> getMySubscription() {
//        Long userId = 1L;
        return ResponseEntity.ok(subscriptionService.getCurrentSubscription());

    }
//
//    @PostMapping("/api/stripe/checkout")
//    public ResponseEntity<CheckoutResponse> createCheckoutResponse(
//            @RequestBody CheckoutRequest request
//    ) {
//        Long userId = 1L;
//        return ResponseEntity.ok(subscriptionService.createCheckoutSessionUrl(request, userId));
//    }
//
//    @PostMapping("/api/stripe/portal")
//    public ResponseEntity<PortalResponse> openCustomerPortal() {
//        Long userId = 1L;
//        return ResponseEntity.ok(subscriptionService.openCustomerPortal(userId));
//    }
}
