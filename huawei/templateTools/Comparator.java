
//length 再按字典序
Collections.sort(list,new Comparator<String>(){
	public int compare(String s1,String s2){
		if(s1.length()!=s2.length())
			return s2.length()-s1.length();
		else
			return s1.compareTo(s2);
	}
});
//map value
List<Map.Entry<String,Integer> > list = new ArrayList<Map.Entry<String,Integer> >(oldMap.entrySet());
Collections.sort(list,new Comparator<Map.Entry<String,Integer> >(){
	public int compare(Map.Entry<String,Integer> o1,Map.Entry<String,Integer> o2){
		return o2.getValue()-o1.getValue();//desc
	}
});