class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        String res = "";
        String finalq = "";
        long num = numerator;
        long denom = denominator;

        boolean negative = false;
        if(num * denom < 0){
            negative = true;
        }

        num = Math.abs(num);
        denom = Math.abs(denom);

        if(num % denom == 0){
            finalq = num/denom +""; 
        }else{
            finalq = getFinalQuo(num,denom);
        }

        res = negative ? "-" + finalq : finalq;
        return res;

    }

    String getFinalQuo(long num, long denom){
        
        //Number Part
        String res = num / denom + ".";
        long remai = num % denom ;  

        //Decimal Part
        long numerDec = remai;
        Map<Long, Integer> map = new HashMap<>();
        int pos = 0;
        String decPart = "";
        long remDec =0;
        long quoDec = 0;
        while(! map.containsKey(numerDec)){
            quoDec = (numerDec *10) / denom ;
            remDec = (numerDec * 10) % denom ; 
            decPart = decPart + quoDec;
            map.put(numerDec, pos);

            if(remDec ==0){
                break;
            }

            //Post Processing - For Next Iteration
            numerDec = remDec;
            pos++;
        } 

        if(remDec !=0){
            pos = map.get(numerDec);
            if(pos ==0){
                decPart = "(" + decPart + ")";
            }else{
                decPart = decPart.substring(0, pos) + "("+ decPart.substring(pos, decPart.length()) + ")";
            }
           
        }
        return res + decPart;

    }
}