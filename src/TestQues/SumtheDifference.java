package TestQues;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* QUESTION

Given an Array of numbers

You have to find all possible non-empty subsets of the array of numbers and then, for each subset, find the difference between the largest and smallest numbers in that subset Then add up all the differences to get the number.

As the number may be large, output the number modulo 10e9 + 7 (1000000007).

Example:

A = [1, 2]

All subsets
[1]    largest-smallest = 1 - 1 = 0
[2]    largest-smallest = 2 - 2 = 0
[1 2]  largest-smallest = 2 - 1 = 1

Sum of the differences = 0 + 0 + 1 = 1

So resultant number is 1
Constraints:
1 ≤ N ≤ 10000

*/

/*  

Input :  8 3 10 2 3 8 1 10 4
Expected : 1787
My Code : 1491

Input : 1000 27 1682 244 874 139 713 1996 1398 391 1026 6 1092 817 1660 36 1465 2000 915 879 380 191 857 850 1534 1065 1496 412 403 725 76 1791 802 443 140 880 265 960 155 1509 1343 964 224 58 367 1694 1021 752 1978 1429 956 413 1774 1605 386 1745 1441 439 1601 1755 1243 782 1665 267 700 783 1627 423 1460 1985 1234 64 526 158 630 831 33 474 1035 1595 1334 1365 306 1506 470 689 923 1335 327 766 753 1888 1074 598 1557 1090 1671 303 1581 1448 223 1008 1722 166 1376 508 16 1379 318 378 604 627 893 8 387 1124 846 432 708 1143 1104 1203 1476 149 320 1462 1358 1965 1327 217 1427 1166 111 1350 1771 245 887 344 1450 1964 5 1687 181 153 1490 1866 525 1872 1949 541 692 959 672 492 258 920 1742 569 431 550 632 1013 1573 602 871 294 576 1511 1483 1333 354 787 1887 1407 981 62 1493 491 980 1303 1854 983 1788 499 1396 1278 81 693 1984 48 845 562 161 628 716 993 1301 1915 434 1824 1702 702 1844 1537 207 1389 293 527 1739 1898 1559 1768 1170 592 875 1069 1513 674 463 1877 1091 806 283 548 393 1071 137 202 603 145 1019 1812 1214 1488 1925 351 646 1738 1017 510 1942 638 330 237 1022 322 769 193 1206 881 584 520 256 1873 1157 1533 1326 834 339 1882 175 1468 953 1154 1043 681 250 1467 1837 12 1590 1784 96 1524 1371 1656 1507 560 1314 46 1031 675 1158 1611 171 804 530 1284 1147 136 198 435 1282 275 1085 142 1827 788 1997 184 1554 1767 251 614 1395 468 266 1050 894 134 66 1497 1779 1117 690 82 952 1409 611 971 1546 1536 709 1087 1319 233 1640 1202 1489 934 624 1631 891 515 750 1683 1455 539 1715 1673 1442 1083 1237 86 1980 68 969 1724 1018 1051 842 1572 495 640 1658 1322 916 195 976 1425 1160 1901 1852 1959 1359 1096 1075 1618 1318 1443 156 832 25 1183 108 1625 105 262 1195 399 445 1068 564 553 54 1639 1240 1058 260 1961 1867 865 388 10 652 419 220 1626 585 872 705 32 841 1815 1835 1340 644 480 1578 43 1855 1325 984 957 1401 336 1063 128 13 647 74 1874 654 246 1252 1125 421 843 574 1247 1231 449 1042 862 1108 522 1553 309 1672 11 1947 568 1351 1661 743 1923 1473 1295 1141 1165 742 1899 1029 749 648 1757 420 228 933 292 636 844 684 1983 552 558 505 1233 1150 56 943 1357 1300 352 970 1392 484 1242 828 1266 1079 1020 1832 1523 1990 1262 1637 18 1011 34 1792 546 1542 1962 1352 1328 1754 112 1893 1567 1200 225 639 478 616 1818 651 1135 764 1491 1267 452 407 425 1144 469 343 1103 209 264 1918 1086 118 727 963 622 1119 1828 1929 760 1603 1137 643 990 1933 450 9 667 676 1560 1109 591 554 1454 918 889 1302 1226 1892 109 1081 375 1215 1916 248 466 365 1471 822 117 441 1633 899 1361 1464 1061 1676 979 144 892 255 995 1346 665 848 773 1968 1870 1289 1129 551 279 1928 904 737 1998 1484 180 348 1059 668 1115 1151 1753 1589 1268 1910 789 346 1693 1765 1212 214 1159 200 355 1449 1093 1435 277 1610 1748 213 516 1309 746 1189 1163 1762 1641 1744 1227 534 1698 657 1193 70 1142 1097 1908 1388 227 49 987 1710 1993 52 447 1459 563 31 1945 1456 1232 994 707 88 1161 430 1777 7 100 456 1591 1805 4 212 385 721 883 50 1668 163 263 185 203 1841 486 204 1850 23 1260 168 940 1479 146 1136 360 1130 1521 882 683 679 390 1703 414 629 398 273 141 1288 1257 1258 1692 472 1181 1290 673 97 1368 77 907 1400 1561 415 1434 506 1120 1969 1131 384 1688 939 1697 1686 623 906 1180 1876 1390 406 1865 1986 1446 996 401 1750 1538 754 866 1049 1582 1569 465 999 1544 809 1648 1617 1643 1045 1298 1979 968 1790 793 1550 1875 230 503 1517 1349 1287 631 126 1414 1783 973 1228 1740 1796 1650 1501 67 433 557 1010 1463 575 38 1007 417 1970 1732 518 580 169 1291 937 1789 1909 931 1421 1457 1453 1452 890 501 1853 1138 1387 606 756 1040 1519 59 779 1614 313 1046 1944 910 1649 1190 1378 1277 1354 1270 1084 319 1279 494 1756 531 650 1842 148 669 1967 1095 740 596 190 366 785 440 1669 416 829 524 317 1564 1064 838 664 694 1951 276 538 1763 1015 924 577 1406 1663 497 405 1259 1470 837 159 914 854 229 1229 1849 1052 601 1644 1833 621 517 1802 637 827 1187 634 521 661 821 1725 254 1927 1720 935 123 1808 69 1786 377 1210 1355 1344 759 1914 453 428 1602 851 1263 858 409 1868 820 1444 1604 1520 1905 1701 1505 1030 666 1813 400 125 496 290 1935 1167 1735 1341 177 1900 781 173 719 162 231 587 1329 1737 807 1704 772 812 350 1162 1616 1053 252 1208 810 1169 1225 1721 1707 1563 1175 912 87 1840 662 688 1836 549 93 73 701 1896 1716 529 113 1571 1845 1670 722 334 116 1324 1499 382 483 1912 1048 1588 593 1848 919 590 761 1532 402 1403 1276 799 1543 1500 1055 122 1966 946 1804 718
                852 1579 1883 110 368 777 985 572 347 1592 612 488 1719 115 487 1495 877 1863
Expected : 293358721
My Code :  160870738
           1000000007


40 9 8 3 6 2 7 1 0 11 13 16 23 14 10 42 4 12 99 78 34 20 92 84 67 64 39 61 80 22 93 19 70 62 9 88 44 30 94 17 43

30 9 8 3 6 2 7 1 0 17 4 9 8 3 6 2 7 1 0 17 4 11 13 16 23 14 10 42 4 12
40 12 99 78 34 20 92 84 67 64 39 9 8 3 6 2 7 1 0 11 13 4 11 13 16 23 14 10 42 4 12 67 64 39 61 80 22 93 19 70 62
*/

