# spring-boot-starter v2

与 [spring-boot-starter v1](https://github.com/deepraining/spring-boot-starter) 的不同点是使用 [mybatis-plus](https://baomidou.com/) 作为数据库驱动层

- `pro-common`: 通用代码
- `pro-mp`: [mybatis-plus-generator](https://baomidou.com/pages/779a6e/) 生成的代码
- `pro-admin`: 使用 JWT 保持登陆状态的后台管理应用，包括基于角色的访问控制（RBAC），示例前端项目 [sbs-admin-web](https://github.com/deepraining/sbs-admin-web)
- `pro-front`: 使用 Session-Cookie 保持登陆状态的前端应用
- `pro-dds`: 使用 [dynamic-datasource](https://github.com/baomidou/dynamic-datasource) 的多数据源支持
