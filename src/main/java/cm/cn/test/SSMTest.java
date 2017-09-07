package cm.cn.test;

import org.junit.Test;

import cm.cn.util.StaticInfo;

public class SSMTest {
	@Test
	public void testSessioId(){
		StaticInfo.sessionid = 9;
		System.out.println(StaticInfo.sessionid);
	}
}
