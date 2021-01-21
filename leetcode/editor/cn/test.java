/**
 * @auther ChenLei
 * @create 2021-01-1:50 PM
 */


//15
//0000000000001111,000F
//-1
//1111111111111111,FFFF
public class test {
    /**
     * 将输入的十进制数字转换为对应的二进制字符串和十六进制字符串
     * @param number string字符串 十进制数字字符串
     * @return string字符串
     */
    public String changeFormatNumber (String number) {
        // write code here
        char[] chars = number.toCharArray();
        char[] numberList = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        long numberLong = 0;
        for (char element : chars) {
            for (int i = 0; i < numberList.length; ++i) {
                if (element == numberList[i]) {
                    numberLong = numberLong * 10 + i;
                    break;
                }
                if (i == numberList.length - 1)
                    return "INPUTERROR";
            }
        }
        if (numberLong > Integer.MAX_VALUE || numberLong < Integer.MIN_VALUE)
            return "NODATA";
        int numberInt = (int) numberLong;
        String numberForTwo = changToTwo(numberInt);
        String numberForSixTeen = changToSixTeen(numberInt);
        return numberForTwo + "," + numberForSixTeen;
    }

    private String changToSixTeen(int number) {

        return "FFFF";
    }

    private String changToTwo(int number) {

        boolean needSplit = false;
        if (number < 0) {
            number = -number;
            needSplit = true;
        }
        while (true) {
            if (number == 0 || number == 1) {
                break;
            }
        }
        return "0000000000001111";
    }
}