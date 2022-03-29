package com.loljoa.server.web.api;

import com.loljoa.server.web.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountApi {
    private final AccountService accountService;
}
