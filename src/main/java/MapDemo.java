/**
 * @ version 1.0
 * @ author dbxiao
 */


import java.util.Iterator;
import java.util.TreeMap;

public class MapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap<String,String> map=new TreeMap<>();
		map.put("a", "aaaa");
		map.put("d", "dddd");
		map.put("c", "cccc");
		map.put("b", "bbbb");
		Iterator<String> i=map.keySet().iterator();
		while(i.hasNext()){
			String a=i.next();
			System.out.println(map.get(a));
		}
	}

}
