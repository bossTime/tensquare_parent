package entity;

import java.io.Serializable;

/**
 * 公共参数
 *
 * @ Author        :  huqingsong
 * @ CreateDate    :  2019-09-12 9:33
 */
public class Result implements Serializable {

    /**
     * 是否成功
     */
    private boolean flag;

    /**
     * 返回码
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回数据
     */
    private Object date;

    /**
     * 满参
     *
     * @param flag
     * @param code
     * @param message
     * @param date
     */
    public Result(boolean flag, Integer code, String message, Object date) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.date = date;
    }

    /**
     * 增删改
     *
     * @param flag
     * @param code
     * @param message
     */
    public Result(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    public Result() {
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }
}
