package com.lovable.demo.entity;
import com.lovable.demo.enums.SubscriptionStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.Id;

import java.time.Instant;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Subscription{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(nullable = false,name = "user_id")
    User user;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(nullable = false,name = "plan_id")
    Plan plan;

   @Enumerated(value = EnumType.STRING)
    SubscriptionStatus status;

    String RazorCustomerId;

    String RazorSubscriptionId;

    Instant currentPeriodStart;

    Instant currentPeriodEnd;

    Boolean cancelAtPeriodEnd = false;


    @CreationTimestamp
    Instant createdAt;

    @UpdateTimestamp
    Instant updatedAt;

}
