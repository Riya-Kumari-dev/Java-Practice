package dsa.bitmanipulation;

public class BehaviorOfOperators {
    static void main(String[] args) {
        /* &
        -> If both 1 then 1 else 0
        => a & 1 = a  (a belongs to {0, 1})
        => a & 0 = 0
        -> use when we need to turn off the bit
        * */
        System.out.println(34 & 1);

        /* |
        -> if both 0 then 0 else 1
        => a | 0 = a
        => a | 1 = 1
        -> to turn on a bit
        */
        System.out.println(20 | 1);

        /* ^
        -> if both bits same then 0 else 1
        => a ^ 0 = a
        => a ^ 1 = ~a (flipped a)
        * */
        System.out.println(21 ^ 1);

        /* Right shift (>>)
        a >> 1 ; here 1 is the number of bits to be shifted or removed from right.
        * */
        System.out.println(23 >> 2);

        /*Left shift (<<)
        a << 2 ; here 2 is number of bits to be shifted from left.
        */
        System.out.println(43 << 1);
    }
}