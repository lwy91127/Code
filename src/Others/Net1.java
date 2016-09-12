package Others;

import org.junit.Test;

import java.util.Scanner;

/**
 * Created by lwy on 2016/3/1.
 */
public class Net1 {
    public static int solution(){
        Scanner sc = new Scanner(System.in);
        String firstline = sc.nextLine();
        int num = Integer.parseInt(firstline.split(" ")[0]);
        int initCap = Integer.parseInt(firstline.split(" ")[1]);
        String secondline = sc.nextLine();
        String[] masters = secondline.split(" ");
        for(int i = 0 ; i < num;i++){
            int masterCap = Integer.parseInt(masters[i]);
            if(initCap >= masterCap){
                initCap += masterCap;
            }else{
                initCap += getGCD(initCap,masterCap);
            }
        }

        return initCap;
    }

    private static int getGCD(int a,int b){
        while(a%b != 0){
            int temp = a%b;
            a = b;
            b = temp;
        }
        return  b;
    }

    public static void main(String[] args) {
        System.out.println(solution());
    }
}



