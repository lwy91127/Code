package Others;

public class LongestPalindrome {
	public static void main(String[] args) {
		String s = "abba";
		//System.out.println(longestPalindrome(s));
		System.out.println(findLongestPalindrome2(s));
	}
	public static String findLongestPalindrome(String s)  
	{  
	    int length=s.length();  
	    int maxlength=0;  
	    int start = 0;  
	    if(length == 1) return s;
	    for(int i=0;i<length;i++)//长度为奇数  
	    {  
	    	if (s.length() - i <= maxlength / 2) break;
	        int j=i-1,k=i+1;  
	        while(j>=0 && k<length && s.charAt(j)==s.charAt(k))  
	        {  
	            if(k-j+1>maxlength)  
	            {  
	                maxlength=k-j+1;  
	                start=j;  
	            }  
	            j--;  
	            k++;  
	        }  
	    }  
	    for(int i=0;i<length;i++)//长度为偶数  
	    {  
	    	if (s.length() - i <= maxlength / 2) break;
	        int j=i,k=i+1;  
	        while(j>=0 && k<length && s.charAt(j)==s.charAt(k))  
	        {  
	            if(k-j+1>maxlength)  
	            {  
	                maxlength=k-j+1;  
	                start=j;  
	            }  
	            j--;  
	            k++;  
	        }  
	    }  
	    if(maxlength>0)  
	        return s.substring(start,maxlength+start);  
	    return "";  
	} 
	public static String findLongestPalindrome2(String s)
	{
		int length = s.length();
		if(length == 0) return "";
		if(length == 1) return s;
		int start = 0,maxlength = 1;
		for(int i = 0;i<length;)
		{
			if(length - i <= maxlength/2) break;
			int l = i,r = i;
			while(r < length - 1 && s.charAt(r) == s.charAt(r+1)) r++;
			i = r+1;
			while(l > 0 && r <length -1 && s.charAt(l-1) == s.charAt(r+1))
			{
				l--;
				r++;
			}
			int newMaxlength = r -l +1;
			if(newMaxlength > maxlength) 
			{
				start = l;
				maxlength = newMaxlength;
			}
		}
		return s.substring(start, maxlength+start);
	}
}
