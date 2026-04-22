public class NumberOfWaysToDivideALongCorridor {

//    private int rec(String s, int i, int total, int taken) {
//        if (total == 2 && s.charAt(i) == 'S') return 1;
//
//        if (taken != 2) {
//            if (s.charAt(i) == 'S') {
//                return rec(s, i + 1, total - 1, taken + 1);
//            }
//            return rec(s, i + 1, total, taken);
//        }
//
//        if (s.charAt(i) == 'S') return rec(s, i + 1, total - 1, 1);
//        return rec(s, i + 1, total, 0) + rec(s, i + 1, total, taken);
//    }
//
//    public int numberOfWays(String corridor) {
//        int total = 0;
//        for (int i = 0; i < corridor.length(); i++) {
//            if (corridor.charAt(i) == 'S') total++;
//        }
//
//        if (total == 0 || total % 2 != 0) return 0;
//        if (total == 2) return 1;
//
//        return rec(corridor, 0, total, 0);
//    }

//    TLE
//    ну вроде с первого раза пришел к TLE
//    осталось понять как к DP привести это

//    так я думаю как сделать за O(n)
//    можно собирать левую часть и держать правую часть
//    аля taken (всё что слева сколько стульев мы собрали) и total, всё что осталось собрать

    public static int numberOfWays(String corridor) {
        int MOD = 1_000_000_007;
        int total = 0;
        for (int i = 0; i < corridor.length(); i++) {
            if (corridor.charAt(i) == 'S') total++;
        }
        if (total == 0 || total % 2 != 0) return 0;
        if (total == 2) return 1;

        int taken = 0;
        long res = 1;
        int i = 0;

        while (i < corridor.length()) {
            if (taken > 0 && taken % 2 == 0) {
                int plants = 0;
                while (i < corridor.length() && corridor.charAt(i) == 'P') {
                    plants++;
                    i++;
                }
                if (plants > 0) {
                    plants++;
                    res = (res * plants) % MOD;
                }
            }

            if (corridor.charAt(i) == 'S') taken++;
            if (total - taken == 1) break;
            i++;
        }

        return (int) res;
    }

//    beats 27.2% memory 48% runtime 34ms
//    лол очень странно конечно, потому что у меня вроде за O(n)

//    бля а так без приколов моё решение +- похоже на ответы.
//    а это блять уровень Хард и я сам к нему пришел +- за час

    public static void main(String[] args) {
//        System.out.println("1 -> " + numberOfWays("SPPSSSSPPS"));
//        System.out.println("1 -> " + numberOfWays("SSSSSSSS"));
//        System.out.println("3 -> " + numberOfWays("SSPPSPS"));
//        System.out.println("6 -> " + numberOfWays("SPSPPSSPSSSS"));
        System.out.println("6 -> " + numberOfWays("SSSSPPPPPSSPSPSSPPPPPPSPSPSSPPPSPSPSPSSPPPSSSSPSSPSPSPSSSSPPSSPSSSSSSPPPSPSSPPSSPSPSPSSPSSSSSSPSSSPSSSPSSPSSPPPSSPSSPPSSSPSSPSPSSSSPSPPSSPSSPPSSPPSPSPPPSPSPPSPPSPSPPPPPPPPSPSSSPPSPSSPSSSSPPSPSPPPPSPPSSPSPSSPSSPSPPPPPPSSPSPPPPSSPSPPPPPSSSSPSSSSSPPSPPPSPSSPPSPSPSSSSPPPSPPSSSPSPPSSSSSSSSPSSSSPSPSSSPSPPPPPSPSPSPPPSSSPSSPSPSSSPPPPSSPSPSSSSPSSSSSPPSPSSSSPSSSSSSPPPSSPPPPPPSPSSSPPSPPSSSPPPSSPPPSPPSSPPSPSSSSSSPPSSSPPSPSPSPPSPSSPPSPSSPSPPSPSPPSSPSSPPSPPSPSPPSPPSSSSPSPPPSSPPSSPPPSPPSSPSPPSPSPSSPSPPSSSPPSSSPSSPSPPSPSPSPSPSPSSPPPSPSSSSSPPSPSSSPSSSPSSSSSSPSPPPPPPPSSPPSPPSPPSPSSSSPSSSPPPPSPSSPSSPSSPPSSSSPPSPSPSPPPSSSPSPSSPPSSSPPSSPSPPPPPSSSPPSSPSPPPSSSPPPPPSPPPPPSPSPSSSPPSPSSPPSPPSSSPSSSPPSSPPSPSSSPSPPSSSSPSPPSSSPSSPSPPPSPPPSPSSPSPPSSSPPSPSSPSPPPPSSSPSSPPSPSPSPSPSSSPSPSPPPPSSSSSSPPPPPPSPPPSPSPPSPSPPSPPPPPSSSPSPPPSPPSPSPPSSSPPSPSSPPPPPSSPPPPPSSPSSPPSPSPSSSPPPSSSSPPPSPPPPSSSPSPPPSPPPSPPSPSSSPPPPPSSSSPPPPSSSSPSPSPSPPSPSPPSPSPSPSSPPPSSPPPPPSSPSPPPPPPSSPSSPSPSSPPSPPSSSPPSPSSSSSSSSSSSPSSPSPSPPPSPSPPPPSPSSSPPPSSPSPSSSSPSPPPSPSPPSPSPPPSPSPPSSSPSPPSSSPPPPPPSPPSSPPPPSPPPPPSPPPPPSPSPSSPPPSPSSSSSPSSSSPPPSSSPPSPPPPPSSPSSSPSPSPSSSPPSSPSPSPPSSPSPSPSPSPPSSSSPPPSSPPPSSSPPSPSPPPPSPSPSPPPSSPSSPSSPPPPSSSPPPPSSSPPPPPPSPSSSPSSPSPSSSSPSPSPSPPSPSSSPPSSSSSPSSPPPPSSSSPPPSPSSPPSPSSPPPPPPPSSPSPPPSSPPPPSSSSSSPSPPPSPPSSSPSPSSSPSSPSSSSSPSSPSPSSPSSPPSSSSPPSPSSPPSSSPSPPSSSPSSPSSSPSPSPPSSPPPPSSPSPSPPSPPPPPSPSSSPPSPPPPSSPPSPSPSSPSPSPSSPPPPPPSSSPPPPSPSPPSSPSPSSSPSSPPPPSPSSSSPPSPPSSSPPSPPPSSPSPSPPPSPSSSSSPPSPSPPPSSPPPSSSPPSSSPPSPSSPPSSSPPSPPPPPPSSSPSSPSSPSPPPSPSPPPSPSSPSSSSSSSSPPPSSSSPPSSSPSSSPSSPPPSSPSPPPPPPPPSSPPSPPPSPPPSSPSSPPPPPSSSSPPSSPPPPSS"));
    }
}
