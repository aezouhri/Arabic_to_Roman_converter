import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Primary class for the S10_arabicToRomanGUI_Hard assignment for SWD Fall 2021.
 * @author aezouhri
 */
public class ArabicToRoman {
    /**
     * The variable arabic_to_roman is a TreeMap that contains multiple arabic number keys
     * and their roman number as values.
     */
    private final TreeMap<Integer,String> arabic_to_roman= new TreeMap<>();

    /**
     * The variable roman_to_arabic is a TreeMap that contains multiple roman number keys
     * and their arabic number as values.
     */
    private final TreeMap<String,Integer> roman_to_arabic=new TreeMap<>();

    /**
     * Arabic number either inputted or outputted.
     */
    private int arabic;

    /**
     * Roman number either inputted or outputted.
     */
    private String roman;

    /**
     * Getter for arabic number.
     * @return arabic
     */
    public int getArabic() {
        return arabic;
    }
    /**
     * Setter for arabic number
     * @param arabic number
     */
    public void setArabic(int arabic) {
        this.arabic = arabic;
    }

    /**
     * Getter for roman number.
     * @return roman
     */
    public String getRoman() {
        return roman;
    }

    /**
     * Setter for roman number.
     * @param roman number
     */
    public void setRoman(String roman) {
        this.roman = roman;
    }


    /**
     * Constructor for when an arabic number is the input. Constructs the TreeMap arabic_to_roman
     * and sets the input number as the arabic variable.
     * @param number is the user input to be converted in a roman number.
     */
    public ArabicToRoman(int number)
     {

         setArabic(number);

         arabic_to_roman.put(1000,"M");
         arabic_to_roman.put(900,"CM");
         arabic_to_roman.put(500,"D");
         arabic_to_roman.put(400,"CD");
         arabic_to_roman.put(100,"C");
         arabic_to_roman.put(90,"XC");
         arabic_to_roman.put(50,"L");
         arabic_to_roman.put(40,"XL");
         arabic_to_roman.put(10,"X");
         arabic_to_roman.put(9,"IX");
         arabic_to_roman.put(5,"V");
         arabic_to_roman.put(4,"IV");
         arabic_to_roman.put(1,"I");


     }


    /**
     * Constructor for when a roman number is the input. Constructs the TreeMap roman_to_arabic
     * and sets the input string as the roman variable.
     * @param text is the user input to be converted in an arabic number.
     */
    public ArabicToRoman(String text)
    {

        setRoman(text);

        roman_to_arabic.put("M",1000);
        roman_to_arabic.put("D",500);
        roman_to_arabic.put("C",100);
        roman_to_arabic.put("L",50);
        roman_to_arabic.put("X",10);
        roman_to_arabic.put("V",5);
        roman_to_arabic.put("I",1);


    }

    /**
     * Goal of this function is to convert an arabic number into a roman number.
     * To do so it will run itself and toRomanUsingInt recursively looking for the lowest key value in arabic_to_roman
     * until it can't anymore.
     * @return final converted roman number.
     */
    public String toRoman()
    {

        int number= getArabic();
        int temp=arabic_to_roman.floorKey(number);

        if(number==temp)
        {
            return arabic_to_roman.get(number);
        }

        return arabic_to_roman.get(temp)+ toRomanUsingInt(number-temp);

    }


    /**
     * Goal of this function is to convert an arabic number into a roman number.
     * To do so it will run itself and toRomanUsingInt recursively looking for the lowest key value in arabic_to_roman
     * until it cant anymore.
     * @param num leftover number from toRoman(), as the recursive function loops the arabic inputted number will get smaller
     *            after matching a key.
     * @return the current roman number ina string format we have reached so far.
     */

    public String toRomanUsingInt(int num)
    {

        int temp=arabic_to_roman.floorKey(num);

            if(num==temp)
            {
                return arabic_to_roman.get(num);
            }
        return arabic_to_roman.get(temp)+ toRomanUsingInt(num-temp);

    }


    /**
     * This function will convert a roman number to it's arabic equivalent.To do so it will check each
     * character of the inputted string and match it with it's value using the roman_to_arabic TreeMap.
     * Following that it will check whether if a value is less than the one on it's right to avoid issues like
     * IX= 9=10 and instead will compute the difference.
     *
     * @return final converted arabic number
     */
    public int toArabic()
    {
        int total_sum=0;

        char[] letters= getRoman().toCharArray();

        ArrayList<Integer> arabic_numbers= new ArrayList<>();

//Converts from letter to equivalent number while keeping the same order
        for(int i=0;i< letters.length;i++)
        {
            char letter= letters[i];

            Iterator iterator= roman_to_arabic.entrySet().iterator();

            while(iterator.hasNext())
            {

                Map.Entry map= (Map.Entry) iterator.next();
                String temp_letter= map.getKey().toString();

                if(letter==temp_letter.charAt(0))
                {

                    int temp_number= (int) map.getValue();
                    arabic_numbers.add(temp_number);

                }

            }

        }


        for(int j=0; j<arabic_numbers.size();j++)
        {


            int current_val=arabic_numbers.get(j);

            int next_val=0;

        if(j+1<arabic_numbers.size())
        {

            next_val=arabic_numbers.get(j+1);

            if(arabic_numbers.get(j)<next_val)
            {
                int final_number=next_val-current_val;
                int position=arabic_numbers.indexOf(next_val);
                arabic_numbers.add(position,final_number);
                arabic_numbers.remove(arabic_numbers.indexOf(next_val));
                arabic_numbers.remove(arabic_numbers.indexOf(current_val));

            }

        }


        }

        for(int i=0; i<arabic_numbers.size();i++)
        {
            total_sum+=arabic_numbers.get(i);
        }

        return total_sum;
    }

    /**
     * This function is used to check if the toArabic() converted the roman number correctly.
     * To do so it will run the toRoman() method using the output of toArabic() and compare the
     * output with the user original user input in toArabic()
     *
     * @return Will return true if the roman number has correctly been converted to arabic, false otherwise
     */
    public boolean toArabicChecker() {

        String roman_input = getRoman();
        int sum_from_toArabic = toArabic();

        ArabicToRoman test= new ArabicToRoman(sum_from_toArabic);

        String real_roman= test.toRoman();


        if (real_roman.equals(roman_input)) {
            return true;
        } else {
            return false;
        }
    }



}
