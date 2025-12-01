package com.lovable.demo.entity;

import java.time.Instant;

public class Usage_Log {
    long id;
    User user;
    Project project;
    String action;
    Integer tokensUesd;
    String metaData;
    Instant createdAt;

}