public class SumtheDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputListSize = sc.nextInt();

        ArrayList<Integer> inputList = new ArrayList<Integer>();
        for (int i = 0; i < inputListSize; i++) {
            int inputNumber = sc.nextInt();
            inputList.add(inputNumber);
        }
        long start = System.nanoTime();
        //call function here.....
        System.out.println(solve(inputList));
        long end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

         start = System.nanoTime();
        //call function here.....
        System.out.println(maxMin(inputList));
         end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

    }

    public static int solveSLOW(ArrayList<Integer> A) {

        if ( A.size() == 0 ) return 0;
        long output=0;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(Integer.MAX_VALUE);
        temp.add(Integer.MIN_VALUE);
         output = generate(A,output,temp,0);
         return (int)output%1000000007;

    }

    public static long generate(ArrayList<Integer> a,long output, ArrayList<Integer> temp, int index)
    {
        for (int i = index; i < a.size(); i++)
        {
            int min = Integer.MAX_VALUE,max = Integer.MIN_VALUE;
            boolean minFlag=false,maxFlag = false;
            if(a.get(i) < temp.get(0)) {
                min = temp.get(0);
                temp.set(0,a.get(i));
                minFlag = true;
            }
            if ( a.get(i) > temp.get(1)){
                max =temp.get(1);
                temp.set(1,a.get(i));
                maxFlag = true;
            }
            output = output + temp.get(1) - temp.get(0);
            output = generate(a, output, temp, i+1);
            if ( minFlag ) temp.set(0,min);
            if ( maxFlag ) temp.set(1,max);

        }
        return output;
    }

    public static int solve( ArrayList<Integer> A){
        if ( A.size() == 0 ) return 0;
        long output=0;
        int size = A.size();
        Collections.sort(A);
//        for (int i = 0; i < A.size(); i++) {
//            for (int j = A.size()-1; j >=i ; j--) {
//                // output = output + (A.get(j) - A.get(i))*pow(2,j-1-1)
//                output = (output%MOD + (((A.get(j) - A.get(i))%MOD)*(powMod(2,j-i-1,MOD)))%MOD)%MOD;
//            }
//        }

        // y= |_sum_{{i=0} tot {n-1}| {arr({n-i-1})x({2^{n-i-1}  - 2^{i}})}}
        for (int i = 0; i < size; i++) {
            output = (output +
                    ((A.get(size -i -1)%MOD)*((powMod(2,size-i-1,MOD)) - (powMod(2,i,MOD)))%MOD)%MOD)%MOD;
        }
        return (int)output;

    }
    public  static long powMod ( int a , int b , int c){
        long res = 1;
         a = a % c;
        while (b > 0)
        {
            if (b % 2 == 1)
                res = (res*a) % c;
            b = b/2;
            a = (a*a) % c;
        }
        return res;
    }

    public static int MOD = 1000000007;
    // function for sum of max min difference
    public static long maxMin (ArrayList<Integer> arr)
    {
        // sort all  numbers
        Collections.sort(arr);

        // iterate over array and with help of
        // horner's rule calc max_sum and min_sum
        long min_sum = 0, max_sum = 0;
        for (int i = 0; i < arr.size(); i++)
        {
            max_sum = 2 * max_sum + arr.get(arr.size() - 1 - i);
            max_sum %= MOD;
            min_sum = 2 * min_sum + arr.get(i);
            min_sum %= MOD;
        }

        return max_sum - min_sum;
    }

}

/* SOLUTION APPROACH

*/