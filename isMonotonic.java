class Solution2 {
    public static void main(String[] args) {
      Solution2 ins = new Solution2();
      int[] arr = {1,2,3,3};
      System.out.println(ins.isMonotonic(arr) == true);
      int[] arr2 = {6,5,4,4};
      System.out.println(ins.isMonotonic(arr2) == true);
      int[] arr3 = {1,3,2,2};
      System.out.println(ins.isMonotonic(arr3) == false);
      int[] arr4 = {3,3,2,2};
      System.out.println(ins.isMonotonic(arr4) == true);
      int[] arr5 = {-5963,-123,8,61,4649};
      System.out.println(ins.isMonotonic(arr5) == true);
      int[] arr6 = {4,4,6,6};
      System.out.println(ins.isMonotonic(arr6) == true);
      int[] arr7 = {666,-999};
      System.out.println(ins.isMonotonic(arr7) == true);
      int[] arr8 = {0,1,8,100};
      System.out.println(ins.isMonotonic(arr8) == true);
      int[] arr9 = {8,3,0,-1,-4,-8};
      System.out.println(ins.isMonotonic(arr9) == true);
      int[] arr10 = {5,5,3,4};
      System.out.println(ins.isMonotonic(arr10) == false);
      int[] arr11 = {5,3,4,4};
      System.out.println(ins.isMonotonic(arr11) == false);
      int[] arr12 = {5,3,4};
      System.out.println(ins.isMonotonic(arr12) == false);
      int[] arr13 = {10,9,-2,7};
      System.out.println(ins.isMonotonic(arr13) == false);
      int[] arr14 = {-321,0,8,-7};
      System.out.println(ins.isMonotonic(arr14) == false);
      int[] arr15 = {-99,0,8,7};
      System.out.println(ins.isMonotonic(arr15) == false);
      int[] arr16 = {0,0,0,0,0,0,0};
      System.out.println(ins.isMonotonic(arr16) == true);
      int[] arr17 = {0};
      System.out.println(ins.isMonotonic(arr17) == true);
      System.out.println("すべてTrueならコンプリート。本番テストへ");
    }

    public boolean isMonotonic(int[] nums) {
      // ここにコードを書いてください
      
      //カウントするための変数
      int count = 0;

      //カウント変数を機能させるための数値を代入する変数
      int countPlus = 1;

      //現在の値
      int nowValue = 0;

      //ひとつ前の値
      int preValue = 0;

      // preValue と nowValue を比較して preValue が nowValue 未満だった場合のルート分岐変数
      int route1 = 0;

      // preValue と nowValue を比較して preValue が nowValue より上だった場合のルート分岐変数
      int route2 = 0;
      
      //配列に代入されている数値の個数分まで繰り返すループ文
      for(int i = 0 ; i<nums.length; i++){
        // i を nowValue に代入する
        nowValue = nums[i];
        // countPlus に +1 したものを count に代入する
        count = countPlus++;

        //ルート分岐
        if(route1 == 1 || route2 == 2){

          // route1 : preValue が nowValue 以下なら何もしない、それ以外はFalseを引数に返す
          if(route1 == 1){
            if(preValue <= nowValue){
              ;
            } else {
              return false;
            }

          // route2 : preValue が nowValue 以上なら何もしない、それ以外はFalseを引数に返す
          } else if(route2 == 2){
            if(preValue >= nowValue){
              ;
            } else {
              return false;
            }
          }
        }

        // count が 2 以上だった場合
        if(count >= 2){
          // preValue が nowValue より小さい場合、 route1 に 1 を代入する
          if(preValue < nowValue){
            route1 = 1;
          // preValue が nowValue より大きい場合、 route2 に 2 を代入する
          } else if (preValue > nowValue){
            route2 = 2;
          }
        }
        
        // count が 1 以上だった場合、 i を preValue に代入する
        if(count >= 1){
          preValue = nums[i];
        }
      }

      // True を引数に返す
        return true;
    }
}