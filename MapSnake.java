import java.util.Random;

public class MapSnake {
	//object array
	static Object maps[][];
	private int randomX;
	private int randomY;
	private int randomCodon;
	//snake list
	static SingleLinkedList snake;
	
	
	
	
	//constructor
	public MapSnake() {
		//initialize map variables
		maps=new Object[25][60];
		randomX=0;
		randomY=0;
		randomCodon=0;
		snake = new SingleLinkedList();
		
		mapInitialize();
		//filling first snake list
		firstSnake(snake);
		
		
	}
	//cons.
	
	
	//initializing map
	public void mapInitialize() {
	      for(int i=0;i<24;i++) {
	    	  if(i==0 || i==23) {
	    		  for(int j=0;j<60;j++) {
	        		  this.maps[i][j]='#';
	        	  }
	    	  }
	    	  else {
	    		  for(int j=0;j<60;j++) {
	    			  if(j==0 || j==59) {
	    				  this.maps[i][j]='#';
	    			  }
	    			  else {
	    				  this.maps[i][j]=' ';
	    			  }
	        	  }
	    	  }
	    	  
	      }
	      for (int i = 0; i < 3; i++) {
	    	  randomCodon=(int)(Math.random()*4)+1;
	          randomX=(int)(Math.random()*22)+1;
	          randomY=(int)(Math.random()*57)+1;
	          if (randomCodon==1) {
	        	  this.maps[randomX][randomY]='A';
	    	  }
	          else if (randomCodon==2) {
	        	  this.maps[randomX][randomY]='C';
	    	  }
	          else if (randomCodon==3) {
	        	  this.maps[randomX][randomY]='T';
	    	  }
	          else if (randomCodon==4) {
	        	  this.maps[randomX][randomY]='G';
	    	  }
	          System.out.println(maps[randomX][randomY]);
	          System.out.println("-----------");
		}
	     //end map init. 
	      
	      
	      
	      
	    	
	    	
	}
	
	
	//first snake
	public void firstSnake(SingleLinkedList snake) {
		
		//random function
	      Random random = new Random();
	      //initial values
	      int startingPointY = 0; 
	      int startingPointX = 0;
	      //starting from head
	      
	      //control boolean to check empty indexes of map
	      boolean controller = false;
	      while(controller==false) {
	    	  //random possible indexes.
	    	  startingPointY = random.nextInt(28)+4;
		      startingPointX = random.nextInt(24)+1;
	    	  if((char)maps[startingPointX][startingPointY] == ' ' && (char)maps[startingPointX][startingPointY+1] == ' ' && (char)maps[startingPointX][startingPointY+2] == ' ')
	    		  controller = true;
	    	  
	      }
	      char[] ch = new char[4];
			ch[0] = 'A'; ch[1] = 'T'; ch[2] = 'G'; ch[3] = 'C';
			Random rand = new Random();
			// Randomly generated 3 letters at the start.
			for(int i = 0; i < 3; i++) {
				int rnd = rand.nextInt(4);
				snake.add(ch[rnd],startingPointX, startingPointY);
				startingPointY++; //increase Y index.
			}	
			Node temp = snake.getHead();
			//copy list to game array
	    	while(temp != null) { 
	    	  maps[temp.getCoordinateX()][temp.getCoordinateY()] = temp.getData(); 
	   	      System.out.println(temp.getData());
	   	      System.out.println(maps[startingPointX][startingPointY]);
	    	  temp = temp.getLink();
	    	
	      }
		// For letters
		
	}
	//
	

	public void displayMap(enigma.console.Console cn) {
		//printing object array
	      for (int i = 0; i < 24; i++) {
			for (int j = 0; j < 60; j++) {
				System.out.print(this.maps[i][j]);
			}
			System.out.println();
		}
	      cn.getTextWindow().setCursorPosition(65, 1);
	      System.out.println("SCORE: ");
	      cn.getTextWindow().setCursorPosition(65, 2);
	      System.out.println("----------");
	      cn.getTextWindow().setCursorPosition(65, 22);
	      System.out.println("Level: ");
	      cn.getTextWindow().setCursorPosition(65, 23);
	      System.out.println("Time: ");

	}
    //end display
	
	
	//GET-SET
	public SingleLinkedList getSnake() {
		return snake;
	}
	public void setSnake(SingleLinkedList snake) {
		this.snake = snake;
	}


	public Object[][] getMaps() {
		return maps;
	}


	public void setMaps(Object[][] maps) {
		this.maps = maps;
	}
	
}
