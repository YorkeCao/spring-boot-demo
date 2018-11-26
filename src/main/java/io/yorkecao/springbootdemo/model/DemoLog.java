package io.yorkecao.springbootdemo.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Date;

/**
 * @author Yorke
 */
@Getter
@Setter
public class DemoLog {

    /**
     * 请求 IP
     */
    private String ip;
    /**
     * 请求时间
     */
    private Date time;
    /**
     * 方法名
     */
    private String methodName;
    /**
     * 接口名
     */
    private String interfaceName;
    /**
     * 方法参数
     */
    private Object[] params;
    /**
     * 描述
     */
    private String description;
    /**
     * 结果类型
     */
    private boolean type;
    /**
     * 执行结果
     */
    private Object result;

    @Override
    public String toString() {
        return "DemoLog{" +
                "ip='" + ip + '\'' +
                ", time=" + time +
                ", methodName='" + methodName + '\'' +
                ", interfaceName='" + interfaceName + '\'' +
                ", params=" + Arrays.toString(params) +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", result=" + result +
                '}';
    }
}
