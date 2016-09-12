package Others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;


public class Solution {
	public static int ladderLength(String start, String end, Set<String> dict){
		dict.add(end);
		HashMap<String, Integer> si = new HashMap<String, Integer>();
		ArrayList<Set> charlist = init(dict);
		System.out.println(charlist);
		if(dict.isEmpty()) return 0;
		dict.remove(start);
		Queue<String> queue = new LinkedList<String>();
		queue.offer(start);
		si.put(start, 1);
		while(!queue.isEmpty())
		{
			String s = queue.peek();
			System.out.println(s);
			queue.poll();
			for(int i = 0;i<s.length();i++)
			{
				String curS = s;
				for(char c:(HashSet<Character>)charlist.get(i))
				{
					char[] curSA = curS.toCharArray();
					curSA[i] = c;
					curS = new String(curSA);
					if(curS.equals(end)) 
						return si.get(s)+1;
					if(dict.contains(curS))
					{
						si.put(curS, si.get(s)+1);
						queue.offer(curS);
						dict.remove(curS);
					}
				}
			}
		}
		return 0;
	}
	private static ArrayList<Set> init(Set<String> dict) {
		ArrayList<Set> charlist = new ArrayList<Set>();
		int leng = dict.iterator().next().length();
		for(int i=0;i<leng;i++)
		{
			HashSet<Character> charset = new HashSet<Character>();
			for(String s:dict)
			{
				charset.add(s.charAt(i));
			}
			charlist.add(charset);
		}
		return charlist;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String start = s.nextLine();
		String end = s.nextLine();
		String[] d = s.nextLine().split(" ");
		Set<String>	dict = new HashSet<String>(Arrays.asList(d));
		System.out.println(ladderLength(start, end, dict));
	}
}
