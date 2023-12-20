class Solution {
    public String reformatDate(String date) {
        String[] splitarr = date.split(" ");
        String datepart = splitarr[0];
        String monthpart = splitarr[1];
        String yearpart  = splitarr[2];

        Map<String, String> monthMap = monthMap();

        StringBuilder sb = new StringBuilder();
        sb.append(yearpart);
        sb.append("-");
        sb.append(getMonthMM(monthpart, monthMap));
        sb.append("-");
        sb.append(getDateDD(datepart));
        return sb.toString();
    }

    String getDateDD(String input){
        String date = new String();
        for(int i=0; i<input.length(); i++){
            char ch = input.charAt(i);
            if(Character.isDigit(ch)){
                date = date+ch;
            }
        }
        return date.length() == 1 ? "0"+date : date; 
    }

    String getMonthMM(String month, Map<String, String> monthMap){
        return monthMap.get(month);
    }

    Map<String, String> monthMap(){
        Map<String, String> map = new HashMap<>();
        map.put("Jan","01");
        map.put("Feb","02");
        map.put("Mar","03");
        map.put("Apr","04");
        map.put("May","05");
        map.put("Jun","06");
        map.put("Jul","07");
        map.put("Aug","08");
        map.put("Sep","09");
        map.put("Oct","10");
        map.put("Nov","11");
        map.put("Dec","12");

        return map;
    }



}