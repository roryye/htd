package cn.bunz.htd.service.Impl;

import cn.bunz.htd.repository.UserRepository;
import cn.bunz.htd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String equalNameAndPassword(String userName) {
        return userRepository.findUserPasswordByUserName(userName);
    }
}
