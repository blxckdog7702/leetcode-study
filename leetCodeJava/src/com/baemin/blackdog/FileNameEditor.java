package com.baemin.blackdog;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Case1 : 일치 = 0번
// A -> A

// Case2 : 닫힌 루프 = n+1번 (temp로의 변경이 필요하기 때문)
// A -> B
// B -> A

// Case3 : 열린 루프 = n번 (루프가 열린 곳부터 바꾸면 되기 때문)
// A -> B
// B -> C
// C -> Z

public class FileNameEditor {

    private Map<String, String> map = new HashMap<>();
    private Set<String> visitedBeforeSet = new HashSet<>();

    public static void main(String[] args) {
        FileNameEditor editor = new FileNameEditor();

        String[] before = {"A", "B", "C"};
        String[] after  = {"B", "C", "A"};
        System.out.println(editor.solution(before, after));
    }

    private int solution(String[] beforeArr, String[] afterArr) {
        for(int i = 0; i < beforeArr.length; i++) {
            map.put(beforeArr[i], afterArr[i]);
        }

        int count = 0;

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String before = entry.getKey();
            if(!visitedBeforeSet.contains(before)) {
                count += find(before);
            }
        }

        return count;
    }

    private int find(String before) {
        visitedBeforeSet.add(before);
        String after = map.get(before);

        if(before.equals(after)) {
            return 0;
        }

        // after가 before 목록에 있는 경우
        if(map.containsKey(after)) {
            // after가 이미 방문했던 before 목록에 있을 경우 (닫힌 루프)
            if(visitedBeforeSet.contains(after)) {
                return 2;
            }
            // 열린 루프인지 닫힌 루프인지 판단을 위해 꼬리물기 재귀
            else {
                return find(after) + 1;
            }
        }
        // after가 before 목록에 없는 경우 (열린 루프)
        else {
            return 1;
        }
    }
}
