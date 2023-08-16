package dr.sbs.mp.service.impl;

import dr.sbs.mp.entity.FrontUser;
import dr.sbs.mp.mapper.FrontUserMapper;
import dr.sbs.mp.service.FrontUserMpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 前端用户 服务实现类
 * </p>
 *
 * @author deepraining
 * @since 2023-08-16
 */
@Service
public class FrontUserMpServiceImp extends ServiceImpl<FrontUserMapper, FrontUser> implements FrontUserMpService {

}
