Calculate the frequency map of t string
Use 2 Pointer approach.
1st Pointer to aquire all the chars , it traverses till it finds all chars and count is 0
2nd pointer to remove unwanted starting chars from substring. it starts when count == 0 ; 2nd Pointer traverses to find the best(smallest) substring and stops when count > 0
Everytime we find the substring ; compare the length with existing length ; if it is smaller then only consider else ignore