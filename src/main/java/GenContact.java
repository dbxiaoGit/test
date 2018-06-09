import java.io.FileWriter;
import java.net.URLEncoder;
import java.text.DecimalFormat;

public class GenContact {

	public static void main(String[] args) throws Exception {

	
/*		int a0 = 0x4e00 + (int) (Math.random() * (0x9fa5 - 0x4e00 + 1));
		char a = (char) a0;
		System.out.println(a);
		char[] a1 = {a};
		System.out.println(new String(a1).getBytes("utf-8"));
		System.out.println(URLEncoder.encode(new String(a1),"utf-8"));
        System.out.println(a);
        System.out.println(getUtf8String());*/
		FileWriter fw = new FileWriter("d:/contact.vcf");
		for(int i=0;i<1000 ;i++) {
			fw.append("BEGIN:VCARD\nVERSION:2.1\n");
			String data1 = getUtf8String();
			String data2 = getUtf8String();
			String data3 = getMobile(i);
			String line1 = String.format("N;CHARSET=UTF-8;ENCODING=QUOTED-PRINTABLE:=E5=B0=B9;%s;%s;;\n", data1,data2);
			String line2 = String.format("FN;CHARSET=UTF-8;ENCODING=QUOTED-PRINTABLE:=E5=B0=B9%s%s\n", data1,data2);
			String line3 = String.format("TEL;CELL:%s\nEND:VCARD\n", data3);
			fw.append(line1);
			fw.append(line2);
			fw.append(line3);
		}
		fw.close();

	}
	
	public static String getUtf8String() throws Exception {
		int a0 = 0x4e00 + (int) (Math.random() * (0x9fa5 - 0x4e00 + 1));
		char a = (char) a0;
		char[] a1 = {a};
		String result = URLEncoder.encode(new String(a1),"utf-8").replaceAll("%", "=");
		return result;
		
	}
	
	public static String getMobile(int n) throws Exception {
		DecimalFormat df = new DecimalFormat("13000000000");
		String result = df.format(n);
		return result;
		
	}

}
