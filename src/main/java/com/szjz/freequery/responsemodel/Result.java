package com.szjz.freequery.responsemodel;
import lombok.Data;
/**
 * 返回结果模型对象
 */
@Data
public class Result {


    private String code = ResultStatusEnum.success.getCode();

    /**
     * 消息
     */
    private String errorMsg;

    /**
     * 业务数据
     */
    private Object data;

    private Result() {
    }

    public Result(String code, String errorMsg) {
        this.code = code;
        this.errorMsg = errorMsg;
    }

    public Result(String code, String errorMsg, Object data) {
        this.code = code;
        this.errorMsg = errorMsg;
        this.data = data;
    }

    public static Result build(ResultStatusEnum codeEnum, String errorMsg) {
        return new Result(codeEnum.getCode(),errorMsg);
    }

    public static Result build( ResultStatusEnum codeEnum) {
        return new Result(codeEnum.getCode(),codeEnum.getMsg());
    }

    public static Result build(Object data, ResultStatusEnum codeEnum) {
        return new Result(codeEnum.getCode(),codeEnum.getMsg(),data);
    }


    /**
     * 操作成功
     */
    public static Result success() {
        return Result.build(ResultStatusEnum.success);
    }

    /**
     * 操作成功
     */
    public static Result success(Object data) {
        return Result.build(data, ResultStatusEnum.success);
    }

    /**
     * 操作失败
     */
    public static Result fail() {
        return Result.build(ResultStatusEnum.fail);
    }

    /**
     * 操作失败
     */
    public static Result fail(String errorMsg) {
        return Result.build(ResultStatusEnum.fail, errorMsg);
    }


}
