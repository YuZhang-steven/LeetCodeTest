package CodeTest;
//give a array list, count how many number pairs only have one digit different.

//go through whole list, each list compare with other. n(n-1)/2
//for each pair, only consider the situation : two number is not same and their length should same
//build a array with 10 cell.
//get all digits of number a, add each of them to the counting array.
//get all digits of number b, minus each of them in counting array.
//when any cell in the array becomes -1, we record one.
//we only add counting, when there is only one -1 cell.
public class AlmostSame {
    public static int countEqual(int[] numbers) {
        int count = 0;//result counting
        //go through the list
        for (int i = 0; i < numbers.length; i++) {
            int[] freq = new int[10];//build a new counting list
            int a = numbers[i];
            String s0 = Integer.toString(a); //change it to string to comparing length later.
            //get each digits of an number and add it to list.
            while (a > 0) {
                freq[a % 10] += 1;
                a /= 10;
            }
            // go through the number in the later.
            for (int j = i + 1; j < numbers.length; j++) {
                //if two number same, we jump
                if (numbers[i] != numbers[j]) {
                    int b = numbers[j];
                    //change to string co comparing length, we only consider the situation that length is same.
                    String s1 = Integer.toString(b);
                    if (s1.length() == s0.length()) {
                        //copy the list, becuase we need to change it.
                        int[] freq2 = freq.clone();
                        int diff = 0;// a small counting
                        //get all digits of the number 2
                        while (b > 0) {
                            freq2[b % 10] -= 1;
                            //if any cell in the list become negtive, we record.
                            if (freq2[b % 10] < 0) { diff++; }
                            b /= 10;
                        }
                        //System.out.println("i" + numbers[i] + " j" + numbers[j] + " diff " + diff);
                        //only when diffirence is 1, we add counting.
                        if(diff == 1) { count++; }
                    }
                }
            }
        }

        return count;
    }



    public static void main(String[] args) {
        // write your code here
        int[] test1 = new int[]{121, 131, 112, 121, 212, 132, 221};
        int result = countEqual(test1);
        System.out.println(result);
    }
}
