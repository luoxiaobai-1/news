package com.me.article.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heima.model.common.article.dtos.ArticleHomeDto;
import com.heima.model.common.article.pojos.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.lang.reflect.Type;
import java.util.List;

/**
* @author 14574
* @description 针对表【ap_article(文章信息表，存储已发布的文章)】的数据库操作Mapper
* @createDate 2023-09-20 22:15:56
* @Entity com.heima.model.common.article.pojos.Article
*/@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
    public List<Article> loadArticleList(@Param("dto") ArticleHomeDto dto,@Param("type") short type);

}




