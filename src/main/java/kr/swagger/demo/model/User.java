package kr.swagger.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class User {

    @Getter
    @AllArgsConstructor
    public static class Info{
        private final long id;
        private final String name;
    }

    @Getter
    @Setter
    @ToString
    public static class Request{
        private String name;
    }

    @Getter
    @AllArgsConstructor
    public static class Response{
        private final User.Info info;
        private final int responseCode;
        private final String responseMessage;
    }
}
