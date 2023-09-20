package com.me.article.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.model.common.article.dtos.ArticleHomeDto;
import com.heima.model.common.article.pojos.Article;
import com.heima.model.common.dtos.ResponseResult;

/**
* @author 14574
* @description 针对表【ap_article(文章信息表，存储已发布的文章)】的数据库操作Service
* @createDate 2023-09-20 22:15:56
*/
public interface ArticleService extends IService<Article> {

    ResponseResult load(Short type, ArticleHomeDto dto);
}
