package com.heima.model.common.article.dtos;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class ArticleHomeDto {
@NotNull(message = "时间不能为空")
    // 最大时间
    Date maxBehotTime;
    // 最小时间
    @NotNull(message = "时间不能为空")
    Date minBehotTime;
    // 分页size
    @NotNull(message = "size 不能为空")
    Integer size;
    // 频道ID
    @NotEmpty(message = "tag 不能为空")
    String tag;
}