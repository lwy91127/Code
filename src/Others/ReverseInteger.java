package Others;

public class ReverseInteger {
	public static int reverseInteger(int x)
	{
		boolean negative = false;
		if(x < 0)
		{
			x = -x ;
			negative = true;
		}
		while(x%10 == 0)
			x = x/10;
		StringBuilder reverseInt = new StringBuilder();
		System.out.println(x);
		while(x != 0)
		{
			reverseInt.append(x%10);
			x = x/10;
		}
		System.out.println(reverseInt);
		int result = 0;
		try{
			result = Integer.parseInt(reverseInt.toString());
		}
		catch(NumberFormatException e)
		{
			return 0;
		}
		
		return negative ? -result:result;
	}
	public static int reverse(int x) {
        long ret=0;
        while(x!=0)
        {
            ret=x%10+ret*10;
            x=x/10;
        }
        if((ret>Integer.MAX_VALUE||ret<Integer.MIN_VALUE))
            return 0;
        return (int)ret;
    }
	public static void main(String[] args) {
		//System.out.println(reverseInteger(-10000000));
		System.out.println(reverse(-1000000003));
	}
}
