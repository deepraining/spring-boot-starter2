package dr.sbs.mp.service.impl;

import dr.sbs.mp.entity.WxUser;
import dr.sbs.mp.mapper.WxUserMapper;
import dr.sbs.mp.service.WxUserMpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 微信用户 服务实现类
 * </p>
 *
 * @author deepraining
 * @since 2023-08-16
 */
@Service
public class WxUserMpServiceImp extends ServiceImpl<WxUserMapper, WxUser> implements WxUserMpService {

}
