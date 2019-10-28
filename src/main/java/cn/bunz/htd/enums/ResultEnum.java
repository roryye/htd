package cn.bunz.htd.enums;

public enum ResultEnum {
    Login_ERROR(201, "登陆失败");

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
