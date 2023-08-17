package dr.sbs.front.service;

import dr.sbs.front.dto.UpdatePasswordParam;
import dr.sbs.front.dto.UserCreateParam;
import dr.sbs.mp2.entity.FrontUser;

public interface UserService {
  /** Get user by username */
  FrontUser getByUsername(String username);

  /** Get user by id */
  FrontUser getById(Long id);

  /** Sign up */
  FrontUser register(UserCreateParam userCreateParam);

  /** Update password */
  boolean updatePassword(UpdatePasswordParam updatePasswordParam);

  /** Get current user information */
  FrontUser getCurrentUser();
}
