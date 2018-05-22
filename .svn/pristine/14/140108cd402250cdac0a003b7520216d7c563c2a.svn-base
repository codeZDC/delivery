package com.tuzhi.delivery.controller;

import java.io.File;
import java.io.RandomAccessFile;

/**
 * @author codeZ
 * @date 2018年3月29日 上午10:32:39
 * 
 */
public class TestRM {
	 // 所有的异常直接抛出，程序中不再进行处理  
    public static void main(String args[]) throws Exception{  
        File f = new File("F:" + File.separator + "test.txt") ; // 指定要操作的文件  
        RandomAccessFile rdf = null ;       // 声明RandomAccessFile类的对象  
        rdf = new RandomAccessFile(f,"rw") ;// 读写模式，如果文件不存在，会自动创建  
        String name = null ;  
        int age = 0 ;  
        name = "郑德超 \t" ;         // 字符串长度为8  
        rdf.write(name.getBytes("UTF-8")) ;      // 将姓名写入文件之中  
        name = "整的 \t" ;         // 字符串长度为8  
        rdf.write(name.getBytes("UTF-8")) ;      // 将姓名写入文件之中  
        name = "打撒打撒 \t " ;         // 字符串长度为8  
        rdf.write(name.getBytes("UTF-8")) ;      // 将姓名写入文件之中  
        rdf.close() ;               // 关闭  
    }  
}
