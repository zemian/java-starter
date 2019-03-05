package com.zemian.hellojava.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import java.util.HashMap;
import java.util.Map;

/**
 * A spring component to initialize webapp context
 */
@Component
public class WebInit {
    @Autowired
    private ServletContext ctx;

    @Autowired
    private Environment env;

    @PostConstruct
    public void init() {
        Map<String, Object> config = new HashMap<>();
        config.put("app.env", env.getProperty("app.env"));
        config.put("app.web.name", env.getProperty("app.web.name"));
        config.put("app.web.htmlTitle", env.getProperty("app.web.htmlTitle"));

        // Setup global context app variables for easy access in view layer.
        Map<String, Object> app = new HashMap<>();
        app.put("contextPath", ctx.getContextPath());
        app.put("config", config);
        ctx.setAttribute("app", app);
    }
}
