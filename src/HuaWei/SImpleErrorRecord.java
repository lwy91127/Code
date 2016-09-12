package HuaWei;

import java.util.*;

/**
 * Created by lwy on 2016/9/1.
 */
public class SImpleErrorRecord {
    public static void main(String[] args) {
        LinkedHashMap hm=new LinkedHashMap<String, Integer>();
        Scanner scanner=new Scanner(System.in);

        while(scanner.hasNext()){
            String[] file=scanner.nextLine().split("\\\\");
            String filename=file[file.length-1];
            if(!hm.containsKey(filename)){
                hm.put(filename, 1);

            }else {
                int temp=(Integer)hm.get(filename);
                hm.put(filename, temp+1);
            }
        }
        scanner.close();

        for(int i=0; i<8;i++){
            Iterator key=hm.keySet().iterator();
            String max_file = null,temp;int num=0;
            while(key.hasNext()){
                temp=(String)key.next();
                if(num<(Integer)hm.get(temp))
                {max_file=temp;
                    num=(Integer)hm.get(temp);}

            }
            hm.remove(max_file);
            String[] maxfile=max_file.split(" ");
            String nameString=maxfile[0];
            if(nameString.length()>16)
                nameString=nameString.substring(nameString.length()-16);
            System.out.println(nameString+" "+maxfile[1]+" "+num);

        }
    }
}
