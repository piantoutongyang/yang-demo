package com.mingyisoft.springcloudalibaba.dubbo.service;

import com.mingyisoft.springcloudalibaba.dubbo.entity.User;

public interface YangService {
    String say(String name);
    User listen(User user);
}
