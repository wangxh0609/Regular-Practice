package com.hust.mutiThread;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class MistorySolution {
	public static void main(String[] args){
		ConcurrentHashMap<Integer, String> map=new ConcurrentHashMap<>();
		String str=map.putIfAbsent(1, "2");
		String test=map.putIfAbsent(1, "2");
	}

}
interface Puzzle<P,M>{
	P initialPostion();
	boolean isGoal(P position);
	Set<M> legalMoves(P position);
	P move(P position,M move);
}

class Node<P,M>{
	final P pos;
	final M move;
	final Node<P,M> prev;
	public Node(P pos,M move,Node<P,M> prev){
		this.pos=pos;
		this.move=move;
		this.prev=prev;
	}
	
	List<M> asMoveList(){
		List<M> solution =new LinkedList<M>();
		for(Node<P,M> n=this;n.move!=null;n=n.prev){
			solution.add(0,n.move);
		}
		return solution;
	}
}