package com.example.hilt.inject

import javax.inject.Inject

class UserInfo(var name: String, var age: Int) {

    @Inject
    constructor() : this("张三", 24)
}

