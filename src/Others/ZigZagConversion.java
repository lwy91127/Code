package Others;

import java.util.ArrayList;
import java.util.List;


public class ZigZagConversion {
	public static String zigzagConversion(String s,int numRows)
	{
		List<StringBuilder> strList = new ArrayList<StringBuilder>();
		for(int i = 0;i<numRows;i++)
		{
			strList.add(new StringBuilder());
		}
		int n = 0;
		int d = 1;
		for(int j = 0;j<s.length();j++)
		{
			strList.get(n).append(s.charAt(j));
			if(n<numRows -1 && d == 1)
				n++;
			else if(n == numRows -1 && d == 1 && n-1>=0)
			{
				n--;
				d = -1;
			}
			else if(n > 0 && d == -1)
			{
				n--;
			}
			else if(n == 0 && d == -1 && n+1 <= numRows-1)
			{
				n++;
				d = 1;
			}	
		}
		StringBuilder result = new StringBuilder();
		for(StringBuilder l:strList)
		{
			result.append(l);
		}
		return result.toString();
	}
	
	public static String convert(String s, int numRows){
	    List<StringBuilder> strList = new ArrayList<StringBuilder>();
	    if(numRows == 1) return s;
	    int i = 0;
	    for(int n = 0;n<numRows;n++)
	    {
	    	strList.add(new StringBuilder());
	    }
	    while(i < s.length())
	    {
	    	for(int j = 0;i<s.length() && j<numRows;j++)
	    	{
	    		System.out.println(i);
	    		strList.get(j).append(s.charAt(i));
	    		i++;
	    	}
	    	for(int j = numRows - 2;j>0 && i<s.length();j--)
	    	{
	    		strList.get(j).append(s.charAt(i));
	    		i++;
	    	}
	    }
	    StringBuilder result = new StringBuilder();
	    for(StringBuilder l:strList)
	    {
	    	result.append(l);
	    }
	    return result.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(convert("AB", 2));
	}
}
