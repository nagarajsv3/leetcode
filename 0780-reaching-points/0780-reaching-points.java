class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        
        while( tx>sx && ty>sy){
            if(tx > ty){
                tx = tx % ty;
            }else{
                ty = ty % tx;
            }
        }

        if(tx==sx && ty>=sy){
            //reapeated ty-tx = sy can be changed to ty-sy % tx ==0 . basic math
            return (ty-sy)%tx == 0;
        }else if(ty==sy && tx>sx){
            //reapeated tx-ty = sx can be changed to tx-sx % ty ==0 . basic math
            return (tx-sx)%ty == 0;
        }else{
            return false;
        }

    }

    //TC O(log (max(tx, ty)))

    //SC O(1)
}