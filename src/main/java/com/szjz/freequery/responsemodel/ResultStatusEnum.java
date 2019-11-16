package com.szjz.freequery.responsemodel;
import lombok.Getter;

/**
 * 结果状态码
 */

@Getter
public enum ResultStatusEnum {
    success("OK", "操作成功"),
    fail("BUSINESS_FAIL", "操作失败"),
    gone("NOT_EXIST", "记录不存在"),
    ;


    /** 状态码 */
    private String code;
    private String msg;

    private ResultStatusEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
