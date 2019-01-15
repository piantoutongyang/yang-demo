package com.mingyisoft.javademo.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.ShortBuffer;

public class BufferDemo1 {
	public static void main(String[] args) {
//		ByteBuffer bb1 = ByteBuffer.allocate(8);
		//直接Buffer的创建成本高，读写效率高，适用于长期生存的Buffer，只有ByteBuffer才允许创建直接Buffer。
//		ByteBuffer bb2 = ByteBuffer.allocateDirect(8);
		
		//ByteBuffer的子类，用于表示Channel将磁盘文件的部分或全部内容映射到内存中后得到的结果，通常由Channel的map()返回。
//		MappedByteBuffer mbb = null;
//		IntBuffer ib = IntBuffer.allocate(8);
//		FloatBuffer fb = FloatBuffer.allocate(8);
//		DoubleBuffer db = DoubleBuffer.allocate(8);
//		ShortBuffer sb = ShortBuffer.allocate(8);
		CharBuffer cb = CharBuffer.allocate(8);
		
		//Buffer的容量
		System.out.println("capacity="+cb.capacity());
		//Buffer的初始位置
		System.out.println("position0="+cb.position());
		//Buffer的界限
		System.out.println("limit0="+cb.limit());
		//写数据
		cb.put('a');
		cb.put('b');
		cb.put('c');
		System.out.println("position1="+cb.position());
		//调用flip，将limit设置为position，把position设置为0，准备读数据,把Buffer中没有数据的存储空间封住，避免读取到NULL值。
		cb.flip();
		System.out.println("limit1="+cb.limit());
		System.out.println("position2="+cb.position());
		//读数据，相对读取，会影响position的位置。
		System.out.println("get1="+cb.get());
		System.out.println("position3="+cb.position());
		//读数据，绝对读取，不会影响position的位置。
		System.out.println("get2="+cb.get(2));
		System.out.println("position4="+cb.position());
		//调用clear，将position设置为0，把limit设置为capacity
		cb.clear();
		System.out.println("limit="+cb.limit());
		System.out.println("position5="+cb.position());
		//调用clear后并没有清空Buffer
		System.out.println("get3="+cb.get(2));
		//重新设定界限值，并返回一个具有新的limit的Buffer对象
		cb.limit(3);

		//判断当前position与limit之间是否还有元素可供处理
		while(cb.hasRemaining()) {
			//循环输出
			System.out.println(cb.get());
		}
		//在0和position之间做mark
		/**
		 * mark可以让缓冲区能够记住缓冲区当前的position并在之后返回，
		 * 在mark方法调用之前，mark的值为-1。reset方法可以将position设置为之前mark的值。
		 * 如果之前没有调用mark会抛出InvalidMarkException。如果调用rewind，clear，flip方法会导致mark的值被重新设为-1，
		 * 或者调用limit(newLimit)和position(newPosition)方法，新值比mark的值小的话，也会导致mark的值重新被设为-1.
		 */
		cb.position(1).mark();
		System.out.println("position6="+cb.position());
		//设置position，并返回一个具有新的position的Buffer对象
		cb.position(2);
		System.out.println("position7="+cb.position());
		//返回当前position与limit之间的元素个数
		System.out.println("remaining="+cb.remaining());
		//将position转到mark的位置
		cb.reset();
		System.out.println("position8="+cb.position());
		//将position设置为0并取消之前的mark
		cb.rewind();
		System.out.println("position9="+cb.position());
		System.out.println("结束");
		
	}
}
