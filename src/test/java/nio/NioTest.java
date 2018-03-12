package nio;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * nio客户端
 * 
 * @author admin
 *
 */
public class NioTest {
	public static void main(String[] args) throws Exception {
		//创建一个客户端通道
		SocketChannel socketChannel =  SocketChannel.open();
		socketChannel.configureBlocking(false);
		//连接远程主机
		socketChannel.connect(new InetSocketAddress("127.0.0.1",6669));
		
		//声明选择器
		Selector selector=Selector.open();
		//将通道注册到选择器上，并指定检测的事件
		socketChannel.register(selector, SelectionKey.OP_CONNECT);
		//轮询监测发生的事件
		/// System.out.println("连接成功");
		while(true){
			//查看是否有已经准备就绪的通道，该方法会产生阻塞
		    int num= selector.select();
		  //  if(num==0) continue;
		    //获取和通道关联的事件
		    Set<SelectionKey> set=selector.selectedKeys();
		    Iterator<SelectionKey> iterator=set.iterator();
		    //检测相关事件并进行处理
		   
		    while(iterator.hasNext()){
		    	SelectionKey sk= iterator.next();
		    	//删除已选择的键，set集合不会自动处理处理完的键
		    	iterator.remove();
		    	//判读该事件是否被触发
		    	if(sk.isConnectable()){
		    		
		    		SocketChannel channel=(SocketChannel)sk.channel();
		    		//判断该通道是否正在连接
		    		if(channel.isConnectionPending()){
		    			if(channel.finishConnect()){
		    				System.out.println("连接成功");
		    			}
		    		}
		    		channel.configureBlocking(false);
		    		//发送信息
		    		channel.write(ByteBuffer.wrap("请多关照。。".getBytes()));
		    		//注册读取事件，用于获取服务端的信息
		    		channel.register(selector, SelectionKey.OP_READ);
		    		
		    	}else if(sk.isReadable()){
		    		SocketChannel channel=(SocketChannel)sk.channel();
		    		ByteBuffer buffer = ByteBuffer.allocate(1024); 
		    		 buffer.clear();  
		    		channel.read(buffer);
		    		System.out.println(new String(buffer.array(), 0, buffer.position()));
		    		buffer.flip();
		    		break;
		    	}
		    }
		}
	}
}