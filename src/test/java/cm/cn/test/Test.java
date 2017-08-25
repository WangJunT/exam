package cm.cn.test;


import cm.cn.util.Base64;

public class Test {
	@org.junit.Test
	public void testPass(){
		String pass = "jianshe824";//emplZHVqaWFuc2hlODI0Y24=
		String pass1= "zjjsedu";
//		String password = Base64.encode(("zjedu"+pass+"cn").getBytes());
		String password = Base64.encode(("zjedu"+pass1+"cn").getBytes());
		System.out.println(password);
		/**
		 * admin    123456
		 * teacher  jianshe824
		 * jianshe  zjjsedu
		 */
	}
}
