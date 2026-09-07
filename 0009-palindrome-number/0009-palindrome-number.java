class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers ya 0 se end hone wale (except 0 khud) palindrome nahi
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        
        int reverted = 0;
        while (x > reverted) {
            reverted = reverted * 10 + x % 10;
            x /= 10;
        }
        
        // Even length: x == reverted
        // Odd length: beech ka digit reverted mein extra hai, isliye reverted / 10
        return x == reverted || x == reverted / 10;
    }
}