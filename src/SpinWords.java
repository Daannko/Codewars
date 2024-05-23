public class SpinWords {


    public static String spin(String word)
    {
        String new_word = new String();
        for(int i = word.length() -1 ; i >0 ; i--)
        {
            new_word = new_word + word.charAt(i);
        }
        return new_word;
    }


    public static String spinWords(String sentence) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() < 5) continue;
            words[i] = spin(words[i]);
        }
        return words.toString();
    }

    public void main()
    {
        spinWords("Co tam u ciebie");
    }
}