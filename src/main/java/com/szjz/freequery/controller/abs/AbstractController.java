package com.szjz.freequery.controller.abs;


import com.szjz.freequery.responsemodel.Result;
import com.szjz.freequery.responsemodel.ResultStatusEnum;

/**
 * 抽象的控制类
 */
public abstract class AbstractController<T> {


    /**
     * 成功
     *
     * @return
     */
    protected Result success() {
        return Result.success();
    }

    protected Result success(Object data) {
        return Result.success(data);
    }

    /**
     * 操作失败
     *
     * @return
     */
    protected Result fail() {
        return Result.fail(ResultStatusEnum.fail.getMsg());
    }

    protected Result fail(String msg) {
        return Result.fail(msg);
    }

    public Result gone() {
        return Result.fail(ResultStatusEnum.gone.getMsg());
    }

}
