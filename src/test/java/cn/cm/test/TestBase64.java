package cn.cm.test;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import cm.cn.util.Base64;


public class TestBase64 {
	@Test
	public void base64Test() throws UnsupportedEncodingException{
		//emhlamlhbmdqaWFuc2hlMTYzLmNvbToxMjM0NTY=
		//emhlamlhbmdqaWFuc2hlKEAxMjM0NTYqKQ=="+123456+"
		String str = Base64.encode(("zjedu"+123456+"cn").getBytes());
		System.out.println(str);
	}
}
