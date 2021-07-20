package CodeTest;
// reverse all number in a list, if number begin with "0" add all "0" to the end. 1200 reverse will be 2100
// add all number in that list.

//remove all the zero in the end, and record a number
//modular get all digits of a number.
//add it to a new recorder number and multi 10.
//in the end multi 10 for every zero in the end.
public class ReverseAndAdd {
    public static int reverseAdd(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int rev = 0;//the new number
            int zero = 0;//the number of zero in the end

            //modular get digit. the condition is 0, becuase the last opration will be only one digit, and
            //we still need get that digit.
            while (numbers[i] > 0) {
                int j = numbers[i] % 10; //modular get the digit of number
                //remove the begining 0. we use rev to check if the zero in the begin.
                if (rev == 0 && j == 0) { zero++; }
                rev *= 10; // we multiply 10 to move the digit to left. if last one is 0, it is still works, but the begining 0 will not work.
                rev += j; //after move digit, we add the number.
                numbers[i] /= 10; // remove one digit.
            }
            //after get the final number, we add all zero back by move digit left(multi 10)
            while ( zero > 0) {
                rev *= 10;
                zero--;
            }
            numbers[i] = rev;//replace the number.
            System.out.println("reverse number:" + rev);

        }

        int result = 0;
        for (int x : numbers) {
            result += x;
        }
        return result;

    }
    public static void main(String[] args) {
        // write your code here
        int[] test1 = new int[]{ 714, 150, 102, 200, 1002};
        int result = reverseAdd(test1);
        System.out.println(result);
        System.out.println(714 + 150 +102 +200+1002);
    }
}
