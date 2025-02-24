import java.util.HashSet;
import java.util.Set;

public class LongestPalindrome {

    // public static int longestPalindrome(String s) {
    //     int [] alp = new int [52];

    //     for (int i = 0; i < s.length(); i++) {
    //         if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
    //             alp[s.charAt(i) - 'a'] += 1;
    //         } else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
    //             alp[s.charAt(i) - 'A' + 26] += 1;
    //         }
    //     }

    //     int size = 0;
    //     int max = 0;
    //     for (int i = 0; i < alp.length; i++) {
    //         if (alp[i] > 0) {
    //             if (alp[i] % 2 == 0) {
    //                 size += alp[i];
    //             } else {
    //                 if (alp[i] > max) {
    //                     max = alp[i];
    //                 } 
    //                 size += alp[i] - 1;
    //             }
    //         }
    //     }

    //     return size + ((max > 0) ? 1 : 0);
    // }

        // Результат решения RunTime 76.77%, Memory 34.78%

        // Но по ходу решения задачи пришло новое решение, точнее додумался как пользоваться
        // set для решения этой задачи. 
        // Так как любые числа, которые имеют пару можно сразу записывать в полиндром, то нам
        // нужно найти остались ли числа у который что-то осталось.
        // Т.е для строки: "lllaaa" существует полиндром длиной 5. Это "laaal" или "allla"
        // (конечно еще есть, но сути не меняет)
        // Т.к мы имеем к-во l = 3 и a = 3, то в нашем set (или где мы будем хранить данные),
        // останется: a = 1, l = 1, и мы просто к нашему результату прибавим одну любую букву,
        // которую поместим по середине.
        // Только щас хз делать ли сет или так же отсавить массив.

    // public static int longestPalindrome(String s) {
    //     Set<Character> set = new HashSet<>();

    //     int size = 0;
    //     for (char c : s.toCharArray()) {
    //         if (set.contains(c)) {
    //             set.remove(c);
    //             size += 2;
    //         } else {
    //             set.add(c);
    //         }
    //     }

    //     return size + ((set.isEmpty()) ? 0 : 1);
    // }

    // результат: runtime beats: 74.03%, memory: 7.43%
    // Конечно, результат увеличился, но код стал чище и понятнее.
    // Можно конечно вместо сета использовать, массив.
    // Думаю стоит сделать просто для теста результатов.
    // Но решение с сетом меня удовлетворяет.


    public static int longestPalindrome(String s) {
        int [] alp = new int [52];

        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                if (alp[s.charAt(i) - 'a'] % 2 == 1) {
                    alp[s.charAt(i) - 'a'] = 0;
                    size += 2;
                } else {
                    alp[s.charAt(i) - 'a'] = 1;
                }
            } else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                if (alp[s.charAt(i) - 'A' + 26] % 2 == 1) {
                    alp[s.charAt(i) - 'A' + 26] = 0;
                    size += 2;
                } else {
                    alp[s.charAt(i) - 'A' + 26] = 1;
                }
            }
        }

        for (int i = 0; i < alp.length; i++) {
            if (alp[i] > 0) {
                return size + 1;
            }
        }

        return size;
    }


    // Результат: runtime 74%, memory 81.36%
    // видимо есть еще сильнее решение
    
    // Посмотрел решения,есть еще решение через odd Counter. Т.е через подсчет
    // нечетных. Реализовывать не буду скорее всего.
        
    public static void main(String[] args) {
        // System.out.println(longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
        System.out.println(longestPalindrome("jglknendplocymmvwtoxvebkekzfdhykknufqdkntnqvgfbahsljkobhbxkvyictzkqjqydczuxjkgecdyhixdttxfqmgksrkyvopwprsgoszftuhawflzjyuyrujrxluhzjvbflxgcovilthvuihzttzithnsqbdxtafxrfrblulsakrahulwthhbjcslceewxfxtavljpimaqqlcbrdgtgjryjytgxljxtravwdlnrrauxplempnbfeusgtqzjtzshwieutxdytlrrqvyemlyzolhbkzhyfyttevqnfvmpqjngcnazmaagwihxrhmcibyfkccyrqwnzlzqeuenhwlzhbxqxerfifzncimwqsfatudjihtumrtjtggzleovihifxufvwqeimbxvzlxwcsknksogsbwwdlwulnetdysvsfkonggeedtshxqkgbhoscjgpiel"));
    }
}
