package Huawai;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author mac
 *         链接：https://www.nowcoder.com/questionTerminal/d3d8e23870584782b3dd48f26cb39c8f?answerType=1&f=discussion
 *         来源：牛客网
 * 
 *         { put('0', '0'); put('1', '8'); put('2', '4'); put('3', 'C');
 *         put('4', '2'); put('5', 'A'); put('6', '6'); put('7', 'E'); put('8',
 *         '1'); put('9', '9'); put('a', '5'); put('b', 'D'); put('c', '3');
 *         put('d', 'B'); put('e', '7'); put('f', 'F'); put('A', '5'); put('B',
 *         'D'); put('C', '3'); put('D', 'B'); put('E', '7'); put('F', 'F'); }
 */
public class StringOperations {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        Map<Character,Character> map = new HashMap<>();
            map.put('0', '0');
            map.put('1', '8');
            map.put('2', '4');
            map.put('3', 'C');
            map.put('4', '2');
            map.put('5', 'A');
            map.put('6', '6');
            map.put('7', 'E');
            map.put('8', '1');
            map.put('9', '9');
            map.put('a', '5');
            map.put('b', 'D');
            map.put('c', '3');
            map.put('d', 'B');
            map.put('e', '7');
            map.put('f', 'F');
            map.put('A', '5');
            map.put('B', 'D');
            map.put('C', '3');
            map.put('D', 'B');
            map.put('E', '7');
            map.put('F', 'F');
        
        while(scan.hasNext()){
            String first = scan.next();
            String second = scan.next();
            char[] cs = (first + second).toCharArray();
            char[] even = new char[cs.length/2];
            char[] odd = new char[cs.length - cs.length / 2];
            for(int i = 0,j=0,k=0; i<cs.length;i++){
                if(i%2 == 0){
                    odd[j] = cs[i];
                    j++;
                }else{
                    even[k] = cs[i];
                    k++;
                }
            }
            
            Arrays.sort(even);
            Arrays.sort(odd);
            
            StringBuilder sb = new StringBuilder();
            for(int i = 0,j=0,k=0; i<cs.length;i++){
                if(i%2 == 0){
                    char c = map.getOrDefault(odd[j],odd[j]);
                    sb.append(c);
                    j++;
                }else{
                   char c = map.getOrDefault(even[k],even[k]);
                    sb.append(c);
                    k++;
                }
            }
            
            System.out.println(sb.toString());
        }
        scan.close();
	}
}
