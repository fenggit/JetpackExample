package com.example.hilt.dagger;

import com.example.hilt.MainActivity;

import dagger.Component;

/**
 * IOC，容器，将对象指定到目标位
 */
@Component
public interface ApplicationComponent {

    void inject(MainActivity activity);
}
