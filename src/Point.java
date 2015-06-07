
public class Point {
       private int value;
       private boolean isVisit = false;
       
       public Point(){
    	   
       }
       
       public void setValue(int value){
    	   this.value = value;
       }
       
       public void setIsVisit(boolean isVisit){
    	   this.isVisit = isVisit;
       }
       
       public int getValue(){
    	   return this.value;
       }
       
       public boolean getIsVisit(){
    	   return isVisit;
       }
}
