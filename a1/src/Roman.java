package Roman;

public class Roman {

    public static int charToint(char rom) {

        // get one char then put in switch case and give back number
        switch (rom) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }

    }


    public static boolean qualifySubtractingrules(Integer smaller, int larger ) {
        /*The subtractive principle of the Roman numeral system is a rule that 
        allows certain letters to represent subtracted values. In Roman numerals, 
        some letters are used to represent values that are subtracted from the next larger value to the left. */

        // so this function check if the roman number that we get violate this rule or not
        // base on what I understand, if the differrence is more than the its place then it's violate
        // like V (5) cannot be in front of C (100)
        
        // if (smaller < 9 && larger >10) {
        //     return false;

        // } else if (smaller < 90 && larger > 100) {
        //     return false;

        // } else if (((smaller - larger) == 5) || ((smaller - larger) == 50) || ((smaller - larger) == 500)) {
        //     return false;
        // }
        // else {
        //     return true;
        // }
        
        if (smaller < 9 && (larger >10 ||  smaller - larger > 10)) {
            return false;

        } else if (smaller < 90 && (larger > 100 || smaller - larger > 90)) {
            return false;

        } else if (((smaller - larger) == 5) || ((smaller - larger) == 50) || ((smaller - larger) == 500)) {
            return false;
        }
        else {
            return true;
        }

                
        // if (smaller < 9 && smaller - larger > 10) {
        //     return false;

        // } else if (smaller < 90 && smaller - larger > 90) {
        //     return false;

        // } else if (((smaller - larger) == 5) || ((smaller - larger) == 50) || ((smaller - larger) == 500)) {
        //     return false;
        // }
        // else {
        //     return true;
        // }

    }



    public static int romanToInt(String romanNum) {

        int length = romanNum.length();
        
        // // check if there is any repeated character 
        int count = 1;
        
        // // I I I I
        // // 0 1 2 3
        
        for (int i = 0; i < length; i++) {
            
            // check between string
            if (i != length-1) {
                char current = romanNum.charAt(i);
                char next = romanNum.charAt(i+1);
                
                if (current == next) {
                    // increment when the next one is the same
                    count++;
                    
                    // when the count == 4 means 
                    // this roman String has 4 of this specific letter
                    if (count == 4) {
                        return 0;
                    }
                    
                } else {
                    // if not the same then reset count
                    count = 1;
                }
            }
            
        }

        // if there are more than 1 letter then we have to check 
        // if the last letter is appropriate or not
        if (length > 1) {
            // check last letter ngub
            if (romanNum.charAt(length-2) == romanNum.charAt(length-1)) {
                
                // increment if same eek
                count++;
                
                if (count == 4) {
                    // against the subtractive principle of the Roman numeral system, give back 0 
                    return 0;
                }
                
            }
        }
        
        int res = 0; // for results

        // loop through String to evaluate each letter in the charToint func
        for (int i = 0; i < length ; i++){
            
            // compare with the next value, if it's less than
            // then subtract from the result
            
            // convert the letter we're dealing with to number that it's represented to
            int current_char_val = charToint(romanNum.charAt(i));

            // check if the current letter is put out of order notation
            // if (current_char_val > res) {
            //     return 0;
            // }

            if (i != (length - 1)) {

                // if i isn't at the end of the string then we can check the next letter
                int next_char_val = charToint(romanNum.charAt(i+1));

                // int diff = current_char_val - next_char_val;

                if (current_char_val < next_char_val){

                    // check against the rules, if the smaller num is too small to subtract to the larger num
                    if (qualifySubtractingrules(current_char_val, next_char_val)){
                        res -= current_char_val;
                    }
                    // against the subtractive principle of the Roman numeral system, give back 0 
                    else {
                        return 0;
                    }
                }

                else if (current_char_val == next_char_val) {
                    
                    if (current_char_val == 5 || current_char_val == 50 || current_char_val == 500) {
                        return 0;
                    }
                    else{
                        res += current_char_val;
                    }
                }

                // more than case
                else {
                    res += current_char_val;
                }
            
            } 
            
            // dealing w/last num
            else {
                res += current_char_val;
            }
        }

        // successfully convert and return the value
        return res;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("XM"));
        System.out.println(romanToInt("XXXX"));
        System.out.println(romanToInt("LL"));
        System.out.println(romanToInt("IC"));
        System.out.println(romanToInt("XM"));
        System.out.println(romanToInt("VX"));
        System.out.println(romanToInt("IVIV"));
        System.out.println(romanToInt("XIXL"));


        // should be num

        System.out.println("\nnumnow\n");
        System.out.println(romanToInt("CXXXIII"));
        System.out.println(romanToInt("XLII"));
        System.out.println(romanToInt("DCCVII"));
        System.out.println(romanToInt("MCMXCVII"));
        System.out.println(romanToInt("CCCXXXIII"));
        System.out.println(romanToInt("MCMXCVIII"));
        System.out.println(romanToInt("CMXCIX"));
        System.out.println(romanToInt("DCCCXVII"));
        System.out.println(romanToInt("MMXIX"));


        
        // Scanner sc = new Scanner(System.in);
        // String rom = sc.nextLine();

        // System.out.println(romanToInt(rom));

        // sc.close();
        



    }
}
