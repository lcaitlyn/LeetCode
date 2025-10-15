import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeysAndRooms {

    private static void visit(List<List<Integer>> rooms, int [] map, int index) {
        if (map[index] != 0) return;

        map[index]++;
        for (int key : rooms.get(index)) {
            visit(rooms, map, key);
        }
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int [] map = new int[rooms.size()];
        visit(rooms, map, 0);
        for (int key : map) {
            if (key == 0) return false;
        }
        return true;
    }

//    beats 100% 0ms. mempry 48.87%. Не сразу решение придумал. Сперва около брутфорса, а так сразу рекурсией

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(List.of(2));
        list.add(new ArrayList<>());
        list.add(List.of(1));
        System.out.println(canVisitAllRooms(list));
    }
}
