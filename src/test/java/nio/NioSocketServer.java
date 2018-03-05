package nio;

import java.nio.ByteBuffer;
import java.net.InetSocketAddress;  
import java.net.ServerSocket;  
import java.nio.channels.SelectionKey;  
import java.nio.channels.Selector;  
import java.nio.channels.ServerSocketChannel;  
import java.nio.channels.SocketChannel;  
import java.util.Iterator;  
import java.util.Set;  
/**
 * 基于nio的socket服务器样例
 * @author admin
 * nio主要是对原有io操作的优化，提供了对基本数据类型的缓存操作，无论是读取数据还是写入数据均是基于缓存区操作的，其选择器类可以使单个线程管理多个io通道，减少了线程切换带来的开销，所以速度大为提升
 */
public class NioSocketServer {
	public static void main(String[] args) throws Exception {  
        //定义缓存区，并指定容量大小
		ByteBuffer buffer = ByteBuffer.allocate(1024);  
        //创建服务器套接字通道，线程安全的
		ServerSocketChannel ssc = ServerSocketChannel.open();           
        ssc.configureBlocking(false);//与选择器配合使用，通道需要设置为非阻塞模式  
        ServerSocket ss = ssc.socket();        
        //创建选择器，用于检测一到多个NIO通道，从而使单个线程可以管理多个通道，减少线程上下文切换带来的资源消耗
        Selector selector = Selector.open(); 
        //创建套接字地址
        InetSocketAddress address = new InetSocketAddress("127.0.0.1",6669);  
        //为该套接字绑定地址
        ss.bind(address);  
        //注册套接字
        SelectionKey key = ssc.register(selector, SelectionKey.OP_ACCEPT);  
        System.out.println("开始监听……");  
        while (true) {  
            int num = selector.select();//返回已经准备就绪的通道
            
           //获取有效键集,检测通道所触发的事件
            Set selectedKeys = selector.selectedKeys();  
            Iterator it = selectedKeys.iterator();  
            //持续监控这个selectedKey的四种事件（接受，连接，读，写）是否就绪
            while (it.hasNext()) {  
                SelectionKey sKey = (SelectionKey) it.next();  
                it.remove();  
                SocketChannel channel = null;  
                if (sKey.isAcceptable()) {  
                    ServerSocketChannel sc = (ServerSocketChannel) key.channel();  
                    channel = sc.accept();// 接受连接请求  
                    channel.write(buffer.wrap(new String("sendddd").getBytes()));
                    channel.configureBlocking(false);  
                    channel.register(selector, SelectionKey.OP_READ );  
                   
                } else if (sKey.isReadable()) {  
                    channel = (SocketChannel) sKey.channel();  
                    while (true) {  
                        buffer.clear();  
                        int r = channel.read(buffer);  
                        if (r <= 0) {  
                            channel.close();  
                            System.out.println("接收完毕，断开连接");  
                            break;  
                        }  
                        System.out.println("##" + r + " " + new String(buffer.array(), 0, buffer.position())+"haha");  
                        buffer.flip();  
                    }  
                      
                } 
            }  
        }  
  
    }  
  
}
