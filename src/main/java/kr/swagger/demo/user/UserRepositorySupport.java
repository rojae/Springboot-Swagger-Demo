package kr.swagger.demo.user;

public interface UserRepositorySupport {
    UserEntity findByName(String name);
}
