package org.features.authorization;
import org.features.Account;

import java.util.Arrays;
import java.util.List;

public class AuthorizationResult {
    private final Account account;
    private final List<String> violations;

    public AuthorizationResult(Account account, String... violations) {
        this.account = account;
        this.violations = Arrays.asList(violations);
    }

    // Getters
    public Account getAccount() {
        return account;
    }

    public List<String> getViolations() {
        return violations;
    }
}

