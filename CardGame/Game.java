import java.util.*;

//Here is the game for 24 point. We used 4 random card, use "+,-,*,/" four ways to get 24. 
//Not include "Jack", "Queen", "King", Aces is 1.

public class Game{

    //Use Set to remove duplicates;
    static Set<Stack<String>> hashSet = new HashSet<Stack<String>>();

    //The way that we may use
    static char[] syms = new char[]{'+', '-', '*', '/'};

    //Check whether the number has been accessed. true indicates yes, false does no.
    static boolean[] visited = new boolean[3];

    //The stack that loads the formula.
    static Stack<String> fu = new Stack<String>();

    //Build a double dimensional array to Load a fully permutation array of four numbers.
    //There are 24 ways of position. And 24=4*3*2*1
    static int[][] all = new int[24][];

    //All Indicates the index of the array.
    static int countOfall = 0;

    //Build a array to store the card
    static String[] suits={"Hearts", "Diamonds", "Clubs", "Spades"};

    //New a random to generate num
    static Random random=new Random();

    public static void main(String[] args){ //set up the random cards and suits.
        int[] nums = new int[4]; //set up number of cards, there are 4 cards.
        for (int i = 0; i < nums.length; i++){
            int i1 = random.nextInt(10)+1;
            //Store the num of card
            nums[i] = i1;
            String s = suits[i];
            System.out.println("The "+(i+1)+" random card is："+ s+ i1);//Output the random card.
        }

        //Generate the place of all card and store the place to the array that named all
        permutations(nums, 0, nums.length);       
        for (int i = 0; i < all.length; i++){
            int i1 = random.nextInt(4);
            int numOne = all[i][0];
            //Copy the remaining numbers to the array that named nums
            nums = Arrays.copyOfRange(all[i], 1, all[i].length);
            //Push the numOne to the Stack that named fu
            fu.push(Integer.toString(numOne));
            //Generate the resolve solution
            resolve(numOne, nums);
            //Pop the head of the Stack to achieve trace back
            fu.pop();
        }

        if (!hashSet.isEmpty()){ //Output all ways that match.
            for (Stack<String> st : hashSet){ //Using stack
                if (!st.isEmpty())
                    System.out.println(st);
            }
        } 
        else{//If the hashSet is EMPTY，then we have no solution to calculate the num of card to be 24
            System.out.println("no solution");
        }
    }

    //We use tracebacking to get all model of the nums
    public static void permutations(int[] nums, int start, int end){//Set the calculation mode
        if (start == end) {
            all[countOfall++] = Arrays.copyOf(nums, nums.length);//Using array get card.
        } 
        else {
            for (int i = start; i < end; i++){
                swap(nums, start, i);
                permutations(nums, start + 1, end);
                swap(nums, start, i);
            }
        }
    }

    //Swap place of nums[a] and nums[b]
    public static void swap(int[] nums, int a, int b){
        int t = nums[a]; 
        nums[a] = nums[b];
        nums[b] = t;
    }

    //To calculate the 24-point code, num is the first of four digits and nums loads the other three digits.
    //because division has to be divisible, so you have to make an extra judgment, 
    //and if it's not divisible, just drop the operation and break it out.

    //Num is the result of calculate
    public static void resolve(int num, int[] nums) { //There are four operations.
        //if the num is 24 and the size of fu is 7,we copy the stack to the hashSet
        if (num == 24 && fu.size() == 7){
            hashSet.add((Stack<String>) fu.clone());
            return;
        }
        //else if the size of fu is 7 but the num is not 24,we trace back
        else if (fu.size() == 7){ 
                    return;
        }

        for (int i = 0; i < nums.length; i++){
            //if the index has not been visited
            if (!visited[i]) {
                for (int j = 0; j < syms.length; j++){
                    int i1 = random.nextInt(3);
                    if (syms[j] == '+') { //set up for "+"
                        visited[i] = true;
                        fu.push("+");
                        fu.push(Integer.toString(nums[i]));
                        //Recursion
                        resolve(nums[i] + num, nums);
                        // Pop the '+' and nums[i] and set visited[i]=false to realize trace back
                        visited[i] = false;
                        fu.pop();
                        fu.pop();
                    } 
                    else if (syms[j] == '-'){ //set up for "-"
                        visited[i] = true;
                        fu.push("-");
                        fu.push(Integer.toString(nums[i]));
                        //Recursion
                        resolve(num - nums[i], nums);
                        // Pop the '-' and nums[i] and set visited[i]=false to realize trace back
                        visited[i] = false;
                        fu.pop();
                        fu.pop();
                    } 
                    else if (syms[j] == '*'){ //set up for "*"
                        visited[i] = true;
                        fu.push("*");
                        fu.push(Integer.toString(nums[i]));
                        //Recursion
                        resolve(nums[i] * num, nums);
                        // Pop the '*' and nums[i] to realize trace back
                        visited[i] = false;
                        fu.pop();
                        fu.pop();
                    } 
                    else{
                        //If it can  divide exactly
                        if (num % nums[i] == 0){ //set up for "/"
                            visited[i] = true;
                            fu.push("/");
                            fu.push(Integer.toString(nums[i]));
                            //Recursion
                            resolve(num / nums[i], nums);
                            // Pop the '/' and nums[i] to realize trace back
                            visited[i] = false;
                            fu.pop();
                            fu.pop();
                        }
                        else break;
                    }
                }
            }
        }
    }
}
