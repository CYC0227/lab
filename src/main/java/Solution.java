import java.util.ArrayList;
import java.util.List;
import java.util.Stack;




class Solution {


    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for(int i = 0; i < answer.length; i++){
            answer[i] = isDrawable(numbers[i]);
//            System.out.println("numbers = " + numbers[i]);
//            System.out.println();
        }
        return answer;
    }

    private int isDrawable(long number) {
        String binary = Long.toString(number, 2);
        if(binary.length() % 2 == 0)
            binary = "0" + binary;

//        System.out.println(binary);

        for(int i = 0;  i< binary.length(); i++){
            int idx = i + 1;
            if(idx % 2 == 0){//짝수면
                if(binary.charAt(i) == '0')
                    return 0;
            }
        }

        return 1;
    }

    public static void main(String[] args) {
//        String convert = "[[2, 3, 22], [1, 6, 25]]";
//
//        convert = convert.replace("[", "{");
//        convert = convert.replace("]", "}");
//        System.out.println(convert);

//        int[][] users = {{40, 10000}, {25, 10000}};
        int[][] tickets = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        Solution s = new Solution();
//[["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]

        int[][] arr1 = {{40,100}, {25, 10000}};
        int[] arr2 = {7000, 9000};

//        s.solution(arr1, arr2);

//        System.out.println(s.solution(6, 4, 6, 2, tickets));

//        System.out.println(Long.toString(42,2));

        //문제 보면서 특이사항 써가면서 하기
        //문제 유형 파악 - 5분만 더 고민, 창조 금지
        //파악한 유형의 특성 생각해보기
        //함수로 나누기
        //더 쉬운 방법 생각하기
        //행동강령 반드시 지키기 - 틀리면 한번 쫙 스캔, 천천히 체크
        //그래도 틀리면 반례 찾기

//        SELECT ao.animal_id, ao.name
//        from animal_outs ao
//        left join animal_ins ai on ao.animal_id = ai.animal_id
//        where ai.animal_id is null
//        order by ao.animal_id asc
    }

}

/*
long 주의


0111111
5
1 2 4 8 16 32

0101010
2 8 32

n번째 = 2(n-1번째) + 1

1   1
2   3
3   7
4   15
5   31
6   63
7   127

0101010
101010


101

42      0101010  101010     노드 갯수 짝수면 + 1
58      111010
63      0111111 111111
111     1101111
95      1011111

홀수번째는 노상관
짝수에 0오면 불가
*/