package com.xiuzhu.utils;

/**
 * The class <code>Class ServiceURL</code>.
 *
 * @author Tonghu Lei
 * @version 1.0
 */
public class ServiceURL {

	public static final String FLASH_PACK_NAME = "air.com.youdeyi.DoctorOnlineForAndroid";
	public static final String FLASH_VERSION = "0.2.7";

	//	/*开发内网**/
//    public static String SERVICEURL = "http://192.168.1.25:8002/"; //医生端  账号系统 测试内网
//    public static String USER_PERSON_SERVICEURL = "http://192.168.1.25:8006/"; //个人端   测试内网
//    public static String DOCTOR_SERVICEURL = "http://192.168.1.25:8003/"; //医生端  医生系统 测试内网
//    public static String Net_SERVICEURL = "http://192.168.1.20/";//.net服务器 测试内网
//    public static String HTML_SERVICEURL = "http://192.168.1.25:8003/";//服务协议地址
//    public static String DOCTOR_YAOPIN_IMAGE = "http://192.168.1.25:8016/"; //医生团队药品库图片地址
//    public static String HEALTH_SERVICEURL = "http://192.168.1.25:8001/";//健康管理系统测试内网
//    public static int Push_Port = 1883;//测试
//    public static String Push_Service_Url = "tcp://192.168.1.25";    //内网
//    public static String LIVE_SERVICEURL = "http://114.119.4.25:38091/";
//

	//	public static int SOCKET_PORT = 7889;            //25上面的端口
	public static int SOCKET_PORT = 8889;            //24上面的端口

	//	public static String SOCKET_IP = "192.168.1.30"; //   192.168.1.30   192.168.3.6
	public static String SOCKET_IP = "192.168.2.38"; //   192.168.1.30   192.168.3.6
	public static String AnyChat_IP = "114.119.4.26";
	public static int AnyChat_Port = 8906;
	//
	public static String health_signkey = "f7fc9a2f83a3629a4401b9ce24264b95";

	//测试内网
	public static String SERVICEURL="http://192.168.1.26:8002/"; //医生端  账号系统 测试内网
	public static String DOCTOR_SERVICEURL="http://192.168.1.26:8003/"; //医生端  医生系统 测试内网
	public static String USER_PERSON_SERVICEURL="http://192.168.1.26:8006/"; //个人端   测试内网
	public static String Net_SERVICEURL = "http://192.168.1.24/";//.net服务器 测试内网
	public static String Push_Service_Url = "tcp://192.168.1.26";	//内网
	public static String HEALTH_SERVICEURL = "http://192.168.1.26:8001/";//健康管理系统测试内网
	public static String DOCTOR_YAOPIN_IMAGE="http://192.168.1.26:8016/"; //医生团队药品库图片地址
	public static int Push_Port = 1883;//测试
	public static String LIVE_SERVICEURL = "http://114.119.4.26:38091/";

	///*测试外网**/
//	public static String SERVICEURL="http://114.119.4.28:8808/"; //医生端  账号系统 测试外网
//	public static String DOCTOR_SERVICEURL="http://114.119.4.28:8806/"; //医生端  医生系统 测试外网
//	public static String Net_SERVICEURL = "http://test.youdeyi.com/";//.net服务器 测试外网
//	public static String HTML_SERVICEURL = "http://114.119.4.28:8806/";
//	public static String HEALTH_SERVICEURL = "http://114.119.4.28:8807/";//健康管理系统test外网
//
//	public static String Push_Service_Url = "tcp://114.119.4.28";	//test
//	public static int Push_Port = 1830;//test
//
//	public static String LIVE_SERVICEURL = "http://114.119.4.26:38091/";


	//正式外网
//	public static String SERVICEURL="http://114.119.4.28:6062/"; //账号系统
//	public static String DOCTOR_SERVICEURL="http://114.119.4.28:6071/"; //医生端APP
//	public static String USER_PERSON_SERVICEURL="http://114.119.4.28:6061/"; //个人端APP
//	public static String Net_SERVICEURL = "http://www.youdeyi.com/";//.net网络医院服务器
//	public static String Push_Service_Url = "tcp://msg.youdeyi.com";  //MQTT 推送
//	public static String HEALTH_SERVICEURL = "http://hm.youdeyi.com/";//健康管理系统
//	public static String DOCTOR_YAOPIN_IMAGE="http://doctor.youdeyi.com/"; //医生团队药品库图片地址
//	public static int Push_Port = 1803;//测试


	public static String getServiceURL() {
		return SERVICEURL;
	}

	public static String ImgUri = Net_SERVICEURL;
//	public static String Push_Password = "CXKUiB2gGaIVFJt2";//正式  或测试外网
//	public static String Push_Username = "infoadmin";

	public static String Push_Password = "123456";    //测试
	public static String Push_Username = "admin";
}
