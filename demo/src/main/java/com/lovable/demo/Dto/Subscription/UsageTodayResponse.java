package com.lovable.demo.Dto.Subscription;

public record UsageTodayResponse(
     Integer  tokensUsed,
     Integer tokensLimit,
     Integer previousRunning,
     Integer previewsLimit
) {
}
