package kr.swagger.demo.user;

import kr.swagger.demo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserEntity> getAll(){
        return userRepository.findAll();
    }

    public UserEntity getOneByName(User.Request request) {
        return userRepository.findByName(request.getName());
    }
}
