package loops.forloop;

public class OddNumbersDivisibleBy3 {
    public static void main(String[] args){
        for(int i=1; i<=45; i+=2){
            if(i%3==0) System.out.print(i+" ");
        }
    }
}
