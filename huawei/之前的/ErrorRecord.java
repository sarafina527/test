import java.util.*;

public class Main{

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Map<String,Integer> record = new LinkedHashMap<String,Integer>();
		while(input.hasNext()){
			String filefullname = input.next();
			int rownum = input.nextInt();
			String[] tmp = filefullname.split("\\\\");
			String fr = tmp[tmp.length-1]+" "+rownum;
			if(record.containsKey(fr))
				record.put(fr,record.get(fr)+1);
			else
				record.put(fr,1);
			
		}
		//System.out.println(record);
        List<Map.Entry<String,Integer> > entrys = new ArrayList<Map.Entry<String,Integer> >(record.entrySet());
		Collections.sort(entrys,new Comparator<Map.Entry<String,Integer> >(){
        	public int compare(Map.Entry<String,Integer> o1,Map.Entry<String,Integer> o2){
        		return o2.getValue()-o1.getValue();
        	}
        });
        //System.out.println(entrys);
        int i=0;
		for(Map.Entry<String,Integer> e:entrys){			
			String[] namerow = (e.getKey()).split(" ");
			String name = namerow[0];
			if(name.length()>16){
				name = name.substring(name.length()-16);
			}
			System.out.println(name+" "+namerow[1]+" "+e.getValue());
            if(++i>=8) break;
		}		
	}
}