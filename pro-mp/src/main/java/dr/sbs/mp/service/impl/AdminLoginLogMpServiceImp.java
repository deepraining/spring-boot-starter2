package dr.sbs.mp.service.impl;

import dr.sbs.mp.entity.AdminLoginLog;
import dr.sbs.mp.mapper.AdminLoginLogMapper;
import dr.sbs.mp.service.AdminLoginLogMpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户登录日志表 服务实现类
 * </p>
 *
 * @author deepraining
 * @since 2023-08-16
 */
@Service
public class AdminLoginLogMpServiceImp extends ServiceImpl<AdminLoginLogMapper, AdminLoginLog> implements AdminLoginLogMpService {

}
