package Exercises.dsaProblems;
//3200. Maximum Height of a Triangle
public class MaximumHeightofATriangle {
    public static void main(String[] args) {
        System.out.println(maxHeightOfTriangle(4,9));
    }
    public static int maxHeightOfTriangle(int red, int blue) {
        int maxHeight = 0, i = 1, tempRed = red, tempBlue = blue,temp = 0, f=0;
        while(tempRed>0 || tempBlue>0){
            if(f==0){
                if (tempRed>=i)
                    tempRed = tempRed - i;
                else
                    break;
            }
            else{
                if (tempBlue>=i)
                    tempBlue = tempBlue - i;
                else
                    break;
            }
            temp++;
            i++;
            f = f ^ 1;
        }
        maxHeight = Math.max(maxHeight, temp);
        temp = 0;i=0;
        tempRed = red; tempBlue = blue;
        while(tempRed>0 || tempBlue>0){
            if(f==0){
                if (tempBlue>=i)
                    tempBlue = tempBlue - i;
                else
                    break;
            }
            else{
                if (tempRed>=i)
                    tempRed = tempRed - i;
                else
                    break;
            }
            temp++;
            i++;
            f = f ^ 1;
        }
        maxHeight = Math.max(maxHeight, temp);
        return maxHeight;

    }
}
//    int maxHeight = 0, i = 1, tempRed = red, tempBlue = blue,temp = 0;
//        while(tempRed>0 && tempBlue>0){
//                if(i%2!=0){
//                tempRed = tempRed - i;
//                }
//                else{
//                tempBlue = tempBlue - i;
//                }
//                i++;
//                temp++;
//                }
//                maxHeight = Math.max(maxHeight, temp);
//                temp = 0;
//                tempRed = red; tempBlue = blue;
//                while(tempRed>0 && tempBlue>0){
//                if(i%2!=0){
//                tempBlue = tempBlue - i;
//                }
//                else{
//                tempRed = tempRed - i;
//                }
//                i++;
//                temp++;
//                }
//                maxHeight = Math.max(maxHeight, temp);
//                return maxHeight;
//
//                }