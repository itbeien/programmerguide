package com.beien.exception;

import com.beien.exception.warnig.DtWarningLevelEnum;
import com.beien.exception.warnig.IDtWarnType;
import com.beien.exception.warnig.module.IDtProductProject;


/**
 * <p>Description: </p>
 * @author itbeien
 * @version 1.0
 * @date 2023年5月22日
 * <p>Copyright:Copyright(c)2023</p>
 */
public interface IDtErrorCode {

    /**
     * 获取业务自定错误编码
     * 方法用途: <br>
     * 实现步骤: <br>
     *
     * @return
     */
    String getSelfDefineCode();

    /**
     * 获取业务定义的完整错误码，
     * 格式:mopon.产品线.项目组。应用.自定义错误码
     * 方法用途: <br>
     * 实现步骤: <br>
     *
     * @return
     */
    IDtProductProject getErroCodePrefix();

    /**
     * 错误码的错误提示消息
     */
    String getMessage();

    /**
     * 错误级别
     * {@link DtWarningLevelEnum}
     * 方法用途: <br>
     * 实现步骤: <br>
     *
     * @return
     */
    DtWarningLevelEnum getWarningLevel();

    /**
     * 成功
     * 方法用途: <br>
     * 实现步骤: <br>
     *
     * @return
     */
    boolean getSuccessFlag();

    /**
     * 获取预警的类别
     * 可以自定义,如果使用默认的预警类别 @see com.mopon.component.constant.MoponDefaultWarnType
     *
     * @return
     */
    IDtWarnType getWarnType();
}
