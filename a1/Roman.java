public class Roman {
    
// check if, maybe while loop is more practical
    // if curr is less than next, check the rules, subtract to the next and then plus it to the res


    // else if curr equal to next, check the next.next number if still equal then sum it up, but at one point that it's 4 times in a row break it 
        
        // if not more than 4 then plus the count var to the index var, so we dont go through what we've checked alr
        
        
    // else if more than then just + normally to the result

    public static int charToint(char rom) {

        // get one char then put in switch case and give back number
        switch (rom) {

            // Upper-case
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;

            // Lower-case
            case 'i': return 1;
            case 'v': return 5;
            case 'x': return 10;
            case 'l': return 50;
            case 'c': return 100;
            case 'd': return 500;
            case 'm': return 1000;
            default: return 0;

        }

    }

    public static boolean qualifySubtractingrules(Integer smaller, int larger ) {
        /*The subtractive principle of the Roman numeral system is a rule that 
        allows certain letters to represent subtracted values. In Roman numerals, 
        some letters are used to represent values that are subtracted from the next larger value to the left. */

        // so this function check if the roman number that we get violate this rule or not T if doesnt violate, F if does violate
        // base on what I understand, if the differrence is more than the its place then it's violate
        // like V (5) cannot be in front of C (100)
        // also you cannot just make a number that exist alr by subtraction
        
        if (smaller == 1 && (larger - smaller) > 9) {
            return false;

        } else if (smaller == 10 && (larger - smaller) > 90) {
            return false;

        } else if (((larger - smaller) == 5) || ((larger - smaller) == 50) || ((larger - smaller)== 500)) {
            return false;
        }
        else {
            return true;
        }
        
    }

    public static int romanToInt(String romanNum) {

        int length = romanNum.length();
        int index = 0; 
        int result = 0;

        while (index < length) {

            // just incase the last char in Roman String hasn't been checked by all the condition below 
            // so we add its val to the result and end the function
            if (index == (length - 1)) {
                return result += charToint(romanNum.charAt(index));
                
            }

            char current = romanNum.charAt(index);
            char next = romanNum.charAt(index+1);

            int current_char_val = charToint(current);
            int next_char_val = charToint(next);

            int count = 1;
            int sum = current_char_val; // storing the val of the same char that appears next to each other

            // check if there is a invalid roman, which sum up and get the existing number
            if ( (current_char_val == next_char_val) && (current_char_val + next_char_val == 10 || 
                current_char_val + next_char_val == 100 || current_char_val + next_char_val == 1000)) {
                return 0;
            }

            // check if there is any same roman char occurs more than 4 times, which means that num is invalid
            while ((index < (length - 1)) && (charToint(romanNum.charAt(index)) == charToint(romanNum.charAt(index+1)))) {

                count++;
                sum += next_char_val;

                if (count == 4) {
                    return 0;
                }

                index++;
            }
            
            // if there are same char appears more than 1 in a row + the char next to them is more than theirs val
            // violates the rule where only 1 smaller value can deduct from the larger num
            if (count > 1 && sum < next_char_val) {
                return 0;
            }

            // if not violate then just add to the result
            else if (count > 1) {
                result += sum;
            }

            // no change, normal sequence, check if the current is smaller or not, if yes then check if it violate the rule 
            else if (current_char_val < next_char_val) {

                if (!(qualifySubtractingrules(current_char_val, next_char_val))){
                    return 0; // violates then end the function
                }
                
                // doesn't violate so just subtract normally
                result += next_char_val - current_char_val;
                index++;
                
            }
            else {
                result += current_char_val;
            }

            index++;
            
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("IV"));
    }

}

