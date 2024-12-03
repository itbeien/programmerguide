package cn.itbeien.socket.handler;


import cn.itbeien.protocol.Protocol;
import cn.itbeien.protocol.request.RegistrationRequest;
import cn.itbeien.protocol.response.RegistrationResponse;
import cn.itbeien.service.IPayConsumerService;
import cn.itbeien.socket.ServerHandler;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import io.netty.channel.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 * Copyright© 2024 itbeien
 */
@Slf4j
@Component
public class PosHandler extends ServerHandler<RegistrationRequest> {
	@Autowired
	private IPayConsumerService payConsumerService;

	@Override
	public void channelRead(Channel channel, RegistrationRequest request) {
		log.info("解析的数据:{}",request.getBatchID());

;		Protocol protocol =  request;
		//payConsumerService.callPayService(JSONObject.parseObject(String.valueOf(msg)));//支付服务
		//payConsumerService.callFeignPayService((JSONObject) JSON.toJSON(request));//支付服务
		log.info("解析完pos端数据后，请求支付微服务:{}",JSON.toJSON(request));
		payConsumerService.callFeignSignService((JSONObject) JSON.toJSON(request));//支付服务
		channel.writeAndFlush(protocol);
	}
}
