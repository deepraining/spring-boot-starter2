package dr.sbs.mp3.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import dr.sbs.mp3.entity.Article;

/**
 * 文章 Mapper 接口
 *
 * @author deepraining
 * @since
 */
@DS("master3")
public interface ArticleMapper extends BaseMapper<Article> {}
