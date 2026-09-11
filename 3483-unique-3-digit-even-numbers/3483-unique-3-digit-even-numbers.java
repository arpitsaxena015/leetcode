class Solution {
    public int totalNumbers(int[] digits) {
       
        int[] availableCount = new int[10];
        for (int digit : digits) {
            availableCount[digit]++;
        }
        
        int validNumbersCount = 0;
        
        for (int num = 100; num < 1000; num += 2) {
            
            
            int hundreds = num / 100;
            int tens = (num / 10) % 10;
            int ones = num % 10;
            
            availableCount[hundreds]--;
            availableCount[tens]--;
            availableCount[ones]--;
            
           
            if (availableCount[hundreds] >= 0 && 
                availableCount[tens] >= 0 && 
                availableCount[ones] >= 0) {
                validNumbersCount++;
            }
            
            
            availableCount[hundreds]++;
            availableCount[tens]++;
            availableCount[ones]++;
        }
        
        return validNumbersCount;
    }
}