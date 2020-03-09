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

### 1、微服务架构案例文章

[微服务架构案例(01)：项目技术选型简介，架构图解说明](https://mp.weixin.qq.com/s?__biz=MzU4Njg0MzYwNw==&mid=2247484173&idx=1&sn=0adceb6d5261aa1d59908043ff690423&chksm=fdf457b5ca83dea3203e5901771ba1cb49ce05db5b700c21536111f2e251373a484da123f0c2&token=1855594949&lang=zh_CN#rd)<br/>
[微服务架构案例(02)：业务架构设计，系统分层管理](https://mp.weixin.qq.com/s?__biz=MzU4Njg0MzYwNw==&mid=2247484192&idx=1&sn=9327cb5595c3eea1f78f777f37892d18&chksm=fdf45798ca83de8eb4b05b344fcb87ea763d5ba1d880536fc9b422e03033ad7d66217fe6e59e&token=1641533948&lang=zh_CN#rd)<br/>
[微服务架构案例(03)：数据库选型简介，业务数据规划设计](https://mp.weixin.qq.com/s?__biz=MzU4Njg0MzYwNw==&mid=2247484199&idx=1&sn=40838d2d9e9c50c35112f03795c4224a&chksm=fdf4579fca83de89ddde900f2b95c4aa1e02edd96d68dd6fb0eef04e314a4214a9e99d9ca1e4&token=1641533948&lang=zh_CN#rd)<br/>
[微服务架构案例(04)：中间件集成，公共服务封装](https://mp.weixin.qq.com/s?__biz=MzU4Njg0MzYwNw==&mid=2247484205&idx=1&sn=522b582d6f69d73a89f91881cbd00b55&chksm=fdf45795ca83de83b02b2e4d3ceb0a851b17428c7e14e352040962c77d6bee806c725a0c6a8f&token=1641533948&lang=zh_CN#rd)<br/>
[微服务架构案例(05)：SpringCloud 基础组件应用设计](https://mp.weixin.qq.com/s?__biz=MzU4Njg0MzYwNw==&mid=2247484211&idx=1&sn=b18843bfbb9b5b291ff1c8b9626b5c53&chksm=fdf4578bca83de9d2542bd2a71e7d655f5f172f90dde99c931ebc2158bb5dafcf34629dfb308&token=1641533948&lang=zh_CN#rd)<br/>
[微服务架构案例(06)：通过业务、应用、技术、存储方面，聊聊架构](https://mp.weixin.qq.com/s?__biz=MzU4Njg0MzYwNw==&mid=2247484230&idx=1&sn=7cf931b52c280147d41daffee57ec59e&chksm=fdf457feca83dee82ca7385918abae16f7a00a90d74a6d3a06fb9a4ad6ed53d0cf597929385a&token=878984111&lang=zh_CN#rd)<br/>

### 2、SpringCloud基础组件

源代码地址：【[GitHub·点这里](https://github.com/cicadasmile/spring-cloud-base)】    【[GitEE·点这里](https://gitee.com/cicadasmile/spring-cloud-base)】

[01、SpringCloud微服务：Eureka组件之服务注册与发现](https://mp.weixin.qq.com/s?__biz=MzU4Njg0MzYwNw==&mid=2247483697&idx=1&sn=723b38f79daf396b0d902a856e70e3fc&chksm=fdf45589ca83dc9fd852f9d10bbbca6d18124757bd31c5235f7bbd918f3c7e92e144ff384443&token=949711998&lang=zh_CN#rd)<br/>
[02、SpringCloud微服务：Ribbon和Feign组件实现负载均衡](https://mp.weixin.qq.com/s?__biz=MzU4Njg0MzYwNw==&mid=2247483981&idx=1&sn=1c5272fca0521ad85fb9d8b2be666492&chksm=fdf456f5ca83dfe3e0cd9caadc2ecf646584af805be2999935c792b839f2bfadbe5773249e97&token=2068987278&lang=zh_CN#rd)<br/>
[03、SpringCloud微服务：Hystrix组件实现服务熔断](https://mp.weixin.qq.com/s?__biz=MzU4Njg0MzYwNw==&mid=2247483985&idx=1&sn=7e27c66495a896edeaa3490314a0f57f&chksm=fdf456e9ca83dfff2b1ade8c4f9c0cec0b1c3a9cf248d0cb11002d75d20b180dad2dd2d2f9e9&token=1511677484&lang=zh_CN#rd)<br/>
[04、SpringCloud微服务：Turbine组件，实现微服务集群监控](https://mp.weixin.qq.com/s?__biz=MzU4Njg0MzYwNw==&mid=2247484004&idx=1&sn=197dab3b3576fbab90beedfd314fc94c&chksm=fdf456dcca83dfca0efe407c654795bb3310ac85d3ae240b6fb72db2873e3654506421739a2a&token=51353754&lang=zh_CN#rd)<br/>
[05、SpringCloud微服务：Zuul组件，实现路由网关控制](https://mp.weixin.qq.com/s?__biz=MzU4Njg0MzYwNw==&mid=2247484022&idx=1&sn=51ae6cf43e67a0213207d34a78e73afd&chksm=fdf456ceca83dfd878110f2c4386d547c95d0718948499c5a1fc94fc114474cd7c028bb40640&token=51353754&lang=zh_CN#rd)<br/>
[06、SpringCloud微服务：Config组件，实现配置统一管理](https://mp.weixin.qq.com/s?__biz=MzU4Njg0MzYwNw==&mid=2247484029&idx=1&sn=6f7b34a7a98c695b16214c73a7af1f24&chksm=fdf456c5ca83dfd389bb573eb0dcff877c8201ae607d6de947c27ced238a8e2a515388440fe3&token=693087170&lang=zh_CN#rd)<br/>
[07、SpringCloud微服务：Zipkin组件，实现请求链路追踪](https://mp.weixin.qq.com/s?__biz=MzU4Njg0MzYwNw==&mid=2247484041&idx=1&sn=8af57497c4ad1036cd0c7a014385c737&chksm=fdf45631ca83df27cbc9274a72eed0fef22ad5e018bcf2f81e50d3a8e4d924965ef08ba017d9&token=1730846991&lang=zh_CN#rd)<br/>
[08、SpringCloud基础组件总结，与Dubbo框架、Boot框架对比分析](https://mp.weixin.qq.com/s?__biz=MzU4Njg0MzYwNw==&mid=2247484056&idx=1&sn=91b7f3c01d8fcc1513150181e22ce264&chksm=fdf45620ca83df36aa94660a6e8b781017676c0ba1555c3c70ed83e3ded8dab82bef9209ba5b&token=1761632241&lang=zh_CN#rd)<br/>
[09、SpringCloud微服务：阿里开源组件Nacos，服务和配置管理](https://mp.weixin.qq.com/s?__biz=MzU4Njg0MzYwNw==&mid=2247484419&idx=1&sn=2b0a9568a6a4dbe61e4bd9a794ce9511&chksm=fdf450bbca83d9ade4a87059d505822c65fe1b472517b8bcfa175e3a8f34aa9cc144f0e4959c&token=1530600379&lang=zh_CN#rd)<br/>

### 3、SpringCloud分库分表案例

源代码地址：【[GitHub点这里](https://github.com/cicadasmile/cloud-shard-jdbc)】    【[码云.点这里](https://gitee.com/cicadasmile/cloud-shard-jdbc)】

1、[SpringBoot2 整合 shard-jdbc 中间件，实现数据分库分表](https://mp.weixin.qq.com/s?__biz=MzU4Njg0MzYwNw==&mid=2247483713&idx=1&sn=cd4228e19d07e0371af7ef06515f4298&chksm=fdf455f9ca83dcef81c44f10bff15a3d3a29553746eef9cad9d4e2a13c5d5709d95a375bff0a&token=582428657&lang=zh_CN#rd)<br/>
2、[基于Shard-Jdbc分库分表模式下，数据库扩容方案描述](https://mp.weixin.qq.com/s?__biz=MzU4Njg0MzYwNw==&mid=2247483723&idx=1&sn=4c4c59e13a05b7cf3ea23054d28a3e22&chksm=fdf455f3ca83dce566173d887ee8f274cc154e72c9c1af29cfecc02e3e77220d9f8b1f3b90c4&token=1249750178&lang=zh_CN#rd)<br/>
3、[基于SpringCloud实现Shard-Jdbc的分库分表模式，数据库扩容方案](https://mp.weixin.qq.com/s?__biz=MzU4Njg0MzYwNw==&mid=2247483732&idx=1&sn=ac0ecd8443ccd7b6f68955023e2291a3&chksm=fdf455ecca83dcfacd2aecc7b6f20deef13ba429f3b0da27159aa67581736a7f492732ae73c8&token=949711998&lang=zh_CN#rd)<br/>

## 关于作者
【<b>公众号：知了一笑</b>】    【<b>[知乎专栏](https://www.zhihu.com/people/cicadasmile/columns)</b>】<br/>
<img width="255px" height="255px" src="https://avatars0.githubusercontent.com/u/50793885?s=460&v=4"/><br/>

## 推荐项目

|项目名称|GitHub地址|GitEE地址|推荐指数|
|:---|:---|:---|:---|
|Java描述常用设计模式,算法,数据结构|[GitHub·点这里](https://github.com/cicadasmile/model-arithmetic-parent)|[GitEE·点这里](https://gitee.com/cicadasmile/model-arithmetic-parent)|☆☆☆☆☆|
|Java基础、进阶、并发、面向对象、Web开发|[GitHub·点这里](https://github.com/cicadasmile/java-base-parent)|[GitEE·点这里](https://gitee.com/cicadasmile/java-base-parent)|☆☆☆☆|
|SpringCloud微服务架构实战综合案例|[GitHub·点这里](https://github.com/cicadasmile/husky-spring-cloud)|[GitEE·点这里](https://gitee.com/cicadasmile/husky-spring-cloud)|☆☆☆☆☆|
|SpringCloud微服务基础组件案例详解|[GitHub·点这里](https://github.com/cicadasmile/spring-cloud-base)|[GitEE·点这里](https://gitee.com/cicadasmile/spring-cloud-base)|☆☆☆|
|SpringCloud实现分库分表模式下数据库实时扩容|[GitHub·点这里](https://github.com/cicadasmile/cloud-shard-jdbc)|[GitEE·点这里](https://gitee.com/cicadasmile/cloud-shard-jdbc)|☆☆☆☆☆|
|SpringBoot框架基础应用入门到进阶|[GitHub·点这里](https://github.com/cicadasmile/spring-boot-base)|[GitEE·点这里](https://gitee.com/cicadasmile/spring-boot-base)|☆☆☆☆|
|SpringBoot框架整合开发常用中间件|[GitHub·点这里](https://github.com/cicadasmile/middle-ware-parent)|[GitEE·点这里](https://gitee.com/cicadasmile/middle-ware-parent)|☆☆☆☆☆|
|Spring+Mvc框架基础案例详解|[GitHub·点这里](https://github.com/cicadasmile/spring-mvc-parent)|[GitEE·点这里](https://gitee.com/cicadasmile/spring-mvc-parent)|☆☆|
|Linux系统基础、运维,常用操作积累|[GitHub·点这里](https://github.com/cicadasmile/linux-system-base)|[GitEE·点这里](https://gitee.com/cicadasmile/linux-system-base)|☆☆☆|
