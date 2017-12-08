package com.grpc;

import com.grpc.HelloRequest;
import com.grpc.HelloResponse;
import com.grpc.HelloServiceGrpc;
import com.grpc.HelloServiceGrpc.HelloServiceBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.netty.NettyChannelBuilder;

/**
 * 客户端
 * @author admin
 *
 */
public class HelloClient {
       public static void main(String[] args) {
		   //建立通道,并使用明文
    	   ManagedChannel channel =NettyChannelBuilder.forAddress("127.0.0.1",9543).usePlaintext(true)
		                           .build();
		   //建立阻塞存根，同步调用
    	   HelloServiceBlockingStub stub= HelloServiceGrpc.newBlockingStub(channel);
		   //建立请求参数
    	   HelloRequest param=HelloRequest.newBuilder().setName("神棍").build();
    	   //发送请求
    	   HelloResponse response=stub.sendHello(param);
    	   //响应内容
    	   System.out.println(response.getMsg());
    	   channel.shutdown();
	}
}
