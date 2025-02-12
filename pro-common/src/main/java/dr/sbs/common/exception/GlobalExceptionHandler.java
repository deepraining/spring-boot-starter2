package dr.sbs.common.exception;

import dr.sbs.common.CommonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

// 全局异常处理
// 注：把这个文件复制到每项目的主包名下，才能生效
// 或者启动时设置 `@SpringBootApplication(scanBasePackages = {"dr.sbs"})`
@ControllerAdvice
public class GlobalExceptionHandler {
  @ResponseBody
  @ExceptionHandler(value = ApiException.class)
  public CommonResult handle(ApiException e) {
    if (e.getCommonResult() != null) {
      return e.getCommonResult();
    }
    if (e.getErrorCode() != null) {
      return CommonResult.failed(e.getErrorCode());
    }
    return CommonResult.failed(e.getMessage());
  }
}
