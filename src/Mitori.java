import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Mitori {
    public static void main(String[] args) {
        int digits,numbers;
        if(args.length<2){
            System.out.println("引数が足りません。\nmitori int桁数 int問題数 [boolean引き算を含むか]\nの形で入力してください。\n第三引数は省略した場合trueになります。");
            return;
        }
        try{
            digits=Integer.parseInt(args[0]);
            numbers=Integer.parseInt(args[1]);
        }catch (NumberFormatException e){
            System.out.println("引数の型が違います。\nmitori int桁数 int問題数 [boolean引き算を含むか]\nの形で入力してください。\n第三引数は省略した場合trueになります。");
            return;
        }

        boolean negative=true;
        if(args.length>2){
            negative=Boolean.parseBoolean(args[2]);
        }
        Random rnd=new Random();
        long min= (long) Math.pow(10,digits-1);
        long ans=0;
        for(int i=0;i<numbers;i++){
            long num=rnd.nextLong(min*9)+min;
            if(negative&&rnd.nextInt(5)==0)num*=-1;
            ans+=num;
            System.out.printf("%"+(digits+1)+"d\n",num);
        }
        Scanner sc=new Scanner(System.in);
        long response;
        try{
            response=sc.nextLong();
        }catch (InputMismatchException e){
            System.out.println("なんじゃそら！");
            return;
        }
        System.out.println(response==ans?"正解！":"ざんねん...");
        System.out.printf("答えは %d でした\n",ans);
        sc.close();
    }
}