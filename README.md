# shiro-model
basic-shiro-model
 
一个 基础的shiro框架模型，能够实现简单login
2 017年9月1日
使用 自定义的realm数据库验证 sql：sys_permissions.sql
使用 passwordHelper 在添加用户的时候对密码进行加密，同时加盐
使用 自定义的表单验证过滤器，MyFormAuthenticationFilter进行验证。
目前 缺少自定义缓存以及自定义session管理，待进一步学习之后更新。
