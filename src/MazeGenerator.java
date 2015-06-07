import java.util.LinkedList;
import java.util.Queue;


public class MazeGenerator {
	private static int row =21;
	private static int col =21;
    private static Point [][]Maze = new Point[row][col];
    private static int []startPoint = new int[2]; 
    private static int []endPoint = new int[2];
     private static void intialMaze(){
    	 for(int i=0;i<row;i++){
    		 for(int j =0;j<col;j++){
    			 if(i%2==1){
    				 Maze[i][j] = new Point();
    				 Maze[i][j].setValue(1);
    			 }else if((i+j)%2==0){
    				 Maze[i][j] = new Point();
    				 Maze[i][j].setValue(0);
    			 }else {
    				 Maze[i][j] = new Point();
    				 Maze[i][j].setValue(1);
    			 }
    		 }
    	 }
     }
     
     private static int[] intialStartPointer(){
    	  startPoint[0]=(int)(Math.random()*col);	
    	  if(startPoint[0]%2==1)
    		  startPoint[0]++;
    	  startPoint[1]=0;
    	  Maze[startPoint[0]][startPoint[1]].setIsVisit(true);
    	  //System.out.println(startPoint[0]+"  "+startPoint[1]);
   // 	 startPoint[0] =32;
    //	 startPoint[1] =32;
    	 return startPoint;
    	 
     }
     
     private static int[] intialEndPointer(){
    	 endPoint[0]=(int)(Math.random()*col);	
   	     endPoint[1]=col;
   	     return endPoint;
     }
     
     private static void  createPath(int [] startPoint, int [] endPoint){
    	 if(Math.abs(startPoint[0]-endPoint[0])>0){
    		 Maze[startPoint[0]+(endPoint[0]-startPoint[0])/2][startPoint[1]].setValue(0);
    	 }else {
    		 Maze[startPoint[0]][startPoint[1]+(endPoint[1]-startPoint[1])/2].setValue(0);
    	 }
     }
     private static Point[][] generateMaze(int [] startPoint){
    	 LinkedList<int[]> q = new LinkedList<int[]>();
         if(startPoint[0]-2>=0){
        	 int [] node = new int[2];
        	 node[0]=startPoint[0]-2;
        	 node[1]=startPoint[1];
        	 q.add(node);
         }
         if(startPoint[0]+2<row){
        	 int [] node = new int[2];
        	 node[0]=startPoint[0]+2;
        	 node[1]=startPoint[1];
        	 q.add(node);
         }
         if(startPoint[1]-2>=0){
         	 int [] node = new int[2];
        	 node[0]=startPoint[0];
        	 node[1]=startPoint[1]-2;
        	 q.add(node);
         }if(startPoint[1]+2<col){
         	 int [] node = new int[2];
        	 node[0]=startPoint[0];
        	 node[1]=startPoint[1]+2;
        	 q.add(node);
         }
         while(q.size()!=0){
        	 int m=(int)(Math.random()*q.size());
        	 int[] move =q.remove(m);
        	 if(Maze[move[0]][move[1]].getIsVisit()==false){
        		 Maze[move[0]][move[1]].setIsVisit(true);
            	 createPath(startPoint, move);
            	 generateMaze(move);
        	 }
         }
    	 
    	 return Maze;
     }
     
     public static void main(String []arg){
    	 intialMaze();
    	 for(int i =0;i<row;i++){
    		 for(int j=0;j<col;j++){
    			 System.out.print(Maze[i][j].getValue());
    		 }
    		 System.out.println();
    		
    	 }
    	 System.out.println("\n\n");
    	 generateMaze(intialStartPointer());
    	 
    	 for(int i =0;i<row;i++){
    		 for(int j=0;j<col;j++){
    			 if(Maze[i][j].getValue()==0){
    				 System.out.print("   ");
    			 }else {
    				 System.out.print("!=!");
    			 }
    			 
    		 }
    		 System.out.println();
    		
    	 }
     }

}
