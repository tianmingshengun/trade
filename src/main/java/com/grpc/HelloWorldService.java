package com.grpc;

import com.grpc.HelloRequest;
import com.grpc.HelloResponse;
import com.grpc.HelloServiceGrpc.HelloServiceImplBase;

import io.grpc.stub.StreamObserver;

/**
 * 对外服务的类
 * @author admin
 *
 */
public class HelloWorldService extends HelloServiceImplBase {

	@Override
	public void sendHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
		System.out.println(request.getName()+"在发送请求，请应答。。。。");
		//展开业务逻辑，并进行响应
		HelloResponse hre=HelloResponse.newBuilder().setMsg(request.getName()+"在吃饭呢，你稍等会儿。。。").build();
		responseObserver.onNext(hre);
		responseObserver.onCompleted();
	}
      
}
