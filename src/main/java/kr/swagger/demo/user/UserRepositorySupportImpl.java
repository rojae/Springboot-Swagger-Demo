package kr.swagger.demo.user;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositorySupportImpl implements UserRepositorySupport{

    @Autowired
    JPAQueryFactory query;

    @Override
    public UserEntity findByName(String name) {
        return query.selectFrom(QUser.user).where(QUser.user.name.eq(name)).fetchOne();
    }

}
