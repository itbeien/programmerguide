package cn.itbeien.timer;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author beien
 * @date 2023-10-29 17:56
 * Copyright© 2023 beien
 */
@Component
@DisallowConcurrentExecution
public class QuartzTask extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(new Date() + "任务开始------------------------------------");
        try {
            //首先分片
            //查询支付交易记录表
            Thread.sleep(10000);
            System.out.println("执行定时任务:"+jobExecutionContext.getJobDetail().getDescription());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(new Date() + "任务结束------------------------------------");
    }
}
