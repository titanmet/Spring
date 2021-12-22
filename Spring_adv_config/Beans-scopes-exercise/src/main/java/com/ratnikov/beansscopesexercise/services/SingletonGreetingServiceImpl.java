package com.ratnikov.beansscopesexercise.services;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("SingletonGreetingService")
public class SingletonGreetingServiceImpl extends AbstractGreetingServiceImpl {
}
