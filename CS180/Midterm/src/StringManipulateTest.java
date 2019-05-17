import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Student test cases for Q2 - StringManipulate
 */
public class StringManipulateTest {

    @Test
    public void testRemoveVowelsNull() {
        String message = "StringManipulate::removeVowels test return value when input string is null";
        assertEquals(message, null, StringManipulate.removeVowels(null));
    }

    @Test
    public void testRemoveVowelsEmptyString() {
        String message = "StringManipulate::removeVowels test return value when input string is empty";
        assertEquals(message, "", StringManipulate.removeVowels(""));
    }

    @Test
    public void testRemoveVowelsNonExistent() {
        String message = "StringManipulate::removeVowels test return value when" +
                " there are no vowels in the input String";
        assertEquals(message, "smthngwfl",  StringManipulate.removeVowels("smthngwfl"));
    }

    @Test
    public void testRemoveVowelsOneOccurrence() {
        String message = "StringManipulate::removeVowels test case when" +
                " there is only one vowel";
        assertEquals(message, "smthngwfl", StringManipulate.removeVowels("somthngwfl"));
    }

    @Test
    public void testRemoveVowelsTwoOccurrences() {
        String message = "StringManipulate::removeVowels test case when" +
                " there are two vowels.";
        assertEquals(message, "smthngwfl", StringManipulate.removeVowels("smethingwfl"));
    }

    @Test
    public void testRemoveVowelsManyOccurrences() {
        String message = "StringManipulate::removeVowels test case when" +
                " there are many vowels.";
        String input = "how who what when where wow world wide web";
        String expected = "hw wh wht whn whr ww wrld wd wb";
        assertEquals(message, expected, StringManipulate.removeVowels(input));
    }

    @Test
    public void testRemoveVowelsManyConsecutiveOccurrences() {
        String message =  "StringManipulate::removeVowels test case when" +
                " there are many consecutive vowels";
        String input = "whaaeeeiioouaiueouat";
        String expected = "wht";
        assertEquals(message, expected, StringManipulate.removeVowels(input));
    }

    @Test
    public void testRemoveVowelsManyConsecutiveOccurrences2() {
        String message =  "StringManipulate::removeVowels test case when" +
                " there are many consecutive occurrences of the same vowel";
        String input = "whaaaaaaat";
        String expected = "wht";
        assertEquals(message, expected, StringManipulate.removeVowels(input));
    }

    @Test
    public void testRemoveVowelsBeginning() {
        String message =  "StringManipulate::removeVowels test case when" +
                " vowel is at the beginning of the string";
        assertEquals(message, "n dctn", StringManipulate.removeVowels("an dctn"));
    }

    @Test
    public void testRemoveVowelsEnd() {
        String message =  "StringManipulate::removeVowels test case when" +
                " vowel is at the end of the string";
        assertEquals(message, "my hs", StringManipulate.removeVowels("my hse"));

    }

    @Test
    public void testRemoveVowelsIgnoreCaseToCompare() {
        String message = "StringManipulate::removeVowels test that you ignore case of vowels to remove them";
        assertEquals(message, "th ln kng", StringManipulate.removeVowels("thE lIon king"));
    }

    @Test
    public void testRemoveVowelsIgnoreCaseToCompare2() {
        String message = "StringManipulate::removeVowels test that you ignore case of vowels to remove them";
        assertEquals(message, "th ln qn", StringManipulate.removeVowels("the liOn qUeEn"));
    }

    @Test
    public void testRemoveVowelsKeepOriginalCase() {
        String message = "StringManipulate::removeVowels test that you keep original case for non-removed chars";
        assertEquals(message, "Th Ln Kng", StringManipulate.removeVowels("The Lion King"));
    }

    @Test
    public void testRemoveVowelsIgnoreCaseToCompareKeepOriginalCase() {
        String message = "StringManipulate::removeVowels test that you ignore case of vowels but keep original case";
        assertEquals(message, "My ndrgrd n Prd CS", StringManipulate.removeVowels("My Undergrad In Purdue CS"));
    }

    @Test
    public void testRemoveVowelsOnlyOneChar() {
        String message = "StringManipulate::removeVowels test case when there is only one character and it needs to be removed";
        assertEquals(message, "", StringManipulate.removeVowels("a"));
    }

    @Test
    public void testRemoveVowelsAllChars() {
        String message = "StringManipulate::removeVowels test case when all chars need to be removed";
        assertEquals(message, "", StringManipulate.removeVowels("aioeoaeiou"));
    }

}