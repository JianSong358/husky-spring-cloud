## 微服务架构

### 1、项目简介

微服务架构案例核心内容，基于SpringCloud框架几个核心组件，Eureka服务注册与发现组件，Feign声明式的WebService客户端组件，Zuul动态路由网关组件。进行多个数据管理，多个服务管理搭建，多个中间件集成，多业务拆分等模式，搭建SpringCloud微服务框架的综合应用案例。

### 2、技术选型

- 基础层框架：`Spring5+`，`SpringBoot2+`，`SpringCloud2+`
- 持久层框架：`MyBatis`，`MyBatis-Plus`
- 开发组件：`Druid`，`Log4j`，`FastJson`，`JodaTime`，`JavaMail`
- 中间件集成：`RocketMQ`，`Redis`，`Quart`，`ElasticSearch`
- 数据存储：`MySQL`、`Redis`、`ElasticSearch`

### 3、依赖知识点

- `SpringBoot`基础  [GitHub·点这里](https://github.com/cicadasmile/spring-boot-base) 或  [GitEE·点这里](https://gitee.com/cicadasmile/spring-boot-base)
- `SpringBoot`应用  [GitHub·点这里](https://github.com/cicadasmile/middle-ware-parent) 或  [GitEE·点这里](https://gitee.com/cicadasmile/middle-ware-parent)
- `SpringCloud`组件  [GitHub·点这里](https://github.com/cicadasmile/spring-cloud-base) 或  [GitEE·点这里](https://gitee.com/cicadasmile/spring-cloud-base)
- `Linux中间件`搭建  [GitHub·点这里](https://github.com/cicadasmile/linux-system-base) 或  [GitEE·点这里](https://gitee.com/cicadasmile/linux-system-base)

## 文章说明

### 1、微服务架构系列

|序号| 标题|
|:---|:---|
|01 | [微服务架构：项目技术选型简介，架构图解说明](https://mp.weixin.qq.com/s/kxbNXupDxcuISm-vW9nhyA)|
|02 | [微服务架构：业务架构设计，系统分层管理](https://mp.weixin.qq.com/s/sx_BSfA5zMJ9FaPAApS3Aw)|
|03 | [微服务架构：数据库选型简介，业务数据规划设计](https://mp.weixin.qq.com/s/hdS2IB0kx-ehBsEWed75xg)|
|04 | [微服务架构：中间件集成，公共服务封装](https://mp.weixin.qq.com/s/5yR5czRHu4EARw5MvnyxcQ)|
|05 | [微服务架构：SpringCloud 基础组件应用设计](https://mp.weixin.qq.com/s/ddyXWTtN2zMnWJZ-T8H8_w)|
|06 | [微服务架构：通过业务、应用、技术、存储，聊聊架构](https://mp.weixin.qq.com/s/mzOK_JOb_i_G1cqy0YAvYw)|
|07 | [微服务技术栈：常见注册中心组件，对比分析](https://mp.weixin.qq.com/s/yBrIZFXe6q7tfRrJC_FUQA)|

### 2、微服务组件和应用

基础组件源码：【[GitHub·点这里](https://github.com/cicadasmile/spring-cloud-base)】    【[GitEE·点这里](https://gitee.com/cicadasmile/spring-cloud-base)】

分库分表源码：【[GitHub点这里](https://github.com/cicadasmile/cloud-shard-jdbc)】    【[码云.点这里](https://gitee.com/cicadasmile/cloud-shard-jdbc)】

|序号|文章标题|
|:---:|:---|
|01|[微服务基础：Eureka组件，管理服务注册发现](https://mp.weixin.qq.com/s/cbEnCOhgo-5wGFX-GAUQtg)|
|02|[微服务基础：Ribbon和Feign组件，实现请求负载均衡](https://mp.weixin.qq.com/s/yHCC-MwFtDda_y817CV2XA)|
|03|[微服务基础：Hystrix组件，实现服务熔断](https://mp.weixin.qq.com/s/pDrda8tBbNfReWVQrzal6w)|
|04|[微服务基础：Turbine组件，实现微服务集群监控](https://mp.weixin.qq.com/s/-PPL5jwe4OdoBq7kQwePKA)|
|05|[微服务基础：Zuul组件，实现路由网关控制](https://mp.weixin.qq.com/s/A7xiIp9EG62_1y-F23TATg)|
|06|[微服务基础：Config组件，实现配置统一管理](https://mp.weixin.qq.com/s/_WZ1r0Kas5yMMPfwZ4MRUw)|
|07|[微服务基础：Zipkin组件，实现请求链路追踪](https://mp.weixin.qq.com/s/p3p3Wi72rJngqMz4FSICBQ)|
|08|[微服务基础：与Dubbo框架、Boot框架对比分析](https://mp.weixin.qq.com/s/RC8F_D1J75XEv7oR7xdK5Q)|
|09|[微服务基础：Nacos组件，服务和配置管理](https://mp.weixin.qq.com/s/adwfdDGg9DQleYLECA8raQ)|
|10|[微服务基础：Sentinel组件，服务限流和降级](https://mp.weixin.qq.com/s/L_Q9PyPKngmCx-c94o0UmA)|
|11|[微服务应用：分库分表模式下，数据库扩容方案](https://mp.weixin.qq.com/s/yCRwHGUd7xzQeEhoXFeO-w)|
|12|[微服务应用：Shard-Jdbc分库分表，扩容方案实现](https://mp.weixin.qq.com/s/QHF4qFP0JUhmievlj3FQPQ)|

## 关于作者
【<b>公众号：知了一笑</b>】    【<b>[知乎专栏](https://www.zhihu.com/people/cicadasmile/columns)</b>】<br/>
<img width="255px" height="255px" src="https://avatars0.githubusercontent.com/u/50793885?s=460&v=4"/><br/>

## 推荐项目

|序号|项目名称|GitHub地址|GitEE地址|推荐指数|
|:---|:---|:---|:---|:---|
|01|Java描述设计模式,算法,数据结构|[GitHub·点这里](https://github.com/cicadasmile/model-arithmetic-parent)|[GitEE·点这里](https://gitee.com/cicadasmile/model-arithmetic-parent)|☆☆☆☆☆|
|02|Java基础、并发、面向对象、Web开发|[GitHub·点这里](https://github.com/cicadasmile/java-base-parent)|[GitEE·点这里](https://gitee.com/cicadasmile/java-base-parent)|☆☆☆☆|
|03|SpringCloud微服务基础组件案例详解|[GitHub·点这里](https://github.com/cicadasmile/spring-cloud-base)|[GitEE·点这里](https://gitee.com/cicadasmile/spring-cloud-base)|☆☆☆|
|04|SpringCloud微服务架构实战综合案例|[GitHub·点这里](https://github.com/cicadasmile/husky-spring-cloud)|[GitEE·点这里](https://gitee.com/cicadasmile/husky-spring-cloud)|☆☆☆☆☆|
|05|SpringBoot框架基础应用入门到进阶|[GitHub·点这里](https://github.com/cicadasmile/spring-boot-base)|[GitEE·点这里](https://gitee.com/cicadasmile/spring-boot-base)|☆☆☆☆|
|06|SpringBoot框架整合开发常用中间件|[GitHub·点这里](https://github.com/cicadasmile/middle-ware-parent)|[GitEE·点这里](https://gitee.com/cicadasmile/middle-ware-parent)|☆☆☆☆☆|
|07|数据管理、分布式、架构设计基础案例|[GitHub·点这里](https://github.com/cicadasmile/data-manage-parent)|[GitEE·点这里](https://gitee.com/cicadasmile/data-manage-parent)|☆☆☆☆☆|
