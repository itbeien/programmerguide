SpringBoot整合Quartz定时任务（持久化到数据库）
常见分布式定时任务
1.quartz   ---单机/分布式环境
2.xxl-job    ---分布式环境
3.elasticJob  ---分布式环境

SpringBoot整合quartz整体流程

下载地址:https://www.quartz-scheduler.org/downloads/

quartz三要素：Scheduler(任务调度器)、Trigger、JobDetai&Job
执行任务(JobDetai(任务)和Trigger(触发器))
1.pom文件添加对应的依赖。
2.mysql数据库对应表的初始化。
qrtz_blob_triggers：以blob格式存放自定义trigger信息
qrtz_calendars：记录quartz任务中的日历信息
qrtz_cron_triggers：记录cronTrigger，即cron表达式相关触发器的信息
qrtz_fired_triggers：存储正在触发的定时器的信息，执行完后数据清空
qrtz_job_details：记录每个定时任务详细信息的表
qrtz_locks：分布式处理时多个节点定时任务的锁信息
qrtz_paused_triggers_grps：存储暂停的任务触发器信息
qrtz_scheduler_state：记录调度器状态的表
qrtz_simple_triggers：记录SimpleTrigger，即普通的触发器信息
qrtz_simprop_triggers：存储CalendarIntervalTrigger和DailyTimeIntervalTrigger触发器信息
qrtz_triggers：记录每个触发器详细信息的表

3.配置对应的properties
4.将原来quartz控制的类的实例化交给spirng IOC控制。
（对应的是核心QuartzConfig类和JobFactory类）
5.业务逻辑层对job进行控制。


如果业务需求(定时任务)是单机架构,优先考虑使用quartz



springboot整合quartz流程
1.创建quartz框架数据库并执行脚本quartz-2.3.0-SNAPSHOT\src\org\quartz\impl\jdbcjobstore
2.在pom.xml中加入jar
3.修改项目和quartz框架的属性文件(数据库相关连接信息)
4.创建QuartzConfig配置类和任务工厂类JobFactory
5.根据实际的业务场景创建定时任务(在数据库中配置好对应的执行表达式cron(linux))
6.创建测试定时任务的view(controller+html+vue)层
