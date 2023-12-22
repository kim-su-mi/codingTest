package Level1;

import java.util.Arrays;

/**
 * 햄버거 게임
 * @author sumi
 *
 */
public class ch01 {
	public static void main(String[] args) {
		int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
		
		StringBuffer str = new StringBuffer();
		int result=0;
		
		for(int i=0; i<ingredient.length; i++) {
			str.append(ingredient[i]);
			
			
		}

		
		
		 // 햄버거 개수를 담기 위한 answer
        int answer = 0;
        // 햄버거 재료들을 순서대로 담을 StringBuilder
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < ingredient.length; i++) {
            // 현재 재료를 sb에 추가
            sb.append(ingredient[i]);

            // sb의 길이가 4 이상이고, 마지막 4개의 재료가 빵-야채-고기-빵인 경우
            if (sb.length() > 3 && sb.substring(sb.length() - 4, sb.length()).equals("1231")) {
                // answer 증가
                answer++;
                // 마지막 4개의 재료 삭제
                sb.delete(sb.length() - 4, sb.length());
            }
        }
        System.out.println(answer);
		
	}
	

}
