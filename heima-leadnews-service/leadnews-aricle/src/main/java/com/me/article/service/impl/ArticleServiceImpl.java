package com.me.article.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.common.constants.ArticleConstants;
import com.heima.model.common.article.dtos.ArticleHomeDto;
import com.heima.model.common.article.pojos.Article;

import com.heima.model.common.dtos.ResponseResult;
import com.me.article.mapper.ArticleMapper;
import com.me.article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 14574
* @description 针对表【ap_article(文章信息表，存储已发布的文章)】的数据库操作Service实现
* @createDate 2023-09-20 22:15:56
*/
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>
    implements ArticleService {
    private  final  static short Max_Page_Size=50;
@Autowired
ArticleMapper articleMapper;
    @Override
    public ResponseResult load(Short type, ArticleHomeDto dto) {
        Integer size = dto.getSize();
        if (size==0)
        {
            size=10;
        }
        if (!type.equals(ArticleConstants.LOADTYPE_LOAD_MORE)&&!type.equals(ArticleConstants.LOADTYPE_LOAD_NEW))
        {

        }

        return null;
    }
}




