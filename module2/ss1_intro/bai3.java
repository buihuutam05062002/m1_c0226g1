package week1;

public class bai3 {
    static String function1(int numb){
        String string = "";

        if(numb <0 || numb >10){
            return "out of ability";
        }
        switch (numb){
            case 1:
                string = "one";
                break;
            case 2:
                string = "two";
                break;
            case 3:
                string = "three";
                break;
            case 4:
                string = "four";
                break;
            case 5:
                string = "five";
                break;
            case 6:
                string = "six";
                break;
            case 7:
                string = "seven";
                break;
            case 8:
                string = "eight";
                break;
            case 9:
                string = "nine";
                break;
            case 10:
                string = "ten";
                break;
        }

        return string;
    }
    static String function2(int numb){
        String string = "";
        if(numb <11 || numb >20){
            return "out of ability";
        }
        switch (numb){
            case 11:
                string = "eleven";
                break;
            case 12:
                string = "twelve";
                break;
            case 13:
                string = "thirteen";
                break;
            case 14:
                string = "fourteen";
                break;
            case 15:
                string = "fifteen";
                break;
            case 16:
                string = "sixteen";
                break;
            case 17:
                string = "seventeen";
                break;
            case 18:
                string = "eighteen";
                break;
            case 19:
                string = "nineteen";
                break;
            case 20:
                string = "twenty";
                break;
        }

        return string;
    }
    static String function3(int numb){
        if(numb <21 || numb >99){
            return "out of ability";
        }
        String string = "";
        int tens = numb /10;
        int ones = numb %10;

        string += function1(tens)+"ty";

        if(ones >0){
            string+= " ";
            string +=function1(ones);
        }
        return string;
    }
    static String function4(int numb){
        if(numb <100 || numb >999) return "out of ability";

        int hundreds = numb / 100;
        int remainder = numb % 100;

        String result = function1(hundreds) + " hundred";

        if (remainder > 0) {
            result += " and " + function3(remainder);
        }
        return result;
    }



    public static void main(String[] args) {
        System.out.println(function4(571));

    }
}
