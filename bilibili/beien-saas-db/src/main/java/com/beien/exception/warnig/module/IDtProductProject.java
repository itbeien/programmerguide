package com.beien.exception.warnig.module;

/**
 * 定义各个产品线的项目组编码枚举接口类(公司.产品线.项目组.自定义)
 * <p>Description: </p>
 * @author itbeien
 * @version 1.0
 * <p>Copyright:Copyright(c)2023</p>
 * @date 2023年5月22日
 */
public interface IDtProductProject {

    /**
     * 获取产品线的项目内部编码
     * 方法用途: <br>
     * 实现步骤: <br>
     *
     * @return
     */
    String getDtProductProjectCode();

    /**
     * 获取产品线项目的内部名称
     * 方法用途: <br>
     * 实现步骤: <br>
     *
     * @return
     */
    String getDtProductProjectName();
}
