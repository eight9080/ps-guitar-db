package com.guitar.db.security;

import com.guitar.db.model.User;
import org.springframework.data.domain.AuditorAware;

public class SecurityAuditorAware implements AuditorAware<User>{
    @Override
    public User getCurrentAuditor() {
        return new User(1L, "TheUser");
    }
}
