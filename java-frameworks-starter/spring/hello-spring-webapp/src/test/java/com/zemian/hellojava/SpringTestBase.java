package com.zemian.hellojava;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/*
A base class for running Spring Tests. We will load CommonConfig and override with `application-test.properties`
for testing purpose.

Subclass can add additional Spring config by using `@ContextConfiguration`
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CommonConfig.class)
@TestPropertySource("classpath:/hellojava/app-test.properties")
public abstract class SpringTestBase {
}
