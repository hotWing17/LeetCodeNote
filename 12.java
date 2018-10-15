//较快
class Solution {
    public String intToRoman(int num) {
        String M[] = {"","M","MM","MMM"};
        String C[] = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String X[] = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String I[] = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[(num%10)];
    }
}

//慢
class Solution {
    public String intToRoman(int num) {
        String result = "";
        int re = 0; //余数
        int me = 0; //商
        me = num / 1000;
        re = num % 1000;
        switch(me){
            case 3 : result += "MMM";break;
            case 2 : result += "MM";break;
            case 1 : result += "M";break;
            case 0 : break;
        }

        me = re / 100;
        re = re % 100;
        switch(me){
            case 9 : result += "CM";break;
            case 8 : result += "DCCC";break;
            case 7 : result += "DCC";break;
            case 6 : result += "DC";break;
            case 5 : result += "D";break;
            case 4 : result += "CD";break;
            case 3 : result += "CCC";break;
            case 2 : result += "CC";break;
            case 1 : result += "C";break;
            case 0 : break;
        }

        me = re / 10;
        re = re % 10;
        switch(me){
            case 9 : result += "XC";break;
            case 8 : result += "LXXX";break;
            case 7 : result += "LXX";break;
            case 6 : result += "LX";break;
            case 5 : result += "L";break;
            case 4 : result += "XL";break;
            case 3 : result += "XXX";break;
            case 2 : result += "XX";break;
            case 1 : result += "X";break;
            case 0 : break;
        }

        switch(re){
            case 9 : result += "IX";break;
            case 8 : result += "VIII";break;
            case 7 : result += "VII";break;
            case 6 : result += "VI";break;
            case 5 : result += "V";break;
            case 4 : result += "IV";break;
            case 3 : result += "III";break;
            case 2 : result += "II";break;
            case 1 : result += "I";break;
            case 0 : break;
        }
        return result;
    }
}


