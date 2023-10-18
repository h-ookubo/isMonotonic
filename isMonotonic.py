from typing import *

class Solution:
    def isMonotonic(self, nums: List[int]) -> bool:
        # ここにコードを書いてください

##################################################

        # preValue を用意するための分岐用変数
        count = 0
        #ひとつ前の値
        preValue = 0
        # route3 の条件を満たさなくなった際に route3 に戻らないようにするための変数
        route3Escaper = 0
        # nums の数値がひとつだった場合に False にするための変数
        excludeSingle = 0
        # preValue と i を比較して preValue が i 以下だった場合のルート分岐変数
        route1 = 0
        # preValue と i を比較して preValue が i 以上だった場合のルート分岐変数
        route2 = 0
        # preValue と i を比較して preValue が i ずっと同じだった場合のルート分岐変数
        route3 = 0

        # nums の数値をひとつずつ i に代入して繰り返す
        for i in nums :
            count += 1
            """
            print("カウント：",count)
            print("nums:",i)
            print("route",route1,route2)
            """

            #ルート分岐
            if route1 == 1 or route2 == 2 or route3 == 3:
                #print("route0が正解",route1,route2)

                # route1 : preValue が i 以下なら何もしない、それ以外はFalseを引数に返す
                if route1 == 1:
                    if preValue <= i:
                        pass
                    else:
                        return False

                # route2 : preValue が i 以上なら何もしない、それ以外はFalseを引数に返す
                elif route2 == 2:
                    if preValue >= i:
                        pass
                    else:
                        return False

                # route3 : 最初の preValue と i が同じだった場合に preValue と i が途中で同じではなくなった場合、または同じままだった場合の分岐処理
                elif route3 == 3:
                    # preValue が i より小さかった場合、 route1 に 1 、 route3 に 0 、 route3Escaper に 1 を代入する
                    if preValue < i:
                        route1 = 1
                        route3 = 0
                        route3Escaper = 1
                    # preValue が i より大きかった場合、 route2 に 2 、 route3 に 0 、 route3Escaper に 1 を代入する
                    elif preValue > i:
                        route2 = 2
                        route3 = 0
                        route3Escaper = 1
                    # preValue が i と同じだった場合、 route3 に 0 を代入する
                    elif preValue == i:
                        route3 = 0

            # count が 2 以降だった場合、 excludeSingle に 1 を代入する
            if count >= 2:
                excludeSingle = 1
                # preValue が i より小さい場合、 route1 に 1 を代入し、 route3Escaper に 1 を代入する
                if preValue < i:
                    route1 = 1
                    route3Escaper = 1

                # preValue が i より大きい場合、 route2 に 2 を代入し、 route3Escaper に 1 を代入する
                elif preValue > i:
                    route2 = 2
                    route3Escaper = 1

                # preValue が i と同じでかつ route3Escaper が 0 だった場合、 route3 に 3 を代入する
                elif preValue == i and route3Escaper == 0:
                    route3 = 3

            # count が 1 以降だった場合、 i を preValue に代入する
            if count >= 1:
                preValue = i

        """
        print(i)
        print("--------------")
        """
        # route3 が 3 だった場合は引数に False を返し、 excludeSingle が 1だった場合は引数に True を返す、それ以外は False
        if route3 == 3:
            return False
        elif excludeSingle == 1:
            return True
        else:
            return False

##################################################

print("スタート")
assert Solution().isMonotonic([1,2,2,3]) == True
assert Solution().isMonotonic([2,2,3,3]) == True
assert Solution().isMonotonic([-5963,-123,8,61,4649]) == True
assert Solution().isMonotonic([6,5,4,4]) == True
assert Solution().isMonotonic([666,-999]) == True
assert Solution().isMonotonic([0.8,1.29,80.5,100]) == True
assert Solution().isMonotonic([8,2.3,0.55,-1,-3.4,-8]) == True
assert Solution().isMonotonic([1,3,2]) == False
assert Solution().isMonotonic([5,5,3,4]) == False
assert Solution().isMonotonic([5,3,4,4]) == False
assert Solution().isMonotonic([5,3,4]) == False
assert Solution().isMonotonic([10,9,-2,7]) == False
assert Solution().isMonotonic([-321,0,8,-7]) == False
assert Solution().isMonotonic([-99,0,0.8,0.7]) == False
assert Solution().isMonotonic([0,0,0,0,0,0,0]) == False
assert Solution().isMonotonic([0]) == False
print("コンプリート!本番テストへ")
