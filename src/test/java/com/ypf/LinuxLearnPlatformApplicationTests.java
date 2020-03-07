package com.ypf;

import com.ypf.util.FastDFSClient;
import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;


@SpringBootTest
class LinuxLearnPlatformApplicationTests {

    @Test
    void contextLoads() {
    }

}



//@RunWith(SpringRunner.class)
//@SpringBootTest
//class LinuxLearnPlatformApplicationTests {
//
//    @Value("${fastdfs_ip}")
//    private String fastdfs_ip;
//
//    @Test
//    public void contextLoads() throws IOException, MyException {
//        ClientGlobal.init("C:\\Users\\A400U\\Desktop\\毕业设计资料\\linux_learn_platform\\src/main\\resources\\client.cfg");
////		3、创建一个TrackerClient对象。
//        TrackerClient client = new TrackerClient();
////		4、创建一个TrackerServer对象。
//        TrackerServer trackerServer = client.getConnection();
////		5、声明一个StorageServer对象，null。
//        StorageServer storageServer = null;
////		6、获得StorageClient对象。
//        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
////		7、直接调用StorageClient对象方法上传文件即可。
//        String[] arr = storageClient.upload_file("E:\\图片\\电脑壁纸\\00.jpg", "jpg", null);
//        for (String string : arr) {
//            System.out.println("打印出来的-->"+string);
//        }
//    }
//
//    @Test
//    public void testClientUtil() {
//        FastDFSClient client = new FastDFSClient("C:\\Users\\A400U\\Desktop\\毕业设计资料\\linux_learn_platform\\src/main\\resources\\client.cfg");
//        String result = client.uploadFile("E:\\图片\\电脑壁纸\\01.jpg", "jpg");
//        System.out.println("图片路径是-->"+result);
//    }
//
//
//}














