package dr.sbs.common;

public enum ResultCode implements IErrorCode {
  //  SUCCESS(0, "Operation Succeeded"),
  SUCCESS(0, "操作成功"),
  //  FAILED(1, "Operation Failed"),
  FAILED(1, "操作失败"),
  //  VALIDATE_FAILED(2, "Check parameters Failed"),
  VALIDATE_FAILED(2, "参数检验失败"),
  //  UNAUTHORIZED(3, "Not Logged In or Token Is Expired"),
  UNAUTHORIZED(3, "未登录或Token已过期"),
  //  FORBIDDEN(4, "No Privileges");
  FORBIDDEN(4, "没有相关权限"),
  //  FORBIDDEN(5, "Token Is Offline");
  OFFLINE(5, "Token已下线"),
  //  FORBIDDEN(6, "Invalid Request");
  INVALID(6, "请求有误");
  private long code;
  private String message;

  private ResultCode(long code, String message) {
    this.code = code;
    this.message = message;
  }

  @Override
  public long getCode() {
    return code;
  }

  @Override
  public String getMessage() {
    return message;
  }
}
