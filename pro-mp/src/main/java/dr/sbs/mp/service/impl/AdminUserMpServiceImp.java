package dr.sbs.mp.service.impl;

import dr.sbs.mp.entity.AdminUser;
import dr.sbs.mp.mapper.AdminUserMapper;
import dr.sbs.mp.service.AdminUserMpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author deepraining
 * @since 2023-08-16
 */
@Service
public class AdminUserMpServiceImp extends ServiceImpl<AdminUserMapper, AdminUser> implements AdminUserMpService {

}
