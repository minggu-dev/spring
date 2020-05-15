package kosta.exam;

public class MainApp {
	public static void main(String[] args) {
		String path = LogTest.class.getClassLoader()
	            .getResource("log4j.properties")
	            .getFile();
	System.setProperty("java.util.logging.config.file", path);
		new LogTest().log();
	}
}
