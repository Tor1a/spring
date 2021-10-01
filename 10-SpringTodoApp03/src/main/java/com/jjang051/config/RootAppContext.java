package com.jjang051.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//프로젝트에 사용할 bean정의

@Configuration
@ComponentScan("com.jjang051.model")
public class RootAppContext {

}
