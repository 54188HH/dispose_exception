package com.lzq.dispose_exception.vo;

/**
 * @author lzq
 * @version 1.0
 * @date 2020/12/18 9:50
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResult implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final int RESULT_FAIL = 0;

    public static final int RESULT_SUCCESS = 1;

    //返回代码
    private Integer  code;

    //返回消息
    private String message;

    //返回对象
    private  Object data;

    public BaseResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
