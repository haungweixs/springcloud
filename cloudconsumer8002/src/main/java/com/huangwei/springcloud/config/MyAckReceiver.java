package com.huangwei.springcloud.config;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.huangwei.springcloud.entities.Rkson;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * Created by Hw
 * 21/02/26 16:55
 */
@Component
public class MyAckReceiver implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        long deliveryTag=message.getMessageProperties().getDeliveryTag();
        try {
            List<Rkson> rksonList= (List<Rkson>) byteObject(message.getBody());
            System.out.println(rksonList.get(0).getId());
            System.out.println("消费的消息来自  :"+message.getMessageProperties().getConsumerQueue());
        }catch (Exception e){

        }
    }

    //将byte数组转换为obj
    private Object byteObject(byte[] bytes)
    {
        Object object=null;
        try {
            ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(bytes);
            ObjectInputStream objectInputStream=new ObjectInputStream(byteArrayInputStream);
            object=objectInputStream.readObject();  //从objectinputstream流中读取一个对象

            //关闭输入流
            byteArrayInputStream.close();
            objectInputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return object;
    }
}
