package Huawai;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ErrorsRecord {
	public static class ErrosFile {
		int index;
		String name;
		int row;

		public ErrosFile(int index, String name, int row) {
			this.index = index;
			this.name = name;
			this.row = row;
		}

		@Override
		public String toString() {
			return name + " " + row;
		}

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<>();
        while(scan.hasNext()){
            String[] strs = scan.nextLine().split("\\s+");
            String fileName = strs[0].substring(strs[0].lastIndexOf("\\"));
            fileName = fileName.length()>16 ? fileName.substring(fileName.length()-16) : fileName;
            String complet = fileName + " " + strs[1];
            if(map.containsKey(complet)){
                map.put(complet, map.get(complet) + 1);
            }else{
                map.put(complet, 1);
            }
        }
        int count = 0;
         for(Map.Entry<String, Integer> it : map.entrySet()){
             if(map.size()-count<=8){
                 System.out.println(it.getKey() + " " + it.getValue());
             }
             count++;
         }
     }

}
