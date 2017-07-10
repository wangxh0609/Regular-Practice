package com.hust.ALTest;

import java.io.IOException;

public class ClearBlackLine {

	public static void main(String[] args) {
		ImageAPI api=null;
		
		String fileName="";
		try {
			int[] fileInt=api.loadPiexls(fileName);
			
			
		} catch (IOException e) {			
			
		}
	}
	

}
interface ImageAPI{
	
	int getMaxPiexl(int p1,int p2);
	int[] loadPiexls(String imageFileName) throws IOException;
}
