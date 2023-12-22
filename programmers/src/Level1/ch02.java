package Level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 추억 점수
 * @author sumi
 *
 */

public class ch02 {
	public static void main(String[] args) {
		String[] name= {"may", "kein", "kain", "radi"};
		int[] yearning= {5,10,1,3};
		String[][] photo= {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};
		// 최종 결과를 담을 배열 생성
		int[] result = new int[photo.length];
		
		// 맵에 친구이름을 key로 점수를 값으로 담음
		Map<String,Integer> score = new HashMap<String,Integer>();
		for(int i=0; i<name.length; i++) {
			score.put(name[i], yearning[i]);
		}
		
		for(int i=0; i<photo.length; i++){
			int sum = 0;
            for(int j=0; j<photo[i].length; j++){
                if(score.containsKey(photo[i][j])) {
                	sum+=score.get(photo[i][j]);
                }
            }
            result[i]=sum;
        }
		System.out.println(Arrays.toString(result));
	}

}
