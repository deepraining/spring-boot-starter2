package dr.sbs.mp2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import dr.sbs.mp2.entity.FrontUser;
import dr.sbs.mp2.mapper.FrontUserMapper;
import dr.sbs.mp2.service.FrontUserMpService;
import org.springframework.stereotype.Service;

/**
 * 前端用户 服务实现类
 *
 * @author deepraining
 * @since 2023-08-17
 */
@Service
public class FrontUserMpServiceImp extends ServiceImpl<FrontUserMapper, FrontUser>
    implements FrontUserMpService {}
