package com.hust.hwoj;

import java.util.*;

public class PokerOrder {

	public static void main(String[] args) {
		
		int[] intSrc=new int[]{1,3,2,5,4};
		
	}
	/*
	 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王
	 * (一副牌原本是54张^_^)...他随机从中抽出了5张牌,想测测自己的手气,看看
	 * 能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小 王,大王,方片5”,“Oh My
	 * God!”不是顺子.....LL不高兴了,他想了想,决 定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张
	 * 牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL 决定去买体育彩票啦。
	 * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的 运气如何。为了方便起见,你可以认为大小王是0。
	 */

	/*
	 * 思路：找出最大的与最小的如果有大小王
	 * 保证除0外没有重复的值
	 * max-min<5
	 * 保证输入合法，0最多四个
	 */
	public static boolean isContinuous(int[] numbers) {
		if(numbers.length == 0) return false;
        Set<Integer> set = new HashSet<>();
        int maxn = -1, minn = 14;
        for(int a: numbers)
        {
            if(!set.add(a) && a!=0) return false;
            if(a!=0) {
                maxn = Math.max(maxn, a);
                minn = Math.min(minn, a);
            }
        }
        if(maxn - minn <=4) return true;
        return false;
	}

}
