package entity;

import java.io.Serializable;

/**
 * 状态码实体类
 *
 * @ Author        :  huqingsong
 * @ CreateDate    :  2019-09-12 9:46
 */
public class StatusCode implements Serializable {
    /**
     * 成功
     */
    public static final int OK = 20000;
    /**
     * 失败
     */
    public static final int ERROR = 20001;
    /**
     * 用户名或密码错误
     */
    public static final int LOGINERROR = 2002;
    /**
     * 权限不足
     */
    public static final int ACCESSERROR = 20003;
    /**
     * 远程调用失败
     */
    public static final int REMOTEERROR = 20004;
    /**
     * 重复操作
     */
    public static final int REPERROR = 20005;
}
