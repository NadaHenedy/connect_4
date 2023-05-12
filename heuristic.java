package Util;

public class heuristic {
	// size of board
	final int length =6;
	final int width = 7;
		// to return the win score of ai
	public int Aiscore(char[][]board) {
		return numberofconnect_4(board , true);
	}
	//to return the win score of player
	 public int playerscore(char[][]board) {
		 return numberofconnect_4(board , false);
	 }
	 // calculate the heuristic of computer which connect 4 
		private int numberofconnect_4(char[][]board , boolean Ai) {
		int number = 0 ;
		char name;
		if(Ai) // if player is computer
		name = 'a';// then give him char a to represent it
		else
			name = 'p';// to represent player
		
		// if the connect 4 happened horizontal
		for(int i =0 ; i<length ; i++) 
			for(int j =0 ; j<width-3 ; j++)
				// check board if every position consecutive in horizontal have the same name 
		if(board[i][j]==name&&board[i][j+1]==name&&board[i][j+2]==name&&board[i][j+3]==name)
		number++;// then increase number of success of player
		
		// if the connect 4 happened vertical
		for(int i=0 ; i<length-3  ; i++)
			for(int j =0 ; j <width ; j++)
				// check board if every position consecutive in vertical have the same name 
				if(board[i][j]==name&&board[i+1][j]==name&&board[i+2][j]==name&&board[i+3][j]==name)
		number ++;// then increase number of success of player
		
		// if connect 4 happened in negative diagonal
		for(int i = 3 ; i<length; i++)
			for(int j =0 ; j<width-3 ; j++)
				// check board if every position consecutive in negative diagonal have the same name 
				if(board[i][j]==name&&board[i-1][j+1]==name&&board[i-2][j+2]==name&&board[i-3][j+3]==name)
		number++;// then increase number of success of player
		
		// if the connect 4 happened in positive diagonal
		for(int i =0 ; i<length-3 ; i++)
			for(int j =0 ; j< width-3 ; j++)
				// check board if every position consecutive in positive diagonal have the same name 
				if(board[i][j]==name&&board[i+1][j+1]==name&&board[i+2][j+2]==name&&board[i+3][j+3]==name)	
		number ++;// then increase number of success of player
	return number;
		}
		
