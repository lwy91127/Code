package Others;

import Utils.MyUtils;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by lwy on 2016/9/5.
 */
public class Fishing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            int t = scanner.nextInt();
            double[][] p = new double[n][m];
            double sum = 0;
            scanner.nextLine();
            for(int i = 0;i<n;i++){
                String line = scanner.nextLine();
                String[] lines = line.split(" ");
                for(int j = 0;j<m;j++){
                    p[i][j] = Double.parseDouble(lines[j]);
                    sum += p[i][j];
                }
            }
            double pss = (sum/(n*m));
            double pcc = p[x][y];
            if(pcc  == pss) {
                System.out.println("equal");
                System.out.printf("%.2f\n",1 - Math.pow(1-pcc,t));
            }
            else if(pcc > pss) {
                System.out.println("cc");
                System.out.printf("%.2f\n",1 - Math.pow(1-pcc,t));
            }
            else {
                System.out.println("ss");
                System.out.printf("%.2f\n",1 - Math.pow(1-pss,t));
            }
        }
    }
}
