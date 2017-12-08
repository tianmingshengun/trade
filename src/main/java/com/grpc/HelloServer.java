package com.grpc;


import io.grpc.Server;
import io.grpc.netty.NettyServerBuilder;

/**
 * 服务端
 * @author admin
 *
 */
public class HelloServer {
      public static void main(String[] args) {
		Server server=NettyServerBuilder.forPort(9543)
				.addService(new HelloWorldService()).build();
		try {
			server.start();
			System.out.println("服务启动了");
			server.awaitTermination();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("服务产生了问题");
		}
	}
}
