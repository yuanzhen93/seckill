package com.gupao.user.starter.annotation;

import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface LoginUserId {
}
