package com.lzq.dispose_exception.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lzq
 * @version 1.0
 * @date 2020/12/22 10:17
 */
@Data
public class RangeVo implements Serializable {
    private static final long serialVersionUID = -6743567631108323096L;
    private Integer productId;
    private String productName;
    private Double score;
}
