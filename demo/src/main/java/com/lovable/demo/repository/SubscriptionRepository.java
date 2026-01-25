package com.lovable.demo.repository;

import com.lovable.demo.entity.Subscription;
import com.lovable.demo.enums.SubscriptionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;
@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription,Long> {
    Optional<Subscription> findByUserIdAndStatusIn(Long userId, Set<SubscriptionStatus> statusSet);

    boolean existsByRazorSubscriptionId(String subscriptionId);

    Optional<Subscription> findByRazorSubscriptionId(String gatewaySubscriptionId);

}

