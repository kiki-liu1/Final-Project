//Xuanxi Liu
//CSC 145 Lab 5:Towers of Hanoi 
//This program is using recursive to solve tower of hanoi problem.
//Given 4 disks stacked on three towers.

public class TowersOfHanoi{
   public static void main(String args[]){
		int n = 4; //Set up number of disks. We can change the n. For this lab is 4.
		TowerOfHanoi(n, 'A', 'C', 'B'); // Set up the three towers:A, B, C.(from left to right)
	}

	public static void TowerOfHanoi(int n, char source_tower, char target_tower, char spare_tower){
   //Set up the source, spare, and target rod.
      //using recursion:
		if (n == 1){ 
         //The first step of moving. Moving the 1st disk from source tower to target tower.
			System.out.println("Move disk 1 from tower " + source_tower + " to tower " + target_tower);
			return;
		}
		else{ //for next step.
         //Move top (n-1) disks from A to C using B as spare tower.
         TowerOfHanoi(n-1, source_tower, spare_tower, target_tower);   
         //Move last disk (n) from A to C.
		   System.out.println("Move disk " + n + " from tower " + source_tower + " to tower " + target_tower); 
		   //Move (n-1) from B to C, A is spare tower.
         TowerOfHanoi(n-1, spare_tower, target_tower, source_tower);
      }
	}
}
