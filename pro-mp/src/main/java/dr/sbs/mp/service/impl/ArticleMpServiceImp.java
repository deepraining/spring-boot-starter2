package dr.sbs.mp.service.impl;

import dr.sbs.mp.entity.Article;
import dr.sbs.mp.mapper.ArticleMapper;
import dr.sbs.mp.service.ArticleMpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章 服务实现类
 * </p>
 *
 * @author deepraining
 * @since 2023-08-16
 */
@Service
public class ArticleMpServiceImp extends ServiceImpl<ArticleMapper, Article> implements ArticleMpService {

}
