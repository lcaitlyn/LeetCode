public class TrappingRainWater {

//    Что вижу первое? То что нужна будет какая нибудь переменная max. с самым длинным бортиком.
//    Будет left и right поинтеры, если правый находит макс,
//    то мы заполняем все водой от предыдущего макса и назначаем left новым максом.
//    Что делать если макс будет в начале и нам нужно будет заливать правую часть?
//    Я думаю будем идти в право и будем заливать постепенно в несколько слоев слева направо,
//    потому что мы не знаем какой будет макс в будущем, может его вообще не будет.
//    Если встречаем валидный бортик, то заливаем его.
//    Единсветнное что это займет видимо O(n^2)

//    крч вбил это в гпт он подогнал идет leftMax и rightMax и идти к центру
//    крч будем наращивать гору. и считать разницу думаю
//    единственный вопрос кто должен идти? тот кто меньше?

    public static int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int leftMax = height[l], rightMax = height[r];
        int res = 0;

        while (l < r) {
            if (leftMax <= rightMax) {
                l++;
                if (height[l] < leftMax) {
                    res += leftMax - height[l];
                } else {
                    leftMax = height[l];
                }
            } else {
                r--;
                if (height[r] < rightMax) {
                    res += rightMax - height[r];
                } else {
                    rightMax = height[r];
                }
            }
        }
        return res;
    }

//    beats 100%, memory 9.6% runtime 0ms


    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trap(new int[]{4,2,0,3,2,5}));
    }
}
