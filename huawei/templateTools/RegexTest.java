import java.util.*;
public class RegexTest {

	public static void main(String[] args) {

		//,
		String sourceStr="1,2,3,,,4,5";
  		String[] sourceStrArray=sourceStr.split(",+");
  		System.out.println(Arrays.toString(sourceStrArray));
  		//.
  		String value = ".192..168.128...33.";
		String[] names = value.split("\\.+");
  		System.out.println(Arrays.toString(names));

  		str.split("\\|");
  		str.split("\\*");
  		str.split("\\+");
  		filefullname.split("\\\\");

  		"Java string-split#test".split(" |-|#")

		//one character
		System.out.println("a".matches("."));
		// 0~1 a
		System.out.println("a".matches("a?"));
		// 1~N a
		System.out.println("aaaa".matches("a+"));
		// 0~N a
		System.out.println("".matches("a*"));
		// 1~N q and 1 0~9 digit
		System.out.println("qqqqqq3".matches("q+[0-9]"));
		// 12~100 cnt
		System.out.println("12345667890123".matches("\\d{12,100}"));
		// 0~3 digit .delimit
		System.out.println("192.168.0.1"
				.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"));
		// 0~2,0~9,0~9
		System.out.println("192".matches("[0-2][0-9][0-9]"));
		// 4 space
		System.out.println(" \n\r\t".matches("\\s{4}"));
		// \
		System.out.println("\\".matches("\\\\"));
		// h start ,0~N char,o end
		System.out.println("hello".matches("^h.*o$"));
		//  h start ,1~3 a-z,o,blank,0~N char,d end 
		System.out.println("hello world".matches("^h[a-z]{1,3}o\\b.*d$"));
		System.out.println("   \n".matches("^[\\s&&[^\\n]]*\\n$"));
		// 0~N char,4 digit one char
		System.out.println("aaa 2222q".matches(".*\\d{4}."));
	}

}