		// calculate heuristic of computer and player which connect 3 
		private int numberofconnect_3(char[][]board , boolean Ai) {
		int number =0 ;
		char name ;
		if(Ai) // if player is computer
		name = 'a';// then give him char a to represent it
		else
			name = 'p';// to represent player
		
			// if the connect 3 happened in horizontal position
		for(int i =0 ; i<length ; i++)
			for(int j =0 ; j<width-3 ; j++) {
				// check board if every 3 position in horizontal have the same name if the space at first position
				if(board[i][j]=='_'&&board[i][j+1]==name&&board[i][j+2]==name&& board[i][j+3]==name)
					number++;// then increase heuristic of player
				// check board if every 3 position consecutive in horizontal have the same name if the space at second position
		if(board[i][j]==name&&board[i][j+1]=='_'&&board[i][j+2]==name&& board[i][j+3]==name)
			number++;// then increase heuristic of player
		// check board if every 3 position  in horizontal have the same name if the space at third position
		if(board[i][j]==name&&board[i][j+1]==name&&board[i][j+2]=='_'&& board[i][j+3]==name)
			number++;// then increase heuristic of player
		// check board if every 3 position  in horizontal have the same name if the space at forth position
		if(board[i][j]==name&&board[i][j+1]==name&&board[i][j+2]==name&& board[i][j+3]=='_')
			number++;// then increase heuristic of player
			}
		// if the connect 3 happened in vertical position
		for(int i =0 ; i<length-3 ; i++)
			for(int j =0 ; j<width ; j++) {
				// check board if every 3 position  in vertical have the same name if the space at first position
				if(board[i][j]=='_'&&board[i+1][j]==name&&board[i+2][j]==name&&board[i+3][j]==name)
					number++;// then increase heuristic of player
				// check board if every 3 position  in vertical have the same name if the space at second position
				if(board[i][j]==name&&board[i+1][j]=='_'&&board[i+2][j]==name&&board[i+3][j]==name)
					number++;// then increase  heuristic of player
				// check board if every 3 position  in vertical have the same name if the space at third position
				if(board[i][j]==name&&board[i+1][j]==name&&board[i+2][j]=='_'&&board[i+3][j]==name)
					number++;// then increase heuristic of player
				// check board if every 3 position in vertical have the same name if the space at forth position
				if(board[i][j]==name&&board[i+1][j]==name&&board[i+2][j]==name&&board[i+3][j]=='_')
			number++;	// then increase heuristic of player	
			}
		
		// if the connect 3 happened in negative diagonal position
		for(int i = 3; i<length ; i++)
			for(int j =0 ; j<width-3 ; j++) {
				// check board if every 3 position  in negative diagonal have the same name if the space at first position
				if(board[i][j]=='_'&&board[i-1][j+1]==name&&board[i-2][j+2]==name&&board[i-3][j+3]==name)
					number++;// then increase heuristic of player
				// check board if every 3 position  in negative diagonal have the same name if the space at second position
				if(board[i][j]==name&&board[i-1][j+1]=='_'&&board[i-2][j+2]==name&&board[i-3][j+3]==name)
					number++;// then increase heuristic of player
				// check board if every 3 position in negative diagonal have the same name if the space at third position
							if(board[i][j]==name&&board[i-1][j+1]==name&&board[i-2][j+2]=='_'&&board[i-3][j+3]==name)
								number++;// then increase heuristic of player
							// check board if every 3 position  in negative diagonal have the same name if the space at forth position
							if(board[i][j]==name&&board[i-1][j+1]==name&&board[i-2][j+2]==name&&board[i-3][j+3]=='_')
								number++;// then increase heuristic of player
			}
		// if the connect 3 happened in positive diagonal position
		for(int i = 0 ; i<length-3 ; i++)
			for(int j =0 ; j<width-3 ; j++) {
				// check board if every 3 position  in positive diagonal have the same name if the space at first position
				if(board[i][j]=='_'&&board[i+1][j+1]==name&&board[i+2][j+2]==name&&board[i+3][j+3]==name)
					number++;// then increase heuristic of player
				// check board if every 3 position  in positive diagonal have the same name if the space at second position
							if(board[i][j]==name&&board[i+1][j+1]=='_'&&board[i+2][j+2]==name&&board[i+3][j+3]==name)
								number++;// then increase heuristic of player
				// check board if every 3 position  in positive diagonal have the same name if the space at third position
							if(board[i][j]==name&&board[i+1][j+1]==name&&board[i+2][j+2]=='_'&&board[i+3][j+3]==name)
								number++;// then increase heuristic of player
			  // check board if every 3 position  in positive diagonal have the same name if the space at forth position
							if(board[i][j]==name&&board[i+1][j+1]==name&&board[i+2][j+2]==name&&board[i+3][j+3]=='_')
								number++;// then increase heuristic of player
			}
		return number;
		}
		// calculate heuristic of computer and player which connect 2
		private int numberofconnect_2(char[][]board , boolean Ai) {
			int number = 0 ;
			char name;
			if(Ai) // if player is computer
			name = 'a';// then give him char a to represent it
			else
				name = 'p';// to represent player
			// if the connect 2 happened in horizontal position 
			for(int i =0 ;i<length ; i++)
				for(int j =0 ; j<width-3 ; j++) {
					// check board if every 2 position in horizontal have the same name if the space at first & second position
					if(board[i][j]=='_'&&board[i][j+1]=='_'&&board[i][j+2]==name&&board[i][j+3]==name)
						number++;// then increase heuristic of player
					// check board if every 2 position in horizontal have the same name if the space at first & third position
					if(board[i][j]=='_'&&board[i][j+1]==name &&board[i][j+2]=='_'&&board[i][j+3]==name)
						number++;// then increase heuristic of player
					// check board if every 2 position in horizontal have the same name if the space at first & forth position
					if(board[i][j]=='_'&&board[i][j+1]==name &&board[i][j+2]=='_'&&board[i][j+3]=='_')
						number++;// then increase heuristic of player
					// check board if every 2 position in horizontal have the same name if the space at second & forth position
					if(board[i][j]==name&&board[i][j+1]=='_'&&board[i][j+2]==name&&board[i][j+3]=='_')
						number++;// then increase heuristic of player
					// check board if every 2 position in horizontal have the same name if the space at second & third position
					if(board[i][j]==name&&board[i][j+1]=='_'&&board[i][j+2]=='_'&&board[i][j+3]==name)
						number++;// then increase heuristic of player
					// check board if every 2 position in horizontal have the same name if the space at third & forth position
					if(board[i][j]==name&&board[i][j+1]=='_'&&board[i][j+2]=='_'&&board[i][j+3]=='_')
						number++;// then increase heuristic of player		
				}
			// if the connect 2 happened in vertical position
			for(int i=0 ; i<length-3 ; i++)
				for(int j =0 ; j<width ; j++) {
					// check board if every 2 position in vertical have the same name if the space at first & second position
				if(board[i][j]=='_'&&board[i+1][j]=='_'&&board[i+2][j]==name&&board[i+3][j]==name)
					number++;// then increase heuristic of player
				// check board if every 2 position in vertical have the same name if the space at first & third position
							if(board[i][j]=='_'&&board[i+1][j]==name&&board[i+2][j]=='_'&&board[i+3][j]==name)
								number++;// then increase heuristic of player
				// check board if every 2 position in vertical have the same name if the space at first & forth position
							if(board[i][j]=='_'&&board[i+1][j]==name&&board[i+2][j]==name&&board[i+3][j]=='_')
								number++;// then increase heuristic of player
				// check board if every 2 position in vertical have the same name if the space at second & forth position
							if(board[i][j]==name&&board[i+1][j]=='_'&&board[i+2][j]==name&&board[i+3][j]=='_')
								number++;// then increase heuristic of player
				// check board if every 2 position in vertical have the same name if the space at second & third position
							if(board[i][j]==name&&board[i+1][j]=='_'&&board[i+2][j]=='_'&&board[i+3][j]==name)
								number++;// then increase heuristic of player
					// check board if every 2 position in vertical have the same name if the space at third & forth position
							if(board[i][j]==name&&board[i+1][j]==name&&board[i+2][j]=='_'&&board[i+3][j]=='_')
								number++;// then increase heuristic of player	
				}
			// if the connect 2 happened in negative diagonal position
			for(int i =3 ; i<length ; i++)
				for(int j=0;j<width-3 ; j++) {
					// check board if every 2 position in negative diagonal have the same name if the space at first & second position
					if(board[i][j]=='_'&&board[i-1][j+1]=='_'&&board[i-2][j+2]==name&&board[i-3][j+3]==name)
						number++;// then increase heuristic of player
					// check board if every 2 position in negative diagonal have the same name if the space at first & third position
					if(board[i][j]=='_'&&board[i-1][j+1]==name&&board[i-2][j+2]=='_'&&board[i-3][j+3]==name)
						number++;// then increase heuristic of player
					// check board if every 2 position in negative diagonal have the same name if the space at first & forth position
					if(board[i][j]=='_'&&board[i-1][j+1]==name&&board[i-2][j+2]==name&&board[i-3][j+3]=='_')
						number++;// then increase heuristic of player
					// check board if every 2 position in negative diagonal have the same name if the space at second & forth position
					if(board[i][j]==name&&board[i-1][j+1]=='_'&&board[i-2][j+2]==name&&board[i-3][j+3]=='_')
						number++;// then increase heuristic of player
					// check board if every 2 position in negative diagonal have the same name if the space at second & third position
					if(board[i][j]==name&&board[i-1][j+1]=='_'&&board[i-2][j+2]=='_'&&board[i-3][j+3]==name)
						number++;// then increase heuristic of player
					// check board if every 2 position in negative diagonal have the same name if the space at third & forth position
					if(board[i][j]==name&&board[i-1][j+1]==name&&board[i-2][j+2]=='_'&&board[i-3][j+3]=='_')
						number++;// then increase heuristic of player	
				}
			// if the connect 2 happened in positive diagonal position
			for(int i=0 ; i<length-3 ; i++)
				for(int j =0 ; j<width-3 ; j++) {
					// check board if every 2 position in positive diagonal have the same name if the space at first & second position
					if(board[i][j]=='_'&&board[i+1][j+1]=='_'&&board[i+2][j+2]==name&&board[i+3][j+3]==name)
						number++;// then increase heuristic of player
					// check board if every 2 position in positive diagonal have the same name if the space at first & third position
					if(board[i][j]=='_'&&board[i+1][j+1]==name&&board[i+2][j+2]=='_'&&board[i+3][j+3]==name)
						number++;// then increase heuristic of player
					// check board if every 2 position in positive diagonal have the same name if the space at first & forth position
					if(board[i][j]=='_'&&board[i+1][j+1]==name&&board[i+2][j+2]==name&&board[i+3][j+3]=='_')
						number++;// then increase heuristic of player
					// check board if every 2 position in positive diagonal have the same name if the space at second & forth position
					if(board[i][j]==name&&board[i+1][j+1]=='_'&&board[i+2][j+2]==name&&board[i+3][j+3]=='_')
						number++;// then increase heuristic of player
					// check board if every 2 position in positive diagonal have the same name if the space at second & third position
					if(board[i][j]==name&&board[i+1][j+1]=='_'&&board[i+2][j+2]=='_'&&board[i+3][j+3]==name)
						number++;// then increase heuristic of player
					// check board if every 2 position in positive diagonal have the same name if the space at third & forth position
					if(board[i][j]==name&&board[i+1][j+1]==name&&board[i+2][j+2]=='_'&&board[i+3][j+3]=='_')
						number++;// then increase heuristic of player	
				}
			return number;	
		}

	public int evalution(char[][]board) {
		int util = 0;// increase when Ai play & decrease when player play
		util+=(numberofconnect_4(board , true))*100000;// Ai play and will make connect 4
		util-=(numberofconnect_4(board , false))*100000;// player play and will make connect 4
		util+=(numberofconnect_3(board , true))*100;// Ai play and will make connect 3
		util-=(numberofconnect_3(board , false))*100;// player play and will make connect 3 
		util+=(numberofconnect_2(board , true))*10;//Ai play and will make connect 2
		util-=(numberofconnect_2(board , false))*10;// player play and will make connect 2
		
		return util;	
	}
	}

