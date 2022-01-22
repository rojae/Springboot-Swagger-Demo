package kr.swagger.demo.api;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.swagger.demo.model.User;
import kr.swagger.demo.user.UserEntity;
import kr.swagger.demo.user.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    private final UserService userService;

    @ApiOperation(value = "사용자 전체조회", notes = "사용자 전체조회")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK !!"),
            @ApiResponse(code = 400, message = "BAD REQUEST !!"),
            @ApiResponse(code = 404, message = "NOT FOUND !!"),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR !!")
    })
    @GetMapping("/users")
    public ResponseEntity<?> users() {
        List<UserEntity> userEntities = userService.getAll();
        return new ResponseEntity<>(userEntities, HttpStatus.OK);
    }

    @ApiOperation(value = "사용자 단일", notes = "사용자 단일")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK !!"),
            @ApiResponse(code = 400, message = "BAD REQUEST !!"),
            @ApiResponse(code = 404, message = "NOT FOUND !!"),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR !!")
    })
    @GetMapping("/user")
    public ResponseEntity<?> userOne(User.Request userName) {
        logger.info(userName.toString());
        UserEntity selectedUser = userService.getOneByName(userName);
        return new ResponseEntity<>(selectedUser, HttpStatus.OK);
    }


}
