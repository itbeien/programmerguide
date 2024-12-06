package cn.itbeien.controller;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import cn.itbeien.timer.QuartzTask;

/**
 * @author beien
 * @date 2023-10-29 17:57
 * Copyright© 2023 beien
 */
@RestController
@RequestMapping("/quartz")
public class BaseController {
    //使用scheduler(任务调度器)获取触发器
    @Autowired
    private Scheduler scheduler;

    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public void index() throws SchedulerException {
        //cron表达式
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/8 * * * * ?");
        //根据name 和group获取当前trgger 的身份
        TriggerKey triggerKey = TriggerKey.triggerKey(QuartzTask.class.getName(), "itbeien");
        CronTrigger triggerOld = null;
        try {
            //获取 触发器的信息
            triggerOld = (CronTrigger) scheduler.getTrigger(triggerKey);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        if (triggerOld == null) {
            //将job加入到jobDetail中
            JobDetail jobDetail = JobBuilder.newJob(QuartzTask.class).withIdentity(QuartzTask.class.getName(), "itbeien").build();
            //触发器
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity(QuartzTask.class.getName(),"itbeien").withSchedule(cronScheduleBuilder).build();
            //执行任务(任务和触发器)
            scheduler.scheduleJob(jobDetail, trigger);
        } else {
            System.out.println("当前job已存在--------------------------------------------");
        }
    }
}
