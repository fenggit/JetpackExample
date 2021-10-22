package com.example.hilt.dagger;

import com.example.hilt.HiltActivity;

import dagger.Component;

/**
 * IOC，容器，将对象指定到目标位
 */
@Component
public interface ApplicationComponent {

    void inject(HiltActivity activity);
}
