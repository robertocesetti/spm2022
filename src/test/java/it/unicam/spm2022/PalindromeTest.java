package it.unicam.spm2022;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PalindromeTest {

    /**
     * It tests if the isPalindrome method of the class Palindrome return true if a string is palindrome
     */
    @ParameterizedTest
    @ValueSource(strings = {"recacer", "anna"})
    void shouldReturnTrueIfPalindrome(String candidates){
        Palindrome palindromes = new Palindrome();
        Assertions.assertTrue(palindromes.isPalindrome(candidates));
    }
}
